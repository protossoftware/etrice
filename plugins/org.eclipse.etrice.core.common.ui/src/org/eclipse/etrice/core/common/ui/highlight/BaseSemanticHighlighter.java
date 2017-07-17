package org.eclipse.etrice.core.common.ui.highlight;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.common.converter.CC_StringConveter;
import org.eclipse.etrice.core.common.util.CCStringIndentation;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;

public class BaseSemanticHighlighter implements	ISemanticHighlightingCalculator {

	@Override
	public void provideHighlightingFor(XtextResource resource,
			IHighlightedPositionAcceptor acceptor) {
		if (resource == null || resource.getParseResult() == null)
			return;

		INode root = resource.getParseResult().getRootNode();
		for (INode node : root.getAsTreeIterable()) {

			EObject obj = node.getGrammarElement();
			if (obj instanceof RuleCall) {
				RuleCall ruleCall = (RuleCall) obj;
				String name = ruleCall.getRule().getName();
				if(name.equals("CC_STRING"))
					detailCodeStringHighlight(node, acceptor, CC_StringConveter.DELIM);
			}
		}
	}
	
	protected void detailCodeStringHighlight(INode node, IHighlightedPositionAcceptor acceptor, String delim) {
		if (node.getText() == null || node.getText().length() < delim.length() * 2)
			return;
		
		acceptor.addPosition(node.getTotalOffset(), delim.length(), DefaultHighlightingConfiguration.STRING_ID);
		acceptor.addPosition(node.getTotalEndOffset() - delim.length(), delim.length(), DefaultHighlightingConfiguration.STRING_ID);

		String detailCodeString = node.getText().substring(delim.length(), node.getText().length() - delim.length());
		CCStringIndentation ccStringIndent = new CCStringIndentation(detailCodeString);
		List<int[]> lineStartLength = ccStringIndent.highlight();

		int offest = node.getOffset() + delim.length();
		for (int[] startLength : lineStartLength) {
			acceptor.addPosition(offest + startLength[0], startLength[1], BaseHighlightingConfig.HL_CCSTRING);
		}
	}

}
