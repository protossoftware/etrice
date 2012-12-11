package org.eclipse.etrice.generator.c.gen;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.generator.generic.GenericStateMachineGenerator;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;

@Singleton
@SuppressWarnings("all")
public class StateMachineGen extends GenericStateMachineGenerator {
  @Inject
  private RoomExtensions _roomExtensions;
  
  public CharSequence genHeaderConstants(final ExpandedActorClass xpac) {
    CharSequence _xblockexpression = null;
    {
      final ActorClass ac = xpac.getActorClass();
      List<State> _allBaseStates = this._roomExtensions.getAllBaseStates(ac);
      int _size = _allBaseStates.size();
      List<State> _allLeafStates = this._roomExtensions.getAllLeafStates(ac);
      int _size_1 = _allLeafStates.size();
      int _minus = (_size - _size_1);
      final int historySize = (_minus + 2);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/* constant for state machine data */");
      _builder.newLine();
      _builder.append("#define ");
      String _name = ac.getName();
      String _upperCase = _name.toUpperCase();
      _builder.append(_upperCase, "");
      _builder.append("_HISTORY_SIZE ");
      _builder.append(historySize, "");
      _builder.newLineIfNotEmpty();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  public CharSequence genDataMembers(final ExpandedActorClass xpac) {
    CharSequence _xblockexpression = null;
    {
      final ActorClass ac = xpac.getActorClass();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/* state machine variables */");
      _builder.newLine();
      _builder.append("etInt16 state;");
      _builder.newLine();
      _builder.append("etInt16 history[");
      String _name = ac.getName();
      String _upperCase = _name.toUpperCase();
      _builder.append(_upperCase, "");
      _builder.append("_HISTORY_SIZE];");
      _builder.newLineIfNotEmpty();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  public CharSequence genInitialization(final ExpandedActorClass xpac) {
    CharSequence _xblockexpression = null;
    {
      final ActorClass ac = xpac.getActorClass();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("self->state = STATE_TOP;");
      _builder.newLine();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int i;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("for (i=0; i<");
      String _name = ac.getName();
      String _upperCase = _name.toUpperCase();
      _builder.append(_upperCase, "	");
      _builder.append("_HISTORY_SIZE; ++i)");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("self->history[i] = NO_STATE;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _name_1 = ac.getName();
      String _operationScope = this.langExt.operationScope(_name_1, false);
      _builder.append(_operationScope, "");
      _builder.append("executeInitTransition(self);");
      _builder.newLineIfNotEmpty();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  public CharSequence genExtra(final ExpandedActorClass xpac) {
    CharSequence _xblockexpression = null;
    {
      final ActorClass ac = xpac.getActorClass();
      StringConcatenation _builder = new StringConcatenation();
      _builder.newLine();
      String _accessLevelPrivate = this.langExt.accessLevelPrivate();
      _builder.append(_accessLevelPrivate, "");
      _builder.append("void setState(");
      String _name = ac.getName();
      _builder.append(_name, "");
      _builder.append("* self, int new_state) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("self->state = new_state;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      String _accessLevelPrivate_1 = this.langExt.accessLevelPrivate();
      _builder.append(_accessLevelPrivate_1, "");
      _builder.append("int getState(");
      String _name_1 = ac.getName();
      _builder.append(_name_1, "");
      _builder.append("* self) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("return self->state;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
}
