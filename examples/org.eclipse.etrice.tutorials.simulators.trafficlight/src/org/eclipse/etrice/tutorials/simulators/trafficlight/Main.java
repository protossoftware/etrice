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

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		if (args.length < 1) {
			System.out
					.println("ERROR: wrong number of arguments - expected >=1 argument");
			printUsage();
			System.exit(1);
		}
		else {
			try {
				int[] ports = new int[args.length];
				for (int i = 0; i < args.length; i++) {
					ports[i] = Integer.parseInt(args[i]);
				}

				new TrafficLightWnd(ports);
			}
			catch (Exception e) {
				System.out.println("ERROR: integer value expected as argument");
				printUsage();
				System.exit(1);
			}
		}
	}

	public static void printUsage() {
		System.out.println("Usage:   java -jar trafficlight.jar [ip-address]+");
		System.out.println("Example: java -jar trafficlight.jar 4440");
	}

}
