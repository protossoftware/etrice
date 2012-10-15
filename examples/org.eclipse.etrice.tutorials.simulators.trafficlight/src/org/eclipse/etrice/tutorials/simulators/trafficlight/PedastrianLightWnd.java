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

public class PedastrianLightWnd extends Frame {
	private static final long serialVersionUID = 1L;

	private TrafficLight3 carLights = null;
	private TrafficLight2 pedLights = null;

	ButtonActionListener buttonListener = null;

	Button requestButton = null;
	TextField statusLine = null;

	private void resetLights() {
		carLights.setState(4);
		pedLights.setState(2);
	}

	public PedastrianLightWnd(int ipPort) {
		super("PedestrianLightsGUI");
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc;
		carLights = new TrafficLight3(4);
		pedLights = new TrafficLight2(2);
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
				ServerSocket echod = new ServerSocket(ipPort);

				Socket socket = echod.accept();
				statusLine.setText("socket connected !");

				BufferedReader in = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
				OutputStream out = socket.getOutputStream();

				buttonListener = new ButtonActionListener(out);
				requestButton.addActionListener(buttonListener);
				requestButton.setEnabled(true);

				resetLights();

				String cmd;
				while ((cmd = in.readLine()) != null) {
					dispatchCommand(requestButton, cmd);
				}
				statusLine.setText("socket disconnected !");

				// deactivate button
				requestButton.removeActionListener(buttonListener);
				requestButton.setEnabled(false);

				resetLights();

				// clean up socket
				socket.close();
				echod.close();
			} catch (IOException e) {
				System.err.println(e.toString());
				System.exit(1);
			}
		}
	}

	private void dispatchCommand(Button requestButton, String cmd) {
		// check carLights
		if (cmd.equals("carLights=red")) {
			carLights.setState(carLights.RED);
		}
		if (cmd.equals("carLights=yellowRed")) {
			carLights.setState(carLights.YELLOWRED);
		}
		if (cmd.equals("carLights=green")) {
			carLights.setState(carLights.GREEN);
		}
		if (cmd.equals("carLights=yellow")) {
			carLights.setState(carLights.YELLOW);
		}
		if (cmd.equals("carLights=off")) {
			carLights.setState(carLights.OFF);
		}

		// check pedLights
		if (cmd.equals("pedLights=red")) {
			pedLights.setState(pedLights.RED);
		}
		if (cmd.equals("pedLights=green")) {
			pedLights.setState(pedLights.GREEN);
		}
		if (cmd.equals("pedLights=off")) {
			pedLights.setState(pedLights.OFF);
		}

		// check button
		if (cmd.equals("button=on")) {
			requestButton.setEnabled(true);
		}
		if (cmd.equals("button=off")) {
			requestButton.setEnabled(false);
		}
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
