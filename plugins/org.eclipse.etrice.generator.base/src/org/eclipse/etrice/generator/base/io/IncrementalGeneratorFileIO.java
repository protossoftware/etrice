/*******************************************************************************
* Copyright (c) 2013 protos software gmbh (http://www.protos.de).
* All rights reserved.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
*
* CONTRIBUTORS:
*           Henrik Rentz-Reichert (initial contribution)
*
 *******************************************************************************/

package org.eclipse.etrice.generator.base.io;

import java.io.File;
import java.io.IOException;
import java.util.zip.CRC32;

import org.apache.commons.io.FileUtils;
import org.eclipse.etrice.generator.base.logging.ILogger;
import org.eclipse.etrice.generator.base.logging.NullLogger;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.util.RuntimeIOException;

import com.google.inject.Inject;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class IncrementalGeneratorFileIO implements IGeneratorFileIO {

	private String genDir;
	private String genInfoDir;
	private ILogger logger;
	private boolean generateIncremental;
	private JavaIoFileSystemAccess fileAccess;
	
	@Inject
	public IncrementalGeneratorFileIO(JavaIoFileSystemAccess fileAccess) {
		setGenDir("src-gen");
		setGenInfoDir("src-gen-info");
		setGenerateIncremental(false);
		setLogger(new NullLogger());
		
		this.fileAccess = fileAccess;
	}

	/**
	 * This method computes a hash key (a {@link java.util.zip.CRC32 CRC32} value) for the file contents
	 * and compares it to the
	 * one stored in the {@code infopath} directory with an added extension ".info". If the values are equal
	 * then the file stored in the {@code infopath} is copied to {@code path} while preserving the file data.
	 * In the other case the key is stored and the file is stored to {@code infopath} and {@code path}.
	 */
	@Override
	public void generateFile(String desc, String file, CharSequence contents) {
		
		long oldCRC = 0;
		
		// use local copy to avoid inconsistencies due to concurrent change
		boolean genInc = generateIncremental;
		
		if (genInc) {
			// read old CRC value
			fileAccess.setOutputPath(genInfoDir);
			try {
				CharSequence val = fileAccess.readTextFile(file+".info", JavaIoFileSystemAccess.DEFAULT_OUTPUT);
				oldCRC = Long.parseLong(val.toString());
			}
			catch (RuntimeIOException e) {
			}
			catch (NumberFormatException e) {
			}
		}
		
		boolean write = true;
		long newCRC = 0;
		
		if (genInc) {
			CRC32 crc32 = new CRC32();
			crc32.update(contents.toString().getBytes());
			newCRC = crc32.getValue();
			if (oldCRC==newCRC) {
				write = false;
			}
			else {
				fileAccess.generateFile(file+".info", ""+newCRC);
			}
		}
		
		if (write) {
			logger.logInfo(desc+" '"+file+"'");
			fileAccess.setOutputPath(genDir);
			fileAccess.generateFile(file, contents);
			
			if (genInc) {
				// save a copy in the info directory which is not cleared (and not compiled)
				fileAccess.setOutputPath(genInfoDir);
				fileAccess.generateFile(file + ".incgen.txt", contents);
			}
		}
		else {
			logger.logInfo(desc+" (unchanged) '"+file+"'");
			File src = new File(genInfoDir+file + ".incgen.txt");
			File dst = new File(genDir+file);
			try {
				FileUtils.copyFile(src, dst, true);
			}
			catch (IOException e) {
				fileAccess.setOutputPath(genDir);
				fileAccess.generateFile(file, contents);
			}
		}
	}

	@Override
	public void generateFile(String file, CharSequence contents) {
		generateFile("generating file", file, contents);
	}

	public void setGenDir(String genDir) {
		this.genDir = genDir + "/";
	}

	public void setGenInfoDir(String genInfoDir) {
		this.genInfoDir = genInfoDir + "/";
	}
	
	public void setGenerateIncremental(boolean generateIncremental) {
		this.generateIncremental = generateIncremental;
	}
	
	public void setLogger(ILogger logger) {
		this.logger = logger;
	}
}
