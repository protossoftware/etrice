/*******************************************************************************
 * Copyright (c) 2015 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.tutorials.simulators.trafficlight;

import java.awt.Button;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.TextField;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class TrafficLightBlock extends Container implements Runnable {

	private static final long serialVersionUID = -3401948826048669424L;

	private TrafficLight3 carLights = null;
	private TrafficLight2 pedLights = null;

	private ButtonActionListener buttonListener = null;

	private Button requestButton = null;
	private TextField statusLine = null;

	private int ipPort;

	public TrafficLightBlock(int ipPort) {
		this.ipPort = ipPort;
		
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		
		Label label = new Label();
		label.setText("Traffic light set for TCP Port " + ipPort);
		layout.setConstraints(label, makeGbc(0, 0, true));
		add(label);

		statusLine = new TextField();
		statusLine.setText("listening");
		statusLine.setEditable(false);
		statusLine.setFocusable(false);
		layout.setConstraints(statusLine, makeGbc(0, 1, true));
		add(statusLine);

		carLights = new TrafficLight3();
		layout.setConstraints(carLights, makeGbc(0, 2, false));
		add(carLights);

		pedLights = new TrafficLight2();
		layout.setConstraints(pedLights, makeGbc(1, 2, false));
		add(pedLights);

		requestButton = new Button("REQUEST");
		requestButton.setEnabled(false);
		layout.setConstraints(requestButton, makeGbc(0, 3, true));
		add(requestButton);
	}
	
	public void run() {
		loopSocket(ipPort); // blocking loop
	}

	private void loopSocket(int ipPort) {
		ServerSocket socketServer = null;
		try {
			// open Socket
			System.out.println("listening on port "+ipPort);
			socketServer = new ServerSocket(ipPort);
			
			while (true) {
				// open and close socket endlessly
				try {
					// wait blocking for client to connect
					Socket socket = socketServer.accept();
					socket.setKeepAlive(true);
					statusLine.setText("accepting commands at port "+ipPort);
					
					// prepare input and output streams
					BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					OutputStream out = socket.getOutputStream();
					
					// add listener for outgoing command
					buttonListener = new ButtonActionListener(out);
					requestButton.addActionListener(buttonListener);
					requestButton.setEnabled(true);
					
					resetLights();
					
					// read blocking until socket is disconnected 
					String cmd;
					while ((cmd = in.readLine()) != null) {
						System.out.println("Received Command:" + cmd);
						
						if (cmd.equals("disconnect"))
							break;
						
						dispatchCommand(requestButton, cmd);
					}
					statusLine.setText("listening");
					
					// deactivate button
					requestButton.removeActionListener(buttonListener);
					requestButton.setEnabled(false);
					
					resetLights();
					
					// clean up socket
					socket.close();
					
				} catch (IOException e) {
					//System.err.println(e.toString());
					//System.exit(1);
				}
			}
		}
		catch (IOException e1) {
			e1.printStackTrace();
			return;
		}
		finally {
			 try {
				if (socketServer != null) {
					socketServer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	private void dispatchCommand(Button requestButton, String cmd) {
		// check carLights
		if (cmd.equals("setCarLightRed=on")) {
			carLights.setRedLight(1);
		}
		if (cmd.equals("setCarLightRed=off")) {
			carLights.setRedLight(0);
		}
		if (cmd.equals("setCarLightYellow=on")) {
			carLights.setYellowLight(1);
		}
		if (cmd.equals("setCarLightYellow=off")) {
			carLights.setYellowLight(0);
		}
		if (cmd.equals("setCarLightGreen=on")) {
			carLights.setGreenLight(1);
		}
		if (cmd.equals("setCarLightGreen=off")) {
			carLights.setGreenLight(0);
		}
		
		// check pedLights
		if (cmd.equals("setPedLightRed=on")) {
			pedLights.setRedLight(1);
		}
		if (cmd.equals("setPedLightRed=off")) {
			pedLights.setRedLight(0);
		}
		if (cmd.equals("setPedLightGreen=on")) {
			pedLights.setGreenLight(1);
		}
		if (cmd.equals("setPedLightGreen=off")) {
			pedLights.setGreenLight(0);
		}

		// check button
		if (cmd.equals("setRequestButtonActive=on")) {
			requestButton.setEnabled(true);
		}
		if (cmd.equals("setRequestButtonActive=off")) {
			requestButton.setEnabled(false);
		}
		carLights.repaint();
		pedLights.repaint();
	}

	private void resetLights() {
		carLights.setRedLight(0);
		carLights.setYellowLight(0);
		carLights.setGreenLight(0);

		pedLights.setRedLight(0);
		pedLights.setGreenLight(0);
	}
	
	private GridBagConstraints makeGbc(int x, int y, boolean both) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = both? 2:1;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		if (both) {
			 gbc.fill = GridBagConstraints.BOTH;
		}
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(1, 1, 1, 1);
		return gbc;
	}
}
