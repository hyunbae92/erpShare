package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadText {

	public static String readText(String path) {
		return ReadText.readText(path, "UTF-8", "|");
	}

	public static String readText(String path, String encording) {
		return ReadText.readText(path, encording, "|");
	}

	public static String readText(String path, String encording, String and) {
		File f = new File(path);
		try {
			FileInputStream fis = new FileInputStream(f);
			InputStreamReader isr = new InputStreamReader(fis, encording);
			BufferedReader br = new BufferedReader(isr);
			StringBuffer sb = new StringBuffer();
			String str;
			while ((str = br.readLine()) != null) {
				sb.append(str + and);
			}
			return sb.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static List<Map<String, String>> parse(String str) {
		List<Map<String, String>> strList = new ArrayList<>();
		String[] strs = str.split("\\|");
		String[] keys = null;
		for (int i = 0; i < strs.length; i++) {
			if (i == 0) {
				keys = strs[i].split(",");

			} else {
				String[] values = strs[i].split(",");
				Map<String, String> map = new HashMap<>();
				if (keys.length == values.length) {
					for (int j = 0; j < keys.length; j++) {
						map.put(keys[j], values[j]);
					}
				}
				strList.add(map);
			}
		}
		return strList;
	}

	public static List<Map<String, String>> parse(String[] key, String str, String and) {
		List<Map<String, String>> strList = new ArrayList<>();
		String[] strs = str.split(and);
		String[] keys = key;
		for (int i = 0; i < strs.length; i++) {
			String[] values = strs[i].split("\\|");
			Map<String, String> map = new HashMap<>();
			for (int j = 0; j < keys.length; j++) {
				map.put(keys[j], values[j]);
			}
			strList.add(map);
		}
		return strList;
	}

}
