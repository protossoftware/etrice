package SendingData;

import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;




public class DemoData {
	
	
	/*--------------------- attributes ---------------------*/
	int int32Val;
	byte int8Array[];
	double float64Val;
	String stringVal;
	
	//--------------------- attribute setters and getters
	public void setInt32Val (int int32Val) {
		 this.int32Val = int32Val;
	}
	public int getInt32Val () {
		return this.int32Val;
	}
	public void setInt8Array (byte[] int8Array) {
		 this.int8Array = int8Array;
	}
	public byte[] getInt8Array () {
		return this.int8Array;
	}
	public void setFloat64Val (double float64Val) {
		 this.float64Val = float64Val;
	}
	public double getFloat64Val () {
		return this.float64Val;
	}
	public void setStringVal (String stringVal) {
		 this.stringVal = stringVal;
	}
	public String getStringVal () {
		return this.stringVal;
	}
	
	/*--------------------- operations ---------------------*/
	
	// default constructor
	public DemoData() {
		super();
		
		// initialize attributes
		this.setInt32Val(4711);
		this.setInt8Array(new byte[] { (byte)1, (byte)2, (byte)3, (byte)4, (byte)5, (byte)6, (byte)7, (byte)8, (byte)9, (byte)10 });
		this.setFloat64Val(0.0d);
		this.setStringVal("\"empty\"");
	}
	
	// constructor using fields
	public DemoData(int int32Val, byte[] int8Array, double float64Val, String stringVal) {
		super();
		
		this.int32Val = int32Val;
		this.int8Array = int8Array;
		this.float64Val = float64Val;
		this.stringVal = stringVal;
	}
	
	// deep copy
	public DemoData deepCopy() {
		DemoData copy = new DemoData();
		copy.int32Val = int32Val;
		for (int i=0;i<int8Array.length;i++){
			copy.int8Array[i] = int8Array[i];
		}
		copy.float64Val = float64Val;
		copy.stringVal = stringVal;
		return copy;
	}
};
