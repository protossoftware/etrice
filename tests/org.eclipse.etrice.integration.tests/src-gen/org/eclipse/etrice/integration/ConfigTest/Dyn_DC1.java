package org.eclipse.etrice.integration.ConfigTest;




public class Dyn_DC1 {
	
	
	/*--------------------- attributes ---------------------*/
	int int_i;
	long long_array_i[];
	Dyn_DC2 dc_i;
	
	//--------------------- attribute setters and getters
	public void setInt_i (int int_i) {
		 this.int_i = int_i;
	}
	public int getInt_i () {
		return this.int_i;
	}
	public void setLong_array_i (long[] long_array_i) {
		 this.long_array_i = long_array_i;
	}
	public long[] getLong_array_i () {
		return this.long_array_i;
	}
	public void setDc_i (Dyn_DC2 dc_i) {
		 this.dc_i = dc_i;
	}
	public Dyn_DC2 getDc_i () {
		return this.dc_i;
	}
	
	/*--------------------- operations ---------------------*/
	
	// default constructor
	public Dyn_DC1() {
		super();
		
		// initialize attributes
		long_array_i = new long[1];
		for (int i=0;i<1;i++){
			long_array_i[i] = 0;
		}
		dc_i = new Dyn_DC2();
	}
	
	// constructor using fields
	public Dyn_DC1(int int_i, long[] long_array_i, Dyn_DC2 dc_i) {
		super();
		
		this.int_i = int_i;
		this.long_array_i = long_array_i;
		this.dc_i = dc_i;
	}
	
	// deep copy
	public Dyn_DC1 deepCopy() {
		Dyn_DC1 copy = new Dyn_DC1();
		copy.int_i = int_i;
		for (int i=0;i<long_array_i.length;i++){
			copy.long_array_i[i] = long_array_i[i];
		}
		if (dc_i!=null) {
			copy.dc_i = dc_i.deepCopy();
		}
		return copy;
	}
};
