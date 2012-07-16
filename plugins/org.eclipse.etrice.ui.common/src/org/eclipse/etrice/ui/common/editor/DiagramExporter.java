/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.common.editor;

import java.io.FileOutputStream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.SWTGraphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.ui.common.Activator;
import org.eclipse.etrice.ui.common.DiagramAccessBase;
import org.eclipse.etrice.ui.common.preferences.PreferenceConstants;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.LayerManager;
import org.eclipse.graphiti.ui.internal.fixed.FixedScaledGraphics;
import org.eclipse.graphiti.ui.internal.services.GraphitiUiInternal;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

@SuppressWarnings("restriction")
public class DiagramExporter {

	public static void export(StructureClass sc, DiagramAccessBase da, final String filename) {
		boolean wasOpen = false;
		RoomDiagramEditor editor = da.findDiagramEditor(sc);
		if (editor!=null)
			wasOpen = true;
		else
			editor = da.openDiagramEditor(sc);

		if (editor!=null) {
			DiagramExporter.export(editor, filename);
			
			if (!wasOpen)
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeEditor(editor, false);
		}
	}
	
	// code copied from org.eclipse.graphiti.ui.internal.action.SaveImageAction
	// and org.eclipse.graphiti.ui.internal.util.ui.print.ExportDiagramDialog
	public static void export(RoomDiagramEditor editor, final String filename) {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		String format = store.getString(PreferenceConstants.EXPORT_DIAGRAM_FORMAT);
		int fmt = SWT.IMAGE_JPEG;
		if (format.equals(PreferenceConstants.FORMAT_BMP))
			fmt = SWT.IMAGE_BMP;
		else if (format.equals(PreferenceConstants.FORMAT_PNG))
			fmt = SWT.IMAGE_PNG;
		else if (format.equals(PreferenceConstants.FORMAT_GIF))
			fmt = SWT.IMAGE_GIF;
		
		final String fname = filename+"."+format;
		GraphicalViewer viewer = (GraphicalViewer) editor.getAdapter(GraphicalViewer.class);
		Image image = createImage(viewer, 1.0d, 3000.0d);
		if (image!=null) {
			try {
				final byte[] imgData = GraphitiUiInternal.getUiService().createImage(image, fmt);
				
				WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
					@Override
					protected void execute(IProgressMonitor monitor) throws CoreException {
						FileOutputStream outputStream = null;
						try {
							outputStream = new FileOutputStream(fname);
							outputStream.write(imgData);
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							try {
								outputStream.close();
							} catch (Exception x) {
								x.printStackTrace();
							}
						}
					}
				};
				new ProgressMonitorDialog(editor.getEditorSite().getShell()).run(false, false, operation);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private static Image createImage(GraphicalViewer viewer, double scaleFactor, double upperBoundPixels) {
		EditPart rootEditPart = viewer.getRootEditPart();
		if (!(rootEditPart instanceof GraphicalEditPart))
			return null;

		// determine _allFigure
		GraphicalEditPart graphicalRootEditPart = (GraphicalEditPart) rootEditPart;
		IFigure rootFigure = ((LayerManager) graphicalRootEditPart).getLayer(LayerConstants.PRINTABLE_LAYERS);
		if (rootFigure == null)
			return null;

		if (scaleFactor * rootFigure.getBounds().width > upperBoundPixels
				|| scaleFactor * rootFigure.getBounds().height > upperBoundPixels) {
			scaleFactor = Math.min(upperBoundPixels / rootFigure.getBounds().width, upperBoundPixels
					/ rootFigure.getBounds().height);
		}

		Image scaledImage = new Image(Display.getDefault(), (int) (rootFigure.getBounds().width * scaleFactor),
				(int) (scaleFactor * rootFigure.getBounds().height));
		GC gc = new GC(scaledImage);
		FixedScaledGraphics graphics = new FixedScaledGraphics(new SWTGraphics(gc));

		graphics.scale(scaleFactor);

		/* move all figures into the positive region */
		EditPart contents = viewer.getContents();
		if (contents instanceof GraphicalEditPart) {
			IFigure contentsFigure = ((GraphicalEditPart) contents).getFigure();
			Rectangle contentBounds = contentsFigure.getBounds();
			graphics.translate(-contentBounds.x, -contentBounds.y);
		}

		rootFigure.paint(graphics);
		
		return scaledImage;
	}
}
