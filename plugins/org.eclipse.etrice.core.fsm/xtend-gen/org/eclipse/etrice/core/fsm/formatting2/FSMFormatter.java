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
package org.eclipse.etrice.core.fsm.formatting2;

import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.common.base.Annotation;
import org.eclipse.etrice.core.common.base.AnnotationType;
import org.eclipse.etrice.core.common.base.Documentation;
import org.eclipse.etrice.core.common.base.Import;
import org.eclipse.etrice.core.common.converter.BaseConverterService;
import org.eclipse.etrice.core.common.converter.CCStringConverter;
import org.eclipse.etrice.core.common.formatting2.BaseFormatter;
import org.eclipse.etrice.core.common.formatting2.CCStringReplacer;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.fsm.fSM.ProtocolSemantics;
import org.eclipse.etrice.core.fsm.fSM.SemanticsRule;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.fSM.Trigger;
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition;
import org.eclipse.etrice.core.fsm.services.FSMGrammarAccess;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionsFinder;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class FSMFormatter extends BaseFormatter {
  @Inject
  @Extension
  private FSMGrammarAccess _fSMGrammarAccess;
  
  @Override
  public void formatAllByKeywords(final EObject it, @Extension final IFormattableDocument document) {
    super.formatAllByKeywords(it, document);
    ISemanticRegionsFinder _allRegionsFor = this.textRegionExtensions.allRegionsFor(it);
    List<ISemanticRegion> _keywords = _allRegionsFor.keywords("->", "extends", "=", "or", "|");
    final Procedure1<ISemanticRegion> _function = new Procedure1<ISemanticRegion>() {
      @Override
      public void apply(final ISemanticRegion it) {
        final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.oneSpace();
          }
        };
        document.surround(it, _function);
      }
    };
    IterableExtensions.<ISemanticRegion>forEach(_keywords, _function);
  }
  
  protected EObject prependDefaultNewLines(final EObject it, @Extension final IFormattableDocument document) {
    EObject _xifexpression = null;
    if (((this.textRegionExtensions.previousHiddenRegion(it) != null) && (this.textRegionExtensions.previousHiddenRegion(it).getLineCount() > 2))) {
      final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.setNewLines(2);
        }
      };
      _xifexpression = document.<EObject>prepend(it, _function);
    } else {
      final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.newLine();
        }
      };
      _xifexpression = document.<EObject>prepend(it, _function_1);
    }
    return _xifexpression;
  }
  
  protected ISemanticRegion prependDefaultNewLines(final ISemanticRegion it, @Extension final IFormattableDocument document) {
    ISemanticRegion _xifexpression = null;
    IHiddenRegion _previousHiddenRegion = it.getPreviousHiddenRegion();
    int _lineCount = _previousHiddenRegion.getLineCount();
    boolean _greaterThan = (_lineCount > 2);
    if (_greaterThan) {
      final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.setNewLines(2);
        }
      };
      _xifexpression = document.prepend(it, _function);
    } else {
      final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.newLine();
        }
      };
      _xifexpression = document.prepend(it, _function_1);
    }
    return _xifexpression;
  }
  
  protected void _format(final StateGraph it, @Extension final IFormattableDocument document) {
    EList<EObject> _eContents = it.eContents();
    final Procedure1<EObject> _function = new Procedure1<EObject>() {
      @Override
      public void apply(final EObject it) {
        FSMFormatter.this.prependDefaultNewLines(it, document);
      }
    };
    IterableExtensions.<EObject>forEach(_eContents, _function);
  }
  
  protected void _format(final State it, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(it);
    List<ISemanticRegion> _keywords = _regionFor.keywords("entry", "exit", "do", "subgraph");
    final Procedure1<ISemanticRegion> _function = new Procedure1<ISemanticRegion>() {
      @Override
      public void apply(final ISemanticRegion it) {
        FSMFormatter.this.prependDefaultNewLines(it, document);
        final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.oneSpace();
          }
        };
        document.append(it, _function);
      }
    };
    IterableExtensions.<ISemanticRegion>forEach(_keywords, _function);
  }
  
  protected void _format(final Transition it, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(it);
    List<ISemanticRegion> _keywords = _regionFor.keywords("action", "guard", "cond");
    final Procedure1<ISemanticRegion> _function = new Procedure1<ISemanticRegion>() {
      @Override
      public void apply(final ISemanticRegion it) {
        FSMFormatter.this.prependDefaultNewLines(it, document);
        final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.oneSpace();
          }
        };
        document.append(it, _function);
      }
    };
    IterableExtensions.<ISemanticRegion>forEach(_keywords, _function);
  }
  
  protected void _format(final TriggeredTransition it, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(it);
    List<ISemanticRegion> _keywords = _regionFor.keywords("action", "guard", "cond", "triggers");
    final Procedure1<ISemanticRegion> _function = new Procedure1<ISemanticRegion>() {
      @Override
      public void apply(final ISemanticRegion it) {
        FSMFormatter.this.prependDefaultNewLines(it, document);
        final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.oneSpace();
          }
        };
        document.append(it, _function);
      }
    };
    IterableExtensions.<ISemanticRegion>forEach(_keywords, _function);
    EList<Trigger> _triggers = it.getTriggers();
    Trigger _head = IterableExtensions.<Trigger>head(_triggers);
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.newLine();
      }
    };
    document.<Trigger>prepend(_head, _function_1);
    EList<Trigger> _triggers_1 = it.getTriggers();
    Iterable<Trigger> _tail = IterableExtensions.<Trigger>tail(_triggers_1);
    final Procedure1<Trigger> _function_2 = new Procedure1<Trigger>() {
      @Override
      public void apply(final Trigger it) {
        final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.oneSpace();
          }
        };
        document.<Trigger>prepend(it, _function);
      }
    };
    IterableExtensions.<Trigger>forEach(_tail, _function_2);
  }
  
  protected void _format(final Trigger it, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(it);
    List<Pair<ISemanticRegion, ISemanticRegion>> _keywordPairs = _regionFor.keywordPairs("<", ">");
    final Procedure1<Pair<ISemanticRegion, ISemanticRegion>> _function = new Procedure1<Pair<ISemanticRegion, ISemanticRegion>>() {
      @Override
      public void apply(final Pair<ISemanticRegion, ISemanticRegion> it) {
        final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.noSpace();
          }
        };
        document.<ISemanticRegion, ISemanticRegion>interior(it, _function);
      }
    };
    IterableExtensions.<Pair<ISemanticRegion, ISemanticRegion>>forEach(_keywordPairs, _function);
  }
  
  protected void _format(final ProtocolSemantics it, @Extension final IFormattableDocument document) {
    EList<SemanticsRule> _rules = it.getRules();
    final Procedure1<SemanticsRule> _function = new Procedure1<SemanticsRule>() {
      @Override
      public void apply(final SemanticsRule it) {
        FSMFormatter.this.prependDefaultNewLines(it, document);
      }
    };
    IterableExtensions.<SemanticsRule>forEach(_rules, _function);
  }
  
  @Inject
  private BaseConverterService converterService;
  
  protected void _format(final DetailCode detailcode, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(detailcode);
    FSMGrammarAccess.DetailCodeElements _detailCodeAccess = this._fSMGrammarAccess.getDetailCodeAccess();
    Assignment _linesAssignment_0_1 = _detailCodeAccess.getLinesAssignment_0_1();
    final ISemanticRegion ccRegion = _regionFor.assignment(_linesAssignment_0_1);
    if ((ccRegion != null)) {
      final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.oneSpace();
        }
      };
      document.<DetailCode>prepend(detailcode, _function);
      boolean _isMultiline = this.textRegionExtensions.isMultiline(detailcode);
      if (_isMultiline) {
        CCStringConverter _cC_StringConverter = this.converterService.getCC_StringConverter();
        CCStringReplacer _cCStringReplacer = new CCStringReplacer(document, ccRegion, _cC_StringConverter);
        document.addReplacer(_cCStringReplacer);
      }
    } else {
      ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(detailcode);
      FSMGrammarAccess.DetailCodeElements _detailCodeAccess_1 = this._fSMGrammarAccess.getDetailCodeAccess();
      Assignment _linesAssignment_1_1 = _detailCodeAccess_1.getLinesAssignment_1_1();
      List<ISemanticRegion> _assignments = _regionFor_1.assignments(_linesAssignment_1_1);
      final Procedure1<ISemanticRegion> _function_1 = new Procedure1<ISemanticRegion>() {
        @Override
        public void apply(final ISemanticRegion it) {
          final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
            @Override
            public void apply(final IHiddenRegionFormatter it) {
              it.newLine();
            }
          };
          document.prepend(it, _function);
        }
      };
      IterableExtensions.<ISemanticRegion>forEach(_assignments, _function_1);
    }
  }
  
  public void format(final Object it, final IFormattableDocument document) {
    if (it instanceof TriggeredTransition) {
      _format((TriggeredTransition)it, document);
      return;
    } else if (it instanceof State) {
      _format((State)it, document);
      return;
    } else if (it instanceof XtextResource) {
      _format((XtextResource)it, document);
      return;
    } else if (it instanceof Transition) {
      _format((Transition)it, document);
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
    } else if (it instanceof DetailCode) {
      _format((DetailCode)it, document);
      return;
    } else if (it instanceof ProtocolSemantics) {
      _format((ProtocolSemantics)it, document);
      return;
    } else if (it instanceof StateGraph) {
      _format((StateGraph)it, document);
      return;
    } else if (it instanceof Trigger) {
      _format((Trigger)it, document);
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
