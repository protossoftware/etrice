/*
 * generated by Xtext
 */
package org.eclipse.etrice.core.etphys.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class ETPhysAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.tokens");
	}
}
