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

package org.eclipse.etrice.generator.java.mvn;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.eclipse.etrice.generator.base.ILineOutput;
import org.eclipse.etrice.generator.java.Main;

/**
 * @author Henrik Rentz-Reichert
 * 
 *
 */
@Mojo(name = "eTriceJavaGenerator", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class JavaGeneratorWrapper extends AbstractMojo {

	class GeneratorOutput implements ILineOutput {

		/* (non-Javadoc)
		 * @see org.eclipse.etrice.generator.base.ILineOutput#println(java.lang.String)
		 */
		@Override
		public void println(String txt) {
			getLog().info(txt);
		}
		
	}
	/**
	 * 
	 */
	@Parameter(required=true)
	String[] arguments;
	
	/**
	 * 
	 */
	public JavaGeneratorWrapper() {
	}

	/* (non-Javadoc)
	 * @see org.apache.maven.plugin.Mojo#execute()
	 */
	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		Main.setOutput(new GeneratorOutput());
		Main.main(arguments);
	}

}
