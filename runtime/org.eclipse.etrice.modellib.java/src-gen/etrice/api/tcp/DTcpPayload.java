package etrice.api.tcp;

import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;
import java.io.Serializable;
import java.util.Objects;




public class DTcpPayload implements Serializable {

	private static final long serialVersionUID = -634077366L;


	/*--------------------- attributes ---------------------*/
	public  int connectionId;
	public  int length;
	public  byte data[];

	/* --------------------- attribute setters and getters */
	public void setConnectionId(int connectionId) {
		 this.connectionId = connectionId;
	}
	public int getConnectionId() {
		return this.connectionId;
	}
	public void setLength(int length) {
		 this.length = length;
	}
	public int getLength() {
		return this.length;
	}
	public void setData(byte[] data) {
		 this.data = data;
	}
	public byte[] getData() {
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

		/* user defined constructor body */
	}

	// constructor using fields
	public DTcpPayload(int connectionId, int length, byte[] data) {
		super();

		this.connectionId = connectionId;
		this.length = length;
		this.data = data;

		/* user defined constructor body */
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
	
	// deep equals
	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if(other == null || this.getClass() != other.getClass()) {
			return false;
		}
	
		DTcpPayload casted = (DTcpPayload) other;
		return Objects.deepEquals(this.connectionId, casted.connectionId) && Objects.deepEquals(this.length, casted.length) && Objects.deepEquals(this.data, casted.data);
	}
	
	// deep hashCode
	@Override
	public int hashCode() {
		return Objects.hash(this.connectionId, this.length, this.data);
	}
};
