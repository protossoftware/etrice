package org.eclipse.etrice.examples.dynamicactors8;

import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;
import java.io.Serializable;




public class DerivedData extends OtherData implements Serializable {
	
	private static final long serialVersionUID = 814304124L;
	
	
	/*--------------------- attributes ---------------------*/
	char cval[];
	
	/* --------------------- attribute setters and getters */
	public void setCval (char[] cval) {
		 this.cval = cval;
	}
	public char[] getCval () {
		return this.cval;
	}
	
	/*--------------------- operations ---------------------*/
	
	// default constructor
	public DerivedData() {
		super();
		
		// initialize attributes
		this.setCval("{'a', 'b', 'c'}".toCharArray());
	}
	
	// constructor using fields
	public DerivedData(SomeData some, boolean bval, char[] cval) {
		super(some, bval);
		
		this.cval = cval;
	}
	
	// deep copy
	public DerivedData deepCopy() {
		DerivedData copy = new DerivedData();
		if (some!=null) {
			copy.some = some.deepCopy();
		}
		copy.bval = bval;
		for (int i=0;i<cval.length;i++){
			copy.cval[i] = cval[i];
		}
		return copy;
	}
};
