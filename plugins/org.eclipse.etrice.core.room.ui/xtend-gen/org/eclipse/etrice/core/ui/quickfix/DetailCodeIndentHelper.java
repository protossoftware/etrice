package org.eclipse.etrice.core.ui.quickfix;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.text.IRegion;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

@SuppressWarnings("all")
public class DetailCodeIndentHelper {
  /**
   * Converts the issued multi line string to single line strings
   * - line with least indentation is adjusted to first line
   * - lines are enclosed with " or '
   * - lines get editor indentation of first line
   * -
   */
  public static String convertToSingleLines(final IXtextDocument document, final Issue issue) {
    try {
      final IRegion issuedRegion = document.getLineInformationOfOffset((issue.getOffset()).intValue());
      final String firstEditorLine = document.get(issuedRegion.getOffset(), issuedRegion.getLength());
      final String editorIndent = Strings.getLeadingWhiteSpace(firstEditorLine);
      final String editorString = document.get((issue.getOffset()).intValue(), (issue.getLength()).intValue());
      final String mark = Character.valueOf(editorString.charAt(0)).toString();
      final List<String> editorLines = Strings.split(editorString, Strings.newLine());
      int _size = editorLines.size();
      boolean _lessEqualsThan = (_size <= 1);
      if (_lessEqualsThan) {
        return editorString;
      }
      final Function1<String, Integer> _function = (String it) -> {
        return Integer.valueOf(DetailCodeIndentHelper.countIndent(it));
      };
      final int minIndent = DetailCodeIndentHelper.countIndent(IterableExtensions.<String>head(IterableExtensions.<String, Integer>sortBy(IterableExtensions.<String>tail(editorLines), _function)));
      final ArrayList<String> newEditorLines = new ArrayList<String>();
      final Procedure2<String, Integer> _function_1 = (String line, Integer lineCount) -> {
        String _xifexpression = null;
        if (((lineCount).intValue() != 0)) {
          _xifexpression = (editorIndent + mark);
        }
        String front = _xifexpression;
        int _countIndent = DetailCodeIndentHelper.countIndent(line);
        int indentCount = (_countIndent - minIndent);
        String _xifexpression_1 = null;
        if ((((lineCount).intValue() != 0) && (indentCount > 0))) {
          StringConcatenation _builder = new StringConcatenation();
          {
            IntegerRange _upTo = new IntegerRange(1, indentCount);
            for(final Integer i : _upTo) {
              _builder.append("\t");
            }
          }
          _xifexpression_1 = _builder.toString();
        }
        String indent = _xifexpression_1;
        String noneWSLine = Strings.removeLeadingWhitespace(line);
        String _xifexpression_2 = null;
        int _size_1 = editorLines.size();
        int _minus = (_size_1 - 1);
        boolean _notEquals = ((lineCount).intValue() != _minus);
        if (_notEquals) {
          _xifexpression_2 = mark;
        }
        String end = _xifexpression_2;
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append(front);
        _builder_1.append(indent);
        _builder_1.append(noneWSLine);
        _builder_1.append(end);
        String newEditorLine = _builder_1.toString();
        newEditorLines.add(newEditorLine);
      };
      IterableExtensions.<String>forEach(editorLines, _function_1);
      return Strings.concat(Strings.newLine(), newEditorLines);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private static int countIndent(final String line) {
    return Strings.getLeadingWhiteSpace(line).replace("\t", "    ").replace("    ", "\t").replaceAll("!\\t", "").length();
  }
}
