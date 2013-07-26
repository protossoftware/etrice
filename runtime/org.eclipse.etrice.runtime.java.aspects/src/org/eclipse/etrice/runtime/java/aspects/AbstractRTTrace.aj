/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Eyrak Paen (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.aspects;

import java.util.Map;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.RTObject;
import org.eclipse.etrice.runtime.java.modelbase.RTSystem;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;

/**
 * A simple trace aspect that produces synchronous MSC traces using the eTrice
 * MSCLogger provided by DebuggingService.
 */
public abstract aspect AbstractRTTrace {
	DebuggingService dbgSvc = DebuggingService.getInstance();
	
	/**
	 * Used to keep track of the object context of constructor calls. Each 
	 * thread has its own stack of objects.
	 */
	Map<Thread, Deque<Object>> ctorFrames = new HashMap<Thread, Deque<Object>>();
	
	/**
	 * Used to keep track of the object context of superclass inits. Each 
	 * thread has its own stack of objects.
	 */
	Map<Thread, Deque<Object>> initFrames = new HashMap<Thread, Deque<Object>>();
	
	/**
	 * Used to keep track of the object context of superclass inits. Each 
	 * thread has its own stack of objects.
	 */
	Map<Thread, Object> lastFinishedInit = new HashMap<Thread, Object>();
	
	/**
	 * Matches joinpoints in classes that implement IRTObject, except for 
	 * concrete base implementation RTObject. Provided as a convenience for 
	 * subclasses.
	 */
	public pointcut rtClasses(): within(RTObject+ && !RTObject);
	
	/**
	 * Matches join points in SubSystemClassBase constructor. Allows exclusion 
	 * of joinpoints that occur before DebuggingService is initialized.
	 */
	pointcut subsystemConstructors(): withincode(SubSystemClassBase+.new(..));
	
	/**
	 * Matches calls to methods of IRTObject, to reduce verboseness of traces.
	 */
	pointcut traceCallFilter(): call(* IRTObject.*(..));
	
	/**
     * Includes join points from trace pointcuts. Concrete extensions of this 
     * aspect must implement this pointcut.
     */
    public abstract pointcut traceScope();
    
    /**
     * Excludes join points from trace pointcuts. Concrete extensions of this 
     * aspect must implement this pointcut.
     */
    public abstract pointcut traceFilter();
    
    /**
     * Matches method calls from IRTObject to IRTObject. The pointcut uses the 
     * abstract pointcuts {@link AbstractRTTrace.traceScope} and 
     * {@link AbstractRTTrace.traceFilter} to control which join points are 
     * included and excluded, respectively. {@link AbstractRTTrace.traceFilter} is 
     * applied as a logical NOT.
     * 
     * This pointcut also filters out calls to IRTObject methods and calls to 
     * the SubSystem constructors that might occur before DebuggingService is 
     * initialized.
     */
    pointcut rtMethodCall(IRTObject src, IRTObject tgt): 
    	traceScope() &&
    	!traceFilter() &&
    	!traceCallFilter() &&
    	call(* *(..)) && 
    	!cflow(subsystemConstructors()) &&
    	this(src) && this(IRTObject) && 
    	target(tgt) && target(IRTObject);
    
    pointcut rtConstructor():
    	traceScope() &&
    	!traceFilter() &&
    	!cflow(subsystemConstructors()) &&
    	!call(RTSystem.new(..)) && !initialization(RTSystem.new(..));
    
    pointcut rtConstructorCall(IRTObject src):
    	rtConstructor() &&
    	call(*.new(..)) &&
    	this(src) && this(IRTObject);
    
    pointcut rtConstructorInit(IRTObject tgt):
    	rtConstructor() &&
    	initialization(*.new(..)) &&
    	this(tgt) && this(IRTObject);
    
    /**
     * Logs trace messages before called methods using the MSCLogger provided   
     * by the DebuggerService singleton.
     */
    before(IRTObject src, IRTObject tgt): rtMethodCall(src, tgt) {
    	String srcLabel = getRTObjectLabel(src);
    	String tgtLabel = getRTObjectLabel(tgt);
    	String msgLabel = getMessageLabel(thisJoinPoint.getSignature().getName());
    	dbgSvc.getSyncLogger().addMessageSyncCall(srcLabel, tgtLabel, msgLabel);
    }
    
    /**
     * Logs trace messages after called methods using the MSCLogger provided   
     * by the DebuggerService singleton.
     */
    after(IRTObject src, IRTObject tgt): rtMethodCall(src, tgt) {
    	String srcLabel = getRTObjectLabel(src);
    	String tgtLabel = getRTObjectLabel(tgt);
    	String msgLabel = getMessageLabel(thisJoinPoint.getSignature().getName());
    	dbgSvc.getSyncLogger().addMessageSyncReturn(srcLabel, tgtLabel, msgLabel);
    }
    
    before(IRTObject src): rtConstructorCall(src) {
    	// add src object to constructor call stack
    	Deque<Object> stack = getCtorStack(Thread.currentThread());
    	// if src is already on the stack, this means that we're past the superclass initializations but still inside src's init
    	if(stack.isEmpty() || src != stack.peekFirst()) {
    		stack.offerFirst(src);
    	}
    	// Testing
    	//System.out.println("ctor called in "+getObjectLabel(src));
    }
    
    before(IRTObject tgt): rtConstructorInit(tgt) {
    	Deque<Object> initStack = getInitStack(Thread.currentThread());
    	Deque<Object> stack = getCtorStack(Thread.currentThread());
    	
    	Object src = stack.peekFirst();
    	if((initStack.isEmpty() || tgt != initStack.peekFirst()) &&
    			tgt != lastFinishedInit.get(Thread.currentThread())) {
	    	String srcLabel = getObjectLabel(src);
	    	String tgtLabel = getObjectLabel(tgt);
	    	dbgSvc.getSyncLogger().addMessageCreate(srcLabel, tgtLabel);
	    	// Testing
	    	// System.out.println("(!)");
    	}
    	initStack.offerFirst(tgt);
    	// Testing
    	/*String srcLabel = getObjectLabel(src);
    	String tgtLabel = getObjectLabel(tgt);
    	System.out.println(srcLabel+"->"+tgtLabel+" (dtn="+thisJoinPoint.getSignature().getDeclaringTypeName()+",tgt="+src.getClass().getName()+")");
    	*/
    }
    
    after(IRTObject tgt): rtConstructorInit(tgt) {
    	Deque<Object> initStack = getInitStack(Thread.currentThread());
    	initStack.pollFirst();
    	lastFinishedInit.put(Thread.currentThread(), tgt);
    	// Testing
    	/*Deque<Object> stack = getCtorStack(Thread.currentThread());
    	Object src = stack.peekFirst();
    	String srcLabel = getObjectLabel(src);
    	String tgtLabel = getObjectLabel(tgt);
    	System.out.println(srcLabel+"<-"+tgtLabel+" (dtn="+thisJoinPoint.getSignature().getDeclaringTypeName()+",tgt="+src.getClass().getName()+")");
    	*/
    }
    
    after(IRTObject src): rtConstructorCall(src) {
    	// add src object to constructor call stack
    	Deque<Object> stack = getCtorStack(Thread.currentThread());
    	stack.pollFirst();
    	// Testing
    	// System.out.println("ctor returned to "+getObjectLabel(src));
    }
    
    /**
     * Builds an MSC source or target label from the IRTObject's instance path.
     * @param obj
     * @return IRTObject instance label
     */
    static String getRTObjectLabel(IRTObject obj) {
    	String label;
    	if(obj == null) {
    		label = "unknown";
    	}
    	else {
    		label = obj.getInstancePath();
    	}
    	return label;
	}
    
    static String getObjectLabel(Object obj) {
    	String label;
    	if(obj == null) {
    		label = "unknown";
    	}
    	else if(obj instanceof IRTObject) {
    		label = getRTObjectLabel((IRTObject)obj);
    	}
    	else {
    		label = obj.toString();
    	}
    	return label;
    }
    
    /**
     * Builds a MSC message label that includes the current thread's Id.
     * @param msg
     * @return message label with thread Id
     */
    static String getMessageLabel(String msg) {
    	String label = msg + " (tid=" + Thread.currentThread().getId() + ")";
    	return label;
    }
    
    Deque<Object> getCtorStack(Thread t) {
    	Deque<Object> stack = ctorFrames.get(t);
    	if(stack == null) {
    		stack = new LinkedList<Object>();
    		ctorFrames.put(t, stack);
    	}
    	return stack;
    }
    
    Deque<Object> getInitStack(Thread t) {
    	Deque<Object> stack = initFrames.get(t);
    	if(stack == null) {
    		stack = new LinkedList<Object>();
    		initFrames.put(t, stack);
    	}
    	return stack;
    }
}
