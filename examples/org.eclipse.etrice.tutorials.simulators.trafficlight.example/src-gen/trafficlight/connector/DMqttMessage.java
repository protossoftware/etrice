package trafficlight.connector;

import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;




public class DMqttMessage {
	
	
	/*--------------------- attributes ---------------------*/
	String topic;
	String payload;
	boolean retained;
	int qos;
	
	/* --------------------- attribute setters and getters */
	public void setTopic (String topic) {
		 this.topic = topic;
	}
	public String getTopic () {
		return this.topic;
	}
	public void setPayload (String payload) {
		 this.payload = payload;
	}
	public String getPayload () {
		return this.payload;
	}
	public void setRetained (boolean retained) {
		 this.retained = retained;
	}
	public boolean getRetained () {
		return this.retained;
	}
	public void setQos (int qos) {
		 this.qos = qos;
	}
	public int getQos () {
		return this.qos;
	}
	
	/*--------------------- operations ---------------------*/
	
	// default constructor
	public DMqttMessage() {
		super();
		
		// initialize attributes
		this.setTopic("");
		this.setPayload("");
	}
	
	// constructor using fields
	public DMqttMessage(String topic, String payload, boolean retained, int qos) {
		super();
		
		this.topic = topic;
		this.payload = payload;
		this.retained = retained;
		this.qos = qos;
	}
	
	// deep copy
	public DMqttMessage deepCopy() {
		DMqttMessage copy = new DMqttMessage();
		copy.topic = topic;
		copy.payload = payload;
		copy.retained = retained;
		copy.qos = qos;
		return copy;
	}
};
