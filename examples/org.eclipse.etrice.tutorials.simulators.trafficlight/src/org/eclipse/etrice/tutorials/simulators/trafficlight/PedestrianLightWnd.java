/*******************************************************************************
 * Copyright (c) 2012 tieto deutschland gmbh (http://www.tieto.com)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Thomas Jung (initial contribution)
 *    Thomas Schuetz
 *******************************************************************************/

package org.eclipse.etrice.tutorials.simulators.trafficlight;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 
 * @author tschuetz
 *
 */
public class PedestrianLightWnd extends Frame {
	private static final long serialVersionUID = 1L;

	private TrafficLight3 carLights = null;
	private TrafficLight2 pedLights = null;

	ButtonActionListener buttonListener = null;

	Button requestButton = null;
	TextField statusLine = null;


	public PedestrianLightWnd(int ipPort) {
		super("Pedestrian Lights GUI");
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc;
		carLights = new TrafficLight3();
		pedLights = new TrafficLight2();
		statusLine = new TextField();
		requestButton = new Button("REQUEST");
		requestButton.setEnabled(false);
		addWindowListener(new WindowClosingAdapter(true));

		setLayout(layout);

		gbc = makeGbc(0, 1, 1, 1);
		layout.setConstraints(carLights, gbc);
		add(carLights);

		gbc = makeGbc(1, 1, 1, 1);
		layout.setConstraints(pedLights, gbc);
		add(pedLights);

		statusLine.setText("listening on TCP Port " + ipPort);
		statusLine.setEditable(false);
		statusLine.setFocusable(false);
		gbc = makeGbc(0, 0, 2, 1);
		gbc.fill = GridBagConstraints.BOTH;
		layout.setConstraints(statusLine, gbc);
		add(statusLine);

		gbc = makeGbc(0, 2, 2, 1);
		gbc.fill = GridBagConstraints.BOTH;
		layout.setConstraints(requestButton, gbc);
		add(requestButton);

		pack();
		setVisible(true);

		loopSocket(ipPort); // blocking loop
	}

	private void loopSocket(int ipPort) {
		while (true) {
			// open and close socket endlessly
			try {
				// open Socket
				ServerSocket socketServer = new ServerSocket(ipPort);

				// wait blocking for client to connect
				Socket socket = socketServer.accept();
				statusLine.setText("socket connected !");

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
					dispatchCommand(requestButton, cmd);
				}
				statusLine.setText("socket disconnected !");

				// deactivate button
				requestButton.removeActionListener(buttonListener);
				requestButton.setEnabled(false);

				resetLights();

				// clean up socket
				socket.close();
				socketServer.close();
				
			} catch (IOException e) {
				System.err.println(e.toString());
				//System.exit(1);
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

	private GridBagConstraints makeGbc(int x, int y, int width, int height) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		gbc.weightx = 1;
		gbc.weighty = 1;
		// gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(1, 1, 1, 1);
		return gbc;
	}
}
