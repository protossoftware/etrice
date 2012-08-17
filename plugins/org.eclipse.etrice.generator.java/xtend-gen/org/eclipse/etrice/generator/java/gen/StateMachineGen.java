package org.eclipse.etrice.generator.java.gen;

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
  
  public CharSequence genExtra(final ExpandedActorClass xpac) {
    CharSequence _xblockexpression = null;
    {
      final ActorClass ac = xpac.getActorClass();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("// state names");
      _builder.newLine();
      _builder.append("protected static final String stateStrings[] = {\"<no state>\",\"<top>\",");
      {
        List<State> _allBaseStatesLeavesLast = this._roomExtensions.getAllBaseStatesLeavesLast(ac);
        boolean _hasElements = false;
        for(final State state : _allBaseStatesLeavesLast) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate(",", "");
          }
          _builder.append("\"");
          String _statePathName = this._roomExtensions.getStatePathName(state);
          _builder.append(_statePathName, "");
          _builder.append("\"");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("};");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("// history");
      _builder.newLine();
      _builder.append("protected int history[] = {NO_STATE,NO_STATE");
      {
        List<State> _allBaseStates = this._roomExtensions.getAllBaseStates(ac);
        for(final State state_1 : _allBaseStates) {
          _builder.append(",NO_STATE");
        }
      }
      _builder.append("};");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("private void setState(int new_state) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if (stateStrings[new_state]!=\"Idle\") {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("System.out.println(getInstancePath() + \" -> \" + stateStrings[new_state]);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("this.state = new_state;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
}
