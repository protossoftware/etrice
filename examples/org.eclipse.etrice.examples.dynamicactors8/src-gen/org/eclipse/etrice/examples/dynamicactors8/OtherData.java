package org.eclipse.etrice.examples.dynamicactors8;

import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;
import java.io.Serializable;




public class OtherData implements Serializable {
	
	private static final long serialVersionUID = -1584626641L;
	
	
	/*--------------------- attributes ---------------------*/
	SomeData some;
	boolean bval;
	
	/* --------------------- attribute setters and getters */
	public void setSome (SomeData some) {
		 this.some = some;
	}
	public SomeData getSome () {
		return this.some;
	}
	public void setBval (boolean bval) {
		 this.bval = bval;
	}
	public boolean getBval () {
		return this.bval;
	}
	
	/*--------------------- operations ---------------------*/
	
	// default constructor
	public OtherData() {
		super();
		
		// initialize attributes
		this.setSome(new SomeData());
		this.setBval(false);
	}
	
	// constructor using fields
	public OtherData(SomeData some, boolean bval) {
		super();
		
		this.some = some;
		this.bval = bval;
	}
	
	// deep copy
	public OtherData deepCopy() {
		OtherData copy = new OtherData();
		if (some!=null) {
			copy.some = some.deepCopy();
		}
		copy.bval = bval;
		return copy;
	}
};
