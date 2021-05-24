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
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.naming.QualifiedName;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.MultimapBuilder;

/**
 * Modelpath implementation based on the file system.
 */
public class FileSystemModelPath implements IModelPath {
	
	private List<ModelDirectory> modelDirs;
	
	/**
	 * Creates a new modelpath that contains all files contained in the passed model directories.
	 * 
	 * @param modelDirs the model directories to search for model files
	 */
	public FileSystemModelPath(List<ModelDirectory> modelDirs) {
		this.modelDirs = modelDirs;
	}
	
	@Override
	public Stream<ModelFile> getFiles(QualifiedName name) {
		return modelDirs.stream().flatMap(dir -> dir.getFiles(name));
	}
	
	@Override
	public Stream<ModelFile> getAllFiles() {
		return modelDirs.stream().flatMap(dir -> dir.getAllFiles());
	}
	
	@Override
	public Optional<QualifiedName> getQualifiedName(URI uri) {
		return toFilePath(uri)
			.flatMap(file -> modelDirs.stream()
				.map(ModelDirectory::getPath)
				.filter(dir -> file.startsWith(dir))
				.max(Comparator.comparingInt(Path::getNameCount))
				.map(dir -> createModelFile(dir, file).name));
	}
	
	@Override
	public boolean isEmpty() {
		return modelDirs.isEmpty();
	}
	
	@Override
	public String toString() {
		return modelDirs.toString();
	}
	
	/**
	 * Represents an index of model files in a file system directory.
	 */
	public static class ModelDirectory {
		private final Path path;
		private final ListMultimap<QualifiedName, ModelFile> files;
		
		/**
		 * Constructs an empty index of model files for a file system directory.
		 * 
		 * @param path the path of the file system directory
		 */
		public ModelDirectory(Path path) {
			this.path = path;
			this.files = MultimapBuilder.hashKeys().arrayListValues().build();
		}
		
		/**
		 * @return the file system path of this model directory
		 */
		public Path getPath() {
			return path;
		}
		
		/**
		 * @param name the qualified name of the requested model files
		 * @return a stream of model files with the specified name
		 */
		public Stream<ModelFile> getFiles(QualifiedName name) {
			return files.get(name).stream();
		}
		
		/**
		 * @return a stream of all model files in this directory
		 */
		public Stream<ModelFile> getAllFiles() {
			return files.values().stream();
		}
		
		/**
		 * Builds up the index of this model directory by traversing its file system directory. 
		 * 
		 * @throws IOException if an io exception occurs while traversing the directory
		 */
		public void indexDirectory() throws IOException {
			files.clear();
			Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
					ModelFile modelFile = createModelFile(path, file);
					files.put(modelFile.name, modelFile);
					return FileVisitResult.CONTINUE;
				}
			});
		}
		
		/**
		 * Adds a file to the index of this directory.
		 * 
		 * @param file the file system path of the model file
		 */
		public void addFile(Path file) {
			ModelFile modelFile = createModelFile(path, file);
			List<ModelFile> list = files.get(modelFile.name);
			list.removeIf(mf -> mf.uri.equals(modelFile.uri));
			list.add(modelFile);
		}
		
		/**
		 * Removes a file from the index of this directory.
		 * 
		 * @param file the file system path to the file
		 */
		public void removeFile(Path file) {
			ModelFile modelFile = createModelFile(path, file);
			files.get(modelFile.name).removeIf(mf -> mf.uri.equals(modelFile.uri));
		}
		
		@Override
		public String toString() {
			return path.toString();
		}
	}
	
	/**
	 * Tries to convert a uri to a file path.
	 */
	private static Optional<Path> toFilePath(URI uri) {
		if(uri.isFile()) {
			/* 
			 * If the authority of a uri is non-empty, URI.toFileString produces a file string
			 * containing the authority that can't be parsed by Path.of.
			 * Therefore we take the detour via java.net.URI.
			 */
			return Optional.of(Path.of(java.net.URI.create(uri.toString())));
		}
		return Optional.empty();
	}
	
	/**
	 * Creates a model file from its file path and the path of its model directory.
	 * 
	 * @param dir the path of the model directory
	 * @param file the path of the model file
	 * @return model file
	 */
	private static ModelFile createModelFile(Path dir, Path file) {
		URI uri = NIOPathUtil.toEMFUri(file);
		Path relativePath = dir.relativize(file);
		String[] segments = StreamSupport.stream(relativePath.spliterator(), false).map(Path::toString).toArray(String[]::new);
		if(segments.length > 0) {
			int lastIndex = segments.length - 1;
			int periodIndex = segments[lastIndex].lastIndexOf('.');
			if(periodIndex != -1) {
				String extension = segments[lastIndex].substring(periodIndex + 1);
				segments[lastIndex] = segments[lastIndex].substring(0, periodIndex);
				return new ModelFile(uri, QualifiedName.create(segments), extension);
			}
		}
		return new ModelFile(uri, QualifiedName.create(segments), "");
	}
}
