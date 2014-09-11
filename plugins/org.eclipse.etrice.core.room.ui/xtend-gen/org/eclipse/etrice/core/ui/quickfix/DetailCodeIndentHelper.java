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
      Integer _offset = issue.getOffset();
      final IRegion issuedRegion = document.getLineInformationOfOffset((_offset).intValue());
      int _offset_1 = issuedRegion.getOffset();
      int _length = issuedRegion.getLength();
      final String firstEditorLine = document.get(_offset_1, _length);
      final String editorIndent = Strings.getLeadingWhiteSpace(firstEditorLine);
      Integer _offset_2 = issue.getOffset();
      Integer _length_1 = issue.getLength();
      final String editorString = document.get((_offset_2).intValue(), (_length_1).intValue());
      char _charAt = editorString.charAt(0);
      final String mark = Character.valueOf(_charAt).toString();
      String _newLine = Strings.newLine();
      final List<String> editorLines = Strings.split(editorString, _newLine);
      Iterable<String> _tail = IterableExtensions.<String>tail(editorLines);
      final Function1<String, Integer> _function = new Function1<String, Integer>() {
        public Integer apply(final String it) {
          return Integer.valueOf(DetailCodeIndentHelper.countIndent(it));
        }
      };
      List<String> _sortBy = IterableExtensions.<String, Integer>sortBy(_tail, _function);
      String _head = IterableExtensions.<String>head(_sortBy);
      final int minIndent = DetailCodeIndentHelper.countIndent(_head);
      final ArrayList<String> newEditorLines = new ArrayList<String>();
      final Procedure2<String, Integer> _function_1 = new Procedure2<String, Integer>() {
        public void apply(final String line, final Integer lineCount) {
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
            _builder.append("�FOR i : (1 .. indentCount)�\t�ENDFOR�");
            _xifexpression_1 = _builder.toString();
          }
          String indent = _xifexpression_1;
          String noneWSLine = Strings.removeLeadingWhitespace(line);
          String _xifexpression_2 = null;
          int _size = editorLines.size();
          int _minus = (_size - 1);
          boolean _notEquals = ((lineCount).intValue() != _minus);
          if (_notEquals) {
            _xifexpression_2 = mark;
          }
          String end = _xifexpression_2;
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("�front��indent��noneWSLine��end�");
          String newEditorLine = _builder_1.toString();
          newEditorLines.add(newEditorLine);
        }
      };
      IterableExtensions.<String>forEach(editorLines, _function_1);
      String _newLine_1 = Strings.newLine();
      return Strings.concat(_newLine_1, newEditorLines);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private static int countIndent(final String line) {
    String _leadingWhiteSpace = Strings.getLeadingWhiteSpace(line);
    String _replace = _leadingWhiteSpace.replace("\t", "    ");
    String _replace_1 = _replace.replace("    ", "\t");
    String _replaceAll = _replace_1.replaceAll("!\\t", "");
    return _replaceAll.length();
  }
}
