/*******************************************************************************
 * Copyright (c) 2012 tieto deutschland gmbh (http://www.tieto.com)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Thomas Jung
 *    Thomas Schuetz
 *******************************************************************************/ 


package org.eclipse.etrice.tutorials.simulators.trafficlight;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.net.*;
import java.awt.event.ActionEvent;

public class PedastrianLightWnd extends Frame {
	// Konstructor
	public PedastrianLightWnd (int ipPort){
		super("PedestrianLightsGUI");		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc;
		TrafficLight3 carLights = new TrafficLight3(4);
		TrafficLight2 pedLights = new TrafficLight2(2);
		TextField statusLine = new TextField();
		Button requestButton = new Button("REQUEST");
		requestButton.setEnabled(false);
		addWindowListener(new WindowClosingAdapter(true));
		char cmdString[]=new char[100];
		int cmdCounter = 0, cmdState = 0;
		
		setLayout(layout);
		
		gbc=makeGbc(0,1,1,1);
		layout.setConstraints(carLights,gbc);
		add(carLights);
		
		gbc=makeGbc(1,1,1,1);
		layout.setConstraints(pedLights,gbc);
		add(pedLights);
		
		statusLine.setText("listening on TCP Port " + ipPort);
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

		// open socket 
		try {
			ServerSocket echod = new ServerSocket(ipPort);
			Socket socket = echod.accept();
			statusLine.setText("connected !");

		//	InputStream in = socket.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			OutputStream out = socket.getOutputStream();

			requestButton.addActionListener(new ButtonActionListener(out));
			requestButton.setEnabled(true);
			
			carLights.setState(4);
			pedLights.setState(2);

			String cmd;

			while ((cmd = in.readLine()) != null){

				if (cmd.equals("carLights=red")){
					carLights.setState(0);
					}
				if (cmd.equals("carLights=yellowRed")){
					carLights.setState(1);
					}
				if (cmd.equals("carLights=green")){
					carLights.setState(2);
					}
				if (cmd.equals("carLights=yellow")){
					carLights.setState(3);
					}
				if (cmd.equals("pedLights=red")){
					pedLights.setState(0);
					}
				if (cmd.equals("pedLights=green")){
					pedLights.setState(1);
					}
				if (cmd.equals("pedLights=off")){
					pedLights.setState(2);
					}
				if (cmd.equals("carLights=off")){
					carLights.setState(4);
					}
				if (cmd.equals("button=on")){
					requestButton.setEnabled(true);
					}
				if (cmd.equals("button=off")){
					requestButton.setEnabled(false);
					}
			}
			 // System.out.println("Verbindung beendet");
			socket.close();
			echod.close();
		}catch (IOException e) {
			System.err.println(e.toString());
			System.exit(1);
		}
	}
	
	private GridBagConstraints makeGbc(int x, int y, int width, int height){
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		gbc.weightx = 1;
		gbc.weighty = 1;
		// gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(1,1,1,1);
		return gbc;
		}	
}
