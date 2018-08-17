/*******************************************************************************
 * Copyright (c) 2012 tieto deutschland gmbh (http://www.tieto.com)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thomas Jung (initial contribution)
 *    
 *******************************************************************************/ 


package org.eclipse.etrice.tutorials.simulators.trafficlight;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;
import java.io.IOException;

public class ButtonActionListener 
implements ActionListener {

	private OutputStream out;
	private String buttonPressedCmd = "pressedRequestButton\n";
	
	public ButtonActionListener(OutputStream out){
		this.out = out;
	}
	
	public void actionPerformed(ActionEvent event) {
		String s = event.getActionCommand();
		
		if (s.equals("REQUEST")) {
			try {
				out.write(buttonPressedCmd.getBytes());
				out.flush();
			}
			catch (IOException e){
				System.out.println(e.toString());
			}
		}
	}
}
