package org.eclipse.etrice.generator.doc.gen;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.io.File;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.ChoicePoint;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.Documentation;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.generator.base.ILogger;
import org.eclipse.etrice.generator.base.IRoomGenerator;
import org.eclipse.etrice.generator.etricegen.Root;
import org.eclipse.etrice.generator.extensions.RoomExtensions;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
@Singleton
public class DocGen implements IRoomGenerator {
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
        String path = _docGenerationTargetPath;
        String _name = model.getName();
        String _operator_plus = StringExtensions.operator_plus(_name, ".tex");
        String file = _operator_plus;
        String _operator_plus_1 = StringExtensions.operator_plus("generating LaTeX documentation: \'", file);
        String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, "\' in \'");
        String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, path);
        String _operator_plus_4 = StringExtensions.operator_plus(_operator_plus_3, "\'");
        this.logger.logInfo(_operator_plus_4);
        this.fileAccess.setOutputPath(path);
        StringConcatenation _generateModelDoc = this.generateModelDoc(root, model);
        this.fileAccess.generateFile(file, _generateModelDoc);
      }
    }
  }
  
  public StringConcatenation generateModelDoc(final Root root, final RoomModel model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\\documentclass[titlepage]{article}");
    _builder.newLine();
    _builder.append("\\usepackage{graphicx}");
    _builder.newLine();
    _builder.append("\\parindent 0pt");
    _builder.newLine();
    _builder.append("\\makeatletter");
    _builder.newLine();
    _builder.append("\\newcommand\\level[1]{%");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("\\ifcase#1\\relax\\expandafter\\chapter\\or");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("\\expandafter\\section\\or");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("\\expandafter\\subsection\\or");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("\\expandafter\\subsubsection\\else");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("\\def\\next{\\@level{#1}}\\expandafter\\next");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("\\fi}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\\newcommand{\\@level}[1]{%");
    _builder.newLine();
    _builder.append("\\@startsection{level#1}");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("{#1}");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("{\\z@}%");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("{-3.25ex\\@plus -1ex \\@minus -.2ex}%");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("{1.5ex \\@plus .2ex}%");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("{\\normalfont\\normalsize\\bfseries}}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\\newdimen\\@leveldim");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("\\newdimen\\@dotsdim");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("{\\normalfont\\normalsize");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\\sbox\\z@{0}\\global\\@leveldim=\\wd\\z@");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\\sbox\\z@{.}\\global\\@dotsdim=\\wd\\z@");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("}  ");
    _builder.newLine();
    _builder.append("\\newcounter{level4}[subsubsection]");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("\\@namedef{thelevel4}{\\thesubsubsection.\\arabic{level4}}");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("\\@namedef{level4mark}#1{}");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("\\def\\l@section{\\@dottedtocline{1}{0pt}{\\dimexpr\\@leveldim*4+\\@dotsdim*1+6pt\\relax}}");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("\\def\\l@subsection{\\@dottedtocline{2}{0pt}{\\dimexpr\\@leveldim*5+\\@dotsdim*2+6pt\\relax}}");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("\\def\\l@subsubsection{\\@dottedtocline{3}{0pt}{\\dimexpr\\@leveldim*6+\\@dotsdim*3+6pt\\relax}}");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("\\@namedef{l@level4}{\\@dottedtocline{4}{0pt}{\\dimexpr\\@leveldim*7+\\@dotsdim*4+6pt\\relax}}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\\count@=4");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("\\def\\@ncp#1{\\number\\numexpr\\count@+#1\\relax}");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("\\loop\\ifnum\\count@<100");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("\\begingroup\\edef\\x{\\endgroup");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("\\noexpand\\newcounter{level\\@ncp{1}}[level\\number\\count@]");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("\\noexpand\\@namedef{thelevel\\@ncp{1}}{%");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("\\noexpand\\@nameuse{thelevel\\@ncp{0}}.\\noexpand\\arabic{level\\@ncp{0}}}");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("\\noexpand\\@namedef{level\\@ncp{1}mark}####1{}%");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("\\noexpand\\@namedef{l@level\\@ncp{1}}%");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("{\\noexpand\\@dottedtocline{\\@ncp{1}}{0pt}{\\the\\dimexpr\\@leveldim*\\@ncp{5}+\\@dotsdim*\\@ncp{0}\\relax}}}%");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("\\x");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("\\advance\\count@\\@ne");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("\\repeat");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("\\makeatother");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("\\setcounter{secnumdepth}{100}");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("\\setcounter{tocdepth}{100}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("\\title{");
    String _name = model.getName();
    _builder.append(_name, "");
    _builder.append(" Modeldocumentation}");
    _builder.newLineIfNotEmpty();
    _builder.append("\\date{\\today}");
    _builder.newLine();
    _builder.append("\\author{generated by eTrice}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\\begin{document}");
    _builder.newLine();
    _builder.append("\\pagestyle{plain}");
    _builder.newLine();
    _builder.append("\\maketitle");
    _builder.newLine();
    _builder.append("\\tableofcontents");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\\newpage");
    _builder.newLine();
    _builder.append("\\listoffigures");
    _builder.newLine();
    _builder.append("\\newpage");
    _builder.newLine();
    _builder.append("\\section{Modeldescription}");
    _builder.newLine();
    Documentation _docu = model.getDocu();
    StringConcatenation _generateDocText = this.generateDocText(_docu);
    _builder.append(_generateDocText, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\\section{Protocol Class Description}");
    _builder.newLine();
    StringConcatenation _generateAllProtocolClassDocs = this.generateAllProtocolClassDocs(root, model);
    _builder.append(_generateAllProtocolClassDocs, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\\section{Data Class Description}");
    _builder.newLine();
    StringConcatenation _generateAllDataClassDocs = this.generateAllDataClassDocs(root, model);
    _builder.append(_generateAllDataClassDocs, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\\section{Actor Class Description}");
    _builder.newLine();
    StringConcatenation _generateAllActorClassDocs = this.generateAllActorClassDocs(root, model);
    _builder.append(_generateAllActorClassDocs, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\\end{document}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation generateAllDataClassDocs(final Root root, final RoomModel model) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<DataClass> _dataClasses = model.getDataClasses();
      for(final DataClass dc : _dataClasses) {
        StringConcatenation _generateDataClassDoc = this.generateDataClassDoc(root, dc);
        _builder.append(_generateDataClassDoc, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public StringConcatenation generateDataClassDoc(final Root root, final DataClass dc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\\level{2} {");
    String _name = dc.getName();
    _builder.append(_name, "");
    _builder.append("}");
    _builder.newLineIfNotEmpty();
    Documentation _docu = dc.getDocu();
    StringConcatenation _generateDocText = this.generateDocText(_docu);
    _builder.append(_generateDocText, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\\level{3}{Attributes}");
    _builder.newLine();
    EList<Attribute> _attributes = dc.getAttributes();
    StringConcatenation _generateAttributesDoc = this.generateAttributesDoc(_attributes);
    _builder.append(_generateAttributesDoc, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\\level{3}{Operations}");
    _builder.newLine();
    EList<StandardOperation> _operations = dc.getOperations();
    StringConcatenation _generateOperationsDoc = this.generateOperationsDoc(_operations);
    _builder.append(_generateOperationsDoc, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public StringConcatenation generateAllProtocolClassDocs(final Root root, final RoomModel model) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<ProtocolClass> _protocolClasses = model.getProtocolClasses();
      for(final ProtocolClass pc : _protocolClasses) {
        StringConcatenation _generateProtocolClassDoc = this.generateProtocolClassDoc(root, pc);
        _builder.append(_generateProtocolClassDoc, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public StringConcatenation generateProtocolClassDoc(final Root root, final ProtocolClass pc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t");
    _builder.append("\\level{2} {");
    String _name = pc.getName();
    _builder.append(_name, "	");
    _builder.append("}");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    Documentation _docu = pc.getDocu();
    StringConcatenation _generateDocText = this.generateDocText(_docu);
    _builder.append(_generateDocText, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\\level{3}{Incoming Messages}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\\begin{tabular}[ht]{|l|l|l|}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\\hline");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Message & Data & Description\\\\");
    _builder.newLine();
    {
      List<Message> _allIncomingMessages = this.roomExt.getAllIncomingMessages(pc);
      for(final Message ims : _allIncomingMessages) {
        _builder.append("\t");
        _builder.append("\\hline");
        _builder.newLine();
        _builder.append("\t");
        String _name_1 = ims.getName();
        _builder.append(_name_1, "	");
        _builder.append(" & ");
        {
          VarDecl _data = ims.getData();
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_data, null);
          if (_operator_notEquals) {
            _builder.append(" ");
            VarDecl _data_1 = ims.getData();
            String _name_2 = _data_1.getName();
            _builder.append(_name_2, "	");
            _builder.append(" ");
          }
        }
        _builder.append(" & ");
        Documentation _docu_1 = ims.getDocu();
        StringConcatenation _generateDocText_1 = this.generateDocText(_docu_1);
        _builder.append(_generateDocText_1, "	");
        _builder.append("\\\\");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("\\hline");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\\end{tabular}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\\level{3}{Outgoing Messages}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\\begin{tabular}[ht]{|l|l|l|}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\\hline");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Message & Data & Description\\\\");
    _builder.newLine();
    {
      List<Message> _allOutgoingMessages = this.roomExt.getAllOutgoingMessages(pc);
      for(final Message oms : _allOutgoingMessages) {
        _builder.append("\t");
        _builder.append("\\hline");
        _builder.newLine();
        _builder.append("\t");
        String _name_3 = oms.getName();
        _builder.append(_name_3, "	");
        _builder.append(" & ");
        {
          VarDecl _data_2 = oms.getData();
          boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_data_2, null);
          if (_operator_notEquals_1) {
            _builder.append(" ");
            VarDecl _data_3 = oms.getData();
            String _name_4 = _data_3.getName();
            _builder.append(_name_4, "	");
            _builder.append(" ");
          }
        }
        _builder.append(" & ");
        Documentation _docu_2 = oms.getDocu();
        StringConcatenation _generateDocText_2 = this.generateDocText(_docu_2);
        _builder.append(_generateDocText_2, "	");
        _builder.append("\\\\");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("\\hline");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\\end{tabular}\t\t\t");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation generateAllActorClassDocs(final Root root, final RoomModel model) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<ActorClass> _actorClasses = model.getActorClasses();
      for(final ActorClass ac : _actorClasses) {
        _builder.append("\\newpage");
        _builder.newLine();
        _builder.append("\t");
        StringConcatenation _generateActorClassDoc = this.generateActorClassDoc(root, model, ac);
        _builder.append(_generateActorClassDoc, "	");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public StringConcatenation generateActorClassDoc(final Root root, final RoomModel model, final ActorClass ac) {
    StringConcatenation _xblockexpression = null;
    {
      String _docGenerationTargetPath = this.roomExt.getDocGenerationTargetPath(model);
      String _operator_plus = StringExtensions.operator_plus(_docGenerationTargetPath, "images\\");
      String _name = ac.getName();
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, _name);
      String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, "_structure.jpg");
      String filename = _operator_plus_2;
      String _replaceAll = filename.replaceAll("\\\\", "/");
      filename = _replaceAll;
      String _replaceAll_1 = filename.replaceAll("/", "//");
      String latexFilename = _replaceAll_1;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\\level{2}{");
      String _name_1 = ac.getName();
      _builder.append(_name_1, "");
      _builder.append("}");
      _builder.newLineIfNotEmpty();
      Documentation _docu = ac.getDocu();
      StringConcatenation _generateDocText = this.generateDocText(_docu);
      _builder.append(_generateDocText, "");
      _builder.newLineIfNotEmpty();
      _builder.append("\\level{3}{Structure}");
      _builder.newLine();
      _builder.newLine();
      {
        String _fileExists = this.fileExists(filename);
        boolean _equals = _fileExists.equals("true");
        if (_equals) {
          String _name_2 = ac.getName();
          String _operator_plus_3 = StringExtensions.operator_plus(_name_2, " Structure");
          StringConcatenation _includeGraphics = this.includeGraphics(latexFilename, "0.4", _operator_plus_3);
          _builder.append(_includeGraphics, "");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\\level{3}{Attributes}");
      _builder.newLine();
      EList<Attribute> _attributes = ac.getAttributes();
      StringConcatenation _generateAttributesDoc = this.generateAttributesDoc(_attributes);
      _builder.append(_generateAttributesDoc, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\\level{3}{Operations}");
      _builder.newLine();
      EList<StandardOperation> _operations = ac.getOperations();
      StringConcatenation _generateOperationsDoc = this.generateOperationsDoc(_operations);
      _builder.append(_generateOperationsDoc, "");
      _builder.newLineIfNotEmpty();
      {
        boolean _hasNonEmptyStateMachine = this.roomExt.hasNonEmptyStateMachine(ac);
        if (_hasNonEmptyStateMachine) {
          _builder.append("\\level{3}{Statemachine}");
          _builder.newLine();
          StringConcatenation _generateFsmDoc = this.generateFsmDoc(model, ac);
          _builder.append(_generateFsmDoc, "");
          _builder.newLineIfNotEmpty();
        }
      }
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  public StringConcatenation generateFsmDoc(final RoomModel model, final ActorClass ac) {
    StringConcatenation _xblockexpression = null;
    {
      String _docGenerationTargetPath = this.roomExt.getDocGenerationTargetPath(model);
      String _operator_plus = StringExtensions.operator_plus(_docGenerationTargetPath, "images\\");
      String _name = ac.getName();
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, _name);
      String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, "_behavior.jpg");
      String filename = _operator_plus_2;
      String _replaceAll = filename.replaceAll("\\\\", "/");
      filename = _replaceAll;
      String _replaceAll_1 = filename.replaceAll("/", "//");
      String latexFilename = _replaceAll_1;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\\level{4}{Top Level}");
      _builder.newLine();
      {
        String _fileExists = this.fileExists(filename);
        boolean _equals = _fileExists.equals("true");
        if (_equals) {
          String _name_1 = ac.getName();
          String _operator_plus_3 = StringExtensions.operator_plus(_name_1, " Top State");
          StringConcatenation _includeGraphics = this.includeGraphics(latexFilename, "0.4", _operator_plus_3);
          _builder.append(_includeGraphics, "");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\\begin{par}");
      _builder.newLine();
      {
        StateGraph _stateMachine = ac.getStateMachine();
        EList<State> _states = _stateMachine.getStates();
        for(final State s : _states) {
          {
            Documentation _docu = s.getDocu();
            boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_docu, null);
            if (_operator_notEquals) {
              _builder.append("\\textbf{State description} \\textit{");
              String _statePathName = this.roomExt.getStatePathName(s);
              String _replaceAll_2 = _statePathName.replaceAll("_", "-");
              _builder.append(_replaceAll_2, "");
              _builder.append("}:");
              _builder.newLineIfNotEmpty();
              _builder.append("\\newline");
              _builder.newLine();
              Documentation _docu_1 = s.getDocu();
              StringConcatenation _generateDocText = this.generateDocText(_docu_1);
              _builder.append(_generateDocText, "");
              _builder.newLineIfNotEmpty();
              _builder.append("\\newline\\newline");
              _builder.newLine();
            }
          }
        }
      }
      _builder.newLine();
      {
        StateGraph _stateMachine_1 = ac.getStateMachine();
        EList<ChoicePoint> _chPoints = _stateMachine_1.getChPoints();
        for(final ChoicePoint c : _chPoints) {
          {
            Documentation _docu_2 = c.getDocu();
            boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_docu_2, null);
            if (_operator_notEquals_1) {
              _builder.append("\\textbf{Choicepoint description} \\textit{");
              String _name_2 = c.getName();
              _builder.append(_name_2, "");
              _builder.append("}:");
              _builder.newLineIfNotEmpty();
              _builder.append("\\newline");
              _builder.newLine();
              Documentation _docu_3 = c.getDocu();
              StringConcatenation _generateDocText_1 = this.generateDocText(_docu_3);
              _builder.append(_generateDocText_1, "");
              _builder.newLineIfNotEmpty();
              _builder.append("\\newline\\newline");
              _builder.newLine();
            }
          }
        }
      }
      _builder.append("\\end{par}");
      _builder.newLine();
      _builder.newLine();
      {
        StateGraph _stateMachine_2 = ac.getStateMachine();
        EList<State> _states_1 = _stateMachine_2.getStates();
        for(final State s_1 : _states_1) {
          {
            boolean _isLeaf = this.roomExt.isLeaf(s_1);
            boolean _operator_not = BooleanExtensions.operator_not(_isLeaf);
            if (_operator_not) {
              StringConcatenation _generateStateDoc = this.generateStateDoc(model, ac, s_1);
              _builder.append(_generateStateDoc, "");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  public StringConcatenation generateStateDoc(final RoomModel model, final ActorClass ac, final State state) {
    StringConcatenation _xblockexpression = null;
    {
      String _docGenerationTargetPath = this.roomExt.getDocGenerationTargetPath(model);
      String _operator_plus = StringExtensions.operator_plus(_docGenerationTargetPath, "images\\");
      String _name = ac.getName();
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, _name);
      String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, "_");
      String _statePathName = this.roomExt.getStatePathName(state);
      String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, _statePathName);
      String _operator_plus_4 = StringExtensions.operator_plus(_operator_plus_3, "_behavior.jpg");
      String filename = _operator_plus_4;
      String _replaceAll = filename.replaceAll("\\\\", "/");
      filename = _replaceAll;
      String _replaceAll_1 = filename.replaceAll("/", "//");
      String latexFilename = _replaceAll_1;
      String _operator_plus_5 = StringExtensions.operator_plus("Gen Filename: ", filename);
      this.logger.logInfo(_operator_plus_5);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\\level{4}{Subgraph ");
      String _statePathName_1 = this.roomExt.getStatePathName(state);
      String _replaceAll_2 = _statePathName_1.replaceAll("_", "-");
      _builder.append(_replaceAll_2, "");
      _builder.append("}");
      _builder.newLineIfNotEmpty();
      {
        String _fileExists = this.fileExists(filename);
        boolean _equals = _fileExists.equals("true");
        if (_equals) {
          String _name_1 = ac.getName();
          String _operator_plus_6 = StringExtensions.operator_plus(_name_1, "_");
          String _statePathName_2 = this.roomExt.getStatePathName(state);
          String _operator_plus_7 = StringExtensions.operator_plus(_operator_plus_6, _statePathName_2);
          StringConcatenation _includeGraphics = this.includeGraphics(latexFilename, "0.4", _operator_plus_7);
          _builder.append(_includeGraphics, "");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\\begin{par}");
      _builder.newLine();
      {
        StateGraph _subgraph = state.getSubgraph();
        EList<State> _states = _subgraph.getStates();
        for(final State s : _states) {
          {
            Documentation _docu = s.getDocu();
            boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_docu, null);
            if (_operator_notEquals) {
              _builder.append("\\textbf{State description} \\textit{");
              String _statePathName_3 = this.roomExt.getStatePathName(s);
              String _replaceAll_3 = _statePathName_3.replaceAll("_", "-");
              _builder.append(_replaceAll_3, "");
              _builder.append("}:");
              _builder.newLineIfNotEmpty();
              _builder.append("\\newline");
              _builder.newLine();
              Documentation _docu_1 = s.getDocu();
              StringConcatenation _generateDocText = this.generateDocText(_docu_1);
              _builder.append(_generateDocText, "");
              _builder.newLineIfNotEmpty();
              _builder.append("\\newline\\newline");
              _builder.newLine();
            }
          }
        }
      }
      _builder.newLine();
      {
        StateGraph _subgraph_1 = state.getSubgraph();
        EList<ChoicePoint> _chPoints = _subgraph_1.getChPoints();
        for(final ChoicePoint c : _chPoints) {
          {
            Documentation _docu_2 = c.getDocu();
            boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_docu_2, null);
            if (_operator_notEquals_1) {
              _builder.append("\\textbf{Choicepoint description} \\textit{");
              String _name_2 = c.getName();
              _builder.append(_name_2, "");
              _builder.append("}:");
              _builder.newLineIfNotEmpty();
              _builder.append("\\newline");
              _builder.newLine();
              Documentation _docu_3 = c.getDocu();
              StringConcatenation _generateDocText_1 = this.generateDocText(_docu_3);
              _builder.append(_generateDocText_1, "");
              _builder.newLineIfNotEmpty();
              _builder.append("\\newline\\newline");
              _builder.newLine();
            }
          }
        }
      }
      _builder.append("\\end{par}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      {
        StateGraph _subgraph_2 = state.getSubgraph();
        EList<State> _states_1 = _subgraph_2.getStates();
        for(final State s_1 : _states_1) {
          {
            boolean _isLeaf = this.roomExt.isLeaf(s_1);
            boolean _operator_not = BooleanExtensions.operator_not(_isLeaf);
            if (_operator_not) {
              StringConcatenation _generateStateDoc = this.generateStateDoc(model, ac, s_1);
              _builder.append(_generateStateDoc, "");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  public StringConcatenation generateAttributesDoc(final List<Attribute> attributes) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isEmpty = attributes.isEmpty();
      boolean _operator_not = BooleanExtensions.operator_not(_isEmpty);
      if (_operator_not) {
        _builder.append("\\begin{tabular}[ht]{|l|l|l|}");
        _builder.newLine();
        _builder.append("\\hline");
        _builder.newLine();
        _builder.append("Name & Type & Description\\\\");
        _builder.newLine();
        {
          for(final Attribute at : attributes) {
            _builder.append("\\hline");
            _builder.newLine();
            String _name = at.getName();
            _builder.append(_name, "");
            _builder.append(" & ");
            RefableType _refType = at.getRefType();
            DataType _type = _refType.getType();
            String _name_1 = _type.getName();
            _builder.append(_name_1, "");
            _builder.append(" & ");
            Documentation _docu = at.getDocu();
            StringConcatenation _generateDocText = this.generateDocText(_docu);
            _builder.append(_generateDocText, "");
            _builder.append("\\\\");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\\hline");
        _builder.newLine();
        _builder.append("\\end{tabular}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public StringConcatenation generateOperationsDoc(final List<StandardOperation> operations) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final StandardOperation op : operations) {
        _builder.append("\\begin{tabular}[ht]{|l|l|}");
        _builder.newLine();
        _builder.append("\\hline\t\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("Name: & ");
        String _name = op.getName();
        _builder.append(_name, "	");
        _builder.append("\\\\");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\\hline");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("ReturnType: &  ");
        {
          RefableType _returntype = op.getReturntype();
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_returntype, null);
          if (_operator_notEquals) {
            RefableType _returntype_1 = op.getReturntype();
            DataType _type = _returntype_1.getType();
            String _name_1 = _type.getName();
            _builder.append(_name_1, "	");
          } else {
            _builder.append("void");
          }
        }
        _builder.append("\\\\");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\\hline");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("Arguments: & ");
        {
          EList<VarDecl> _arguments = op.getArguments();
          boolean hasAnyElements = false;
          for(final VarDecl pa : _arguments) {
            if (!hasAnyElements) {
              hasAnyElements = true;
            } else {
              _builder.appendImmediate(", ", "	");
            }
            String _name_2 = pa.getName();
            _builder.append(_name_2, "	");
            _builder.append(":");
            RefableType _refType = pa.getRefType();
            DataType _type_1 = _refType.getType();
            String _name_3 = _type_1.getName();
            _builder.append(_name_3, "	");
          }
        }
        _builder.append("\\\\");
        _builder.newLineIfNotEmpty();
        {
          Documentation _docu = op.getDocu();
          boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_docu, null);
          if (_operator_notEquals_1) {
            _builder.append("\t");
            _builder.append("\\hline");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\\multicolumn{2} {|l|} {");
            Documentation _docu_1 = op.getDocu();
            StringConcatenation _generateDocText = this.generateDocText(_docu_1);
            _builder.append(_generateDocText, "	");
            _builder.append("}\\\\");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("\\hline");
        _builder.newLine();
        _builder.append("\\end{tabular}");
        _builder.newLine();
        _builder.append("\\newline\\newline\\newline");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public StringConcatenation generateDocText(final Documentation doc) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(doc, null);
      if (_operator_notEquals) {
        EList<String> _text = doc.getText();
        String _join = IterableExtensions.join(_text);
        _builder.append(_join, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public String fileExists(final String f) {
      File _file = new File(f);
      final File file = _file;
      boolean _exists = file.exists();
      final boolean exist = _exists;
      boolean _operator_equals = ObjectExtensions.operator_equals(((Boolean)exist), ((Boolean)true));
      if (_operator_equals) {
        {
          String _operator_plus = StringExtensions.operator_plus("File found ! ", f);
          this.logger.logInfo(_operator_plus);
          return "true";
        }
      } else {
        {
          String _operator_plus_1 = StringExtensions.operator_plus("File not found ! ", f);
          this.logger.logInfo(_operator_plus_1);
          return "false";
        }
      }
  }
  
  public StringConcatenation includeGraphics(final String filename, final String scale, final String caption) {
    StringConcatenation _xblockexpression = null;
    {
      String _replaceAll = caption.replaceAll("_", "-");
      String latexCaption = _replaceAll;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\\begin{figure}[h]");
      _builder.newLine();
      _builder.append("\\begin{center}");
      _builder.newLine();
      _builder.append("\\includegraphics[scale=");
      _builder.append(scale, "");
      _builder.append("]{");
      _builder.append(filename, "");
      _builder.append("}");
      _builder.newLineIfNotEmpty();
      _builder.append("\\caption{");
      _builder.append(latexCaption, "");
      _builder.append("}");
      _builder.newLineIfNotEmpty();
      _builder.append("\\end{center}");
      _builder.newLine();
      _builder.append("\\end{figure}");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  public String irgendwas(final Root root, final ActorClass ac) {
    String _name = ac.getName();
    String _operator_plus = StringExtensions.operator_plus(_name, ".bla");
    return _operator_plus;
  }
}
