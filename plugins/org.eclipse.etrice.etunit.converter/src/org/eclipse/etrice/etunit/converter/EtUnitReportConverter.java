/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 		Juergen Haug - added support for in-memory conversion
 * 
 *******************************************************************************/

package org.eclipse.etrice.etunit.converter;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

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
	
	public static class BaseOptions {
		private boolean combinedResults = false;
		private boolean replaceSuiteName = false;
		private boolean prefixSuiteName = false;
		private boolean onlyCombinedResults = false;
		private String combinedFile = null;
		private String suiteName = null;
		private String suiteNamePrefix = null;
		
		/** check that etUnit header line is present */
		private boolean checkEtUnitHeader = true;
		
		public boolean isCombinedResults() {
			return combinedResults;
		}

		public void setCombinedResults(boolean combinedResults) {
			this.combinedResults = combinedResults;
		}

		public boolean isReplaceSuiteName() {
			return replaceSuiteName;
		}

		public void setReplaceSuiteName(boolean replaceSuiteName) {
			this.replaceSuiteName = replaceSuiteName;
		}
		
		public boolean isPrefixSuiteName() {
			return prefixSuiteName;
		}
		
		public void setPrefixSuiteName(boolean appendSuiteName) {
			this.prefixSuiteName = appendSuiteName;
		}

		public boolean isOnlyCombinedResults() {
			return onlyCombinedResults;
		}

		public void setOnlyCombinedResults(boolean onlyCombinedResults) {
			this.onlyCombinedResults = onlyCombinedResults;
		}

		public String getCombinedFile() {
			return combinedFile;
		}

		public void setCombinedFile(String combinedFile) {
			this.combinedFile = combinedFile;
		}

		public String getSuiteName() {
			return suiteName;
		}

		public void setSuiteName(String suiteName) {
			this.suiteName = suiteName;
		}
		
		public String getSuiteNamePrefix() {
			return suiteNamePrefix;
		}
		
		public void setSuiteNamePrefix(String suiteNamePrefix) {
			this.suiteNamePrefix = suiteNamePrefix;
		}
		
		public boolean needCombined() {
			return combinedResults;
		}
		
		public boolean checkEtUnitHeader() {
			return checkEtUnitHeader;
		}
		
		public void setCheckEtUnitHeader(boolean checkEtUnitHeader) {
			this.checkEtUnitHeader = checkEtUnitHeader;
		}
	}
	
	public static class Options extends BaseOptions {
		private ArrayList<String> files = new ArrayList<String>();
			
		public ArrayList<String> getFiles() {
			return files;
		}

		public void setFiles(ArrayList<String> files) {
			this.files = files;
		}
		
		public boolean parseOptions(String[] args) {
			for (int i=0; i<args.length; ++i) {
				if (args[i].equals(OPTION_COMBINED)) {
					setCombinedResults(true);
					if (++i<args.length) {
						setCombinedFile(args[i]);
					}
					else {
						System.err.println("Error: "+OPTION_COMBINED+" must be followed by filename");
						return false;
					}
				}
				else if (args[i].equals(OPTION_SUITE_NAME)) {
					setReplaceSuiteName(true);
					if (++i<args.length) {
						setSuiteName(args[i]);
					}
					else {
						System.err.println("Error: "+OPTION_SUITE_NAME+" must be followed by a suite name");
						return false;
					}
				}
				else if(args[i].equals(OPTION_SUITE_NAME_PREFIX)) {
					setPrefixSuiteName(true);
					if(++i < args.length) {
						setSuiteNamePrefix(args[i]);
					}
					else {
						System.err.println("Error: " + OPTION_SUITE_NAME_PREFIX + "must be followed by a suite name prefix");
						return false;
					}
				}
				else if (args[i].equals(OPTION_ONLY_COMBINED)) {
					setCombinedResults(true);
					setOnlyCombinedResults(true);
					if (++i<args.length) {
						setCombinedFile(args[i]);
					}
					else {
						System.err.println("Error: "+OPTION_ONLY_COMBINED+" must be followed by filename");
						return false;
					}
				}
				else if (args[i].startsWith("-")) {
					int nextOption = parseOption(args, i);
					if (nextOption<0) {
						System.err.println("Error: unknown option "+args[i]);
						return false;
					}
					i = nextOption;
				}
				else {
					if (args[i].endsWith(ETU_EXTENSION))
						getFiles().add(args[i]);
					else {
						System.err.println("Error: invalid file name '"+args[i]+"' (only *"+ETU_EXTENSION+" files allowed)");
						return false;
					}
				}
			}
			if (getFiles().isEmpty()) {
				System.err.println("Error: no reports specified");
				return false;
			}
			
			return true;
		}

		/**
		 * @param args
		 * @param i
		 * @return
		 */
		protected int parseOption(String[] args, int i) {
			return -1;
		}
	}
	
	private static final String TC_END = "tc end";
	private static final String TC_FAIL = "tc fail";
	private static final String TC_START = "tc start";
	private static final String TS_START = "ts start: ";
	public static final String ETU_EXTENSION = ".etu";
	public static final String OPTION_COMBINED = "-combined";
	public static final String OPTION_ONLY_COMBINED = "-only_combined";
	public static final String OPTION_SUITE_NAME = "-suite";
	public static final String OPTION_SUITE_NAME_PREFIX = "-presuite";

	protected void printUsage() {
		System.err.println("usage: EtUnitReportConverter [("+OPTION_COMBINED+"|"+OPTION_ONLY_COMBINED+") <combined file>] ["+OPTION_SUITE_NAME+" <name>] <*"+ETU_EXTENSION+" files>\n"
				+"    "+OPTION_COMBINED+" <combined file>: also save a combined result for all tests to the specified file\n"
				+"    "+OPTION_ONLY_COMBINED+" <combined file>: don't create reports for every single test, only combined one to the specified file\n"
				+"    "+OPTION_SUITE_NAME+" <name>: replace the suite name in the result\n"
				+"    "+OPTION_SUITE_NAME_PREFIX+" <prefix>: prefix the prefix to the suitename\n"
			);
	}
	
	public static void main(String[] args) {
		int result = new EtUnitReportConverter().run(args);
		System.exit(result);
	}

	/**
	 * Can be used for testing.
	 */
	public int run(String[] args) {
		// check options and create file list
		Options options = parseOptions(args);
		if (options==null)
			return 1;

		doEMFRegistration();
		
		ResourceSet rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xml", new EtunitResourceFactoryImpl());

		boolean success = saveReports(options, rs);
		if (options.needCombined()) {
			success &= saveCombined(createCombinedReport(rs), options, rs);
		}
		
		return (success) ? 0 : 2;
	}
	
	/**
	 *  In-memory conversion. Returns a list of all successful converted reports.
	 *  TODO don't report errors on stderr.
	 */
	public List<String> convert(BaseOptions options, Iterable<InputStream> etUnitStreams) {
		ResourceSet rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xml", new EtunitResourceFactoryImpl());
		
		boolean success = saveReports(options, etUnitStreams, rs);
		final List<Resource> resources = new ArrayList<Resource>();
		if (options.needCombined()) {
			DocumentRoot root = createCombinedReport(rs);
			Resource res = rs.createResource(URI.createURI("dummy:/" + UUID.randomUUID() + ".xml"));
			res.getContents().add(root);
			resources.add(res);
		} else {
			resources.addAll(rs.getResources());
		}
		
		List<String> result = new ArrayList<String>();
		for(Resource res : resources) {
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			try {
				res.save(output, null);
				result.add(output.toString(StandardCharsets.UTF_8.name()));
			} catch (IOException e) {
				System.err.println("Error: could not serialize report");
				e.printStackTrace();
				success = false;
			}
		}
		
		return (success) ? result : Collections.emptyList();
	}
	
	/**
	 * @param args
	 * @return
	 */
	protected Options parseOptions(String[] args) {
		Options options = new Options();
		if (!options.parseOptions(args)) {
			printUsage();
			return null;
		}
		
		return options;
	}

	private DocumentRoot createCombinedReport(ResourceSet rs) {
		DocumentRoot root = EtunitFactory.eINSTANCE.createDocumentRoot();
		TestsuitesType testsuites = EtunitFactory.eINSTANCE.createTestsuitesType();
		root.setTestsuites(testsuites);

		for (Resource res : rs.getResources()) {
			DocumentRoot r = (DocumentRoot) res.getContents().get(0);
			testsuites.getTestsuite().addAll(r.getTestsuites().getTestsuite());
		}
		
		computeAndSetInfo(testsuites);
		
		return root;
	}

	protected boolean saveCombined(DocumentRoot root, Options options, ResourceSet rs) {
		if (options.isCombinedResults()) {
			File report = new File(options.getCombinedFile());
			return saveJUnitReport(root, report, rs, true);
		}
		return true;
	}
	
	protected boolean saveReports(BaseOptions options, Iterable<InputStream> etUnitStreams, ResourceSet rs) {
		boolean success = true;
		for (InputStream stream : etUnitStreams) {
			DocumentRoot root = applyOptions(options, createParseTree(stream, options));
			if((success &= root != null)) {
				Resource resource = rs.createResource(URI.createURI("dummy:/" + UUID.randomUUID() + ".xml"));
				resource.getContents().add(root);
			}
		}
		return success;
	}
	
	protected boolean saveReports(Options options, ResourceSet rs) {
		boolean success = true;
		for (String file : options.getFiles()) {
			File report = new File(file);
			if (report.exists()) {
				DocumentRoot root = applyOptions(options, createParseTree(report, options));
				success &= root != null && saveJUnitReport(root, report, rs, !options.isCombinedResults());
			}
			else {
				System.err.println("Error: report "+file+" does not exist");
				success = false;
			}
		}
		return success;
	}
	
	protected DocumentRoot applyOptions(BaseOptions options, DocumentRoot root) {
		if (root!=null && options.isReplaceSuiteName()) {
			if (root.getTestsuites()!=null) {
				if (root.getTestsuites().getTestsuite().size()==1) {
					root.getTestsuites().getTestsuite().get(0).setName(options.getSuiteName());
				}
				else {
					int i=0;
					for (TestsuiteType suite : root.getTestsuites().getTestsuite()) {
						suite.setName(options.getSuiteName()+i);
						++i;
					}
				}
			}
		}
		if(root != null && options.isPrefixSuiteName()) {
			if(root.getTestsuites() != null) {
				for(TestsuiteType suite : root.getTestsuites().getTestsuite()) {
					suite.setName(options.getSuiteNamePrefix() + suite.getName());
				}
			}
		}
		
		return root;
	}

	private boolean saveJUnitReport(DocumentRoot root, File report, ResourceSet rs, boolean save) {
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
				return false;
			}
		}
		return true;
	}

	private DocumentRoot createParseTree(File report, BaseOptions options) {
		
		FileReader input = null;	
		try {
			input = new FileReader(report.toString());
			BufferedReader bufRead = new BufferedReader(input);
			return createParseTree(bufRead, options);
		} catch (IOException e) {
			System.err.println("Error: file "+report+" could not be read ("+e.getMessage()+")");
			e.printStackTrace();
		} 
		finally {			
			try {			
				if(input != null)
					input.close();
			} catch (IOException e) {}
		}

		return null;
	}
	
	private DocumentRoot createParseTree(InputStream etUnitStream, BaseOptions options) {
		try {
			return createParseTree(new BufferedReader(new InputStreamReader(etUnitStream)), options);
		} catch (IOException e) {
			return null;
		}
	}
	
	private DocumentRoot createParseTree(BufferedReader bufRead, BaseOptions options) throws IOException {
		int count = 0;
		
		try {		
			if(options.checkEtUnitHeader) {
				String line = bufRead.readLine();
				++count;
				if (line==null) {
					System.err.println("Error: etUnit report is empty - no etunit file");
					return null;
				}
				if (!line.equals("etUnit report")) {
					System.err.println("Error: in etUnt report line "+line+" is missing header line - no etunit file");
					return null;
				}
			}
			
			HashMap<Integer, TestcaseType> id2case = new HashMap<Integer, TestcaseType>();
			TestsuiteType currentSuite = null;
			DocumentRoot root = EtunitFactory.eINSTANCE.createDocumentRoot();
			TestsuitesType testsuites = EtunitFactory.eINSTANCE.createTestsuitesType();
			root.setTestsuites(testsuites);
			
			String line = bufRead.readLine();
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
						System.err.println("Error: in etUnit report line "+count+" - unknown test case id");
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
						System.err.println("Error: in etUnit report line "+count+" - unknown test case id");
						return null;
					}
					// time was measured in ms. Convert to s
					tc.setTime(BigDecimal.valueOf(time/1000.0));
				}
				line = bufRead.readLine();
				++count;
			}
			
			computeAndSetInfo(testsuites);
			
			return root;
		} catch (NumberFormatException e) {
			System.err.println("Error: in etUnit report line "+count+" - could not read number");
			return null;
		}			
	}
	
	private void computeAndSetInfo(TestsuitesType testsuites) {
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

	private void doEMFRegistration() {
		if (!EPackage.Registry.INSTANCE.containsKey("platform:/resource/org.eclipse.etrice.etunit.converter/model/etunit.xsd")) {
			EPackage.Registry.INSTANCE.put("platform:/resource/org.eclipse.etrice.etunit.converter/model/etunit.xsd", EtunitPackage.eINSTANCE);
		}
	}
}