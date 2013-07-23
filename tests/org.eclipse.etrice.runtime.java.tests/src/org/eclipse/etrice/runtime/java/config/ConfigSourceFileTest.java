package org.eclipse.etrice.runtime.java.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import junit.framework.TestCase;

public class ConfigSourceFileTest extends TestCase {

	private Map<String, Object> map;

	public void testConfigSourceFile() {

		IConfigSource source = new ConfigSourceFile("tmp/ConfigTest");

		map = new HashMap<String, Object>();
		map.put("SS/AC/doubleA", new Double[] { 0.0, 1.1, 2.2, 0.4e-5 });
		map.put("SS/AC/int", 3);
		map.put("SS/AC/double", 0.4e-5);
		map.put("SS/AC/booleanA", new Boolean[] { true, false, true, false });
		map.put("SS/AC/boolean", true);
		map.put("SS/AC/string", "test");
		map.put("SS/AC/stringA", new String[] { "\"\"", "", "test1",
				"\"test2\"" });
		map.put("SS/AC/intA", new Integer[] { 1, 2, 3, 4, 5, 6 });

		source.writeValues(map);
		assertTrue(readAndCompare(source));

		map.put("SS/AC/int", 999);
		map.put("SS/AC/stringA", new String[] { "\"\"", "", "test1" });
		map.put("SS/AC/booleanA", new Boolean[] { false });
		map.put("SS/AC/long", Long.MIN_VALUE);
		source.writeValues(map);
		assertTrue(readAndCompare(source));
	}

	private boolean readAndCompare(IConfigSource source) {
		Map<String, Object> readMap = source.readValues();
		for (Entry<String, Object> entry : map.entrySet()) {
			String key = entry.getKey();
			if (!readMap.containsKey(key))
				return false;

			Object readValue = readMap.get(key);
			Object origValue = entry.getValue();
			if (origValue instanceof Object[]) {
				if (!(readValue instanceof String[]))
					continue;
				List<String> tmp = new ArrayList<String>();
				for (Object s : (Object[]) origValue)
					tmp.add(s.toString());
				if (Arrays.deepEquals(tmp.toArray(new String[0]),
						(String[]) readValue))
					readMap.remove(key);
			} else if (origValue.toString().equals(readValue.toString()))
				readMap.remove(key);
		}

		for (String key : readMap.keySet())
			if (map.containsKey(key))
				return false;
		return true;
	}
}
