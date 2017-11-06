package org.eclipse.etrice.generator.java.gen;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.HashMap;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.genmodel.etricegen.OpenBinding;
import org.eclipse.etrice.core.genmodel.etricegen.OpenServiceConnection;
import org.eclipse.etrice.core.genmodel.etricegen.OptionalActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.WiredActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.WiredStructureClass;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.CommunicationType;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.fsm.base.FileSystemHelpers;
import org.eclipse.etrice.generator.fsm.base.IGeneratorFileIo;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.java.gen.JavaExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class OptionalActorFactoryGen {
  @Inject
  private IGeneratorFileIo fileIO;
  
  @Inject
  @Extension
  private RoomHelpers _roomHelpers;
  
  @Inject
  @Extension
  private JavaExtensions _javaExtensions;
  
  @Inject
  @Extension
  private RoomExtensions _roomExtensions;
  
  @Inject
  @Extension
  private FileSystemHelpers _fileSystemHelpers;
  
  public void doGenerate(final Root root) {
    final HashMap<ActorClass, WiredActorClass> ac2wired = new HashMap<ActorClass, WiredActorClass>();
    final Function1<WiredStructureClass, Boolean> _function = (WiredStructureClass w) -> {
      return Boolean.valueOf((w instanceof WiredActorClass));
    };
    final Consumer<WiredStructureClass> _function_1 = (WiredStructureClass w) -> {
      ac2wired.put(((WiredActorClass) w).getActorClass(), ((WiredActorClass) w));
    };
    IterableExtensions.<WiredStructureClass>filter(root.getWiredInstances(), _function).forEach(_function_1);
    final Function1<OptionalActorInstance, Boolean> _function_2 = (OptionalActorInstance cl) -> {
      return Boolean.valueOf(this._fileSystemHelpers.isValidGenerationLocation(cl.getActorClass()));
    };
    Iterable<OptionalActorInstance> _filter = IterableExtensions.<OptionalActorInstance>filter(root.getOptionalInstances(), _function_2);
    for (final OptionalActorInstance oi : _filter) {
      {
        final ActorClass ac = oi.getActorClass();
        final WiredActorClass wired = ac2wired.get(ac);
        String _generationTargetPath = this._roomExtensions.getGenerationTargetPath(ac);
        String _path = this._roomExtensions.getPath(ac);
        final String path = (_generationTargetPath + _path);
        String _generationInfoPath = this._roomExtensions.getGenerationInfoPath(ac);
        String _path_1 = this._roomExtensions.getPath(ac);
        final String infopath = (_generationInfoPath + _path_1);
        final String file = this._javaExtensions.getJavaFactoryFileName(ac);
        this.fileIO.generateFile("generating ActorClass Interface implementation", path, infopath, file, this.generate(root, oi, wired));
      }
    }
  }
  
  public CharSequence generate(final Root root, final OptionalActorInstance oi, final WiredActorClass wired) {
    CharSequence _xblockexpression = null;
    {
      final ActorClass ac = oi.getActorClass();
      final String clsname = this._javaExtensions.getJavaFactoryName(ac);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      String _package = this._roomExtensions.getPackage(ac);
      _builder.append(_package);
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import ");
      String _package_1 = this._roomExtensions.getPackage(ac);
      _builder.append(_package_1);
      _builder.append(".");
      String _name = ac.getName();
      _builder.append(_name);
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.OptionalActorInterfaceBase;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.IOptionalActorFactory;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class ");
      _builder.append(clsname);
      _builder.append(" implements IOptionalActorFactory {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      String _name_1 = ac.getName();
      _builder.append(_name_1, "\t");
      _builder.append(" create(OptionalActorInterfaceBase ai, String name) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("// instantiate sub tree");
      _builder.newLine();
      _builder.append("\t\t");
      String _name_2 = ac.getName();
      _builder.append(_name_2, "\t\t");
      _builder.append(" actor = new ");
      String _name_3 = ac.getName();
      _builder.append(_name_3, "\t\t");
      _builder.append("(ai, name);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// wiring");
      _builder.newLine();
      {
        final Function1<Port, Boolean> _function = (Port p) -> {
          return Boolean.valueOf(this._roomHelpers.isExternal(p));
        };
        Iterable<Port> _filter = IterableExtensions.<Port>filter(this._roomHelpers.getAllEndPorts(ac), _function);
        for(final Port port : _filter) {
          _builder.append("\t\t");
          String _xifexpression = null;
          boolean _isDataDriven = this._roomHelpers.isDataDriven(port);
          if (_isDataDriven) {
            _xifexpression = "DataPortBase";
          } else {
            _xifexpression = "InterfaceItemBase";
          }
          _builder.append(_xifexpression, "\t\t");
          _builder.append(".connect(ai, \"");
          String _name_4 = port.getName();
          _builder.append(_name_4, "\t\t");
          _builder.append("\", name+\"/");
          String _name_5 = port.getName();
          _builder.append(_name_5, "\t\t");
          _builder.append("\");");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        EList<OpenBinding> _openBindings = wired.getOpenBindings();
        for(final OpenBinding open : _openBindings) {
          _builder.append("\t\t");
          String _xifexpression_1 = null;
          boolean _isDataDriven_1 = this._roomHelpers.isDataDriven(open.getPort());
          if (_isDataDriven_1) {
            _xifexpression_1 = "DataPortBase";
          } else {
            _xifexpression_1 = "InterfaceItemBase";
          }
          _builder.append(_xifexpression_1, "\t\t");
          _builder.append(".connect(ai, \"");
          String _name_6 = open.getPort().getName();
          _builder.append(_name_6, "\t\t");
          _builder.append("\", name+\"/");
          String _join = IterableExtensions.join(open.getPath(), "/");
          _builder.append(_join, "\t\t");
          _builder.append("\");");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        EList<OpenServiceConnection> _requiredServices = wired.getRequiredServices();
        for(final OpenServiceConnection req : _requiredServices) {
          _builder.append("\t\t");
          String _xifexpression_2 = null;
          CommunicationType _commType = req.getProtocol().getCommType();
          boolean _equals = Objects.equal(_commType, CommunicationType.DATA_DRIVEN);
          if (_equals) {
            _xifexpression_2 = "DataPortBase";
          } else {
            _xifexpression_2 = "InterfaceItemBase";
          }
          _builder.append(_xifexpression_2, "\t\t");
          _builder.append(".connect(ai, \"");
          String _fullyQualifiedName = this._roomExtensions.getFullyQualifiedName(req.getProtocol());
          _builder.append(_fullyQualifiedName, "\t\t");
          _builder.append("\", name+\"/");
          String _join_1 = IterableExtensions.join(req.getPath(), "/");
          _builder.append(_join_1, "\t\t");
          _builder.append("\");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return actor;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
}
