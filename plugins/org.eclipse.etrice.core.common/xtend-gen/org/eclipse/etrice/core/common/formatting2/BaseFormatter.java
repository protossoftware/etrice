/**
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 */
package org.eclipse.etrice.core.common.formatting2;

import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.common.base.Annotation;
import org.eclipse.etrice.core.common.base.AnnotationAttribute;
import org.eclipse.etrice.core.common.base.AnnotationType;
import org.eclipse.etrice.core.common.base.Documentation;
import org.eclipse.etrice.core.common.base.Import;
import org.eclipse.etrice.core.common.base.KeyValue;
import org.eclipse.etrice.core.common.services.BaseGrammarAccess;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionsFinder;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class BaseFormatter extends AbstractFormatter2 {
  @Inject
  @Extension
  private BaseGrammarAccess _baseGrammarAccess;
  
  /**
   * recursive keyword formatting
   */
  protected void formatAllByKeywords(final EObject it, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _allRegionsFor = this.textRegionExtensions.allRegionsFor(it);
    List<Pair<ISemanticRegion, ISemanticRegion>> _keywordPairs = _allRegionsFor.keywordPairs("{", "}");
    final Consumer<Pair<ISemanticRegion, ISemanticRegion>> _function = (Pair<ISemanticRegion, ISemanticRegion> it_1) -> {
      ISemanticRegion _key = it_1.getKey();
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_2) -> {
        it_2.oneSpace();
      };
      document.prepend(_key, _function_1);
      final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it_2) -> {
        it_2.indent();
      };
      document.<ISemanticRegion, ISemanticRegion>interior(it_1, _function_2);
      ISemanticRegion _value = it_1.getValue();
      final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it_2) -> {
        it_2.newLine();
      };
      document.prepend(_value, _function_3);
    };
    _keywordPairs.forEach(_function);
    ISemanticRegionsFinder _allRegionsFor_1 = this.textRegionExtensions.allRegionsFor(it);
    List<Pair<ISemanticRegion, ISemanticRegion>> _keywordPairs_1 = _allRegionsFor_1.keywordPairs("(", ")");
    final Consumer<Pair<ISemanticRegion, ISemanticRegion>> _function_1 = (Pair<ISemanticRegion, ISemanticRegion> it_1) -> {
      final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it_2) -> {
        it_2.noSpace();
      };
      document.<ISemanticRegion, ISemanticRegion>interior(it_1, _function_2);
    };
    _keywordPairs_1.forEach(_function_1);
    ISemanticRegionsFinder _allRegionsFor_2 = this.textRegionExtensions.allRegionsFor(it);
    ISemanticRegion _keyword = _allRegionsFor_2.keyword("(");
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it_1) -> {
      it_1.noSpace();
      it_1.lowPriority();
    };
    document.prepend(_keyword, _function_2);
    ISemanticRegionsFinder _allRegionsFor_3 = this.textRegionExtensions.allRegionsFor(it);
    List<ISemanticRegion> _keywords = _allRegionsFor_3.keywords(",");
    final Consumer<ISemanticRegion> _function_3 = (ISemanticRegion it_1) -> {
      final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it_2) -> {
        it_2.oneSpace();
      };
      document.append(it_1, _function_4);
    };
    _keywords.forEach(_function_3);
    ISemanticRegionsFinder _allRegionsFor_4 = this.textRegionExtensions.allRegionsFor(it);
    List<ISemanticRegion> _keywords_1 = _allRegionsFor_4.keywords(".");
    final Consumer<ISemanticRegion> _function_4 = (ISemanticRegion it_1) -> {
      final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it_2) -> {
        it_2.noSpace();
      };
      document.surround(it_1, _function_5);
    };
    _keywords_1.forEach(_function_4);
    ISemanticRegionsFinder _allRegionsFor_5 = this.textRegionExtensions.allRegionsFor(it);
    List<ISemanticRegion> _keywords_2 = _allRegionsFor_5.keywords(":");
    final Consumer<ISemanticRegion> _function_5 = (ISemanticRegion it_1) -> {
      final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it_2) -> {
        it_2.noSpace();
      };
      document.prepend(it_1, _function_6);
      final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it_2) -> {
        it_2.oneSpace();
      };
      document.append(it_1, _function_7);
    };
    _keywords_2.forEach(_function_5);
    ISemanticRegionsFinder _allRegionsFor_6 = this.textRegionExtensions.allRegionsFor(it);
    BaseGrammarAccess.TIMEElements _tIMEAccess = this._baseGrammarAccess.getTIMEAccess();
    Keyword _sKeyword_0_1 = _tIMEAccess.getSKeyword_0_1();
    BaseGrammarAccess.TIMEElements _tIMEAccess_1 = this._baseGrammarAccess.getTIMEAccess();
    Keyword _msKeyword_1_1 = _tIMEAccess_1.getMsKeyword_1_1();
    BaseGrammarAccess.TIMEElements _tIMEAccess_2 = this._baseGrammarAccess.getTIMEAccess();
    Keyword _usKeyword_2_1 = _tIMEAccess_2.getUsKeyword_2_1();
    BaseGrammarAccess.TIMEElements _tIMEAccess_3 = this._baseGrammarAccess.getTIMEAccess();
    Keyword _nsKeyword_3_1 = _tIMEAccess_3.getNsKeyword_3_1();
    List<ISemanticRegion> _keywords_3 = _allRegionsFor_6.keywords(_sKeyword_0_1, _msKeyword_1_1, _usKeyword_2_1, _nsKeyword_3_1);
    final Consumer<ISemanticRegion> _function_6 = (ISemanticRegion it_1) -> {
      IHiddenRegion _previousHiddenRegion = it_1.getPreviousHiddenRegion();
      int _length = _previousHiddenRegion.getLength();
      boolean _greaterThan = (_length > 1);
      if (_greaterThan) {
        final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it_2) -> {
          it_2.oneSpace();
        };
        document.prepend(it_1, _function_7);
      } else {
        final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it_2) -> {
          it_2.noSpace();
        };
        document.prepend(it_1, _function_8);
      }
      final Procedure1<IHiddenRegionFormatter> _function_9 = (IHiddenRegionFormatter it_2) -> {
        it_2.oneSpace();
        it_2.lowPriority();
      };
      document.append(it_1, _function_9);
    };
    _keywords_3.forEach(_function_6);
  }
  
  protected void _format(final Documentation it, @Extension final IFormattableDocument document) {
  }
  
  protected void _format(final Import it, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(it);
    BaseGrammarAccess.ImportElements _importAccess = this._baseGrammarAccess.getImportAccess();
    Keyword _importKeyword_0 = _importAccess.getImportKeyword_0();
    BaseGrammarAccess.ImportElements _importAccess_1 = this._baseGrammarAccess.getImportAccess();
    Keyword _modelKeyword_1_1 = _importAccess_1.getModelKeyword_1_1();
    List<ISemanticRegion> _keywords = _regionFor.keywords(_importKeyword_0, _modelKeyword_1_1);
    final Consumer<ISemanticRegion> _function = (ISemanticRegion it_1) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_2) -> {
        it_2.oneSpace();
      };
      document.append(it_1, _function_1);
    };
    _keywords.forEach(_function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(it);
    BaseGrammarAccess.ImportElements _importAccess_2 = this._baseGrammarAccess.getImportAccess();
    Keyword _fromKeyword_1_0_1 = _importAccess_2.getFromKeyword_1_0_1();
    ISemanticRegion _keyword = _regionFor_1.keyword(_fromKeyword_1_0_1);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    document.surround(_keyword, _function_1);
  }
  
  protected void _format(final AnnotationType it, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(it);
    BaseGrammarAccess.AnnotationTypeElements _annotationTypeAccess = this._baseGrammarAccess.getAnnotationTypeAccess();
    Keyword _annotationTypeKeyword_0 = _annotationTypeAccess.getAnnotationTypeKeyword_0();
    ISemanticRegion _keyword = _regionFor.keyword(_annotationTypeKeyword_0);
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(it);
    BaseGrammarAccess.AnnotationTypeElements _annotationTypeAccess_1 = this._baseGrammarAccess.getAnnotationTypeAccess();
    Keyword _targetKeyword_4 = _annotationTypeAccess_1.getTargetKeyword_4();
    ISemanticRegion _keyword_1 = _regionFor_1.keyword(_targetKeyword_4);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
      it_1.newLine();
    };
    document.prepend(_keyword_1, _function_1);
    EList<AnnotationAttribute> _attributes = it.getAttributes();
    final Consumer<AnnotationAttribute> _function_2 = (AnnotationAttribute it_1) -> {
      final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it_2) -> {
        it_2.newLine();
      };
      document.<AnnotationAttribute>prepend(it_1, _function_3);
    };
    _attributes.forEach(_function_2);
  }
  
  protected void _format(final Annotation it, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(it);
    BaseGrammarAccess.AnnotationElements _annotationAccess = this._baseGrammarAccess.getAnnotationAccess();
    Keyword _commercialAtKeyword_0 = _annotationAccess.getCommercialAtKeyword_0();
    ISemanticRegion _keyword = _regionFor.keyword(_commercialAtKeyword_0);
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.noSpace();
    };
    document.append(_keyword, _function);
    EList<KeyValue> _attributes = it.getAttributes();
    final Consumer<KeyValue> _function_1 = (KeyValue it_1) -> {
      final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it_2) -> {
        it_2.newLine();
      };
      document.<KeyValue>prepend(it_1, _function_2);
    };
    _attributes.forEach(_function_1);
  }
  
  public void format(final Object it, final IFormattableDocument document) {
    if (it instanceof XtextResource) {
      _format((XtextResource)it, document);
      return;
    } else if (it instanceof Annotation) {
      _format((Annotation)it, document);
      return;
    } else if (it instanceof AnnotationType) {
      _format((AnnotationType)it, document);
      return;
    } else if (it instanceof Documentation) {
      _format((Documentation)it, document);
      return;
    } else if (it instanceof Import) {
      _format((Import)it, document);
      return;
    } else if (it instanceof EObject) {
      _format((EObject)it, document);
      return;
    } else if (it == null) {
      _format((Void)null, document);
      return;
    } else if (it != null) {
      _format(it, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, document).toString());
    }
  }
}
