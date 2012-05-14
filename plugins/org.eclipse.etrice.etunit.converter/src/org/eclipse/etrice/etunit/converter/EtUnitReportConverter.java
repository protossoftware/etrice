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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot;
import org.eclipse.etrice.etunit.converter.Etunit.EtunitFactory;
import org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage;
import org.eclipse.etrice.etunit.converter.Etunit.FailureType;
import org.eclipse.etrice.etunit.converter.Etunit.TestcaseType;
import org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType;
import org.eclipse.etrice.etunit.converter.Etunit.TestsuitesType;
import org.eclipse.etrice.etunit.converter.Etunit.util.EtunitResourceFactoryImpl;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class EtUnitReportConverter {

	private static final Object OPTION_COMBINE = "-combine";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean combineResults = false;
		String combinedFile = null;
		ArrayList<String> files = new ArrayList<String>();
		for (int i=0; i<args.length; ++i) {
			if (args[i].equals(OPTION_COMBINE)) {
				combineResults = true;
				if (++i<args.length) {
					combinedFile = args[i];
				}
				else {
					System.err.println("Error: "+OPTION_COMBINE+" must be followed by filename");
				}
			}
			else {
				files.add(args[i]);
			}
		}
		if (files.isEmpty()) {
			System.err.println("Error: no reports specified");
			return;
		}
		
		doEMFRegistration();
		
		ResourceSet rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xml", new EtunitResourceFactoryImpl());
		for (String file : files) {
			File report = new File(file);
			if (report.exists()) {
				DocumentRoot root = createParseTree(report);
				if (root!=null) {
					saveJUnitReport(root, report, rs);
				}
			}
			else {
				System.err.println("Error: report "+file+" does not exist");
			}
		}
		
		if (combineResults) {
			DocumentRoot root = EtunitFactory.eINSTANCE.createDocumentRoot();
			TestsuitesType testsuites = EtunitFactory.eINSTANCE.createTestsuitesType();
			root.setTestsuites(testsuites);

			for (Resource res : rs.getResources()) {
				DocumentRoot r = (DocumentRoot) res.getContents().get(0);
				testsuites.getTestsuite().addAll(r.getTestsuites().getTestsuite());
			}
			
			computeAndSetInfo(testsuites);
			
			File report = new File(combinedFile);
			saveJUnitReport(root, report, rs);
		}
	}

	private static void computeAndSetInfo(TestsuitesType testsuites) {
		for (TestsuiteType ts : testsuites.getTestsuite()) {
			int failures = 0;
			BigDecimal time = new BigDecimal(0);
			for (TestcaseType tc : ts.getTestcase()) {
				if (tc.getTime()!=null)
					time = time.add(tc.getTime());
				if (tc.getFailure()!=null)
					++failures;
			}
			ts.setTests(ts.getTestcase().size());
			ts.setFailures(failures);
			ts.setTime(time);
		}
	}

	private static void saveJUnitReport(DocumentRoot root, File report,
			ResourceSet rs) {
		URI uri = URI.createFileURI(report.toString());
		uri = uri.trimFileExtension();
		uri = uri.appendFileExtension("xml");
		Resource resource = rs.createResource(uri);
		resource.getContents().add(root);
		try {
			resource.save(Collections.EMPTY_MAP);
			System.out.println("saved "+uri);
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error: file "+uri+" could not be saved ("+e.getMessage()+")");
		}
	}

	/**
	 * @param string
	 * @return
	 */
	private static DocumentRoot createParseTree(File report) {
		
		int count = 0;
		try {
			FileReader input = new FileReader(report.toString());
			BufferedReader bufRead = new BufferedReader(input);

			HashMap<Integer, TestcaseType> id2case = new HashMap<Integer, TestcaseType>();
			TestsuiteType currentSuite = null;
			String line = bufRead.readLine();
			++count;
			if (!line.equals("etUnit report")) {
				System.err.println("Error: file "+report+", line "+line+" is missing header line - no etunit file");
				return null;
			}

			DocumentRoot root = EtunitFactory.eINSTANCE.createDocumentRoot();
			TestsuitesType testsuites = EtunitFactory.eINSTANCE.createTestsuitesType();
			root.setTestsuites(testsuites);
			
			line = bufRead.readLine();
			++count;
			while (line!=null) {
				if (line.startsWith("ts start")) {
					currentSuite = EtunitFactory.eINSTANCE.createTestsuiteType();
					currentSuite.setName(line.substring(9, line.length()));
					testsuites.getTestsuite().add(currentSuite);
				}
				else if (line.startsWith("tc start")) {
					int pos = line.indexOf(':');
					int id = Integer.parseInt(line.substring(9, pos));
					TestcaseType tc = EtunitFactory.eINSTANCE.createTestcaseType();
					tc.setName(line.substring(pos+2));
					id2case.put(id, tc);
					currentSuite.getTestcase().add(tc);
				}
				else if (line.startsWith("tc fail")) {
					int pos = line.indexOf(':');
					int id = Integer.parseInt(line.substring(8, pos));
					TestcaseType tc = id2case.get(id);
					if (tc==null) {
						System.err.println("Error: in file "+report+", line "+count+" - unknown test case id");
						return null;
					}
					FailureType fail = EtunitFactory.eINSTANCE.createFailureType();
					pos = line.indexOf('#')+1;
					int end = line.indexOf('#', pos);
					if (end>pos)
						fail.setExpected(line.substring(pos, end));
					pos = end+1;
					end = line.indexOf('#', pos);
					if (end>pos)
						fail.setActual(line.substring(pos, end));
					pos = end+1;
					end = line.indexOf('#', pos);
					String loc = (end>pos)? line.substring(pos, end) : null;
					pos = line.lastIndexOf('#');
					String trace = line.substring(pos+1);
					if (loc!=null)
						trace += "\n at "+loc;
					FeatureMapUtil.addText(fail.getMixed(), trace);
					tc.setFailure(fail);
				}
				else if (line.startsWith("tc end")) {
					int pos = line.indexOf(':');
					int id = Integer.parseInt(line.substring(7, pos));
					int time = Integer.parseInt(line.substring(pos+2));
					TestcaseType tc = id2case.get(id);
					if (tc==null) {
						System.err.println("Error: in file "+report+", line "+count+" - unknown test case id");
						return null;
					}
					tc.setTime(BigDecimal.valueOf(time));
				}
				line = bufRead.readLine();
				++count;
			}
			
			bufRead.close();
			
			computeAndSetInfo(testsuites);
			
			return root;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("Error: file "+report+" could not be read ("+e.getMessage()+")");
		} catch (IOException e) {
			System.err.println("Error: file "+report+" could not be read ("+e.getMessage()+")");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.err.println("Error: in file "+report+", line "+count+" - could not read number");
		}
		
		return null;
	}

	private static void doEMFRegistration() {
		if (!EPackage.Registry.INSTANCE.containsKey("platform:/resource/org.eclipse.etrice.etunit.converter/model/etunit.xsd")) {
			EPackage.Registry.INSTANCE.put("platform:/resource/org.eclipse.etrice.etunit.converter/model/etunit.xsd", EtunitPackage.eINSTANCE);
		}
	}
}
