package room.basic.service.tcp;

import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;
import java.io.Serializable;




public class DTcpControl implements Serializable {

	private static final long serialVersionUID = -156692117L;


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
};
