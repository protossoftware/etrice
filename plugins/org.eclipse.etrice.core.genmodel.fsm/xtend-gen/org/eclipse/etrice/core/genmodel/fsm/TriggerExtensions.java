/**
 * Copyright (c) 2017 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 */
package org.eclipse.etrice.core.genmodel.fsm;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.fsm.fSM.MessageFromIf;
import org.eclipse.etrice.core.fsm.fSM.Trigger;
import org.eclipse.etrice.core.fsm.naming.FSMNameProvider;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class TriggerExtensions {
  public static String TRIGGER_SEP = "#";
  
  @Inject
  @Extension
  protected FSMNameProvider _fSMNameProvider;
  
  public String getTriggerTag(final MessageFromIf it) {
    String _name = it.getFrom().getName();
    String _plus = (_name + TriggerExtensions.TRIGGER_SEP);
    String _messageName = this._fSMNameProvider.getMessageName(it.getMessage());
    return (_plus + _messageName);
  }
  
  public boolean isMatching(final Trigger trig, final String trigstr) {
    EList<MessageFromIf> _msgFromIfPairs = trig.getMsgFromIfPairs();
    for (final MessageFromIf mif : _msgFromIfPairs) {
      {
        final String tr = this.getTriggerTag(mif);
        boolean _equals = Objects.equal(tr, trigstr);
        if (_equals) {
          return true;
        }
      }
    }
    return false;
  }
}
