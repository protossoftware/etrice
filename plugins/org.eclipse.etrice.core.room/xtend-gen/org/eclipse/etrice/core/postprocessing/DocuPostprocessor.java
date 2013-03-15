package org.eclipse.etrice.core.postprocessing;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.core.postprocessing.PostprocessingHelpers;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.GeneratedMetamodel;

/**
 * This post processor adds documentation to the generated EMF model.
 * By intention no {@code null} checks are performed. This way developers
 * find easier if the referenced class, attribute or reference isn't found.
 */
@SuppressWarnings("all")
public class DocuPostprocessor {
  public void process(final GeneratedMetamodel metamodel) {
    final EPackage pckg = metamodel.getEPackage();
    EClass cls = PostprocessingHelpers.getClass(pckg, "RoomModel");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("The root object for the ROOM model. It gives access to {@link Import imports} and");
    _builder.newLine();
    _builder.append("the {@link SubSystemClass sub system},");
    _builder.newLine();
    _builder.append("{@link ActorClass actor}, {@link ProtocolClass protocol} and");
    _builder.newLine();
    _builder.append("{@link DataClass data} classes defined.");
    _builder.newLine();
    EcoreUtil.setDocumentation(cls, _builder.toString());
    EAttribute _attribute = PostprocessingHelpers.getAttribute(cls, "name");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("The model name is a dot separated fully qualified name and is");
    _builder_1.newLine();
    _builder_1.append("used to provide a name space. The generators may use that also");
    _builder_1.newLine();
    _builder_1.append("to place the generated code into separate directories.");
    _builder_1.newLine();
    EcoreUtil.setDocumentation(_attribute, _builder_1.toString());
    EClass _class = PostprocessingHelpers.getClass(pckg, "Import");
    cls = _class;
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("The import references another ROOM model. Optionally it may import also");
    _builder_2.newLine();
    _builder_2.append("the name space of the imported model.");
    _builder_2.newLine();
    EcoreUtil.setDocumentation(cls, _builder_2.toString());
    EAttribute _attribute_1 = PostprocessingHelpers.getAttribute(cls, "importedNamespace");
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("The imported name space has to be a dot separated qualified name followed by .*.");
    _builder_3.newLine();
    _builder_3.append("Example: my.namespace.*");
    _builder_3.newLine();
    EcoreUtil.setDocumentation(_attribute_1, _builder_3.toString());
    EAttribute _attribute_2 = PostprocessingHelpers.getAttribute(cls, "importURI");
    StringConcatenation _builder_4 = new StringConcatenation();
    _builder_4.append("The import URI can be a relative or absolute file system path.");
    _builder_4.newLine();
    _builder_4.append("It may contain environment variables in ${} which will be expanded.");
    _builder_4.newLine();
    _builder_4.append("<p>");
    _builder_4.newLine();
    _builder_4.append("Examples:");
    _builder_4.newLine();
    _builder_4.append("<ul>");
    _builder_4.newLine();
    _builder_4.append("  ");
    _builder_4.append("<li>import model \"AnotherModel.room\"</li>");
    _builder_4.newLine();
    _builder_4.append("  ");
    _builder_4.append("<li>import my.namespace.* from \"AnotherModel.room\"</li>");
    _builder_4.newLine();
    _builder_4.append("  ");
    _builder_4.append("<li>import my.namespace.* from \"../../AnotherProject/models/AnotherModel.room\"</li>");
    _builder_4.newLine();
    _builder_4.append("  ");
    _builder_4.append("<li>import my.namespace.* from \"/${ROOM_MODELS}/SomeModel.room\"</li>");
    _builder_4.newLine();
    _builder_4.append("</ul>");
    _builder_4.newLine();
    _builder_4.append("</p>");
    _builder_4.newLine();
    EcoreUtil.setDocumentation(_attribute_2, _builder_4.toString());
    EClass _class_1 = PostprocessingHelpers.getClass(pckg, "DataClass");
    cls = _class_1;
    StringConcatenation _builder_5 = new StringConcatenation();
    _builder_5.append("The data class in ROOM is a {@link ComplexType} which has {@link Attribute} members.");
    _builder_5.newLine();
    _builder_5.append("It can be derived from a single base data class. ");
    _builder_5.newLine();
    EcoreUtil.setDocumentation(cls, _builder_5.toString());
    EAttribute _attribute_3 = PostprocessingHelpers.getAttribute(cls, "name");
    StringConcatenation _builder_6 = new StringConcatenation();
    _builder_6.append("The name of the data class by which it is referred to in the model.");
    _builder_6.newLine();
    EcoreUtil.setDocumentation(_attribute_3, _builder_6.toString());
    EReference _reference = PostprocessingHelpers.getReference(cls, "base");
    StringConcatenation _builder_7 = new StringConcatenation();
    _builder_7.append("The base class from which all attributes and operations are inherited.");
    _builder_7.newLine();
    EcoreUtil.setDocumentation(_reference, _builder_7.toString());
    EReference _reference_1 = PostprocessingHelpers.getReference(cls, "attributes");
    StringConcatenation _builder_8 = new StringConcatenation();
    _builder_8.append("Attributes are the data members of the data class.");
    _builder_8.newLine();
    EcoreUtil.setDocumentation(_reference_1, _builder_8.toString());
    EReference _reference_2 = PostprocessingHelpers.getReference(cls, "operations");
    StringConcatenation _builder_9 = new StringConcatenation();
    _builder_9.append("Operations are the methods of the data class.");
    _builder_9.newLine();
    EcoreUtil.setDocumentation(_reference_2, _builder_9.toString());
  }
}
