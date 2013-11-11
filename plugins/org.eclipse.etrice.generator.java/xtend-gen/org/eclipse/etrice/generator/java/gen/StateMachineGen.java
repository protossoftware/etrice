/**
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 */
package org.eclipse.etrice.generator.java.gen;

import com.google.common.base.Objects;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.generic.GenericStateMachineGenerator;
import org.eclipse.xtend2.lib.StringConcatenation;

@Singleton
@SuppressWarnings("all")
public class StateMachineGen extends GenericStateMachineGenerator {
  public CharSequence genExtra(final ExpandedActorClass xpac) {
    CharSequence _xblockexpression = null;
    {
      ArrayList<State> _arrayList = new ArrayList<State>();
      final ArrayList<State> states = _arrayList;
      ActorClass ac = xpac.getActorClass();
      boolean _notEquals = (!Objects.equal(ac, null));
      boolean _while = _notEquals;
      while (_while) {
        {
          List<State> _allBaseStates = RoomHelpers.getAllBaseStates(ac);
          List<State> _leafStatesLast = this._roomExtensions.getLeafStatesLast(_allBaseStates);
          states.addAll(0, _leafStatesLast);
          ActorClass _base = ac.getBase();
          ac = _base;
        }
        boolean _notEquals_1 = (!Objects.equal(ac, null));
        _while = _notEquals_1;
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\t\t");
      _builder.append("�IF Main::settings.generateMSCInstrumentation || Main::settings.generateWithVerboseOutput�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("// state names");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("protected static final String stateStrings[] = {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("\"<no state>\",");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("\"<top>\",");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�FOR state : states SEPARATOR \",\"�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("\"�state.genStatePathName�\"");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("};");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("���\t \tTODOHRR: history defined in ActorClassBase, init in constructor");
      _builder.newLine();
      _builder.append("���\t\t\thistory = new int[5];");
      _builder.newLine();
      _builder.append("���\t\t\tfor (int i = 0; i < history.length; i++) {");
      _builder.newLine();
      _builder.append("���\t\t\t\thistory[i] = NO_STATE;");
      _builder.newLine();
      _builder.append("���\t\t\t}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// history");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("protected int history[] = {NO_STATE, NO_STATE�FOR state : states�, NO_STATE�ENDFOR�};");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("private void setState(int new_state) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�IF Main::settings.generateMSCInstrumentation�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�IF Main::settings.generateWithVerboseOutput�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("if (stateStrings[new_state]!=\"Idle\") {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("System.out.println(\"state switch of \"+getInstancePath() + \": \"");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("+ stateStrings[this.state] + \" -> \" + stateStrings[new_state]);");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}\t");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("this.state = new_state;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  public int getHistorySize(final ExpandedActorClass xpac) {
    ActorClass _actorClass = xpac.getActorClass();
    List<State> _allBaseStates = RoomHelpers.getAllBaseStates(_actorClass);
    int _size = _allBaseStates.size();
    int _plus = (_size + 2);
    return _plus;
  }
}
