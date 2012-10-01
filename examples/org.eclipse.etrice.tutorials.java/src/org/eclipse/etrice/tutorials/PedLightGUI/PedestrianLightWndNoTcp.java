/*******************************************************************************
 * Copyright (c) 2011 tieto deutschland gmbh (http://www.tieto.com)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Thomas Jung
 *******************************************************************************/ 

package org.eclipse.etrice.tutorials.PedLightGUI;

//This is used for PedLightController tutorial and must be disabled for Blinky 
import PedLightsController.PedControlProtocol.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A little simple Trafficlight GUI for the etrice tutorials
 * 
 * @author Thomas Jung
 *
 */
@SuppressWarnings("serial")
public class PedestrianLightWndNoTcp extends Frame 
implements ActionListener {
	private TrafficLight3 carLights;
	private TrafficLight2 pedLights;
	Button requestButton;
	TextField statusLine;

	//This is used for PedLightController tutorial and must be disabled for Blinky
	private PedControlProtocolConjPort port=null;
	
	// Constructors
	public PedestrianLightWndNoTcp(){
		super("PedastrianLightsGUI");
		setupWindow();
		statusLine.setText("    direct connection");
	}
	
	public PedestrianLightWndNoTcp(String wnd, String but){
		super(wnd);		
		setupWindow();
		statusLine.setText(but);
	}

	private void setupWindow(){
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc;
		carLights = new TrafficLight3(TrafficLight3.OFF);
		pedLights = new TrafficLight2(TrafficLight2.OFF);
		statusLine = new TextField();
		requestButton = new Button("REQUEST");
		requestButton.setEnabled(false);
		addWindowListener(new WindowClosingAdapter(true));
		
		setLayout(layout);
		
		gbc=makeGbc(0,1,1,1);
		layout.setConstraints(carLights,gbc);
		add(carLights);
		
		gbc=makeGbc(1,1,1,1);
		layout.setConstraints(pedLights,gbc);
		add(pedLights);
		
		statusLine.setText("");
		statusLine.setEditable(false);
		statusLine.setFocusable(false);
		gbc = makeGbc(0,0,2,1);
		gbc.fill = GridBagConstraints.BOTH;
		layout.setConstraints(statusLine,gbc);
		add(statusLine);

		gbc = makeGbc(0,2,2,1);
		gbc.fill = GridBagConstraints.BOTH;
		layout.setConstraints(requestButton,gbc);
		add(requestButton);

		pack();
		setVisible(true);

		requestButton.addActionListener(this);
		requestButton.setEnabled(true);
		
		carLights.setState(TrafficLight3.RED);
		pedLights.setState(TrafficLight2.RED);
	}
	
	public TrafficLight3 getCarLights(){
		return carLights;
	}
	
	public TrafficLight2 getPedLights(){
		return pedLights;
	}
	
	private GridBagConstraints makeGbc(int x, int y, int width, int height){
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(1,1,1,1);
		return gbc;
		}	
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String s = arg0.getActionCommand();
		
		if (s.equals("REQUEST")) {
			System.out.println("Taste gedrückt");
		// This is used for PedLightController tutorial and must be disabled for Blinky	
			if (port != null) port.start();
		}
	}
	public void closeWindow(){
		   this.setVisible(false);
		   this.dispose();
		  // System.exit(0);
	}

// This is used for PedLightController tutorial and must be disabled for Blinky	
	public void setPort(PedControlProtocolConjPort p){
		port=p;
	}
}