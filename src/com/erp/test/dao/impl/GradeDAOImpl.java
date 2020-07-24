package com.erp.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erp.test.common.Connector;
import com.erp.test.dao.GradeDAO;

public class GradeDAOImpl implements GradeDAO {

	@Override
	public int insertGrade(Map<String, Object> grade) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			conn = Connector.getConnection();
			String sql = "insert into grade (grd_no, grd_name, grd_desc)"
					+ " values((select nvl(max(grd_no),0)+1 from grade),?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, grade.get("grd_name").toString());
			ps.setString(2, grade.get("grd_desc").toString());
			result = ps.executeUpdate();
			conn.commit();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Connector.close(ps, conn);
		}
		return 0;
	}

	@Override
	public int updateGrade(Map<String, Object> grade) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			conn = Connector.getConnection();
			String sql = "update grade set grd_name = ? ,grd_desc = ? "
					+ " where grd_no = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, grade.get("grd_name").toString());
			ps.setString(2, grade.get("grd_desc").toString());
			ps.setInt(3, Integer.parseInt(grade.get("grd_no").toString()));
			result = ps.executeUpdate();
			conn.commit();
			return  result;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Connector.close(ps, conn);
		}
		return 0;
	}

	@Override
	public int deleteGrade(Map<String, Object> grade) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			conn = Connector.getConnection();
			String sql = "delete from grade where "
					+ " grd_no = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(grade.get("grd_no").toString()));
			result =  ps.executeUpdate();
			conn.commit();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Connector.close(ps, conn);
		}
		return 0;
	}

	@Override
	public Map<String, Object> selectGrade(Map<String, Object> grade) {
		Map<String, Object> gMap = new HashMap<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = Connector.getConnection();
			String sql = "select grd_no, grd_name, grd_desc from grade"
					+ " where grd_no = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(grade.get("grd_no").toString()));
			rs = ps.executeQuery();
			if(rs.next()) {
				gMap.put("grd_no", rs.getInt("grd_no"));
				gMap.put("grd_name", rs.getString("grd_name"));
				gMap.put("grd_desc", rs.getString("grd_desc"));
			}
			return gMap;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Connector.close(rs, ps, conn);
		}
		return null;
	}

	@Override
	public List<Map<String, Object>> selectGradeList(Map<String, Object> grade) {
		List<Map<String, Object>> gradeList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = Connector.getConnection();
			String sql = "select grd_no, grd_name, grd_desc from grade";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("grd_no", rs.getInt("grd_no"));
				map.put("grd_name", rs.getString("grd_name"));
				map.put("grd_desc", rs.getString("grd_desc"));
				gradeList.add(map);
			}
			return gradeList;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Connector.close(rs, ps, conn);
		}
		return null;
	}

}
