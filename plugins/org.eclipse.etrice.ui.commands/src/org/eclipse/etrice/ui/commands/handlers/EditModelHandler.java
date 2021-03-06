package org.eclipse.etrice.ui.commands.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.ui.commands.RoomOpeningHelper;
import org.eclipse.etrice.ui.common.base.editor.DiagramEditorBase;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class EditModelHandler extends AbstractHandler {
	
	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		IEditorPart editor = window.getActivePage().getActiveEditor();
		if (editor instanceof DiagramEditorBase) {
			Diagram diagram = ((DiagramEditorBase) editor).getDiagramTypeProvider().getDiagram();
			if(diagram != null) {
				EObject model = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(diagram);
				if(model != null && !model.eIsProxy()) {
					RoomOpeningHelper.showInTextualEditor(model);
				}
			}
		}
		
		return null;
	}
}
