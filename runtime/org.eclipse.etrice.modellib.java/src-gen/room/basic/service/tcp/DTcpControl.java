package room.basic.service.tcp;

import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;




public class DTcpControl {
	
	
	/*--------------------- attributes ---------------------*/
	String IPAddr;
	int TcpPort;
	
	/* --------------------- attribute setters and getters */
	public void setIPAddr (String IPAddr)
	 {
		 this.IPAddr = IPAddr;
	}
	public String getIPAddr ()
	 {
		return this.IPAddr;
	}
	public void setTcpPort (int TcpPort)
	 {
		 this.TcpPort = TcpPort;
	}
	public int getTcpPort ()
	 {
		return this.TcpPort;
	}
	
	/*--------------------- operations ---------------------*/
	
	// default constructor
	public DTcpControl() {
		super();
		
		// initialize attributes
		this.setIPAddr("");
	}
	
	// constructor using fields
	public DTcpControl(String IPAddr, int TcpPort) {
		super();
		
		this.IPAddr = IPAddr;
		this.TcpPort = TcpPort;
	}
	
	// deep copy
	public DTcpControl deepCopy() {
		DTcpControl copy = new DTcpControl();
		copy.IPAddr = IPAddr;
		copy.TcpPort = TcpPort;
		return copy;
	}
};
