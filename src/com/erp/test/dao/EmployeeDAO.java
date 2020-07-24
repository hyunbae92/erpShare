package com.erp.test.dao;

import java.util.List;

import com.erp.test.vo.EmployeeVO;

public interface EmployeeDAO {

	int insertEmployee(EmployeeVO employee);
	int updateEmployee(EmployeeVO employee);
	int deleteEmployee(EmployeeVO employee);
	EmployeeVO selectEmployee(EmployeeVO employee);
	List<EmployeeVO> selectEmployeeList(EmployeeVO employee);
}