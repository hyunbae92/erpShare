package com.erp.test.service;

import java.util.List;
import java.util.Map;

import com.erp.test.vo.EmployeeVO;

public interface EmployeeService {

	Map<String, Object> doInsertEmployee(EmployeeVO employee);
	Map<String, Object> doUpdateEmployee(EmployeeVO employee);
	Map<String, Object> doDeleteEmployee(EmployeeVO employee);
	EmployeeVO doSelectEmployee(EmployeeVO employee);
	List<EmployeeVO> doSelectEmployeeList(EmployeeVO employee);
}
