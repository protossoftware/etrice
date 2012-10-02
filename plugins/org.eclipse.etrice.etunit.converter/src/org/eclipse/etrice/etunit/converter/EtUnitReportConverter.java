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
import java.io.FileWriter;
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

	private static final String TC_END = "tc end";
	private static final String TC_FAIL = "tc fail";
	private static final String TC_START = "tc start";
	private static final String TS_START = "ts start: ";
	public static final String ETU_EXTENSION = ".etu";
	public static final String OPTION_COMBINED = "-combined";
	public static final String OPTION_ONLY_COMBINED = "-only_combined";
	public static final String OPTION_TEX_OUTPUT = "-tex";
	public static final String OPTION_SUITE_NAME = "-suite";

	private static void printUsage() {
		System.err.println("usage: EtUnitReportConverter [("+OPTION_COMBINED+"|"+OPTION_ONLY_COMBINED+") <combined file>] ["+OPTION_TEX_OUTPUT+" <tex file>] ["+OPTION_SUITE_NAME+" <name>] <*"+ETU_EXTENSION+" files>\n"
				+"    "+OPTION_COMBINED+" <combined file>: also save a combined result for all tests to the specified file\n"
				+"    "+OPTION_ONLY_COMBINED+" <combined file>: don't create reports for every single test, only combined one to the specified file\n"
				+"    "+OPTION_TEX_OUTPUT+" <tex file>: produce tex output to specified file\n"
				+"    "+OPTION_SUITE_NAME+" <name>: replace the suite name in the result\n"
			);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// check options and create file list
		boolean combinedResults = false;
		boolean replaceSuiteName = false;
		boolean onlyCombinedResults = false;
		String combinedFile = null;
		String suiteName = null;
		boolean texOutput = false;
		String texFile = null;
		ArrayList<String> files = new ArrayList<String>();
		for (int i=0; i<args.length; ++i) {
			if (args[i].equals(OPTION_COMBINED)) {
				combinedResults = true;
				if (++i<args.length) {
					combinedFile = args[i];
				}
				else {
					System.err.println("Error: "+OPTION_COMBINED+" must be followed by filename");
					printUsage();
					return;
				}
			}
			else if (args[i].equals(OPTION_SUITE_NAME)) {
				replaceSuiteName = true;
				if (++i<args.length) {
					suiteName = args[i];
				}
				else {
					System.err.println("Error: "+OPTION_SUITE_NAME+" must be followed by a suite name");
					printUsage();
					return;
				}
			}
			else if (args[i].equals(OPTION_ONLY_COMBINED)) {
				combinedResults = true;
				onlyCombinedResults = true;
				if (++i<args.length) {
					combinedFile = args[i];
				}
				else {
					System.err.println("Error: "+OPTION_ONLY_COMBINED+" must be followed by filename");
					printUsage();
					return;
				}
			}
			else if (args[i].equals(OPTION_TEX_OUTPUT)) {
				texOutput = true;
				if (++i<args.length) {
					texFile = args[i];
				}
				else {
					System.err.println("Error: "+OPTION_TEX_OUTPUT+" must be followed by filename");
					printUsage();
					return;
				}
			}
			else if (args[i].startsWith("-")) {
				System.err.println("Error: unknown option "+args[i]);
				printUsage();
				return;
			}
			else {
				if (args[i].endsWith(ETU_EXTENSION))
					files.add(args[i]);
				else {
					System.err.println("Error: invalid file name '"+args[i]+"' (only *"+ETU_EXTENSION+" files allowed)");
					printUsage();
					return;
				}
			}
		}
		if (files.isEmpty()) {
			System.err.println("Error: no reports specified");
			printUsage();
			return;
		}
		
		doEMFRegistration();
		
		ResourceSet rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xml", new EtunitResourceFactoryImpl());
		for (String file : files) {
			File report = new File(file);
			if (report.exists()) {
				DocumentRoot root = createParseTree(report);
				if (root!=null && replaceSuiteName) {
					if (root.getTestsuites()!=null) {
						if (root.getTestsuites().getTestsuite().size()==1) {
							root.getTestsuites().getTestsuite().get(0).setName(suiteName);
						}
						else {
							int i=0;
							for (TestsuiteType suite : root.getTestsuites().getTestsuite()) {
								suite.setName(suiteName+i);
								++i;
							}
						}
					}
				}
				if (root!=null) {
					saveJUnitReport(root, report, rs, !onlyCombinedResults);
				}
			}
			else {
				System.err.println("Error: report "+file+" does not exist");
			}
		}
		
		if (combinedResults || texOutput) {
			DocumentRoot root = EtunitFactory.eINSTANCE.createDocumentRoot();
			TestsuitesType testsuites = EtunitFactory.eINSTANCE.createTestsuitesType();
			root.setTestsuites(testsuites);

			for (Resource res : rs.getResources()) {
				DocumentRoot r = (DocumentRoot) res.getContents().get(0);
				testsuites.getTestsuite().addAll(r.getTestsuites().getTestsuite());
			}
			
			computeAndSetInfo(testsuites);
			
			if (combinedResults) {
				File report = new File(combinedFile);
				saveJUnitReport(root, report, rs, true);
			}
			if (texOutput) {
				File report = new File(texFile);
				saveTexReport(root, report);
			}
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

	private static void saveJUnitReport(DocumentRoot root, File report, ResourceSet rs, boolean save) {
		URI uri = URI.createFileURI(report.toString());
		uri = uri.trimFileExtension();
		uri = uri.appendFileExtension("xml");
		Resource resource = rs.createResource(uri);
		resource.getContents().add(root);
		if (save) {
			try {
				resource.save(Collections.EMPTY_MAP);
				System.out.println("saved "+uri);
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("Error: file "+uri+" could not be saved ("+e.getMessage()+")");
			}
		}
	}
	
	private static String doEscape(String x){
		int index = 0;
		String c = "azAZ";
		String ret = x;
		while (index < x.length()-2)
		{
			if (ret.charAt(index) >= c.charAt(0) && 
				ret.charAt(index) <= c.charAt(1) && 
				ret.charAt(index+1) >= c.charAt(2) && 
				ret.charAt(index+1) <= c.charAt(3)
			)
			{
				ret = ret.substring(0,index+1) + "\\-" + ret.substring(index+1);
			}
			index = index + 1;
		}
		return ret.replaceAll("_","\\\\-\\\\_");
	}

	private static void saveTexReport(DocumentRoot root, File report) {
		StringBuilder contents = new StringBuilder();

		contents.append("\\newcommand{\\ForAllTestCases}{}%\n");
		contents.append("\\newcounter{FailCount}%\n");
		contents.append("\\newcommand{\\ForAllSuites}{%\n");
		contents.append("    %\\DoSuite{name}{nTests}{nPassed}{nFail}{time}%\n");
		for (TestsuiteType ts : root.getTestsuites().getTestsuite()) {
			contents.append("    \\setcounter{FailCount}{"+ts.getFailures()+"}%\n");
			contents.append("    \\renewcommand{\\ForAllTestCases}{%\n");
			contents.append("        %\\DoCase{name}{time}{status}{msg}{short}{long}%\n");
			for (TestcaseType tc : ts.getTestcase()) {
				String status = tc.getFailure()!=null?"fail":"pass";
				String msg = tc.getFailure()!=null?
						"expected "+tc.getFailure().getExpected()+" but was "+tc.getFailure().getActual()
						:
						"";
				String combinedName = ts.getName()+tc.getName();
				contents.append("        \\DoCase{" + tc.getName() + "}{" + doEscape(tc.getName()) + "}{" + tc.getTime() + "}{" + status + "}{" + msg
						+ "}{\\" + combinedName + "shortdesc}{\\" + combinedName + "longdesc}%\n");
			}
			contents.append("    }%\n");
			int nPassed = ts.getTests()-ts.getFailures();
			contents.append("    \\DoSuite{"+ts.getName()+"}{" + doEscape(ts.getName()) + "}{"+ts.getTests()+"}{"+nPassed+"}{"+ts.getFailures()+"}{"+ts.getTime()+"}%\n");
		}
		contents.append("}%\n");
		
		FileWriter fos = null;
		try {
			fos = new FileWriter(report);
			fos.append(contents.toString());
		} catch (FileNotFoundException e) {
			System.err.println("Error: file "+report.toString()+" could not be saved ("+e.getMessage()+")");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error: file "+report.toString()+" could not be written ("+e.getMessage()+")");
			e.printStackTrace();
		}
		finally {
			if (fos!=null)
				try {
					fos.close();
				} catch (IOException e) {
					System.err.println("Error: file "+report.toString()+" could not be closed ("+e.getMessage()+")");
					e.printStackTrace();
				}
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
				bufRead.close();
				input.close();
				return null;
			}

			DocumentRoot root = EtunitFactory.eINSTANCE.createDocumentRoot();
			TestsuitesType testsuites = EtunitFactory.eINSTANCE.createTestsuitesType();
			root.setTestsuites(testsuites);
			
			line = bufRead.readLine();
			++count;
			while (line!=null) {
				if (line.startsWith(TS_START)) {
					currentSuite = EtunitFactory.eINSTANCE.createTestsuiteType();
					currentSuite.setName(line.substring(TS_START.length(), line.length()));
					testsuites.getTestsuite().add(currentSuite);
				}
				else if (line.startsWith(TC_START)) {
					int pos = line.indexOf(':');
					int id = Integer.parseInt(line.substring(9, pos));
					TestcaseType tc = EtunitFactory.eINSTANCE.createTestcaseType();
					tc.setName(line.substring(pos+2));
					id2case.put(id, tc);
					currentSuite.getTestcase().add(tc);
				}
				else if (line.startsWith(TC_FAIL)) {
					int pos = line.indexOf(':');
					int id = Integer.parseInt(line.substring(8, pos));
					TestcaseType tc = id2case.get(id);
					if (tc==null) {
						System.err.println("Error: in file "+report+", line "+count+" - unknown test case id");
						bufRead.close();
						input.close();
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
				else if (line.startsWith(TC_END)) {
					int pos = line.indexOf(':');
					int id = Integer.parseInt(line.substring(7, pos));
					int time = Integer.parseInt(line.substring(pos+2));
					TestcaseType tc = id2case.get(id);
					if (tc==null) {
						System.err.println("Error: in file "+report+", line "+count+" - unknown test case id");
						bufRead.close();
						input.close();
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
