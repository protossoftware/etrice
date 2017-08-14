package org.eclipse.etrice.core;

import com.google.common.base.Objects;
import com.google.common.io.CharStreams;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.etrice.core.CoreTestsActivator;
import org.eclipse.etrice.core.room.tests.RoomInjectorProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.formatter.FormatterTestRequest;
import org.eclipse.xtext.junit4.formatter.FormatterTester;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osgi.framework.Bundle;

@RunWith(XtextRunner.class)
@InjectWith(RoomInjectorProvider.class)
@SuppressWarnings("all")
public class FormatterTest extends FormatterTester {
  private final List<Pattern> patterns = new Function0<List<Pattern>>() {
    public List<Pattern> apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("([^\\w\\s])\\s+(\\w)");
      Pattern _compile = Pattern.compile(_builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("([^\\w\\s])\\s+([^\\w\\s])");
      Pattern _compile_1 = Pattern.compile(_builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("(\\w)\\s+([^\\w\\s])");
      Pattern _compile_2 = Pattern.compile(_builder_2.toString());
      return Collections.<Pattern>unmodifiableList(CollectionLiterals.<Pattern>newArrayList(_compile, _compile_1, _compile_2));
    }
  }.apply();
  
  @Test
  public void unformatEqualsFormat() {
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
    final Procedure1<ArrayList<String>> _function = (ArrayList<String> contents) -> {
      try {
        CoreTestsActivator _instance = CoreTestsActivator.getInstance();
        Bundle _bundle = _instance.getBundle();
        final Enumeration<URL> entries = _bundle.findEntries("models/formatting/unformatEqualsFormat/", "*.room", false);
        while (entries.hasMoreElements()) {
          URL _nextElement = entries.nextElement();
          URL _fileURL = FileLocator.toFileURL(_nextElement);
          InputStream _openStream = _fileURL.openStream();
          InputStreamReader _inputStreamReader = new InputStreamReader(_openStream);
          String _string = CharStreams.toString(_inputStreamReader);
          contents.add(_string);
        }
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    final ArrayList<String> expectedContents = ObjectExtensions.<ArrayList<String>>operator_doubleArrow(_newArrayList, _function);
    boolean _isEmpty = expectedContents.isEmpty();
    boolean _not = (!_isEmpty);
    Assert.assertTrue(_not);
    final Function1<String, String> _function_1 = (String content) -> {
      String _xblockexpression = null;
      {
        final Function2<String, Pattern, String> _function_2 = (String replaced, Pattern pattern) -> {
          Matcher _matcher = pattern.matcher(replaced);
          return _matcher.replaceAll("$1$2");
        };
        final String unformatted = IterableExtensions.<Pattern, String>fold(this.patterns, content, _function_2);
        Assert.assertNotEquals(content, unformatted);
        String _replace = unformatted.replace("\r\n", " ");
        _xblockexpression = _replace.replace("\n", " ");
      }
      return _xblockexpression;
    };
    final Function1<? super String, ? extends String> unformatter = _function_1;
    final Consumer<String> _function_2 = (String expected) -> {
      String _apply = unformatter.apply(expected);
      InputOutput.<String>println(_apply);
      final Procedure1<FormatterTestRequest> _function_3 = (FormatterTestRequest it) -> {
        it.setExpectation(expected);
        String _apply_1 = unformatter.apply(expected);
        it.setToBeFormatted(_apply_1);
      };
      this.assertFormatted(_function_3);
    };
    expectedContents.forEach(_function_2);
  }
  
  @Test
  public void testManual() {
    final Function1<String, Map<String, String>> _function = (String path) -> {
      HashMap<String, String> _xblockexpression = null;
      {
        CoreTestsActivator _instance = CoreTestsActivator.getInstance();
        Bundle _bundle = _instance.getBundle();
        final Enumeration<URL> entries = _bundle.findEntries(path, "*.room", false);
        HashMap<String, String> _newHashMap = CollectionLiterals.<String, String>newHashMap();
        final Procedure1<HashMap<String, String>> _function_1 = (HashMap<String, String> contentMap) -> {
          try {
            while (entries.hasMoreElements()) {
              {
                final URL entry = entries.nextElement();
                URI _uRI = entry.toURI();
                String _string = _uRI.toString();
                org.eclipse.emf.common.util.URI _createURI = org.eclipse.emf.common.util.URI.createURI(_string);
                final String name = _createURI.lastSegment();
                URL _fileURL = FileLocator.toFileURL(entry);
                InputStream _openStream = _fileURL.openStream();
                InputStreamReader _inputStreamReader = new InputStreamReader(_openStream);
                String _string_1 = CharStreams.toString(_inputStreamReader);
                contentMap.put(name, _string_1);
              }
            }
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        };
        _xblockexpression = ObjectExtensions.<HashMap<String, String>>operator_doubleArrow(_newHashMap, _function_1);
      }
      return _xblockexpression;
    };
    final Function1<? super String, ? extends Map<String, String>> collector = _function;
    final Map<String, String> unformattedContents = collector.apply("models/formatting/expected/");
    final Map<String, String> expectedContents = collector.apply("models/formatting/expected/");
    Assert.assertTrue(((!unformattedContents.isEmpty()) && Objects.equal(expectedContents.keySet(), unformattedContents.keySet())));
    Set<String> _keySet = expectedContents.keySet();
    final Consumer<String> _function_1 = (String fileName) -> {
      final Procedure1<FormatterTestRequest> _function_2 = (FormatterTestRequest it) -> {
        String _get = expectedContents.get(fileName);
        it.setExpectation(_get);
        String _get_1 = unformattedContents.get(fileName);
        it.setToBeFormatted(_get_1);
      };
      this.assertFormatted(_function_2);
    };
    _keySet.forEach(_function_1);
  }
}
