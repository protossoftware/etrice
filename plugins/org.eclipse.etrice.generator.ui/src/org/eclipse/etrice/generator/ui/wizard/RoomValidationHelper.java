package org.eclipse.etrice.generator.ui.wizard;

import java.io.Reader;
import java.io.StringReader;

import org.eclipse.etrice.core.parser.antlr.RoomParser;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import com.google.inject.Injector;

public class RoomValidationHelper {

	private RoomParser parser;
	private String parserMessage;
	
	private RoomValidationHelper(RoomParser parser){
		this.parser = parser;
	}
	
	public static RoomValidationHelper createInstance(){
		Injector injector = new org.eclipse.etrice.core.RoomStandaloneSetup().createInjector();
		return new RoomValidationHelper(injector.getInstance(RoomParser.class));
	}
	
	public String getMessage(){
		return parserMessage;
	}
	
	public boolean isValidFQN(String name){
		Reader reader = new StringReader(name);
		IParseResult result = parser.parse(parser.getGrammarAccess().getFQNRule(), reader);
	
		parserMessage = null;
		for(INode node : result.getSyntaxErrors())
			if(node.getSyntaxErrorMessage() != null){
				parserMessage = node.getSyntaxErrorMessage().getMessage();
				break;
			}
		
		return !result.hasSyntaxErrors();
	}
}
