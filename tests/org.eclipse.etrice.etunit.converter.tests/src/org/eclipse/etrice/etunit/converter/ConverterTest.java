/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.etunit.converter;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.etrice.etunit.converter.EtUnitReportConverter.BaseOptions;
import org.eclipse.etrice.etunit.converter.tests.Activator;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class ConverterTest {

	private String basePath;
	private String expectsPath;

	@Before
	public void prepare() {
		try {
			URL modelsDir = Activator.getInstance().getBundle().getEntry("reports");
			URL fileURL = FileLocator.toFileURL(modelsDir);
			basePath = fileURL.getFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			URL modelsDir = Activator.getInstance().getBundle().getEntry("expects");
			URL fileURL = FileLocator.toFileURL(modelsDir);
			expectsPath = fileURL.getFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testConversion() throws IOException {
		ArrayList<String> args = new ArrayList<String>();
		args.add(basePath+"report1.etu");
		
		String[] arguments = new String[args.size()];
		new EtUnitReportConverter().run(args.toArray(arguments));
		
		assertEquals(Files.toString(new File(expectsPath+"report1.xml"), Charsets.UTF_8), Files.toString(new File(basePath+"report1.xml"), Charsets.UTF_8));
	}
	

	@Test
	public void testDoubleConversion() {
		ArrayList<String> args = new ArrayList<String>();
		args.add(basePath+"report1.etu");
		args.add(basePath+"report2.etu");
		
		String[] arguments = new String[args.size()];
		new EtUnitReportConverter().run(args.toArray(arguments));
	}

	@Test
	public void testCombine() {
		ArrayList<String> args = new ArrayList<String>();
		args.add(basePath+"report1.etu");
		args.add(basePath+"report2.etu");
		args.add(EtUnitReportConverter.OPTION_COMBINED);
		args.add(basePath+"combined.xml");
		
		String[] arguments = new String[args.size()];
		new EtUnitReportConverter().run(args.toArray(arguments));
	}

	@Test
	public void testOnlyCombine() {
		ArrayList<String> args = new ArrayList<String>();
		args.add(basePath+"report3.etu");
		args.add(basePath+"report4.etu");
		args.add(EtUnitReportConverter.OPTION_ONLY_COMBINED);
		args.add(basePath+"only_combined.xml");
		
		String[] arguments = new String[args.size()];
		new EtUnitReportConverter().run(args.toArray(arguments));
	}

	@Test
	public void testChangeSuiteName() {
		ArrayList<String> args = new ArrayList<String>();
		args.add(basePath+"report5.etu");
		args.add(EtUnitReportConverter.OPTION_SUITE_NAME);
		args.add("new.suite.name");
		
		String[] arguments = new String[args.size()];
		new EtUnitReportConverter().run(args.toArray(arguments));
	}

	@Test
	public void testEmptyFile() {
		ArrayList<String> args = new ArrayList<String>();
		args.add(basePath+"report6.etu");
		
		String[] arguments = new String[args.size()];
		new EtUnitReportConverter().run(args.toArray(arguments));
	}
	
	@Test
	public void testInMemory() throws IOException {
		List<InputStream> streams = new ArrayList<InputStream>();
		streams.add(new FileInputStream(new File(basePath+"report1.etu")));
		
		List<String> results = new EtUnitReportConverter().convert(new BaseOptions(), streams);
		assertEquals(1,  results.size());
		assertEquals(Files.toString(new File(expectsPath+"report1.xml"), Charsets.UTF_8), results.get(0));
	}
}
