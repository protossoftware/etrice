package org.eclipse.etrice.generator.java.gen;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.HashMap;
import java.util.List;
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
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.base.FileSystemHelpers;
import org.eclipse.etrice.generator.base.IGeneratorFileIo;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.java.gen.JavaExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class OptionalActorFactoryGen {
  @Inject
  private IGeneratorFileIo fileIO;
  
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
    HashMap<ActorClass,WiredActorClass> _hashMap = new HashMap<ActorClass, WiredActorClass>();
    final HashMap<ActorClass,WiredActorClass> ac2wired = _hashMap;
    EList<WiredStructureClass> _wiredInstances = root.getWiredInstances();
    final Function1<WiredStructureClass,Boolean> _function = new Function1<WiredStructureClass,Boolean>() {
      public Boolean apply(final WiredStructureClass w) {
        return Boolean.valueOf((w instanceof WiredActorClass));
      }
    };
    Iterable<WiredStructureClass> _filter = IterableExtensions.<WiredStructureClass>filter(_wiredInstances, _function);
    final Procedure1<WiredStructureClass> _function_1 = new Procedure1<WiredStructureClass>() {
      public void apply(final WiredStructureClass w) {
        ActorClass _actorClass = ((WiredActorClass) w).getActorClass();
        ac2wired.put(_actorClass, ((WiredActorClass) w));
      }
    };
    IterableExtensions.<WiredStructureClass>forEach(_filter, _function_1);
    EList<OptionalActorInstance> _optionalInstances = root.getOptionalInstances();
    final Function1<OptionalActorInstance,Boolean> _function_2 = new Function1<OptionalActorInstance,Boolean>() {
      public Boolean apply(final OptionalActorInstance cl) {
        ActorClass _actorClass = cl.getActorClass();
        boolean _isValidGenerationLocation = OptionalActorFactoryGen.this._fileSystemHelpers.isValidGenerationLocation(_actorClass);
        return Boolean.valueOf(_isValidGenerationLocation);
      }
    };
    Iterable<OptionalActorInstance> _filter_1 = IterableExtensions.<OptionalActorInstance>filter(_optionalInstances, _function_2);
    for (final OptionalActorInstance oi : _filter_1) {
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
        CharSequence _generate = this.generate(root, oi, wired);
        this.fileIO.generateFile("generating ActorClass Interface implementation", path, infopath, file, _generate);
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
      _builder.append(_package, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import ");
      String _package_1 = this._roomExtensions.getPackage(ac);
      _builder.append(_package_1, "");
      _builder.append(".");
      String _name = ac.getName();
      _builder.append(_name, "");
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
      _builder.append(clsname, "");
      _builder.append(" implements IOptionalActorFactory {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      String _name_1 = ac.getName();
      _builder.append(_name_1, "	");
      _builder.append(" create(OptionalActorInterfaceBase ai, String name) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("// instantiate sub tree");
      _builder.newLine();
      _builder.append("\t\t");
      String _name_2 = ac.getName();
      _builder.append(_name_2, "		");
      _builder.append(" actor = new ");
      String _name_3 = ac.getName();
      _builder.append(_name_3, "		");
      _builder.append("(ai, name);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// wiring");
      _builder.newLine();
      {
        List<Port> _allEndPorts = RoomHelpers.getAllEndPorts(ac);
        final Function1<Port,Boolean> _function = new Function1<Port,Boolean>() {
          public Boolean apply(final Port p) {
            boolean _isExternal = RoomHelpers.isExternal(p);
            return Boolean.valueOf(_isExternal);
          }
        };
        Iterable<Port> _filter = IterableExtensions.<Port>filter(_allEndPorts, _function);
        for(final Port port : _filter) {
          _builder.append("\t\t");
          String _xifexpression = null;
          boolean _isDataDriven = RoomHelpers.isDataDriven(port);
          if (_isDataDriven) {
            _xifexpression = "DataPortBase";
          } else {
            _xifexpression = "InterfaceItemBase";
          }
          _builder.append(_xifexpression, "		");
          _builder.append(".connect(ai, \"");
          String _name_4 = port.getName();
          _builder.append(_name_4, "		");
          _builder.append("\", name+\"/");
          String _name_5 = port.getName();
          _builder.append(_name_5, "		");
          _builder.append("\");");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        EList<OpenBinding> _openBindings = wired.getOpenBindings();
        for(final OpenBinding open : _openBindings) {
          _builder.append("\t\t");
          String _xifexpression_1 = null;
          Port _port = open.getPort();
          boolean _isDataDriven_1 = RoomHelpers.isDataDriven(_port);
          if (_isDataDriven_1) {
            _xifexpression_1 = "DataPortBase";
          } else {
            _xifexpression_1 = "InterfaceItemBase";
          }
          _builder.append(_xifexpression_1, "		");
          _builder.append(".connect(ai, \"");
          Port _port_1 = open.getPort();
          String _name_6 = _port_1.getName();
          _builder.append(_name_6, "		");
          _builder.append("\", name+\"/");
          EList<String> _path = open.getPath();
          String _join = IterableExtensions.join(_path, "/");
          _builder.append(_join, "		");
          _builder.append("\");");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        EList<OpenServiceConnection> _requiredServices = wired.getRequiredServices();
        for(final OpenServiceConnection req : _requiredServices) {
          _builder.append("\t\t");
          String _xifexpression_2 = null;
          ProtocolClass _protocol = req.getProtocol();
          CommunicationType _commType = _protocol.getCommType();
          boolean _equals = Objects.equal(_commType, CommunicationType.DATA_DRIVEN);
          if (_equals) {
            _xifexpression_2 = "DataPortBase";
          } else {
            _xifexpression_2 = "InterfaceItemBase";
          }
          _builder.append(_xifexpression_2, "		");
          _builder.append(".connect(ai, \"");
          ProtocolClass _protocol_1 = req.getProtocol();
          String _fullyQualifiedName = this._roomExtensions.getFullyQualifiedName(_protocol_1);
          _builder.append(_fullyQualifiedName, "		");
          _builder.append("\", name+\"/");
          EList<String> _path_1 = req.getPath();
          String _join_1 = IterableExtensions.join(_path_1, "/");
          _builder.append(_join_1, "		");
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
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
}
