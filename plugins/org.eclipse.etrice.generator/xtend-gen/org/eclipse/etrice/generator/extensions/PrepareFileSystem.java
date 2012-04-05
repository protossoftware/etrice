package org.eclipse.etrice.generator.extensions;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.generator.base.ILogger;
import org.eclipse.etrice.generator.etricegen.Root;
import org.eclipse.etrice.generator.extensions.RoomExtensions;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
@Singleton
public class PrepareFileSystem {
  @Inject
  private RoomExtensions roomExt;
  
  @Inject
  private JavaIoFileSystemAccess fileAccess;
  
  @Inject
  private ILogger logger;
  
  public void prepare(final Resource resource) {
      HashSet<String> _hashSet = new HashSet<String>();
      Set<String> pathes = _hashSet;
      EList<EObject> _contents = resource.getContents();
      for (final EObject e : _contents) {
        if ((e instanceof Root)) {
          EList<RoomModel> _usedRoomModels = ((Root) e).getUsedRoomModels();
          for (final RoomModel mdl : _usedRoomModels) {
            String _generationTargetPath = this.roomExt.getGenerationTargetPath(mdl);
            pathes.add(_generationTargetPath);
          }
        }
      }
      for (final String path : pathes) {
        {
          String _operator_plus = StringExtensions.operator_plus("clearing ", path);
          this.logger.logInfo(_operator_plus);
          File _file = new File(path);
          File f = _file;
          this.eraseContents(f);
          this.fileAccess.setOutputPath(path);
          StringConcatenation _readmeText = this.readmeText();
          this.fileAccess.generateFile("readme.txt", _readmeText);
        }
      }
  }
  
  public void eraseContents(final File f) {
    boolean _isDirectory = f.isDirectory();
    if (_isDirectory) {
      {
        File[] _listFiles = f.listFiles();
        File[] children = _listFiles;
        for (final File child : children) {
          {
            this.eraseContents(child);
            child.delete();
          }
        }
      }
    }
  }
  
  public StringConcatenation readmeText() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("This directory is an eTrice code generation target.");
    _builder.newLine();
    _builder.append("It will be erased every time the generator is executed.");
    _builder.newLine();
    _builder.newLine();
    _builder.append("DO NOT PLACE OTHER FILES HERE!");
    _builder.newLine();
    return _builder;
  }
}
