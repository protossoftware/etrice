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
	private HashMap<QualifiedName, List<URI>> packages;
	
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
	public Stream<URI> getFiles(QualifiedName name) {
		Stream<URI> stream = Stream.empty();
		while(!name.isEmpty()) {
			name = name.skipLast(1);
			stream = Stream.concat(stream, getPackage(name));
		}
		return stream;
	}
	
	@Override
	public Stream<URI> getAllFiles() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public Optional<QualifiedName> getQualifiedName(URI uri) {
		if(uri.isFile()) {
			Path path = Paths.get(uri.toFileString());
			return paths.stream().filter(p -> path.startsWith(p))
				.map(p -> p.relativize(path))
				.map(p -> createQualifiedName(p))
				.findFirst();
		}
		return Optional.empty();
	}
	
	@Override
	public String toString() {
		return paths.toString();
	}
	
	/**
	 * Returns all files that are contained in the package with the specified name.
	 * 
	 * @param name the fully qualified name of the package
	 * @return a stream of all file uris
	 */
	private Stream<URI> getPackage(QualifiedName name) {
		List<URI> pkg = packages.computeIfAbsent(name, n -> createPackage(n));
		return pkg.stream();
	}
	
	/**
	 * Searches for all files that are contained in the package with the specified name.
	 * 
	 * @param name the fully qualified name of the package
	 * @return a list of all file uris
	 */
	private List<URI> createPackage(QualifiedName name) {
		return paths.stream()
			.map(path -> createPackagePath(name, path))
			.filter(path -> Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS))
			.flatMap(dir -> collectFiles(dir))
			.collect(Collectors.toList());
	}
	
	/**
	 * Lists all files of the passed directory.
	 * 
	 * @param dir the path of a folder
	 * @return a stream of file uris
	 */
	private Stream<URI> collectFiles(Path dir) {
		try {
			return Files.list(dir)
				.filter(path -> Files.isRegularFile(path))
				.map(file -> createURI(file));
		}
		catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	
	/**
	 * Creates an uri for a given path.
	 */
	private URI createURI(Path path) {
		return URI.createURI(path.toUri().toString());
	}
	
	/**
	 * Creates the path of a specific package within the passed directory.
	 * 
	 * @param name the fully qualified name of the package
	 * @param dir the folder which the package path is based on
	 * @return the path of the package
	 */
	private Path createPackagePath(QualifiedName name, Path dir) {
		if(!name.isEmpty()) {
			String firstSegment = name.getFirstSegment();
			String[] segments = new String[name.getSegmentCount() - 1];
			for(int i = 0; i < segments.length; ++i) {
				segments[i] = name.getSegment(i + 1);
			}
			Path relativePackagePath = dir.getFileSystem().getPath(firstSegment, segments);
			Path packagePath = dir.resolve(relativePackagePath);
			return packagePath;
		}
		return dir;
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
	
}
