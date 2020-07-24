package com.erp.test.dao;

import java.util.List;

import com.erp.test.vo.EmployeeVO;

public interface EmployeeDAO {

	EmployeeVO insertEmployee(EmployeeVO employee);
	EmployeeVO updateEmployee(EmployeeVO employee);
	EmployeeVO deleteEmployee(EmployeeVO employee);
	EmployeeVO selectEmployee(EmployeeVO employee);
	List<EmployeeVO> selectEmployeeList(EmployeeVO employee);
}