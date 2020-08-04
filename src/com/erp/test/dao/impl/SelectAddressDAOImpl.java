package com.erp.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.erp.test.common.Connector;
import com.erp.test.dao.SelectAddressDAO;

public class SelectAddressDAOImpl implements SelectAddressDAO {

	@Override
	public List<String> selectSidoList(String sido) {
		List<String> sidoList = new ArrayList<>();
		Connection conn = Connector.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select distinct sido from select_address order by sido";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				sidoList.add(rs.getString(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Connector.close(rs, ps, conn);
		}
		return sidoList;
	}

	@Override
	public List<String> selectGugunList(String sido) {
		List<String> gugunList = new ArrayList<>();
		Connection conn = Connector.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select distinct gugun from select_address " 
				+ " where sido=? " 
				+ " order by gugun ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, sido);
			rs = ps.executeQuery();
			while (rs.next()) {
				gugunList.add(rs.getString(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Connector.close(rs, ps, conn);
		}
		return gugunList;
	}

	@Override
	public List<String> selectDongList(String sido, String gugun) {
		List<String> dongNameList = new ArrayList<>();
		Connection conn = Connector.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select distinct dong_name from select_address " 
				+ " where sido=? " 
				+ " and gugun=?"
				+ " order by dong_name ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, sido);
			ps.setString(2, gugun);
			rs = ps.executeQuery();
			while (rs.next()) {
				dongNameList.add(rs.getString(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Connector.close(rs, ps, conn);
		}
		return dongNameList;
	}

	public static void main(String[] args) {
		SelectAddressDAO saDao = new SelectAddressDAOImpl();
		System.out.println(saDao.selectSidoList(null));
		System.out.println(saDao.selectGugunList("서울특별시"));
		System.out.println(saDao.selectDongList("서울특별시","중랑구"));
	}
}
