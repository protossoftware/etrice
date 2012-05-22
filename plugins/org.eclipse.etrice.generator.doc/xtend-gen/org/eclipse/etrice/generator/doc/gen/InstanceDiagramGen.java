package org.eclipse.etrice.generator.doc.gen;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.genmodel.base.ILogger;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.StructureInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.generator.base.IRoomGenerator;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
@Singleton
public class InstanceDiagramGen implements IRoomGenerator {
  @Inject
  private JavaIoFileSystemAccess fileAccess;
  
  @Inject
  private RoomExtensions roomExt;
  
  @Inject
  private ILogger logger;
  
  public void doGenerate(final Root root) {
    EList<RoomModel> _models = root.getModels();
    for (final RoomModel model : _models) {
      {
        String _docGenerationTargetPath = this.roomExt.getDocGenerationTargetPath(model);
        String _operator_plus = StringExtensions.operator_plus(_docGenerationTargetPath, "/images");
        String path = _operator_plus;
        this.fileAccess.setOutputPath(path);
        String file2 = "dot2jpg.bat";
        EList<SubSystemInstance> _subSystemInstances = root.getSubSystemInstances();
        for (final SubSystemInstance sc : _subSystemInstances) {
          {
            String _name = sc.getName();
            String _operator_plus_1 = StringExtensions.operator_plus(_name, "_instanceTree.dot");
            String file = _operator_plus_1;
            String _operator_plus_2 = StringExtensions.operator_plus("generating LaTeX documentation: \'", file);
            String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, "\' in \'");
            String _operator_plus_4 = StringExtensions.operator_plus(_operator_plus_3, path);
            String _operator_plus_5 = StringExtensions.operator_plus(_operator_plus_4, "\'");
            this.logger.logInfo(_operator_plus_5);
            SubSystemClass _subSystemClass = sc.getSubSystemClass();
            StringConcatenation _generate = this.generate(root, sc, _subSystemClass);
            this.fileAccess.generateFile(file, _generate);
          }
        }
        StringConcatenation _generate2jpg = this.generate2jpg(root);
        this.fileAccess.generateFile(file2, _generate2jpg);
        this.runDot2Jpg();
      }
    }
  }
  
  public StringConcatenation generate2jpg(final Root root) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<SubSystemInstance> _subSystemInstances = root.getSubSystemInstances();
      for(final SubSystemInstance sc : _subSystemInstances) {
        _builder.append("dot -Tjpg -o ");
        String _name = sc.getName();
        _builder.append(_name, "");
        _builder.append("_instanceTree.jpg ");
        String _name_1 = sc.getName();
        _builder.append(_name_1, "");
        _builder.append("_instanceTree.dot");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public StringConcatenation generate(final Root root, final SubSystemInstance ssi, final SubSystemClass ssc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("digraph ");
    String _name = ssi.getName();
    _builder.append(_name, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("rankdir=LR;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("node [shape=box];");
    _builder.newLine();
    _builder.append("\t");
    String _path = ssi.getPath();
    String _pathName = this.roomExt.getPathName(_path);
    _builder.append(_pathName, "	");
    _builder.append(" [label=\"");
    String _name_1 = ssc.getName();
    _builder.append(_name_1, "	");
    _builder.append("\\n(");
    String _name_2 = ssi.getName();
    _builder.append(_name_2, "	");
    _builder.append(")\" style=filled color=yellow];");
    _builder.newLineIfNotEmpty();
    {
      EList<ActorInstance> _instances = ssi.getInstances();
      for(final ActorInstance ai : _instances) {
        _builder.append("\t");
        StringConcatenation _instance = this.instance(ai);
        _builder.append(_instance, "	");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation instance(final ActorInstance ai) {
    StringConcatenation _builder = new StringConcatenation();
    EObject _eContainer = ai.eContainer();
    StructureInstance parent = ((StructureInstance) _eContainer);
    _builder.newLineIfNotEmpty();
    String _path = ai.getPath();
    String _pathName = this.roomExt.getPathName(_path);
    _builder.append(_pathName, "");
    _builder.append(" [label=\"");
    String _name = ai.getName();
    _builder.append(_name, "");
    _builder.append("\\n(");
    ActorClass _actorClass = ai.getActorClass();
    String _name_1 = _actorClass.getName();
    _builder.append(_name_1, "");
    _builder.append(")\"];");
    _builder.newLineIfNotEmpty();
    String _path_1 = parent.getPath();
    String _pathName_1 = this.roomExt.getPathName(_path_1);
    _builder.append(_pathName_1, "");
    _builder.append(" -> ");
    String _path_2 = ai.getPath();
    String _pathName_2 = this.roomExt.getPathName(_path_2);
    _builder.append(_pathName_2, "");
    _builder.append(";  ");
    _builder.newLineIfNotEmpty();
    {
      EList<ActorInstance> _instances = ai.getInstances();
      for(final ActorInstance sub_ai : _instances) {
        StringConcatenation _instance = this.instance(sub_ai);
        _builder.append(_instance, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public Process runDot2Jpg() {
    Process _xtrycatchfinallyexpression = null;
    try {
      Runtime _runtime = Runtime.getRuntime();
      Process _exec = _runtime.exec("dot2jpg.bat");
      _xtrycatchfinallyexpression = _exec;
    } catch (final Exception e) {
      e.printStackTrace();
    }
    return _xtrycatchfinallyexpression;
  }
}
