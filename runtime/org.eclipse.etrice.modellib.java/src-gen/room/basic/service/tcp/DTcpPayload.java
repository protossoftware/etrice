package room.basic.service.tcp;

import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;




public class DTcpPayload {
	
	
	/*--------------------- attributes ---------------------*/
	int connectionId;
	int length;
	byte data[];
	
	//--------------------- attribute setters and getters
	public void setConnectionId (int connectionId) {
		 this.connectionId = connectionId;
	}
	public int getConnectionId () {
		return this.connectionId;
	}
	public void setLength (int length) {
		 this.length = length;
	}
	public int getLength () {
		return this.length;
	}
	public void setData (byte[] data) {
		 this.data = data;
	}
	public byte[] getData () {
		return this.data;
	}
	
	/*--------------------- operations ---------------------*/
	
	// default constructor
	public DTcpPayload() {
		super();
		
		// initialize attributes
		{
			byte[] array = new byte[1000];
			for (int i=0;i<1000;i++){
				array[i] = (byte)0;
			}
			this.setData(array);
		}
	}
	
	// constructor using fields
	public DTcpPayload(int connectionId, int length, byte[] data) {
		super();
		
		this.connectionId = connectionId;
		this.length = length;
		this.data = data;
	}
	
	// deep copy
	public DTcpPayload deepCopy() {
		DTcpPayload copy = new DTcpPayload();
		copy.connectionId = connectionId;
		copy.length = length;
		for (int i=0;i<data.length;i++){
			copy.data[i] = data[i];
		}
		return copy;
	}
};
