package trafficlight.connector;

import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;




public class DMqttConfig {
	
	
	/*--------------------- attributes ---------------------*/
	String url;
	String id;
	
	/* --------------------- attribute setters and getters */
	public void setUrl (String url) {
		 this.url = url;
	}
	public String getUrl () {
		return this.url;
	}
	public void setId (String id) {
		 this.id = id;
	}
	public String getId () {
		return this.id;
	}
	
	/*--------------------- operations ---------------------*/
	
	// default constructor
	public DMqttConfig() {
		super();
		
		// initialize attributes
		this.setUrl("");
		this.setId("");
	}
	
	// constructor using fields
	public DMqttConfig(String url, String id) {
		super();
		
		this.url = url;
		this.id = id;
	}
	
	// deep copy
	public DMqttConfig deepCopy() {
		DMqttConfig copy = new DMqttConfig();
		copy.url = url;
		copy.id = id;
		return copy;
	}
};
