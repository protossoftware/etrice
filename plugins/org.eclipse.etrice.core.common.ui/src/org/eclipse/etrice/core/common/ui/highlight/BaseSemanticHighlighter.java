package org.eclipse.etrice.core.common.ui.highlight;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.common.converter.CCStringIndentation;
import org.eclipse.etrice.core.common.converter.CC_StringConverter;
import org.eclipse.etrice.core.common.services.BaseGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.xbase.lib.Pair;

import com.google.inject.Inject;

public class BaseSemanticHighlighter implements	ISemanticHighlightingCalculator {

	@Inject
	BaseGrammarAccess grammar;
	
	@Override
	public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		if (resource == null || resource.getParseResult() == null)
			return;

		INode root = resource.getParseResult().getRootNode();
		for (INode node : root.getAsTreeIterable()) {

			EObject obj = node.getGrammarElement();
			if (obj instanceof RuleCall) {
				if(((RuleCall) obj).getRule() == grammar.getCC_STRINGRule()) {
					detailCodeStringHighlight(node, acceptor);
				}
			}
		}
	}
	
	protected void detailCodeStringHighlight(INode node, IHighlightedPositionAcceptor acceptor) {
		final String delim = CC_StringConverter.DELIM;
		if (node.getText() == null || node.getText().length() < delim.length() * 2)
			return;
		
		acceptor.addPosition(node.getOffset(), delim.length(), DefaultHighlightingConfiguration.STRING_ID);
		acceptor.addPosition(node.getEndOffset() - delim.length(), delim.length(), DefaultHighlightingConfiguration.STRING_ID);

		int offset = node.getOffset() + delim.length();
		List<Pair<Integer, Integer>> lineStartLength = new CCStringIndentation(CC_StringConverter.stripDelim(node.getText())).highlight();
		for (Pair<Integer, Integer> offsetLength : lineStartLength) {
			acceptor.addPosition(offset + offsetLength.getKey(), offsetLength.getValue(), BaseHighlightingConfig.HL_CCSTRING);
		}	
	}

}
