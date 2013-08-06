package org.eclipse.etrice.examples.dynamicactors8;

import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;
import java.io.Serializable;




public class SomeData implements Serializable {
	
	private static final long serialVersionUID = -7989559L;
	
	
	/*--------------------- attributes ---------------------*/
	float fval[];
	double dval;
	String str;
	
	/* --------------------- attribute setters and getters */
	public void setFval (float[] fval) {
		 this.fval = fval;
	}
	public float[] getFval () {
		return this.fval;
	}
	public void setDval (double dval) {
		 this.dval = dval;
	}
	public double getDval () {
		return this.dval;
	}
	public void setStr (String str) {
		 this.str = str;
	}
	public String getStr () {
		return this.str;
	}
	
	/*--------------------- operations ---------------------*/
	
	// default constructor
	public SomeData() {
		super();
		
		// initialize attributes
		{
			float[] array = new float[3];
			for (int i=0;i<3;i++){
				array[i] = 1.0f;
			}
			this.setFval(array);
		}
		this.setDval(123.4d);
		this.setStr("\"Text\"");
	}
	
	// constructor using fields
	public SomeData(float[] fval, double dval, String str) {
		super();
		
		this.fval = fval;
		this.dval = dval;
		this.str = str;
	}
	
	// deep copy
	public SomeData deepCopy() {
		SomeData copy = new SomeData();
		for (int i=0;i<fval.length;i++){
			copy.fval[i] = fval[i];
		}
		copy.dval = dval;
		copy.str = str;
		return copy;
	}
};
