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

package org.eclipse.etrice.ui.common.base.export;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.SWTGraphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.ui.common.base.UIBaseActivator;
import org.eclipse.etrice.ui.common.base.editor.DiagramEditorBase;
import org.eclipse.etrice.ui.common.base.preferences.UIBasePreferenceConstants;
import org.eclipse.etrice.ui.common.base.support.DiagramAccessBase;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.LayerManager;
import org.eclipse.graphiti.ui.internal.fixed.FixedScaledGraphics;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

@SuppressWarnings("restriction")
public class DiagramExporter {

	public static void export(EObject sc, DiagramAccessBase da, final String filename) {
		boolean wasOpen = false;
		DiagramEditorBase editor = da.findDiagramEditor(sc);
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
	public static void export(DiagramEditorBase editor, final String filename) {
		IPreferenceStore store = UIBaseActivator.getDefault().getPreferenceStore();
		String format = store.getString(UIBasePreferenceConstants.EXPORT_DIAGRAM_FORMAT);
		int fmt = SWT.IMAGE_JPEG;
		if (format.equals(UIBasePreferenceConstants.FORMAT_BMP))
			fmt = SWT.IMAGE_BMP;
		else if (format.equals(UIBasePreferenceConstants.FORMAT_PNG))
			fmt = SWT.IMAGE_PNG;
		else if (format.equals(UIBasePreferenceConstants.FORMAT_GIF))
			fmt = SWT.IMAGE_GIF;
		
		final String fname = filename+"."+format;
		GraphicalViewer viewer = (GraphicalViewer) editor.getAdapter(GraphicalViewer.class);
		Image image = createImage(viewer, 1.0d, 3000.0d);
		if (image!=null) {
			try {
				final byte[] imgData = convertImageToBytes(image, fmt);
				
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

	/* copied from DefaultSaveImageFeature */
	/* TODO: use DefaultSaveImageFeature directly? */
	private static byte[] convertImageToBytes(Image image, int format) {
		ByteArrayOutputStream result = new ByteArrayOutputStream();

		try {
			ImageData imDat = null;
			// Save as GIF is only working if not more than 256 colors are used
			// in the image
			if (format == SWT.IMAGE_GIF) {
				imDat = create8BitIndexedPaletteImage(image);
			}

			if (imDat == null) {
				imDat = image.getImageData();
			}

			ImageLoader imageLoader = new ImageLoader();
			imageLoader.data = new ImageData[] { imDat };
			try {
				imageLoader.save(result, format);
			} catch (SWTException e) {
				String error = "Depth: " + Integer.toString(image.getImageData().depth) + "\n" + "X: " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						+ Integer.toString(image.getImageData().x)
						+ "\n" + "Y: " + Integer.toString(image.getImageData().y); //$NON-NLS-1$ //$NON-NLS-2$
				throw new IllegalStateException(error, e);
			}
		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			image.dispose();
		}

		return result.toByteArray();
	}

	private static ImageData create8BitIndexedPaletteImage(Image image) {
		int upperboundWidth = image.getBounds().width;
		int upperboundHeight = image.getBounds().height;
		ImageData imageData = image.getImageData();

		// determine number of used colors
		ArrayList<Integer> colors = new ArrayList<Integer>();
		for (int x = 0; x < upperboundWidth; x++) {
			for (int y = 0; y < upperboundHeight; y++) {
				int color = imageData.getPixel(x, y);
				Integer colorInteger = new Integer(color);
				if (!colors.contains(colorInteger))
					colors.add(colorInteger);
			}
		}

		// at the moment this is only working if not more than 256 colors are
		// used in the image
		if (colors.size() > 256) {
			throw new IllegalStateException(
					"Image contains more than 256 colors. \n Automated color reduction is currently not supported."); //$NON-NLS-1$
		}

		// create an indexed palette
		RGB[] rgbs = new RGB[256];
		for (int i = 0; i < 256; i++)
			rgbs[i] = new RGB(255, 255, 255);
		for (int i = 0; i < colors.size(); i++) {
			int pixelValue = ((colors.get(i))).intValue();
			int red = (pixelValue & imageData.palette.redMask) >>> Math.abs(imageData.palette.redShift);
			int green = (pixelValue & imageData.palette.greenMask) >>> Math.abs(imageData.palette.greenShift);
			int blue = (pixelValue & imageData.palette.blueMask) >>> Math.abs(imageData.palette.blueShift);
			rgbs[i] = new RGB(red, green, blue);
		}

		// create new imageData
		PaletteData palette = new PaletteData(rgbs);
		ImageData newImageData = new ImageData(imageData.width, imageData.height, 8, palette);

		// adjust imageData with regard to the palette
		for (int x = 0; x < upperboundWidth; x++) {
			for (int y = 0; y < upperboundHeight; y++) {
				int color = imageData.getPixel(x, y);
				newImageData.setPixel(x, y, colors.indexOf(new Integer(color)));
			}
		}

		return newImageData;
	}
}
