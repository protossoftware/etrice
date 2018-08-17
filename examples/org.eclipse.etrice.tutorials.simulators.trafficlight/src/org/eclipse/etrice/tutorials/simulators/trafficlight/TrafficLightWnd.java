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
 *    Thomas Schuetz
 *******************************************************************************/

package org.eclipse.etrice.tutorials.simulators.trafficlight;

import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

/**
 * 
 * @author Thomas Schuetz
 *
 */
public class TrafficLightWnd extends Frame {
	private static final long serialVersionUID = 1L;

	public TrafficLightWnd(int[] ipPorts) {
		super("Traffic Lights GUI");
		
		addWindowListener(new WindowClosingAdapter(true));

		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		
		TrafficLightBlock[] lightBlocks = new TrafficLightBlock[ipPorts.length];
		for (int i = 0; i < ipPorts.length; i++) {
			lightBlocks[i] = new TrafficLightBlock(ipPorts[i]);
			layout.setConstraints(lightBlocks[i], makeGbc(i, 0, false));
			add(lightBlocks[i]);
		}

		pack();
		setVisible(true);
		
		Thread[] lightBlockThreads = new Thread[lightBlocks.length];
		for (int i = 0; i < ipPorts.length; i++) {
			lightBlockThreads[i] = new Thread(lightBlocks[i]);
			lightBlockThreads[i].start();
		}
		
		try {
			for (int i = 0; i < ipPorts.length; i++) {
				lightBlockThreads[i].join();
			}
		}
		catch (InterruptedException e) {
		}
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
