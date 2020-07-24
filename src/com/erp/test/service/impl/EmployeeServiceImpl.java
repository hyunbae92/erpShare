package com.erp.test.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erp.test.dao.EmployeeDAO;
import com.erp.test.dao.impl.EmployeeDAOImpl;
import com.erp.test.service.EmployeeService;
import com.erp.test.vo.EmployeeVO;

public class EmployeeServiceImpl implements EmployeeService {
	EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	Map<String, Object> rMap = new HashMap<>();
	@Override
	public Map<String, Object> doInsertEmployee(EmployeeVO employee) {
		rMap.put("msg", employeeDAO.insertEmployee(employee)==1?"입력 성공":"입력 실패");
		return rMap;
	}

	@Override
	public Map<String, Object> doUpdateEmployee(EmployeeVO employee) {
		rMap.put("msg", employeeDAO.updateEmployee(employee)==1?"입력 성공":"입력 실패");
		return rMap;
	}

	@Override
	public Map<String, Object> doDeleteEmployee(EmployeeVO employee) {
		rMap.put("msg", employeeDAO.deleteEmployee(employee)==1?"입력 성공":"입력 실패");
		return rMap;
	}

	@Override
	public EmployeeVO doSelectEmployee(EmployeeVO employee) {
		return employeeDAO.selectEmployee(employee);
	}

	@Override
	public List<EmployeeVO> doSelectEmployeeList(EmployeeVO employee) {
		return employeeDAO.selectEmployeeList(employee);
	}

}
