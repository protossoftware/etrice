package org.eclipse.etrice.integration.ConfigTest;




public class Dyn_DC2 {
	
	
	/*--------------------- attributes ---------------------*/
	double double_i;
	char char_i[];
	
	//--------------------- attribute setters and getters
	public void setDouble_i (double double_i) {
		 this.double_i = double_i;
	}
	public double getDouble_i () {
		return this.double_i;
	}
	public void setChar_i (char[] char_i) {
		 this.char_i = char_i;
	}
	public char[] getChar_i () {
		return this.char_i;
	}
	
	/*--------------------- operations ---------------------*/
	
	// default constructor
	public Dyn_DC2() {
		super();
		
		// initialize attributes
		char_i = new char[10];
	}
	
	// constructor using fields
	public Dyn_DC2(double double_i, char[] char_i) {
		super();
		
		this.double_i = double_i;
		this.char_i = char_i;
	}
	
	// deep copy
	public Dyn_DC2 deepCopy() {
		Dyn_DC2 copy = new Dyn_DC2();
		copy.double_i = double_i;
		for (int i=0;i<char_i.length;i++){
			copy.char_i[i] = char_i[i];
		}
		return copy;
	}
};
