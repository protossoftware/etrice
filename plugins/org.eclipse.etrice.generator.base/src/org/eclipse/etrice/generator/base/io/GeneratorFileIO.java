/*******************************************************************************
* Copyright (c) 2018 protos software gmbh (http://www.protos.de).
* All rights reserved.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
*
* CONTRIBUTORS:
*           Jan Belle (initial contribution)
*
 *******************************************************************************/

package org.eclipse.etrice.generator.base.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.CRC32;

import org.eclipse.etrice.generator.base.logging.ILogger;
import org.eclipse.etrice.generator.base.logging.NullLogger;
import org.eclipse.xtext.util.RuntimeIOException;

/**
 * Incrementally writes files to an output directory.
 * 
 * Therefore stores a checksum of the file content in the file attributes.
 * If file attributes are not available, recomputes the checksum from the content of the file.
 * Additionally keeps record of all generated files to allow removal of obsolete files.
 */
public class GeneratorFileIO implements IGeneratorFileIO {

	private static final String CHECKSUM_ATTRIBUTE_NAME = "user.crc32";
	
	private HashSet<Path> generatedFiles;
	private Path outputPath;
	private ILogger logger;
	
	/**
	 * Creates a new generator file io instance that writes to the working directory.
	 */
	public GeneratorFileIO() {
		this("");
	}
	
	/**
	 * Creates a new generator file io that writes to the specified output directory.
	 * 
	 * @param outputPath the path to the output directory
	 */
	public GeneratorFileIO(String outputPath) {
		this(outputPath, new NullLogger());
	}
	
	/**
	 * Creates a new generator file io that writes to the specified output directory.
	 * 
	 * @param outputPath the path to the output directory
	 * @param logger the logger
	 */
	public GeneratorFileIO(String outputPath, ILogger logger) {
		generatedFiles = new HashSet<>();
		
		setOutputDirectory(outputPath);
		setLogger(logger);
	}
	
	/**
	 * Sets to logger.
	 * 
	 * @param logger the logger
	 */
	public void setLogger(ILogger logger) {
		this.logger = logger;
	}
	
	/**
	 * Returns the output directory path.
	 * 
	 * @return the path of the output directory
	 */
	public Path getOutputDirectory() {
		return outputPath;
	}
	
	/**
	 * Sets the output directory.
	 * 
	 * @param path the path to the new output directory
	 */
	public void setOutputDirectory(Path path) {
		outputPath = path.normalize();
	}
	
	/**
	 * Sets the output directory.
	 * 
	 * @param path the path to the new output directory
	 */
	public void setOutputDirectory(String path) {
		setOutputDirectory(Paths.get(path));
	}
	
	@Override
	public void generateFile(String file, CharSequence content) {
		generateFile("generating file", file, content);
	}

	@Override
	public void generateFile(String desc, String file, CharSequence content) {
		Path path = getPath(file);
		String contentStr = content.toString();
		long checksum = getContentChecksum(contentStr);
		
		if(!isUnchanged(path, checksum)) {
			logger.logInfo(desc + " " + file);
			writeFile(path, contentStr);
			setChecksumAttribute(path, checksum);
		}
		else {
			logger.logInfo(desc + " (unchanged) " + file);
		}
		
		generatedFiles.add(path);
	}
	
	/**
	 * Removes all files in the output directory that haven't been written by this instance.
	 */
	public void cleanOutputDirectory() {
		try {
			FileVisitor<Path> visitor = new FileCleaner(generatedFiles, logger);
			Files.walkFileTree(outputPath, visitor);
		} catch (IOException e) {
			throw new RuntimeIOException(e);
		}
	}
	
	private Path getPath(String file) {
		return outputPath.resolve(Paths.get(file)).normalize();
	}
	
	private void writeFile(Path path, String content) {
		try {
			Path parent = path.getParent();
			if(parent != null) {
				Files.createDirectories(parent);
			}
			BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
			writer.append(content);
			writer.close();
		}
		catch(IOException e) {
			throw new RuntimeIOException(e);
		}
	}
	
	private boolean isUnchanged(Path path, long checksum) {
		if(Files.exists(path)) {
			Long oldChecksum = getChecksumAttribute(path);
			if(oldChecksum != null && oldChecksum.longValue() == checksum) {
				return true;
			}
			oldChecksum = getFileChecksum(path);
			if(oldChecksum != null && oldChecksum.longValue() == checksum) {
				return true;
			}
		}
		return false;
	}
	
	private long getContentChecksum(String content) {
		CRC32 crc = new CRC32();
		crc.update(content.getBytes(StandardCharsets.UTF_8));
		return crc.getValue();
	}
	
	private Long getChecksumAttribute(Path path) {
		Long checksum = null;
		try {
			UserDefinedFileAttributeView view = Files.getFileAttributeView(path, UserDefinedFileAttributeView.class);
			if(view != null) {
				ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
				view.read(CHECKSUM_ATTRIBUTE_NAME, buffer);
				buffer.flip();
				checksum = buffer.getLong();
			}
		}
		catch(IOException | UnsupportedOperationException | IllegalArgumentException | ClassCastException e) {
			logger.logDebug(e.toString());
		}
		return checksum;
	}
	
	private void setChecksumAttribute(Path path, long checksum) {
		try {
			UserDefinedFileAttributeView view = Files.getFileAttributeView(path, UserDefinedFileAttributeView.class);
			if(view != null) {
				ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
				buffer.putLong(checksum);
				buffer.flip();
				view.write(CHECKSUM_ATTRIBUTE_NAME, buffer);
			}
		}
		catch(IOException | UnsupportedOperationException | IllegalArgumentException | ClassCastException e) {
			logger.logDebug(e.toString());
		}
	}
	
	private Long getFileChecksum(Path path) {
		Long checksum = null;
		try {
			byte[] bytes = Files.readAllBytes(path);
			CRC32 crc = new CRC32();
			crc.update(bytes);
			checksum = crc.getValue();
		}
		catch(IOException e) {
			logger.logDebug(e.toString());
		}
		return checksum;
	}
	
	private static class FileCleaner implements FileVisitor<Path> {
		
		private Set<Path> excludedFiles;
		private ILogger logger;
		
		public FileCleaner(Set<Path> excludedFiles, ILogger logger) {
			this.excludedFiles = excludedFiles;
			this.logger = logger;
		}

		@Override
		public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
			if(!excludedFiles.contains(file)) {
				Files.delete(file);
				logger.logDebug("deleting file " + file);
			}
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
			return FileVisitResult.CONTINUE;
		}

	};

}