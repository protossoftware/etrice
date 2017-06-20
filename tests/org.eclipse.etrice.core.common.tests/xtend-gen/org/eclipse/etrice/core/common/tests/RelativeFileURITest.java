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
package org.eclipse.etrice.core.common.tests;

import com.google.common.collect.Iterables;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.etrice.core.common.scoping.RelativeFileURIHandler;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class RelativeFileURITest {
  private final static List<String> ABSOLUTE_URLS = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("file:/", "file:/bar", "file:/bar/", "file:/bar/baz", "file:/bar/baz/", "file:/c:", "file:/c:/", "file:/c:/bar", "file:/c:/bar/", "file:/c:/bar/baz", "file:/c:/bar/baz/", "file://foo", "file://foo/", "file://foo/bar", "file://foo/bar/", "file://foo/bar/baz", "file://foo/bar/baz/", "file://foo/c:", "file://foo/c:/", "file://foo/c:/bar", "file://foo/c:/bar/", "file://foo/c:/bar/baz", "file://foo/c:/bar/baz/"));
  
  private final static List<String> RESOLVED_PRESERVE_ABOVE_ROOT_URIS = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("file:/a/../g", "file:/a/../../g"));
  
  private final static List<String> RESOLVED_NO_PRESERVE_ABOVE_ROOT_URIS = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("file:/a/g", "file:/a/g/e"));
  
  private final static List<String> ENCODED_URIS = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("http://www.eclipse.org/foo", "http://server%231.eclipse.org/foo%20bar/baz#toc", "myscheme:my%20name", "file:/C:/My%20Documents/me/50%25+1.txt"));
  
  private final static List<String> ENCODED_PLATFORM_PATH_URIS = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("platform:/resource/project/myfile.txt", "platform:/resource/My%20Project%20%231/My%20File.txt", "platform:/resource/are%20you%20there%3F", "platform:/resource/are%20you%20there%3F.txt", "platform:/resource"));
  
  private final static List<String> QUERIES = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("", "?q=huh"));
  
  private final static List<String> FRAGMENTS = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("", "#toc", "#/a/b/c/d/e/f/g/h/i/j/k/l/m/n/o/p", "#1:2:3"));
  
  private final static URI TEST_URI = URI.createURI("file:/a/b/c/d");
  
  public Iterable<URI> allURIs() {
    Iterable<String> _plus = Iterables.<String>concat(RelativeFileURITest.ABSOLUTE_URLS, RelativeFileURITest.RESOLVED_PRESERVE_ABOVE_ROOT_URIS);
    Iterable<String> _plus_1 = Iterables.<String>concat(_plus, RelativeFileURITest.RESOLVED_NO_PRESERVE_ABOVE_ROOT_URIS);
    Iterable<String> _plus_2 = Iterables.<String>concat(_plus_1, RelativeFileURITest.ENCODED_URIS);
    final Function1<String, List<List<String>>> _function = new Function1<String, List<List<String>>>() {
      @Override
      public List<List<String>> apply(final String uri) {
        final Function1<String, List<String>> _function = new Function1<String, List<String>>() {
          @Override
          public List<String> apply(final String query) {
            final Function1<String, String> _function = new Function1<String, String>() {
              @Override
              public String apply(final String fragment) {
                return ((uri + query) + fragment);
              }
            };
            return ListExtensions.<String, String>map(RelativeFileURITest.FRAGMENTS, _function);
          }
        };
        return ListExtensions.<String, List<String>>map(RelativeFileURITest.QUERIES, _function);
      }
    };
    Iterable<List<List<String>>> _map = IterableExtensions.<String, List<List<String>>>map(_plus_2, _function);
    Iterable<List<String>> _flatten = Iterables.<List<String>>concat(_map);
    Iterable<String> _flatten_1 = Iterables.<String>concat(_flatten);
    final Function1<String, URI> _function_1 = new Function1<String, URI>() {
      @Override
      public URI apply(final String it) {
        return URI.createURI(it);
      }
    };
    return IterableExtensions.<String, URI>map(_flatten_1, _function_1);
  }
  
  private final RelativeFileURIHandler handler = new RelativeFileURIHandler();
  
  @Test
  public void resolveSelf() {
    Iterable<URI> _allURIs = this.allURIs();
    final Consumer<URI> _function = new Consumer<URI>() {
      @Override
      public void accept(final URI uri) {
        RelativeFileURITest.this.handler.setBaseURI(RelativeFileURITest.TEST_URI);
        URI _resolve = RelativeFileURITest.this.handler.resolve(uri);
        Assert.assertEquals(uri, _resolve);
      }
    };
    _allURIs.forEach(_function);
  }
  
  @Test
  public void roundtripResolve() {
    Iterable<URI> _allURIs = this.allURIs();
    final Consumer<URI> _function = new Consumer<URI>() {
      @Override
      public void accept(final URI uri) {
        URI _createURI = URI.createURI("file:/a/b/c/d");
        RelativeFileURITest.this.handler.setBaseURI(_createURI);
        URI _deresolve = RelativeFileURITest.this.handler.deresolve(uri);
        URI _resolve = RelativeFileURITest.this.handler.resolve(_deresolve);
        Assert.assertEquals(uri, _resolve);
      }
    };
    _allURIs.forEach(_function);
  }
  
  @Test
  public void deresolveBaseFile() {
    final URI testURI = RelativeFileURITest.TEST_URI.appendFragment("1:2:3");
    String _get = RelativeFileURITest.RESOLVED_NO_PRESERVE_ABOVE_ROOT_URIS.get(0);
    URI _createURI = URI.createURI(_get);
    this.handler.setBaseURI(_createURI);
    URI _deresolve = this.handler.deresolve(testURI);
    String _string = _deresolve.toString();
    Assert.assertEquals("b/c/d#1:2:3", _string);
    String _get_1 = RelativeFileURITest.RESOLVED_NO_PRESERVE_ABOVE_ROOT_URIS.get(1);
    URI _createURI_1 = URI.createURI(_get_1);
    this.handler.setBaseURI(_createURI_1);
    URI _deresolve_1 = this.handler.deresolve(testURI);
    String _string_1 = _deresolve_1.toString();
    Assert.assertEquals("../b/c/d#1:2:3", _string_1);
  }
  
  @Test
  public void interDocument() {
    final URI testURI = RelativeFileURITest.TEST_URI.appendFragment("1:2:3");
    this.handler.setBaseURI(RelativeFileURITest.TEST_URI);
    URI _deresolve = this.handler.deresolve(testURI);
    String _string = _deresolve.toString();
    Assert.assertEquals("#1:2:3", _string);
    URI _appendFragment = RelativeFileURITest.TEST_URI.appendFragment("some");
    this.handler.setBaseURI(_appendFragment);
    URI _deresolve_1 = this.handler.deresolve(testURI);
    String _string_1 = _deresolve_1.toString();
    Assert.assertEquals("#1:2:3", _string_1);
  }
}
