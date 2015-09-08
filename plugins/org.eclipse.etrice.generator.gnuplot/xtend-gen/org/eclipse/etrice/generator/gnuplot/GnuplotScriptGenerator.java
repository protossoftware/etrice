/**
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Eyrak Pean (initial contribution)
 * 		Juergen Haug
 */
package org.eclipse.etrice.generator.gnuplot;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.common.base.Annotation;
import org.eclipse.etrice.core.common.base.AnnotationType;
import org.eclipse.etrice.core.common.base.IntLiteral;
import org.eclipse.etrice.core.common.base.KeyValue;
import org.eclipse.etrice.core.common.base.Literal;
import org.eclipse.etrice.core.common.base.RealLiteral;
import org.eclipse.etrice.core.common.base.StringLiteral;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.generator.fsm.base.IGeneratorFileIo;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class GnuplotScriptGenerator {
  @Inject
  private IGeneratorFileIo fileIo;
  
  @Inject
  @Extension
  private RoomExtensions roomExtensions;
  
  public void doGenerate(final Root root) {
    EList<SubSystemInstance> _subSystemInstances = root.getSubSystemInstances();
    boolean _isEmpty = _subSystemInstances.isEmpty();
    if (_isEmpty) {
      return;
    }
    EList<SubSystemInstance> _subSystemInstances_1 = root.getSubSystemInstances();
    final SubSystemInstance ssi = IterableExtensions.<SubSystemInstance>head(_subSystemInstances_1);
    SubSystemClass _subSystemClass = ssi.getSubSystemClass();
    final String path = this.roomExtensions.getGenerationTargetPath(_subSystemClass);
    SubSystemClass _subSystemClass_1 = ssi.getSubSystemClass();
    final String infoPath = this.roomExtensions.getGenerationInfoPath(_subSystemClass_1);
    try {
      String _name = ssi.getName();
      String _plus = ("Generating gnuplot script for subsystem " + _name);
      CharSequence _generatePlotScript = this.generatePlotScript(ssi);
      this.fileIo.generateFile(_plus, path, infoPath, 
        "/gnuplot/log_main.data.csv-Script.plt", _generatePlotScript);
      CharSequence _gnuPlotLaunchFile = this.gnuPlotLaunchFile();
      this.fileIo.generateFile("Generating gnuplot launch configuration", path, infoPath, 
        "/gnuplot/create_gnuplot.launch", _gnuPlotLaunchFile);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  protected CharSequence gnuPlotLaunchFile() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
    _builder.newLine();
    _builder.append("<launchConfiguration type=\"org.eclipse.ui.externaltools.ProgramLaunchConfigurationType\">");
    _builder.newLine();
    _builder.append("<stringAttribute key=\"org.eclipse.ui.externaltools.ATTR_LAUNCH_CONFIGURATION_BUILD_SCOPE\" value=\"${none}\"/>");
    _builder.newLine();
    _builder.append("<stringAttribute key=\"org.eclipse.ui.externaltools.ATTR_LOCATION\" value=\"${system_path:gnuplot}\"/>");
    _builder.newLine();
    _builder.append("<stringAttribute key=\"org.eclipse.ui.externaltools.ATTR_TOOL_ARGUMENTS\" value=\"${project_loc}/src-gen/gnuplot/log_main.data.csv-Script.plt\"/>");
    _builder.newLine();
    _builder.append("<stringAttribute key=\"org.eclipse.ui.externaltools.ATTR_WORKING_DIRECTORY\" value=\"${project_loc}\"/>");
    _builder.newLine();
    _builder.append("</launchConfiguration>");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  protected KeyValue getAttribute(final Annotation anno, final String name) {
    EList<KeyValue> _attributes = anno.getAttributes();
    final Function1<KeyValue, Boolean> _function = new Function1<KeyValue, Boolean>() {
      public Boolean apply(final KeyValue attr) {
        String _key = attr.getKey();
        return Boolean.valueOf(Objects.equal(_key, name));
      }
    };
    return IterableExtensions.<KeyValue>findFirst(_attributes, _function);
  }
  
  protected String asString(final KeyValue kv) {
    String _xifexpression = null;
    Literal _value = kv.getValue();
    if ((_value instanceof StringLiteral)) {
      Literal _value_1 = kv.getValue();
      _xifexpression = ((StringLiteral) _value_1).getValue();
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  protected Double asReal(final KeyValue kv) {
    Double _xifexpression = null;
    Literal _value = kv.getValue();
    if ((_value instanceof RealLiteral)) {
      Literal _value_1 = kv.getValue();
      _xifexpression = Double.valueOf(((RealLiteral) _value_1).getValue());
    } else {
      Double _xifexpression_1 = null;
      Literal _value_2 = kv.getValue();
      if ((_value_2 instanceof IntLiteral)) {
        Literal _value_3 = kv.getValue();
        long _value_4 = ((IntLiteral) _value_3).getValue();
        _xifexpression_1 = Double.valueOf(((double) _value_4));
      } else {
        _xifexpression_1 = null;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  protected Long asInteger(final KeyValue kv) {
    Long _xifexpression = null;
    Literal _value = kv.getValue();
    if ((_value instanceof IntLiteral)) {
      Literal _value_1 = kv.getValue();
      _xifexpression = Long.valueOf(((IntLiteral) _value_1).getValue());
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  protected CharSequence generatePlotScript(final SubSystemInstance ssi) {
    CharSequence _xblockexpression = null;
    {
      SubSystemClass _subSystemClass = ssi.getSubSystemClass();
      EList<Annotation> _annotations = _subSystemClass.getAnnotations();
      final Function1<Annotation, Boolean> _function = new Function1<Annotation, Boolean>() {
        public Boolean apply(final Annotation a) {
          AnnotationType _type = a.getType();
          String _name = _type.getName();
          return Boolean.valueOf(Objects.equal(_name, "Gnuplot"));
        }
      };
      Iterable<Annotation> _filter = IterableExtensions.<Annotation>filter(_annotations, _function);
      final Annotation plotAnnotation = IterableExtensions.<Annotation>head(_filter);
      final int defaultFontsize = 10;
      KeyValue _attribute = null;
      if (plotAnnotation!=null) {
        _attribute=this.getAttribute(plotAnnotation, "format");
      }
      String _asString = null;
      if (_attribute!=null) {
        _asString=this.asString(_attribute);
      }
      final String format = _asString;
      KeyValue _attribute_1 = null;
      if (plotAnnotation!=null) {
        _attribute_1=this.getAttribute(plotAnnotation, "outputfile");
      }
      String _asString_1 = null;
      if (_attribute_1!=null) {
        _asString_1=this.asString(_attribute_1);
      }
      final String outputfile = _asString_1;
      KeyValue _attribute_2 = null;
      if (plotAnnotation!=null) {
        _attribute_2=this.getAttribute(plotAnnotation, "width");
      }
      Long _asInteger = null;
      if (_attribute_2!=null) {
        _asInteger=this.asInteger(_attribute_2);
      }
      final Long width = _asInteger;
      KeyValue _attribute_3 = null;
      if (plotAnnotation!=null) {
        _attribute_3=this.getAttribute(plotAnnotation, "height");
      }
      Long _asInteger_1 = null;
      if (_attribute_3!=null) {
        _asInteger_1=this.asInteger(_attribute_3);
      }
      final Long height = _asInteger_1;
      Number _elvis = null;
      KeyValue _attribute_4 = null;
      if (plotAnnotation!=null) {
        _attribute_4=this.getAttribute(plotAnnotation, "fontsize");
      }
      Long _asInteger_2 = null;
      if (_attribute_4!=null) {
        _asInteger_2=this.asInteger(_attribute_4);
      }
      if (_asInteger_2 != null) {
        _elvis = _asInteger_2;
      } else {
        _elvis = Integer.valueOf(defaultFontsize);
      }
      final Number fontsize = ((Number)_elvis);
      SubSystemClass _subSystemClass_1 = ssi.getSubSystemClass();
      EList<Annotation> _annotations_1 = _subSystemClass_1.getAnnotations();
      final Function1<Annotation, Boolean> _function_1 = new Function1<Annotation, Boolean>() {
        public Boolean apply(final Annotation a) {
          AnnotationType _type = a.getType();
          String _name = _type.getName();
          return Boolean.valueOf(Objects.equal(_name, "GnuplotGraph"));
        }
      };
      Iterable<Annotation> _filter_1 = IterableExtensions.<Annotation>filter(_annotations_1, _function_1);
      final List<Annotation> graphAnnotations = IterableExtensions.<Annotation>toList(_filter_1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("#!/gnuplot");
      _builder.newLine();
      _builder.newLine();
      _builder.append("# Color Brewer set1 5-set");
      _builder.newLine();
      _builder.append("set linetype 1 lc rgb \'#e41a1c\' lw 1");
      _builder.newLine();
      _builder.append("set linetype 2 lc rgb \'#377eb8\' lw 1");
      _builder.newLine();
      _builder.append("set linetype 3 lc rgb \'#4daf4a\' lw 1");
      _builder.newLine();
      _builder.append("set linetype 4 lc rgb \'#984ea3\' lw 1");
      _builder.newLine();
      _builder.append("set linetype 5 lc rgb \'#ff7f00\' lw 1");
      _builder.newLine();
      _builder.append("set linetype cycle 5");
      _builder.newLine();
      _builder.newLine();
      _builder.append("cd \'log\'");
      _builder.newLine();
      _builder.append("set datafile separator comma");
      _builder.newLine();
      _builder.append("set terminal ");
      _builder.append(format, "");
      _builder.append(" size ");
      _builder.append(width, "");
      _builder.append(",");
      _builder.append(height, "");
      _builder.append(" font \",");
      _builder.append(((Number)fontsize), "");
      _builder.append("\" background \"white\"");
      _builder.newLineIfNotEmpty();
      _builder.append("set output \'");
      _builder.append(outputfile, "");
      _builder.append("\'");
      _builder.newLineIfNotEmpty();
      _builder.append("set size 1,1");
      _builder.newLine();
      _builder.append("set multiplot layout ");
      int _size = graphAnnotations.size();
      _builder.append(_size, "");
      _builder.append(",1");
      _builder.newLineIfNotEmpty();
      _builder.append("set grid");
      _builder.newLine();
      _builder.append("show grid");
      _builder.newLine();
      _builder.append("set format y \"% 5.3f\"");
      _builder.newLine();
      int i = 0;
      _builder.newLineIfNotEmpty();
      {
        for(final Annotation a : graphAnnotations) {
          _builder.newLine();
          int _plusPlus = i++;
          int _size_1 = graphAnnotations.size();
          CharSequence _generateGraph = this.generateGraph(ssi, a, _plusPlus, _size_1);
          _builder.append(_generateGraph, "");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("unset multiplot");
      _builder.newLine();
      _builder.append("unset output");
      _builder.newLine();
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  protected CharSequence generateGraph(final SubSystemInstance ssi, final Annotation graph, final int index, final int total) {
    CharSequence _xblockexpression = null;
    {
      KeyValue _attribute = this.getAttribute(graph, "paths");
      String _asString = null;
      if (_attribute!=null) {
        _asString=this.asString(_attribute);
      }
      final String paths = _asString;
      Number _elvis = null;
      KeyValue _attribute_1 = this.getAttribute(graph, "interval");
      Long _asInteger = null;
      if (_attribute_1!=null) {
        _asInteger=this.asInteger(_attribute_1);
      }
      if (_asInteger != null) {
        _elvis = _asInteger;
      } else {
        _elvis = Integer.valueOf(20);
      }
      final Number interval = ((Number)_elvis);
      Number _elvis_1 = null;
      KeyValue _attribute_2 = this.getAttribute(graph, "xtics");
      Double _asReal = null;
      if (_attribute_2!=null) {
        _asReal=this.asReal(_attribute_2);
      }
      if (_asReal != null) {
        _elvis_1 = _asReal;
      } else {
        _elvis_1 = Integer.valueOf(100);
      }
      final Number xtics = ((Number)_elvis_1);
      Number _elvis_2 = null;
      KeyValue _attribute_3 = this.getAttribute(graph, "mxtics");
      Long _asInteger_1 = null;
      if (_attribute_3!=null) {
        _asInteger_1=this.asInteger(_attribute_3);
      }
      if (_asInteger_1 != null) {
        _elvis_2 = _asInteger_1;
      } else {
        _elvis_2 = Integer.valueOf(4);
      }
      final Number mxtics = ((Number)_elvis_2);
      KeyValue _attribute_4 = this.getAttribute(graph, "ymin");
      Double _asReal_1 = null;
      if (_attribute_4!=null) {
        _asReal_1=this.asReal(_attribute_4);
      }
      final Double ymin = _asReal_1;
      KeyValue _attribute_5 = this.getAttribute(graph, "ymax");
      Double _asReal_2 = null;
      if (_attribute_5!=null) {
        _asReal_2=this.asReal(_attribute_5);
      }
      final Double ymax = _asReal_2;
      final double vertOrigin = (((double) (total - (index + 1))) / total);
      final float vertSize = (1.0F / total);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("set yrange [");
      Object _elvis_3 = null;
      if (ymin != null) {
        _elvis_3 = ymin;
      } else {
        _elvis_3 = "*";
      }
      _builder.append(((Object)_elvis_3), "");
      _builder.append(" : ");
      Object _elvis_4 = null;
      if (ymax != null) {
        _elvis_4 = ymax;
      } else {
        _elvis_4 = "*";
      }
      _builder.append(((Object)_elvis_4), "");
      _builder.append("]");
      _builder.newLineIfNotEmpty();
      _builder.append("set xtics rotate ");
      _builder.append(((Number)xtics), "");
      _builder.newLineIfNotEmpty();
      _builder.append("set mxtics ");
      _builder.append(((Number)mxtics), "");
      _builder.newLineIfNotEmpty();
      _builder.append("set ylabel");
      _builder.newLine();
      _builder.append("set xlabel \"time (ms)\"");
      _builder.newLine();
      _builder.append("timeInMs(x) = ");
      _builder.append(((Number)interval), "");
      _builder.append(" * x");
      _builder.newLineIfNotEmpty();
      _builder.append("set origin 0,");
      _builder.append(vertOrigin, "");
      _builder.newLineIfNotEmpty();
      _builder.append("set size 1,");
      _builder.append(vertSize, "");
      _builder.newLineIfNotEmpty();
      _builder.append("plot \'main.data.csv\' using (timeInMs(column(1))):(column(\"");
      _builder.append(paths, "");
      _builder.append("\")) with lines");
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
}
