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
	public int  insertEmployee(EmployeeVO employee) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			conn = Connector.getConnection();
			String sql = "insert into employee ("
					+ " emp_no, emp_name, emp_credat, emp_salary, grd_no)"
					+ " values(seq_emp_no.nextval, ?, sysdate,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, employee.getEmpName());
			ps.setInt(2, employee.getEmpSalary());
			ps.setInt(3, employee.getGrdNo());
			result = ps.executeUpdate();
			conn.commit();
			return result; 
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			Connector.close(ps, conn);
		}
		return 0;
	}

	@Override
	public int  updateEmployee(EmployeeVO employee) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			conn = Connector.getConnection();
			String sql = "update employee set emp_name=?,"
					+ " emp_salary=?,"
					+ " emp_active=?,"
					+ " grd_no=?,"
					+ " emp_credat=?"
					+ " where emp_no=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, employee.getEmpName());
			ps.setInt(2, employee.getEmpSalary());
			ps.setInt(3, employee.getEmpActive());
			ps.setInt(4, employee.getGrdNo());
			ps.setString(5, employee.getEmpCredat());
			ps.setInt(6, employee.getEmpNo());			
			result = ps.executeUpdate();
			conn.commit();
			return result; 
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			Connector.close(ps, conn);
		}
		return 0;
	}

	@Override
	public int  deleteEmployee(EmployeeVO employee) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			conn = Connector.getConnection();
			String sql = "delete from employee where emp_no=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, employee.getEmpNo());
			result = ps.executeUpdate();
			conn.commit();
			return result; 
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			Connector.close(ps, conn);
		}
		return 0;
	}

	@Override
	public EmployeeVO selectEmployee(EmployeeVO employee) {
		EmployeeVO emp = new EmployeeVO();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = Connector.getConnection();
			String sql = "select e.emp_no, e.emp_name, e.emp_salary, e.emp_credat, e.emp_active, g.grd_no, g.grd_name from employee e,"
					+ " grade g "
					+ " where e.grd_no=g.grd_no and e.emp_no=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, employee.getEmpNo());
			rs = ps.executeQuery();
			if (rs.next()) {
				emp.setEmpNo(rs.getInt("emp_no"));
				emp.setEmpName(rs.getString("emp_name"));
				emp.setEmpSalary(rs.getInt("emp_salary"));
				emp.setEmpCredat(rs.getString("emp_credat"));
				emp.setGrdName(rs.getString("grd_name"));
				emp.setGrdNo(rs.getInt("grd_name"));
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
			String sql = "select e.emp_no, e.emp_name, e.emp_active, g.grd_name from employee e, grade g "
					+ " where e.grd_no=g.grd_no";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				EmployeeVO emp = new EmployeeVO();
				emp.setEmpNo(rs.getInt("emp_no"));
				emp.setEmpName(rs.getString("emp_name"));
				emp.setGrdName(rs.getString("grd_name"));
				emp.setEmpActive(rs.getInt("emp_active"));
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
		emp.setEmpNo(150);
//		System.out.println(e.selectEmployee(emp));
		
//		System.out.println(e.selectEmployeeList(null));
		
//		System.out.println(e.deleteEmployee(emp));
		
	}

}
