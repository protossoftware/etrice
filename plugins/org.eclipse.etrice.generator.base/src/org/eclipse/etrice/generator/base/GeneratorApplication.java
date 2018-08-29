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
import java.util.List;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.generator.base.args.Arguments;
import org.eclipse.etrice.generator.base.args.Options;
import org.eclipse.etrice.generator.base.cli.CommandLineParseException;
import org.eclipse.etrice.generator.base.cli.ICommandLineParser;
import org.eclipse.etrice.generator.base.cli.IHelpFormatter;
import org.eclipse.etrice.generator.base.io.IGeneratorFileIO;
import org.eclipse.etrice.generator.base.io.ILineOutput;
import org.eclipse.etrice.generator.base.io.IGeneratorResourceLoader;
import org.eclipse.etrice.generator.base.io.IncrementalGeneratorFileIO;
import org.eclipse.etrice.generator.base.io.LineOutput;
import org.eclipse.etrice.generator.base.logging.ILogger;
import org.eclipse.etrice.generator.base.logging.Logger;
import org.eclipse.etrice.generator.base.logging.Loglevel;
import org.eclipse.etrice.generator.base.setup.GeneratorBaseOptions;
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
	public static GeneratorApplication create(String moduleName) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Module module = (Module) Class.forName(moduleName).newInstance();
		return create(module);
	}

	private final Options options;
	private boolean initializedEMF = EMFPlugin.IS_ECLIPSE_RUNNING;
	private ICommandLineParser commandLineParser;
	private IHelpFormatter helpFormatter;
	private Provider<Logger> loggerProvider;
	private Provider<IncrementalGeneratorFileIO> fileIOProvider;
	private Provider<IGenerator> generatorProvider;
	private IGeneratorResourceLoader resourceLoader;
	private IGeneratorResourceValidator resourceValidator;

	@Inject
	public GeneratorApplication(GeneratorBaseOptions optionsModule, ICommandLineParser commandLineParser,
			IHelpFormatter helpFormatter, Provider<Logger> loggerProvider,
			Provider<IncrementalGeneratorFileIO> fileIOProvider, Provider<IGenerator> generatorProvider,
			IGeneratorResourceLoader resourceLoader, IGeneratorResourceValidator resourceValidator) {
		this.options = new Options(optionsModule);
		this.initializedEMF = EMFPlugin.IS_ECLIPSE_RUNNING;
		this.commandLineParser = commandLineParser;
		this.helpFormatter = helpFormatter;
		this.loggerProvider = loggerProvider;
		this.fileIOProvider = fileIOProvider;
		this.generatorProvider = generatorProvider;
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
			Arguments arguments = commandLineParser.parseArgs(options, args);

			if(arguments.get(GeneratorBaseOptions.HELP)) {
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
		ILogger logger = createLogger(arguments, out);
		IGeneratorFileIO fileIO = createGeneratorFileIO(arguments, logger);

		execute(arguments, fileIO, logger);
	}

	/**
	 * Returns the options of this generator.
	 * 
	 * @return the options
	 */
	public final Options getOptions() {
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
	
	private void execute(Arguments arguments, IGeneratorFileIO fileIO, ILogger logger) throws GeneratorException {
		try {
			logger.logDebug(arguments.toString());

			// Create new generator to avoid problems with static states in eTrice AbstractGenerator
			IGenerator generator = generatorProvider.get();

			doEMFRegistration(generator);

			List<Resource> resources = load(arguments.getFiles(), arguments, logger);

			validate(resources, arguments, logger);

			generate(generator, resources, arguments, fileIO, logger);
		}
		catch (Exception e) {
			logException(e, logger);
			throw e;
		}
	}

	private void printHelp(ILineOutput out) {
		String help = helpFormatter.getHelp(options);
		out.println(help);
	}

	private ILogger createLogger(Arguments arguments, ILineOutput out) {
		Logger logger = loggerProvider.get();
		logger.setLoglevel(arguments.get(GeneratorBaseOptions.LOGLEVEL));
		logger.setOutput(out);
		return logger;
	}

	private IGeneratorFileIO createGeneratorFileIO(Arguments arguments, ILogger logger) {
		IncrementalGeneratorFileIO fileIO = fileIOProvider.get();
		fileIO.setGenDir(arguments.get(GeneratorBaseOptions.GEN_DIR));
		fileIO.setGenInfoDir(arguments.get(GeneratorBaseOptions.GEN_INFO_DIR));
		fileIO.setGenerateIncremental(arguments.get(GeneratorBaseOptions.GEN_INCREMENTAL));
		fileIO.setLogger(logger);
		return fileIO;
	}

	private void doEMFRegistration(IGenerator generator) {
		if(!initializedEMF) {
			generator.doEMFRegistration();
			initializedEMF = true;
		}
	}

	private List<Resource> load(List<String> files, Arguments arguments, ILogger logger) {
		return resourceLoader.load(arguments, logger);
	}

	private void validate(List<Resource> models, Arguments arguments, ILogger logger) {
		resourceValidator.validate(models, arguments, logger);
	}

	private void generate(IGenerator generator, List<Resource> resources, Arguments arguments, IGeneratorFileIO fileIO, ILogger logger) {
		generator.generate(resources, arguments, fileIO, logger);
	}

	private void logException(Exception e, ILogger logger) {
		if(Loglevel.DEBUG.compareTo(logger.getLoglevel()) >= 0) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			logger.logDebug(sw.toString());
		}
	}
}
