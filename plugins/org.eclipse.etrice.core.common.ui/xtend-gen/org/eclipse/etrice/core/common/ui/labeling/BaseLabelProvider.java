/**
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Eyrak Paen (initial contribution)
 */
package org.eclipse.etrice.core.common.ui.labeling;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.etrice.core.common.base.Import;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;
import org.eclipse.xtext.ui.label.StylerFactory;

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#labelProvider
 */
@SuppressWarnings("all")
public class BaseLabelProvider extends DefaultEObjectLabelProvider {
  protected final static String KEYWORD_COLOR = "KEYWORD_COLOR";
  
  @Inject
  protected StylerFactory stylerFactory;
  
  protected StyledString.Styler keywordStyler = null;
  
  protected StyledString.Styler typeStyler = null;
  
  @Inject
  public BaseLabelProvider(final AdapterFactoryLabelProvider delegate) {
    super(delegate);
    ColorRegistry _colorRegistry = JFaceResources.getColorRegistry();
    RGB _rGB = new RGB(50, 50, 50);
    _colorRegistry.put(BaseLabelProvider.KEYWORD_COLOR, _rGB);
  }
  
  public String image(final Import mdl) {
    return null;
  }
  
  public StyledString text(final Import im) {
    String _importedNamespace = im.getImportedNamespace();
    boolean _equals = Objects.equal(_importedNamespace, null);
    if (_equals) {
      String _importURI = im.getImportURI();
      String _plus = ("import model " + _importURI);
      StyledString txt = new StyledString(_plus);
      StyledString.Styler _keywordStyler = this.getKeywordStyler();
      txt.setStyle(0, 12, _keywordStyler);
      return txt;
    } else {
      String _importedNamespace_1 = im.getImportedNamespace();
      String _plus_1 = ("import ns " + _importedNamespace_1);
      StyledString txt_1 = new StyledString(_plus_1);
      StyledString.Styler _keywordStyler_1 = this.getKeywordStyler();
      txt_1.setStyle(0, 9, _keywordStyler_1);
      return txt_1;
    }
  }
  
  protected StyledString.Styler getKeywordStyler() {
    boolean _equals = Objects.equal(this.keywordStyler, null);
    if (_equals) {
      FontDescriptor font = JFaceResources.getFontDescriptor(JFaceResources.TEXT_FONT);
      FontDescriptor boldFont = font.setStyle(SWT.BOLD);
      StyledString.Styler _createStyler = this.stylerFactory.createStyler(boldFont, BaseLabelProvider.KEYWORD_COLOR, null);
      this.keywordStyler = _createStyler;
    }
    return this.keywordStyler;
  }
  
  protected StyledString.Styler getTypeStyler() {
    boolean _equals = Objects.equal(this.typeStyler, null);
    if (_equals) {
      FontDescriptor font = JFaceResources.getFontDescriptor(JFaceResources.TEXT_FONT);
      FontDescriptor italicFont = font.setStyle(SWT.ITALIC);
      StyledString.Styler _createStyler = this.stylerFactory.createStyler(italicFont, null, null);
      this.typeStyler = _createStyler;
    }
    return this.typeStyler;
  }
}
