package org.eclipse.etrice.generator.java.gen;

import com.google.inject.Inject;
import java.util.HashMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.OptionalActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.WiredActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.WiredStructureClass;
import org.eclipse.etrice.core.room.ActorClass;
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
    for (final OptionalActorInstance oi : _optionalInstances) {
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
      _builder.append("package �ac.package�;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import �ac.package�.�ac.name�;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.OptionalActorInterfaceBase;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.IOptionalActorFactory;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class �clsname� implements IOptionalActorFactory {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public �ac.name� create(OptionalActorInterfaceBase ai, String name) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// instantiate sub tree");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ac.name� actor = new �ac.name�(ai, name);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// wiring");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�FOR port: RoomHelpers::getAllEndPorts(ac).filter(p|RoomHelpers::isExternal(p))�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�if (RoomHelpers::isDataDriven(port)) \"DataPortBase\" else \"InterfaceItemBase\"�.connect(ai, \"�port.name�\", name+\"/�port.name�\");");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�FOR open: wired.openBindings�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�if (RoomHelpers::isDataDriven(open.port)) \"DataPortBase\" else \"InterfaceItemBase\"�.connect(ai, \"�open.port.name�\", name+\"/�open.path.join(\'/\')�\");");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�FOR req: wired.requiredServices�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�if (req.protocol.commType==CommunicationType::DATA_DRIVEN) \"DataPortBase\" else \"InterfaceItemBase\"�.connect(ai, \"�req.protocol.fullyQualifiedName�\", name+\"/�req.path.join(\'/\')�\");");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
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
  
  private String relPath(final OptionalActorInstance oi, final InterfaceItemInstance pi) {
    String _path = pi.getPath();
    ActorClass _actorClass = oi.getActorClass();
    String _name = _actorClass.getName();
    int _length = _name.length();
    int _plus = (_length + 1);
    String path = _path.substring(_plus);
    return path;
  }
}
