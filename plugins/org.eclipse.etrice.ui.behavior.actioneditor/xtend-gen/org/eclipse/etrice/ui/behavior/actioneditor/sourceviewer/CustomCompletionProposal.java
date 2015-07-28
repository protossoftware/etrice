/**
 * Copyright (c) 2015 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 */
package org.eclipse.etrice.ui.behavior.actioneditor.sourceviewer;

import com.google.common.base.Objects;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.xtend.lib.annotations.Delegate;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class CustomCompletionProposal implements ICompletionProposal {
  @Delegate
  private final ICompletionProposal delegate;
  
  private final Point selection;
  
  public Point getSelection(final IDocument document) {
    Point _xifexpression = null;
    boolean _notEquals = (!Objects.equal(this.selection, null));
    if (_notEquals) {
      _xifexpression = this.selection;
    } else {
      _xifexpression = this.delegate.getSelection(document);
    }
    return _xifexpression;
  }
  
  public CustomCompletionProposal(final ICompletionProposal delegate, final Point selection) {
    super();
    this.delegate = delegate;
    this.selection = selection;
  }
  
  public void apply(final IDocument document) {
    this.delegate.apply(document);
  }
  
  public String getAdditionalProposalInfo() {
    return this.delegate.getAdditionalProposalInfo();
  }
  
  public IContextInformation getContextInformation() {
    return this.delegate.getContextInformation();
  }
  
  public String getDisplayString() {
    return this.delegate.getDisplayString();
  }
  
  public Image getImage() {
    return this.delegate.getImage();
  }
}
