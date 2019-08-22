package etrice.api.tcp;

import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;
import java.io.Serializable;
import java.util.Objects;




public class DTcpControl implements Serializable {

	private static final long serialVersionUID = 1104167705L;


	/*--------------------- attributes ---------------------*/
	public  String IPAddr;
	public  int TcpPort;

	/* --------------------- attribute setters and getters */
	public void setIPAddr(String IPAddr) {
		 this.IPAddr = IPAddr;
	}
	public String getIPAddr() {
		return this.IPAddr;
	}
	public void setTcpPort(int TcpPort) {
		 this.TcpPort = TcpPort;
	}
	public int getTcpPort() {
		return this.TcpPort;
	}

	/*--------------------- operations ---------------------*/

	// default constructor
	public DTcpControl() {
		super();

		// initialize attributes
		this.setIPAddr("");

		/* user defined constructor body */
	}

	// constructor using fields
	public DTcpControl(String IPAddr, int TcpPort) {
		super();

		this.IPAddr = IPAddr;
		this.TcpPort = TcpPort;

		/* user defined constructor body */
	}

	// deep copy
	public DTcpControl deepCopy() {
		DTcpControl copy = new DTcpControl();
		copy.IPAddr = IPAddr;
		copy.TcpPort = TcpPort;
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
	
		DTcpControl casted = (DTcpControl) other;
		return Objects.deepEquals(this.IPAddr, casted.IPAddr) && Objects.deepEquals(this.TcpPort, casted.TcpPort);
	}
	
	// deep hashCode
	@Override
	public int hashCode() {
		return Objects.hash(this.IPAddr, this.TcpPort);
	}
};
