package io;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.erp.test.common.Connector;

public class Execute {
	
	public static void insertlogic(String name) {
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
		String fileName = "C:\\java_study\\address\\"+name;
		String str = ReadText.readText(fileName,"MS949","<>");
		List<Map<String,String>> phList = ReadText.parse(keys,str,"<>");
		String sql = "insert into address(";
		String values = " values(";
		for(String k:keys) {
			sql += k+",";
			values += "?,";
		}
		sql =sql.substring(0,(sql.length()-1))+")";
		values =values.substring(0,(values.length()-1))+")";
		sql = sql+values;
		Connection conn = Connector.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			for(Map<String,String> row:phList) {
				for(int i=0;i<keys.length;i++) {
					ps.setString((i+1), row.get(keys[i]));
				}
				ps.executeUpdate();
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		
	}
	
	
}
