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

package org.eclipse.etrice.generator.base;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.generator.base.args.Arguments;
import org.eclipse.etrice.generator.base.args.Options;
import org.eclipse.etrice.generator.base.cli.CommandLineParseException;
import org.eclipse.etrice.generator.base.cli.ICommandLineParser;
import org.eclipse.etrice.generator.base.cli.IHelpFormatter;
import org.eclipse.etrice.generator.base.io.GeneratorFileIO;
import org.eclipse.etrice.generator.base.io.ILineOutput;
import org.eclipse.etrice.generator.base.io.IGeneratorResourceLoader;
import org.eclipse.etrice.generator.base.io.LineOutput;
import org.eclipse.etrice.generator.base.logging.Logger;
import org.eclipse.etrice.generator.base.logging.Loglevel;
import org.eclipse.etrice.generator.base.setup.GeneratorApplicationOptions;
import org.eclipse.etrice.generator.base.setup.GeneratorName;
import org.eclipse.etrice.generator.base.setup.GeneratorOptions;
import org.eclipse.etrice.generator.base.validation.IGeneratorResourceValidator;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Provider;

/**
 * Executes a generator.
 */
public class GeneratorApplication {

	/**
	 * Creates a new generator instance using the specified generator module.
	 * 
	 * @param module the generator module
	 * @return the new generator application
	 */
	public static GeneratorApplication create(Module module) {
		Injector injector = Guice.createInjector(module);
		GeneratorApplication genAppl = injector.getInstance(GeneratorApplication.class);
		return genAppl;
	}

	/**
	 * Creates a new generator instance using the specified generator module.
	 * 
	 * @param moduleName the name of the class of the generator module
	 * @return the new generator application
	 */
	public static GeneratorApplication create(String moduleName)
		throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		Module module = (Module) Class.forName(moduleName).getDeclaredConstructor().newInstance();
		return create(module);
	}

	private String name;
	private Options options;
	private ICommandLineParser commandLineParser;
	private IHelpFormatter helpFormatter;
	private Provider<Logger> loggerProvider;
	private Provider<GeneratorFileIO> fileIOProvider;
	private IGenerator generator;
	private IGeneratorResourceLoader resourceLoader;
	private IGeneratorResourceValidator resourceValidator;

	@Inject
	public GeneratorApplication(@GeneratorName String name,
			GeneratorOptions optionsModule, ICommandLineParser commandLineParser,
			IHelpFormatter helpFormatter, Provider<Logger> loggerProvider,
			Provider<GeneratorFileIO> fileIOProvider, IGenerator generator,
			IGeneratorResourceLoader resourceLoader, IGeneratorResourceValidator resourceValidator) {
		this.name = name;
		this.options = new Options(new GeneratorApplicationOptions(), optionsModule);
		this.commandLineParser = commandLineParser;
		this.helpFormatter = helpFormatter;
		this.loggerProvider = loggerProvider;
		this.fileIOProvider = fileIOProvider;
		this.generator = generator;
		this.resourceLoader = resourceLoader;
		this.resourceValidator = resourceValidator;
	}

	/**
	 * Runs the generator with the specified command line arguments.
	 * 
	 * @param args the command line arguments
	 */
	public void run(String[] args) throws GeneratorException {
		run(args, new LineOutput());
	}

	/**
	 * Runs the generator with the specified command line arguments and output.
	 * 
	 * @param args the command line arguments
	 * @param out the output
	 */
	public void run(String[] args, ILineOutput out) throws GeneratorException {
		try {
			Arguments arguments = commandLineParser.parseArgs(options, GeneratorApplicationOptions.FILES, args);

			if(arguments.get(GeneratorApplicationOptions.HELP)) {
				printHelp(out);
			}
			else {
				run(arguments, out);
			}
		}
		catch (CommandLineParseException e) {
			out.println("Error: " + e.getMessage());
			printHelp(out);
			throw new GeneratorException(e);
		}
	}

	/**
	 * Runs the generator using the specified arguments and output.
	 * 
	 * @param arguments the generator arguments
	 * @param out the output
	 */
	public void run(Arguments arguments, ILineOutput out) throws GeneratorException {
		Logger logger = createLogger(arguments, out);
		try {
			List<String> files = Arrays.asList(arguments.get(GeneratorApplicationOptions.FILES));
			List<String> modelpath = Arrays.asList(arguments.get(GeneratorApplicationOptions.MODELPATH));
			List<Resource> resources = resourceLoader.load(files, modelpath, arguments, logger);
			
			validateAndGenerate(resources, arguments, logger);
		}
		catch (Exception e) {
			logException(e, logger);
			throw e;
		}
	}
	
	/**
	 * Runs the generator on the given resources with the specified arguments.
	 * 
	 * @param resources the resources to generator code from
	 * @param arguments the generator arguments
	 * @param out some output channel
	 */
	public void run(List<Resource> resources, Arguments arguments, ILineOutput out) throws GeneratorException {
		Logger logger = createLogger(arguments, out);
		try {
			validateAndGenerate(resources, arguments, logger);
		}
		catch(Exception e) {
			logException(e, logger);
			throw e;
		}
	}

	/**
	 * Returns the name of this generator.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the options of this generator.
	 * 
	 * @return the options
	 */
	public Options getOptions() {
		return options;
	}
	
	/**
	 * Creates a new set of arguments for this generator.
	 * 
	 * @return the default arguments
	 */
	public Arguments createArguments() {
		return new Arguments(getOptions());
	}

	private void printHelp(ILineOutput out) {
		String help = helpFormatter.getHelp(name, options, GeneratorApplicationOptions.FILES);
		out.println(help);
	}
	
	private void validateAndGenerate(List<Resource> resources, Arguments arguments, Logger logger) {
		resourceValidator.validate(resources, arguments, logger);
		
		GeneratorFileIO fileIO = fileIOProvider.get();
		String genDir = arguments.get(GeneratorApplicationOptions.GEN_DIR);
		fileIO.init(genDir, logger);
		logger.logDebug("output directory: " + fileIO.getOutputDirectory().toAbsolutePath());
		
		generator.generate(resources, arguments, fileIO, logger);
		
		if(arguments.get(GeneratorApplicationOptions.CLEAN)) {
			fileIO.cleanOutputDirectory();
		}
	}

	private Logger createLogger(Arguments arguments, ILineOutput out) {
		Logger logger = loggerProvider.get();
		Loglevel loglevel = arguments.get(GeneratorApplicationOptions.LOGLEVEL);
		logger.init(loglevel, out);
		logger.logDebug("arguments: " + arguments);
		return logger;
	}
	
	private void logException(Exception e, Logger logger) {
		if(Loglevel.DEBUG.compareTo(logger.getLoglevel()) >= 0) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			logger.logDebug(sw.toString());
		}
	}
}
