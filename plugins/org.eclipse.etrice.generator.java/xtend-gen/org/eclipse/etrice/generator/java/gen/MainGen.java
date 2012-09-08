package org.eclipse.etrice.generator.java.gen;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.generator.generic.PrepareFileSystem;
import org.eclipse.etrice.generator.java.gen.ActorClassGen;
import org.eclipse.etrice.generator.java.gen.DataClassGen;
import org.eclipse.etrice.generator.java.gen.ProtocolClassGen;
import org.eclipse.etrice.generator.java.gen.SubSystemClassGen;
import org.eclipse.etrice.generator.java.gen.SubSystemRunnerGen;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;

@Singleton
@SuppressWarnings("all")
public class MainGen implements IGenerator {
  @Inject
  private DataClassGen dataClassGen;
  
  @Inject
  private ProtocolClassGen protocolClassGen;
  
  @Inject
  private ActorClassGen actorClassGen;
  
  @Inject
  private SubSystemClassGen subsystemClassGen;
  
  @Inject
  private SubSystemRunnerGen subsystemRunnerGen;
  
  @Inject
  private PrepareFileSystem prepFS;
  
  public void doGenerate(final Resource resource, final IFileSystemAccess fsa) {
    this.prepFS.prepare(resource);
    EList<EObject> _contents = resource.getContents();
    for (final EObject e : _contents) {
      if ((e instanceof Root)) {
        this.doGenerate(((Root) e));
      }
    }
  }
  
  public void doGenerate(final Root e) {
    this.dataClassGen.doGenerate(e);
    this.protocolClassGen.doGenerate(e);
    this.actorClassGen.doGenerate(e);
    this.subsystemClassGen.doGenerate(e);
    boolean _isLibrary = e.isLibrary();
    boolean _not = (!_isLibrary);
    if (_not) {
      this.subsystemRunnerGen.doGenerate(e);
    }
  }
}
