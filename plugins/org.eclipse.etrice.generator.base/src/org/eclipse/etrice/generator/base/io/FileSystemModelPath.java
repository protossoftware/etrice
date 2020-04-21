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

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.naming.QualifiedName;

/**
 * Modelpath implementation based on the file system.
 */
public class FileSystemModelPath implements IModelPath {
	
	private List<Path> paths;
	private HashMap<QualifiedName, List<ModelFile>> packages;
	
	/**
	 * Creates a new modelpath that contains all files in the passed paths.
	 * 
	 * @param paths the paths to search for files
	 */
	public FileSystemModelPath(List<Path> paths) {
		this.paths = paths;
		this.packages = new HashMap<>();
	}
	
	@Override
	public Stream<ModelFile> getFiles(QualifiedName name) {
		QualifiedName pkgName = name.skipLast(1);
		String fileName = name.getLastSegment();
		return packages.computeIfAbsent(pkgName, n -> createPackage(n)).stream()
				.filter(mf -> mf.name.getLastSegment().equals(fileName));
	}
	
	@Override
	public Stream<ModelFile> getAllFiles() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public Optional<QualifiedName> getQualifiedName(URI uri) {
		return toFilePath(uri)
			.flatMap(path -> paths.stream()
				.filter(p -> path.startsWith(p))
				.map(p -> p.relativize(path))
				.map(p -> createQualifiedName(p))
				.findFirst()
			);
	}
	
	@Override
	public boolean isEmpty() {
		return paths.isEmpty();
	}
	
	@Override
	public String toString() {
		return paths.toString();
	}
	
	/**
	 * Searches for all files that are contained in the package with the specified name.
	 * 
	 * @param name the fully qualified name of the package
	 * @return a list of all file uris
	 */
	private List<ModelFile> createPackage(QualifiedName name) {
		return paths.stream()
			.map(path -> createPackagePath(path, name))
			.filter(path -> Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS))
			.flatMap(dir -> listFiles(dir, name))
			.collect(Collectors.toList());
	}
	
	/**
	 * Lists all files of the passed directory.
	 * 
	 * @param dir the path of a folder
	 * @param name the qualified name of the directory
	 * @return a stream of file uris
	 */
	private Stream<ModelFile> listFiles(Path dir, QualifiedName name) {
		try {
			return Files.list(dir)
				.filter(path -> Files.isRegularFile(path))
				.map(file -> createModelFile(file, name));
		}
		catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	
	/**
	 * Creates a new model file from the path and package.
	 * 
	 * @param file the path of the file
	 * @param pkg the qualified name of the package
	 * @return the new model file
	 */
	private ModelFile createModelFile(Path file, QualifiedName pkg) {
		URI uri = URI.createURI(file.toUri().toString());
		String fileName = file.getFileName().toString();
		return ModelFile.create(uri, pkg, fileName);
	}
	
	/**
	 * Creates the path of a specific package within the passed directory.
	 * 
	 * @param dir the folder which the package path is based on
	 * @param name the fully qualified name of the package
	 * @return the path of the package
	 */
	private Path createPackagePath(Path dir, QualifiedName name) {
		String[] segments = name.getSegments().toArray(new String[name.getSegmentCount()]);
		Path relativePackagePath = dir.getFileSystem().getPath("", segments);
		Path packagePath = dir.resolve(relativePackagePath);
		return packagePath;
	}
	
	/**
	 * Converts a path to a qualified name.
	 * Removes a possible file extension.
	 * 
	 * @param path the path to convert
	 * @return a fully qualified name consisting of the path segments
	 */
	private QualifiedName createQualifiedName(Path path) {
		String[] segments = StreamSupport.stream(path.spliterator(), false).map(p -> p.toString()).toArray(String[]::new);
		if(segments.length > 0) {
			int lastIndex = segments.length - 1;
			segments[lastIndex] = trimFileExtension(segments[lastIndex]);
		}
		return QualifiedName.create(segments);
	}
	
	/**
	 * Searches for the last dot in the string and discards everything that follows it.
	 * If the fileName doesn't contain a dot it is simply returned.
	 * 
	 * @param fileName the name of the file to trim the extension
	 * @return the name of the file without a file extension
	 */
	private String trimFileExtension(String fileName) {
		int periodIndex = fileName.lastIndexOf('.');
		if(periodIndex != -1) {
			return fileName.substring(0, periodIndex);
		}
		return fileName;
	}
	
	/**
	 * Tries to convert a uri to a file path.
	 */
	private Optional<Path> toFilePath(URI uri) {
		if(uri.isFile()) {
			/* 
			 * If the authority of the uri is non-empty,
			 * URI.toFileString produces a file string containing the authority that can't be parsed by Paths.get.
			 * So we create the path directly from the device and segments of the uri and convert it to an absolute path if necessary.
			 */
			Path path = Paths.get(uri.hasDevice() ? uri.device() : "", uri.segments());
			return Optional.of(uri.hasAbsolutePath() ? path.toAbsolutePath() : path);
		}
		return Optional.empty();
	}
}
