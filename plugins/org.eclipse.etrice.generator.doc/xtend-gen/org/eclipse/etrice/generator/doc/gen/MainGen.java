package org.eclipse.etrice.generator.doc.gen;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.generator.doc.gen.DocGen;
import org.eclipse.etrice.generator.doc.gen.InstanceDiagramGen;
import org.eclipse.etrice.generator.etricegen.Root;
import org.eclipse.etrice.generator.generic.PrepareFileSystem;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;

@SuppressWarnings("all")
@Singleton
public class MainGen implements IGenerator {
  @Inject
  private InstanceDiagramGen instanceDiagramGen;
  
  @Inject
  private PrepareFileSystem prepFS;
  
  @Inject
  private DocGen docGen;
  
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
      this.instanceDiagramGen.doGenerate(e);
      this.docGen.doGenerate(e);
  }
}
