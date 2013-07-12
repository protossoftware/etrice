/*******************************************************************************
 * Copyright (c) 2012 tieto deutschland gmbh (http://www.tieto.com)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

		if (checkArgs(args) == false) {
			System.exit(0);
		}

		new PedastrianLightWnd(Integer.parseInt(args[0]));
	}

	public static boolean checkArgs(String[] args) {
		// check length
		if (args.length != 1) {
			System.out
					.println("ERROR: wrong number of arguments - expected 1 argument");
			printUsage();
			return false;
		} else {
			try {
				Integer.parseInt(args[0]);
				return true;
			} catch (Exception e) {
				System.out.println("ERROR: integer value expected as argument");
				printUsage();
				return false;
			}
		}
	}

	public static void printUsage() {
		System.out.println("Usage:   java -jar trafficlight.jar [ip-address]");
		System.out.println("Example: java -jar trafficlight.jar 4440");
	}

}
