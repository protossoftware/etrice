/**
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 */
package org.eclipse.etrice.core.postprocessing;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.etrice.core.common.postprocessing.PostprocessingHelpers;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.GeneratedMetamodel;

@SuppressWarnings("all")
public class ImplPostProcessing {
  public boolean process(final GeneratedMetamodel metamodel) {
    boolean _xblockexpression = false;
    {
      final EPackage configPackage = metamodel.getEPackage();
      final EClass configModel = PostprocessingHelpers.getClass(configPackage, "ConfigModel");
      EClassifier _eClassifier = configPackage.getEClassifier("ActorClassConfig");
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
        "getActorClassConfigs", _eClassifier, 
        Integer.valueOf(PostprocessingHelpers.UNBOUNDED_MULTIPLICITY), _builder.toString());
      EClassifier _eClassifier_1 = configPackage.getEClassifier("ActorInstanceConfig");
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
        "getActorInstanceConfigs", _eClassifier_1, 
        Integer.valueOf(PostprocessingHelpers.UNBOUNDED_MULTIPLICITY), _builder_1.toString());
      EClassifier _eClassifier_2 = configPackage.getEClassifier("ProtocolClassConfig");
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
        "getProtocolClassConfigs", _eClassifier_2, 
        Integer.valueOf(PostprocessingHelpers.UNBOUNDED_MULTIPLICITY), _builder_2.toString());
      EClassifier _eClassifier_3 = configPackage.getEClassifier("SubSystemConfig");
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
      PostprocessingHelpers.addOperation(configModel, 
        "getSubSystemConfigs", _eClassifier_3, 
        Integer.valueOf(PostprocessingHelpers.UNBOUNDED_MULTIPLICITY), _builder_3.toString());
      final EClass refSeg = PostprocessingHelpers.getClass(configPackage, "RefSegment");
      EAttribute _attribute = PostprocessingHelpers.getAttribute(refSeg, "idx");
      _attribute.setDefaultValueLiteral("-1");
      EClassifier _eClassifier_4 = EcorePackage.eINSTANCE.getEClassifier("EString");
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("return getRef() + ((getIdx()>=0)? \":\"+getIdx() : \"\");");
      _builder_4.newLine();
      boolean _addOperation = PostprocessingHelpers.addOperation(refSeg, 
        "toString", _eClassifier_4, 
        Integer.valueOf(1), _builder_4.toString());
      _xblockexpression = (_addOperation);
    }
    return _xblockexpression;
  }
}
