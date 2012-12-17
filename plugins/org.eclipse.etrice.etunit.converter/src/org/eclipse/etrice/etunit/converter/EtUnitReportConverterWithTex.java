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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot;
import org.eclipse.etrice.etunit.converter.Etunit.TestcaseType;
import org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class EtUnitReportConverterWithTex extends EtUnitReportConverter {

	protected static class TexOptions extends EtUnitReportConverter.Options {
		
		private boolean texOutput = false;
		private String texFile = null;

		/* (non-Javadoc)
		 * @see org.eclipse.etrice.etunit.converter.EtUnitReportConverter.Options#needCombined()
		 */
		@Override
		public boolean needCombined() {
			return isCombinedResults() || texOutput;
		}

		public boolean isTexOutput() {
			return texOutput;
		}

		public void setTexOutput(boolean texOutput) {
			this.texOutput = texOutput;
		}

		public String getTexFile() {
			return texFile;
		}

		public void setTexFile(String texFile) {
			this.texFile = texFile;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.etrice.etunit.converter.EtUnitReportConverter.Options#parseOption(java.lang.String[], int)
		 */
		@Override
		protected int parseOption(String[] args, int i) {
			if (args[i].equals(OPTION_TEX_OUTPUT)) {
				setTexOutput(true);
				if (++i<args.length) {
					setTexFile(args[i]);
					return i;
				}
				else {
					System.err.println("Error: "+OPTION_TEX_OUTPUT+" must be followed by filename");
				}
			}
			return -1;
		}
	}
	
	public static final String OPTION_TEX_OUTPUT = "-tex";


	protected void printUsage() {
		System.err.println("usage: EtUnitReportConverterTex [("+OPTION_COMBINED+"|"+OPTION_ONLY_COMBINED+") <combined file>] ["+OPTION_TEX_OUTPUT+" <tex file>] ["+OPTION_SUITE_NAME+" <name>] <*"+ETU_EXTENSION+" files>\n"
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
		new EtUnitReportConverterWithTex().run(args);
	}
	
	/**
	 * @param args
	 * @return
	 */
	protected Options parseOptions(String[] args) {
		TexOptions options = new TexOptions();
		if (!options.parseOptions(args)) {
			printUsage();
			return null;
		}
		
		return options;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.etunit.converter.EtUnitReportConverter#saveCombined(org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot, org.eclipse.etrice.etunit.converter.EtUnitReportConverter.Options, org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	@Override
	protected void saveCombined(DocumentRoot root, Options options, ResourceSet rs) {
		super.saveCombined(root, options, rs);
		
		if (options instanceof Options && ((TexOptions)options).isTexOutput()) {
			File report = new File(((TexOptions)options).getTexFile());
			saveTexReport(root, report);
		}
	}
	
	private String doEscape(String x){
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

	private void saveTexReport(DocumentRoot root, File report) {
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
}
