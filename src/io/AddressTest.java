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

public class AddressTest {

	public static void main(String[] args) {
		List<Map<String,String>> adrList = new ArrayList<>();
		File f = new File("c:\\build_sejong.txt");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f),"MS949"));
			StringBuffer sb = new StringBuffer();
			String str;
			while((str=br.readLine())!=null) {
				sb.append(str+"<>");
			}
			String key = "DONG_CODE\r\n" + 
					"SIDO\r\n" + 
					"GUGUN\r\n" + 
					"DONG_NAME\r\n" + 
					"LEE_NAME\r\n" + 
					"IS_MNT\r\n" + 
					"JIBUN\r\n" + 
					"SUB_JIBUN\r\n" + 
					"ROAD_CODE\r\n" + 
					"ROAD_NAME\r\n" + 
					"IS_BASE\r\n" + 
					"BUILD_NUM\r\n" + 
					"SUB_BUILD_NUM\r\n" + 
					"BUILDING_NAME\r\n" + 
					"DETAIL_BUILDING_NAME\r\n" + 
					"ADDR_CODE";
			String[] keys = key.split("\r\n");
			String[] adrress = sb.toString().split("<>");
			for(int i=0;i<adrress.length;i++) {
				Map<String,String> adrMap = new HashMap<>();
				String[] values = adrress[i].split("\\|");
				for(int j=0;j<keys.length;j++) {
					adrMap.put(keys[j],values[j]);
				}
				adrList.add(adrMap);
			}
			
			
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(Map<String,String> map:adrList) {
			System.out.println(map);
		}
	}
}
