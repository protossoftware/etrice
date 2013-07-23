/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.base;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.ExternalType;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.RoomFactory;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.InstanceTestsActivator;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class TestDetailCodeTranslator {

	
	/**
	 * @author Henrik Rentz-Reichert
	 *
	 */
	private final class TestTranslationProvider implements ITranslationProvider {
		
		@Override
		public boolean translateMembers() {
			return true;
		}
		
		@Override
		public String getAttributeGetter(Attribute att, String index, String orig) {
			if (index==null)
				return ">"+att.getName()+"<";
			else
				return ">"+att.getName()+"["+index+"]<";
		}
		
		@Override
		public String getAttributeSetter(Attribute att, String index, String value, String orig) {
			if (index==null)
				return ">"+att.getName()+" = "+value+"<";
			else
				return ">"+att.getName()+"["+index+"] = "+value+"<";
		}

		@Override
		public String getOperationText(Operation op, ArrayList<String> args, String orig) {
			return ">"+op.getName()+"("+getArgList(args)+")<";
		}

		@Override
		public String getInterfaceItemMessageText(InterfaceItem item, Message msg, ArrayList<String> args, String index, String orig) {
			if (index==null)
				return ">"+item.getName()+"."+msg.getName()+"("+getArgList(args)+")<";
			else
				return ">"+item.getName()+"["+index+"]."+msg.getName()+"("+getArgList(args)+")<";
		}
		
		@Override
		public String getInterfaceItemMessageValue(InterfaceItem item, Message msg, String orig) {
			return ">"+item.getName()+"."+msg.getName()+"<";
		}

		private String getArgList(ArrayList<String> args) {
			StringBuilder result = new StringBuilder();
			for (String string : args) {
				result.append(string+", ");
			}
			int end = args.isEmpty()? result.length():result.length()-2;
			return result.substring(0, end);
		}

		@Override
		public boolean translateTags() {
			return true;
		}

		@Override
		public String translateTag(String tag, DetailCode code) {
			return ">"+tag+"<";
		}

		@Override
		public void setContainerClass(EObject container) {
		}
	}

	private RoomModel model;
	private ActorClass ac;
	private DetailCodeTranslator translator;

	@Before
	public void setUp() {
		model = RoomFactory.eINSTANCE.createRoomModel();
		
		ProtocolClass pc = RoomFactory.eINSTANCE.createProtocolClass();
		model.getProtocolClasses().add(pc);
		pc.setName("TestProtocol");
		Message out1 = RoomFactory.eINSTANCE.createMessage();
		out1.setName("out1");
		Message out2 = RoomFactory.eINSTANCE.createMessage();
		out2.setName("out2");
		VarDecl typedID = RoomFactory.eINSTANCE.createVarDecl();
		typedID.setName("param");
		PrimitiveType type = RoomFactory.eINSTANCE.createPrimitiveType();
		type.setName("int32");
		type.setCastName("Integer");
		type.setTargetName("int32");
		type.setDefaultValueLiteral("0");
		RefableType refType = RoomFactory.eINSTANCE.createRefableType();
		refType.setType(type);
		typedID.setRefType(refType);
		out2.setData(typedID);
		pc.getOutgoingMessages().add(out1);
		pc.getOutgoingMessages().add(out2);
		Message in1 = RoomFactory.eINSTANCE.createMessage();
		in1.setName("in1");
		pc.getIncomingMessages().add(in1);
		
		ac = RoomFactory.eINSTANCE.createActorClass();
		model.getActorClasses().add(ac);
		ac.setName("TestActor");
		
		Port port = RoomFactory.eINSTANCE.createPort();
		port.setName("fct");
		port.setProtocol(pc);
		ac.getIntPorts().add(port);
		
		Attribute attr = RoomFactory.eINSTANCE.createAttribute();
		attr.setName("value");
		attr.setRefType(EcoreUtil.copy(refType));
		ac.getAttributes().add(attr);
		
		attr = RoomFactory.eINSTANCE.createAttribute();
		attr.setName("array");
		attr.setRefType(EcoreUtil.copy(refType));
		attr.setSize(8);
		ac.getAttributes().add(attr);

		StandardOperation op0 = RoomFactory.eINSTANCE.createStandardOperation();
		op0.setName("bar0");
		ac.getOperations().add(op0);
		
		StandardOperation op1 = RoomFactory.eINSTANCE.createStandardOperation();
		op1.setName("bar1");
		VarDecl param1 = RoomFactory.eINSTANCE.createVarDecl();
		param1.setName("param");
		ExternalType ft = RoomFactory.eINSTANCE.createExternalType();
		ft.setName("MyType");
		ft.setTargetName("MyType");
		refType = RoomFactory.eINSTANCE.createRefableType();
		refType.setType(ft);
		param1.setRefType(refType);
		op1.getArguments().add(param1);
		ac.getOperations().add(op1);
		
		StandardOperation op2 = RoomFactory.eINSTANCE.createStandardOperation();
		op2.setName("bar2");
		VarDecl param2 = RoomFactory.eINSTANCE.createVarDecl();
		param2.setName("param");
		ExternalType ft2 = EcoreUtil.copy(ft);
		ft2.setName("MyOtherType");
		refType = RoomFactory.eINSTANCE.createRefableType();
		refType.setType(ft2);
		param2.setRefType(refType);
		op2.getArguments().add(EcoreUtil.copy(param1));
		op2.getArguments().add(param2);
		ac.getOperations().add(op2);
		
		translator = new DetailCodeTranslator(ac, new TestTranslationProvider());
	}
	
	@Test
	public void testSingleComment() {
		DetailCode dc = RoomFactory.eINSTANCE.createDetailCode();
		dc.getCommands().add("//");
		
		String result = translator.translateDetailCode(dc);
		
		assertEquals("comment", "//", result);
	}
	
	@Test
	public void testMultiComment() {
		DetailCode dc = RoomFactory.eINSTANCE.createDetailCode();
		dc.getCommands().add("/* some comment");
		dc.getCommands().add("continued");
		dc.getCommands().add("*/");
		
		String result = translator.translateDetailCode(dc);
		
		assertEquals("comment", "/* some comment\ncontinued\n*/", result);
	}
	
	@Test
	public void testPortNonExMsg() {
		DetailCode dc = RoomFactory.eINSTANCE.createDetailCode();
		dc.getCommands().add("fct.out();");
		
		String result = translator.translateDetailCode(dc);
		
		assertEquals("port.non_ex_message _no_ replacement", "fct.out();", result);
	}
	
	@Test
	public void testPortMsg() {
		DetailCode dc = RoomFactory.eINSTANCE.createDetailCode();
		dc.getCommands().add("fct.out1();");
		
		String result = translator.translateDetailCode(dc);
		
		assertEquals("port.message replacement", ">fct.out1()<;", result);
	}
	
	@Test
	public void testIndexedPortMsg() {
		DetailCode dc = RoomFactory.eINSTANCE.createDetailCode();
		dc.getCommands().add("fct[2].out1();");
		
		String result = translator.translateDetailCode(dc);
		
		assertEquals("port.message replacement", ">fct[2].out1()<;", result);
	}
	
	@Test
	public void testIndexedPortMsgComplex() {
		DetailCode dc = RoomFactory.eINSTANCE.createDetailCode();
		dc.getCommands().add("fct[self->index[2]].out1();");
		
		String result = translator.translateDetailCode(dc);
		
		assertEquals("port.message replacement", ">fct[self->index[2]].out1()<;", result);
	}

	@Test
	public void testPortMsgValue() {
		DetailCode dc = RoomFactory.eINSTANCE.createDetailCode();
		dc.getCommands().add("x = 2*fct.in1;");
		
		String result = translator.translateDetailCode(dc);
		
		assertEquals("port.message as value (getter) replacement", "x = 2*>fct.in1<;", result);
	}
	
	@Test
	public void testPortMsgValueInGuard() {
		DetailCode dc = RoomFactory.eINSTANCE.createDetailCode();
		dc.getCommands().add("fct.in1");
		
		String result = translator.translateDetailCode(dc);
		
		assertEquals("port.message as value (getter) replacement", ">fct.in1<", result);
	}
	
	@Test
	public void testPortMsgValueNoReplace() {
		DetailCode dc = RoomFactory.eINSTANCE.createDetailCode();
		dc.getCommands().add("x = 2*fct.out1;");
		
		String result = translator.translateDetailCode(dc);
		
		assertEquals("port.message as value (getter) replacement", "x = 2*fct.out1;", result);
	}
	
	@Test
	public void testPortMsgComments() {
		DetailCode dc = RoomFactory.eINSTANCE.createDetailCode();
		dc.getCommands().add("fct . out1  (/*comment*/");
		dc.getCommands().add("//comment");
		dc.getCommands().add("  );");
		
		String result = translator.translateDetailCode(dc);
		
		assertEquals("port.message (with comments and white space) replacement", ">fct.out1()<;", result);
	}
	
	@Test
	public void testPortMsgData() {
		DetailCode dc = RoomFactory.eINSTANCE.createDetailCode();
		dc.getCommands().add("fct.out2(123);");
		
		String result = translator.translateDetailCode(dc);
		
		assertEquals("port.message(data) replacement", ">fct.out2(123)<;", result);
	}
	
	@Test
	public void testPortMsgDataComment() {
		DetailCode dc = RoomFactory.eINSTANCE.createDetailCode();
		dc.getCommands().add("fct.out2(123/4 /*comment*/);");
		
		String result = translator.translateDetailCode(dc);
		
		assertEquals("port.message(data) replacement", ">fct.out2(123/4 /*comment*/)<;", result);
	}
	
	@Test
	public void testPortMsgDataRecursive() {
		DetailCode dc = RoomFactory.eINSTANCE.createDetailCode();
		dc.getCommands().add("fct.out2(value);");
		
		String result = translator.translateDetailCode(dc);
		
		assertEquals("port.message(attrib) recursive replacement", ">fct.out2(>value<)<;", result);
	}
	
	@Test
	public void testPortMsgDataFloat() {
		DetailCode dc = RoomFactory.eINSTANCE.createDetailCode();
		dc.getCommands().add("fct.out2(123.4);");
		
		String result = translator.translateDetailCode(dc);
		
		assertEquals("port.message(data) replacement", ">fct.out2(123.4)<;", result);
	}
	
	@Test
	public void testPortMsgDataComplex() {
		DetailCode dc = RoomFactory.eINSTANCE.createDetailCode();
		dc.getCommands().add("fct.out2(foxy(abc, 12.3));");
		
		String result = translator.translateDetailCode(dc);
		
		assertEquals("port.message(data) replacement", ">fct.out2(foxy(abc, 12.3))<;", result);
	}
	
	@Test
	public void testAttributeGetter() {
		DetailCode dc = RoomFactory.eINSTANCE.createDetailCode();
		dc.getCommands().add("int x = value*2;");
		
		String result = translator.translateDetailCode(dc);
		
		assertEquals("read attribute", "int x = >value<*2;", result);
	}
	
	@Test
	public void testAttributeIndexedGetter() {
		DetailCode dc = RoomFactory.eINSTANCE.createDetailCode();
		dc.getCommands().add("int x = array[2]*2;");
		
		String result = translator.translateDetailCode(dc);
		
		assertEquals("read indexed attribute", "int x = >array[2]<*2;", result);
	}
	
	@Test
	public void testAttributeSetter() {
		DetailCode dc = RoomFactory.eINSTANCE.createDetailCode();
		dc.getCommands().add("value.set(2);");
		
		String result = translator.translateDetailCode(dc);
		
		assertEquals("write attribute", ">value = 2<;", result);
	}
	
	@Test
	public void testAttributeIndexedSetter() {
		DetailCode dc = RoomFactory.eINSTANCE.createDetailCode();
		dc.getCommands().add("array[3].set(2);");
		
		String result = translator.translateDetailCode(dc);
		
		assertEquals("write indexed attribute", ">array[3] = 2<;", result);
	}
	
	@Test
	public void testAttributeIndexedSetterRecursive() {
		DetailCode dc = RoomFactory.eINSTANCE.createDetailCode();
		dc.getCommands().add("array[value].set(value);");
		
		String result = translator.translateDetailCode(dc);
		
		assertEquals("write indexed attribute", ">array[>value<] = >value<<;", result);
	}
	
	@Test
	public void testOperation0() {
		DetailCode dc = RoomFactory.eINSTANCE.createDetailCode();
		dc.getCommands().add("bar0();");
		
		String result = translator.translateDetailCode(dc);
		
		assertEquals("fct() replacement", ">bar0()<;", result);
	}
	
	@Test
	public void testOperation1() {
		DetailCode dc = RoomFactory.eINSTANCE.createDetailCode();
		dc.getCommands().add("bar1(123);");
		
		String result = translator.translateDetailCode(dc);
		
		assertEquals("bar1(123) replacement", ">bar1(123)<;", result);
	}
	
	@Test
	public void testOperation2() {
		DetailCode dc = RoomFactory.eINSTANCE.createDetailCode();
		dc.getCommands().add("bar2(123, 456);");
		
		String result = translator.translateDetailCode(dc);
		
		assertEquals("bar2(123, 456) replacement", ">bar2(123, 456)<;", result);
	}
	
	@Test
	public void testOperation3() {
		DetailCode dc = RoomFactory.eINSTANCE.createDetailCode();
		dc.getCommands().add("bar2(123, value);");
		
		String result = translator.translateDetailCode(dc);
		
		assertEquals("bar2(123, value) recursive replacement", ">bar2(123, >value<)<;", result);
	}
	
	@Test
	public void testOperation4() {
		DetailCode dc = RoomFactory.eINSTANCE.createDetailCode();
		dc.getCommands().add("bar2(123, bar1(value));");
		
		String result = translator.translateDetailCode(dc);
		
		assertEquals("bar2(123, value) recursive replacement", ">bar2(123, >bar1(>value<)<)<;", result);
	}
	
	@Test
	public void testOperationWrongNArg() {
		DetailCode dc = RoomFactory.eINSTANCE.createDetailCode();
		dc.getCommands().add("bar2(123, 456, 789);");
		
		String result = translator.translateDetailCode(dc);
		
		assertEquals("fct(123) no replacement", "bar2(123, 456, 789);", result);
	}
	
	@Test (timeout=1000)
	public void testCommentBug() {
		DetailCode dc = RoomFactory.eINSTANCE.createDetailCode();
		dc.getCommands().add("*/ no comment */");
		
		String result = translator.translateDetailCode(dc);
		
		assertEquals("wrong comment", "*/ no comment */", result);
	}
	
	@Test (timeout=1000)
	public void testLargeFile() {
		DetailCode dc = getLargeFile();
		
		// this adds a trailing \n
		String orig = RoomHelpers.getDetailCode(dc);
		
		// remove trailing \n
		orig = orig.substring(0, orig.length()-1);
		
		String result = translator.translateDetailCode(dc);
		
		assertEquals("large file", orig, result);
	}

	private DetailCode getLargeFile() {
		try {
			URL fileURL = InstanceTestsActivator.getInstance().getBundle().getEntry("models/largeFile.cpp");
			fileURL = FileLocator.toFileURL(fileURL);
			InputStream istream = fileURL.openStream();
			InputStreamReader ireader = new InputStreamReader(istream);
			BufferedReader reader = new BufferedReader(ireader);
			DetailCode dc = RoomFactory.eINSTANCE.createDetailCode();
			String line;
			while ((line = reader.readLine())!=null) {
				dc.getCommands().add(line);
			}
			return dc;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Test
	public void testTags() {
		DetailCode dc = RoomFactory.eINSTANCE.createDetailCode();
		dc.getCommands().add("log(\"my message\", \"<|location|>\");");
		
		String result = translator.translateDetailCode(dc);
		
		assertEquals("large file", "log(\"my message\", \">location<\");", result);
	}
}
