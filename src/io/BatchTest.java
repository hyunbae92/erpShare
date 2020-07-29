package io;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.erp.test.common.Connector;

public class BatchTest {

	public static void main(String[] args) {
		
		Connection conn = Connector.getConnection();
		long sTime = System.currentTimeMillis();
		String sql = "insert into batch_test values(?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			for(int i=1;i<=1000000;i++) {
				ps.setInt(1, i);
				ps.setString(2, "이름"+i);
				ps.addBatch();
				if(i%10000==0) {
					System.out.println(i/10000);
					ps.executeBatch();
					conn.commit();
					ps.clearBatch();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		long eTime = System.currentTimeMillis();
		System.out.println("실행시간 : "+(eTime-sTime));
		
				
	}
}
