/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.etunit.converter;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.etrice.etunit.converter.tests.Activator;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class ConverterTest {

	private String basePath;

	@Before
	public void prepare() {
		try {
			URL modelsDir = Activator.getInstance().getBundle().getEntry("reports");
			URL fileURL = FileLocator.toFileURL(modelsDir);
			basePath = fileURL.getFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testConversion() {
		ArrayList<String> args = new ArrayList<String>();
		args.add(basePath+"report1.etu");
		
		String[] arguments = new String[args.size()];
		EtUnitReportConverter.main(args.toArray(arguments));
	}

	@Test
	public void testDoubleConversion() {
		ArrayList<String> args = new ArrayList<String>();
		args.add(basePath+"report1.etu");
		args.add(basePath+"report2.etu");
		
		String[] arguments = new String[args.size()];
		EtUnitReportConverter.main(args.toArray(arguments));
	}

	@Test
	public void testCombine() {
		ArrayList<String> args = new ArrayList<String>();
		args.add(basePath+"report1.etu");
		args.add(basePath+"report2.etu");
		args.add(EtUnitReportConverter.OPTION_COMBINED);
		args.add(basePath+"combined.xml");
		
		String[] arguments = new String[args.size()];
		EtUnitReportConverter.main(args.toArray(arguments));
	}

	@Test
	public void testOnlyCombine() {
		ArrayList<String> args = new ArrayList<String>();
		args.add(basePath+"report3.etu");
		args.add(basePath+"report4.etu");
		args.add(EtUnitReportConverter.OPTION_ONLY_COMBINED);
		args.add(basePath+"only_combined.xml");
		
		String[] arguments = new String[args.size()];
		EtUnitReportConverter.main(args.toArray(arguments));
	}

	@Test
	public void testChangeSuiteName() {
		ArrayList<String> args = new ArrayList<String>();
		args.add(basePath+"report5.etu");
		args.add(EtUnitReportConverter.OPTION_SUITE_NAME);
		args.add("new.suite.name");
		
		String[] arguments = new String[args.size()];
		EtUnitReportConverter.main(args.toArray(arguments));
	}

	@Test
	public void testEmptyFile() {
		ArrayList<String> args = new ArrayList<String>();
		args.add(basePath+"report6.etu");
		
		String[] arguments = new String[args.size()];
		EtUnitReportConverter.main(args.toArray(arguments));
	}
}
