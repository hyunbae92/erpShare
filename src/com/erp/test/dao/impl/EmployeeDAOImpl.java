package com.erp.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.erp.test.common.Connector;
import com.erp.test.dao.EmployeeDAO;
import com.erp.test.vo.EmployeeVO;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public EmployeeVO insertEmployee(EmployeeVO employee) {

		return null;
	}

	@Override
	public EmployeeVO updateEmployee(EmployeeVO employee) {
		return null;
	}

	@Override
	public EmployeeVO deleteEmployee(EmployeeVO employee) {

		return null;
	}

	@Override
	public EmployeeVO selectEmployee(EmployeeVO employee) {
		EmployeeVO emp = new EmployeeVO();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = Connector.getConnection();
			String sql = "select emp_no, emp_name, emp_salary, smp_credat, emp_active, grd_no, grd_name from employee e,"
					+ " grade g "
					+ " where e.grd_no=g.grd_no and e.emp_no=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, employee.getEmpNo());
			rs = ps.executeQuery();
			if (rs.next()) {
				emp.setEmpNo(rs.getInt("emp_no"));
				emp.setEmpName(rs.getString("emp_name"));
				emp.setEmpSalaty(rs.getInt("emp_salary"));
				emp.setEmpCredat(rs.getString("emp_credat"));
				emp.setGrdNo(rs.getInt("grd_no"));
				emp.setEmpActive(rs.getInt("emp_active"));
			}
			return emp;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connector.close(rs, ps, conn);
		}
		return null;
	}

	@Override
	public List<EmployeeVO> selectEmployeeList(EmployeeVO employee) {
		List<EmployeeVO> employeeList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = Connector.getConnection();
			String sql = "select emp_no, emp_name, emp_salary, smp_credat, emp_active, grd_no from employee";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				EmployeeVO emp = new EmployeeVO();
				employee.setEmpNo(rs.getInt("emp_no"));
				employee.setEmpName(rs.getString("emp_name"));
				employee.setEmpSalaty(rs.getInt("emp_salary"));
				employee.setEmpCredat(rs.getString("emp_credat"));
				employee.setGrdNo(rs.getInt("grd_no"));
				employee.setEmpActive(rs.getInt("emp_active"));
				employeeList.add(emp);
			}
			return employeeList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connector.close(rs, ps, conn);
		}
		return null;
	}
	
	public static void main(String[] args) {
		EmployeeDAO e = new EmployeeDAOImpl();
		EmployeeVO emp = new EmployeeVO();
		emp.setEmpNo(1);
		e.selectEmployee(emp);
	}

}
