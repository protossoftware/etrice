package org.eclipse.etrice.ui.commands.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.core.ui.RoomUiModule;
import org.eclipse.etrice.ui.behavior.editor.BehaviorEditor;
import org.eclipse.etrice.ui.structure.editor.StructureEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.ITextRegion;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class EditModelHandler extends AbstractHandler {
	
	@Inject
	ILocationInFileProvider locationProvider;
	
	/**
	 * The constructor.
	 */
	public EditModelHandler() {
		Injector injector = RoomUiModule.getInjector();
		injector.injectMembers(this);
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		IEditorPart editor = window.getActivePage().getActiveEditor();
		StructureClass sc = null;
		if (editor instanceof StructureEditor) {
			sc = ((StructureEditor)editor).getStructureClass();
		}
		else if (editor instanceof BehaviorEditor) {
			sc = ((BehaviorEditor)editor).getActorClass();
		}
		if (sc!=null) {
			try {
				if (EditUIUtil.openEditor(sc)) {
					editor = window.getActivePage().getActiveEditor();
					if (editor instanceof XtextEditor) {
						XtextEditor xed = (XtextEditor) editor;
						ITextRegion location = locationProvider.getFullTextRegion(sc);
						xed.selectAndReveal(location.getOffset(), location.getLength());
					}
				}
			} catch (PartInitException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
