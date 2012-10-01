package SendingData;




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
		int32Val = 4711;
		int8Array = new byte[] {1,2,3,4,5,6,7,8,9,10};
		float64Val = 0.0;
		stringVal = "empty";
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
