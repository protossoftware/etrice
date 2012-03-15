package org.eclipse.etrice.integration.SendingDataByValueTest;




public class PingPongDataDeep {
	
	
	/*--------------------- attributes ---------------------*/
	byte i8Val;
	short i16Val;
	int i32Val;
	char charVal;
	float f32Val;
	double f64Val;
	String stringVal;
	int arrayFromInt32[];
	
	//--------------------- attribute setters and getters
	public void setI8Val (byte i8Val) {
		 this.i8Val = i8Val;
	}
	public byte getI8Val () {
		return this.i8Val;
	}
	public void setI16Val (short i16Val) {
		 this.i16Val = i16Val;
	}
	public short getI16Val () {
		return this.i16Val;
	}
	public void setI32Val (int i32Val) {
		 this.i32Val = i32Val;
	}
	public int getI32Val () {
		return this.i32Val;
	}
	public void setCharVal (char charVal) {
		 this.charVal = charVal;
	}
	public char getCharVal () {
		return this.charVal;
	}
	public void setF32Val (float f32Val) {
		 this.f32Val = f32Val;
	}
	public float getF32Val () {
		return this.f32Val;
	}
	public void setF64Val (double f64Val) {
		 this.f64Val = f64Val;
	}
	public double getF64Val () {
		return this.f64Val;
	}
	public void setStringVal (String stringVal) {
		 this.stringVal = stringVal;
	}
	public String getStringVal () {
		return this.stringVal;
	}
	public void setArrayFromInt32 (int[] arrayFromInt32) {
		 this.arrayFromInt32 = arrayFromInt32;
	}
	public int[] getArrayFromInt32 () {
		return this.arrayFromInt32;
	}
	
	/*--------------------- operations ---------------------*/
	
	// default constructor
	public PingPongDataDeep() {
		super();
		
		// initialize attributes
		arrayFromInt32 = new int[10];
	}
	
	// constructor using fields
	public PingPongDataDeep(byte i8Val, short i16Val, int i32Val, char charVal, float f32Val, double f64Val, String stringVal, int[] arrayFromInt32) {
		super();
		
		this.i8Val = i8Val;
		this.i16Val = i16Val;
		this.i32Val = i32Val;
		this.charVal = charVal;
		this.f32Val = f32Val;
		this.f64Val = f64Val;
		this.stringVal = stringVal;
		this.arrayFromInt32 = arrayFromInt32;
	}
	
	// deep copy
	public PingPongDataDeep deepCopy() {
		PingPongDataDeep copy = new PingPongDataDeep();
		copy.i8Val = i8Val;
		copy.i16Val = i16Val;
		copy.i32Val = i32Val;
		copy.charVal = charVal;
		copy.f32Val = f32Val;
		copy.f64Val = f64Val;
		copy.stringVal = stringVal;
		for (int i=0;i<arrayFromInt32.length;i++){
			copy.arrayFromInt32[i] = arrayFromInt32[i];
		}
		return copy;
	}
};
