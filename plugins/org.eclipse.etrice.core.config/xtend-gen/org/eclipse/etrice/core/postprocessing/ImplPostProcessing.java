package org.eclipse.etrice.core.postprocessing;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.etrice.core.postprocessing.PostprocessingHelpers;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.GeneratedMetamodel;

@SuppressWarnings("all")
public class ImplPostProcessing {
  public boolean process(final GeneratedMetamodel metamodel) {
    boolean _xblockexpression = false;
    {
      EPackage configPackage = metamodel.getEPackage();
      EClass configModel = PostprocessingHelpers.getClass(configPackage, "ConfigModel");
      EClassifier _eClassifier = configPackage.getEClassifier("ActorClassConfig");
      int _minus = (-1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("EList<ActorClassConfig> list = new org.eclipse.emf.common.util.BasicEList<ActorClassConfig>();");
      _builder.newLine();
      _builder.append("for(ConfigElement element : this.getConfigElements())");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if(element instanceof ActorClassConfig)");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("list.add((ActorClassConfig) element);");
      _builder.newLine();
      _builder.append("return list;");
      _builder.newLine();
      PostprocessingHelpers.addOperation(configModel, 
        "getActorClassConfigs", _eClassifier, Integer.valueOf(_minus), _builder.toString());
      EClassifier _eClassifier_1 = configPackage.getEClassifier("ActorInstanceConfig");
      int _minus_1 = (-1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("EList<ActorInstanceConfig> list = new org.eclipse.emf.common.util.BasicEList<ActorInstanceConfig>();");
      _builder_1.newLine();
      _builder_1.append("for(ConfigElement element : this.getConfigElements())");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("if(element instanceof ActorInstanceConfig)");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("list.add((ActorInstanceConfig) element);");
      _builder_1.newLine();
      _builder_1.append("return list;");
      PostprocessingHelpers.addOperation(configModel, 
        "getActorInstanceConfigs", _eClassifier_1, Integer.valueOf(_minus_1), _builder_1.toString());
      EClassifier _eClassifier_2 = configPackage.getEClassifier("ProtocolClassConfig");
      int _minus_2 = (-1);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("EList<ProtocolClassConfig> list = new org.eclipse.emf.common.util.BasicEList<ProtocolClassConfig>();");
      _builder_2.newLine();
      _builder_2.append("for(ConfigElement element : this.getConfigElements())");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("if(element instanceof ProtocolClassConfig)");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("list.add((ProtocolClassConfig) element);");
      _builder_2.newLine();
      _builder_2.append("return list;");
      _builder_2.newLine();
      PostprocessingHelpers.addOperation(configModel, 
        "getProtocolClassConfigs", _eClassifier_2, Integer.valueOf(_minus_2), _builder_2.toString());
      EClassifier _eClassifier_3 = configPackage.getEClassifier("SubSystemConfig");
      int _minus_3 = (-1);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("EList<SubSystemConfig> list = new org.eclipse.emf.common.util.BasicEList<SubSystemConfig>();");
      _builder_3.newLine();
      _builder_3.append("for(ConfigElement element : this.getConfigElements())");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("if(element instanceof SubSystemConfig)");
      _builder_3.newLine();
      _builder_3.append("\t\t");
      _builder_3.append("list.add((SubSystemConfig) element);");
      _builder_3.newLine();
      _builder_3.append("return list;");
      boolean _addOperation = PostprocessingHelpers.addOperation(configModel, 
        "getSubSystemConfigs", _eClassifier_3, Integer.valueOf(_minus_3), _builder_3.toString());
      _xblockexpression = (_addOperation);
    }
    return _xblockexpression;
  }
}
