/**
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 */
package org.eclipse.etrice.core.ui.hover;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.common.ui.hover.KeywordEObjectTextHover;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.services.RoomGrammarAccess;
import org.eclipse.jface.text.IRegion;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.Pair;

@SuppressWarnings("all")
public class RoomHoverProvider extends KeywordEObjectTextHover {
  @Inject
  private RoomGrammarAccess grammar;
  
  @Override
  protected Pair<EObject, IRegion> getXtextElementAt(final XtextResource resource, final int offset) {
    return super.getXtextElementAt(resource, offset);
  }
  
  private ActorClass findActorClass(final EObject model) {
    EObject parent = model;
    while ((parent != null)) {
      {
        if ((parent instanceof ActorClass)) {
          return ((ActorClass) parent);
        }
        EObject _eContainer = parent.eContainer();
        parent = _eContainer;
      }
    }
    return null;
  }
}
