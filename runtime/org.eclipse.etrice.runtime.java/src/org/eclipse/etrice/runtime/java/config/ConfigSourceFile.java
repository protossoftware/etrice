package org.eclipse.etrice.runtime.java.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigSourceFile implements IConfigSource {

	private String filePath = "config.txt";

	@Override
	public int getPolling() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, String> getValues() {
		List<String> lines = readFile();
		Map<String, String> map = new HashMap<String, String>(lines.size());
		for (String l : lines) {
			String[] entry = l.split("=");
			if (entry.length != 2)
				continue;
			if (!entry[0].trim().isEmpty() && !entry[1].trim().isEmpty())
				map.put(entry[0], entry[1]);
		}

		return map;
	}

	private List<String> readFile() {
		List<String> lines = new ArrayList<String>();
		File file = new File(filePath);
		try {
			BufferedReader fis = new BufferedReader(new FileReader(file));
			String s = null;
			while ((s = fis.readLine()) != null)
				lines.add(s);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lines;
	}

}
