/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.base;

import java.io.File;
import java.io.IOException;
import java.util.zip.CRC32;

import org.apache.commons.io.FileUtils;
import org.eclipse.etrice.core.genmodel.base.ILogger;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.util.RuntimeIOException;

import com.google.inject.Inject;


/**
 * @author Henrik Rentz-Reichert
 *
 */
public class IncrementalGenerationFileIo implements IGeneratorFileIo {

	@Inject JavaIoFileSystemAccess fileAccess;
	@Inject ILogger logger;

	private static boolean generateIncremental = false;
	
	/**
	 * @return {@code true} if incremental generation is chosen
	 */
	public static boolean isGenerateIncremental() {
		return generateIncremental;
	}

	/**
	 * @param generateIncremental select {@code true} if incremental generation is desired
	 */
	public static void setGenerateIncremental(boolean generateIncremental) {
		IncrementalGenerationFileIo.generateIncremental = generateIncremental;
	}

	/**
	 * This method computes a hash key (a {@link java.util.zip.CRC32 CRC32} value) for the file contents
	 * and compares it to the
	 * one stored in the {@code infopath} directory with an added extension ".info". If the values are equal
	 * then the file stored in the {@code infopath} is copied to {@code path} while preserving the file data.
	 * In the other case the key is stored and the file is stored to {@code infopath} and {@code path}.
	 */
	public void generateFile(String desc, String path, String infopath, String file, CharSequence contents) {
		
		long oldCRC = 0;
		
		// use local copy to avoid inconsistencies due to concurrent change
		boolean genInc = generateIncremental;
		
		if (genInc) {
			// read old CRC value
			fileAccess.setOutputPath(infopath);
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
			logger.logInfo(desc+" '"+file+"' in '"+path+"'");
			fileAccess.setOutputPath(path);
			fileAccess.generateFile(file, contents);
			
			if (genInc) {
				// save a copy in the info directory which is not cleared (and not compiled)
				fileAccess.setOutputPath(infopath);
				fileAccess.generateFile(file, contents);
			}
		}
		else {
			logger.logInfo(desc+" (unchanged) '"+file+"' in '"+path+"'");
			File src = new File(infopath+file);
			File dst = new File(path+file);
			try {
				FileUtils.copyFile(src, dst, true);
			}
			catch (IOException e) {
				fileAccess.setOutputPath(path);
				fileAccess.generateFile(file, contents);
			}
		}
	}
}
