/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.base;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.eclipse.etrice.generator.fsm.base.FolderFilter;
import org.eclipse.etrice.generator.fsm.base.GenDir;
import org.eclipse.etrice.generator.fsm.base.GenFile;
import org.eclipse.etrice.generator.fsm.base.GenFileTreeBuilder;
import org.eclipse.etrice.generator.fsm.base.GenItem;
import org.junit.Test;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class TestGenFileTreeBuilder {
	
	private static final String[] files = {
		"/path/to/my/project/sub1/foo/a.txt",
		"/path/to/my/project/sub1/foo/b.txt",
		"/path/to/my/project/sub1/foo/c.txt",
		"/path/to/my/project/sub1/bar/x.txt",
		"/path/to/my/project/sub1/bar/y.txt",
		"/path/to/my/project/sub1/bar/z.txt",
		"/path/to/my/project/sub2/dir1/f.txt",
		"/path/to/my/project/sub2/dir1/g.txt",
		"/path/to/my/project/sub2/dir2/k.txt",
		"/path/to/my/project/sub2/dir2/l.txt",
		"/path/to/my/project/sub2/m.txt",
		"/path/to/my/project/sub2/n.txt"
	};

	private void collectGenFiles(GenDir root, HashMap<String, GenFile> genFiles) {
		for (GenItem item : root.getContents()) {
			if (item instanceof GenDir)
				collectGenFiles((GenDir) item, genFiles);
			else if (item instanceof GenFile)
				genFiles.put(item.getPath(), (GenFile) item);
			else
				fail("unexpected sub type");
		}
	}
	
	@Test
	public void testWithoutFilter() {
		GenFileTreeBuilder builder = new GenFileTreeBuilder("/path/to/my/project/", Arrays.asList(files), null);
		GenDir root = builder.getGenFileTree();
		assertNotNull("root available", root);
		assertEquals("name", "root", root.getName());
		
		HashMap<String, GenFile> genFiles = new HashMap<String, GenFile>();
		collectGenFiles(root, genFiles);
		
		GenFile f = genFiles.get("sub2/dir1/f.txt");
		assertNotNull("f.txt", f);
		
		f = genFiles.get("sub2/n.txt");
		assertNotNull("n.txt", f);
	}
	
	@Test
	public void testWithFilter() {
		ArrayList<String> folders = new ArrayList<String>();
		folders.add("sub2/dir1");
		folders.add("sub1");
		FolderFilter ff = new FolderFilter(folders);
		GenFileTreeBuilder builder = new GenFileTreeBuilder("/path/to/my/project/", Arrays.asList(files), ff);
		GenDir root = builder.getGenFileTree();
		assertNotNull("root available", root);
		assertEquals("name", "root", root.getName());
		
		HashMap<String, GenFile> genFiles = new HashMap<String, GenFile>();
		collectGenFiles(root, genFiles);
		
		GenFile f = genFiles.get("sub2/dir1/f.txt");
		assertNotNull("f.txt", f);
		
		f = genFiles.get("sub2/n.txt");
		assertNull("n.txt", f);
	}
}
