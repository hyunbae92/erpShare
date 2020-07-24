package com.erp.test.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.test.service.EmployeeService;
import com.erp.test.service.GradeService;
import com.erp.test.service.impl.EmployeeServiceImpl;
import com.erp.test.service.impl.GradeServiceImpl;
import com.erp.test.vo.EmployeeVO;

public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeService employeeService = new EmployeeServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if("/employee/employee-list".equals(uri)) {
			request.setAttribute("employeeList", employeeService.doSelectEmployeeList(null));
			RequestDispatcher rd = request.getRequestDispatcher("/views/employee/employee-list");
			rd.forward(request, response);
			return;
		}else if("/employee/employee-view".equals(uri)) {
			EmployeeVO emp =new EmployeeVO();
			emp.setEmpNo(Integer.parseInt(request.getParameter("emp_no").toString()));
			request.setAttribute("employee", employeeService.doSelectEmployee(emp));
			RequestDispatcher rd = request.getRequestDispatcher("/views/employee/employee-view");
			rd.forward(request, response);
			return;
		}else if("/employee/employee-insert".equals(uri)) {
			GradeService gradeservice = new GradeServiceImpl();
			request.setAttribute("gradeList", gradeservice.doSelectGradeList(null));
			RequestDispatcher rd = request.getRequestDispatcher("/views/employee/employee-insert");
			rd.forward(request, response);
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String goUri = "/employee/employee-list";
		if("/employee/employee-insert".equals(uri)) {
			EmployeeVO employee = new EmployeeVO();
			employee.setEmpName(request.getParameter("emp_name"));
			employee.setEmpSalary(Integer.parseInt(request.getParameter("emp_salary")));
			employee.setGrdNo(Integer.parseInt(request.getParameter("grd_no")));
			Map<String,Object> result = employeeService.doInsertEmployee(employee);
			result.put("uri",goUri);
		}else if("/employee/employee-update".equals(uri)) {
			EmployeeVO employee = new EmployeeVO();
			employee.setEmpName(request.getParameter("emp_name"));
			employee.setEmpSalary(Integer.parseInt(request.getParameter("emp_salary")));
			employee.setEmpActive(Integer.parseInt(request.getParameter("emp_active")));
			employee.setGrdNo(Integer.parseInt(request.getParameter("grd_no")));
			employee.setEmpCredat(request.getParameter("emp_credat"));
			employee.setEmpNo(Integer.parseInt(request.getParameter("emp_no")));
			Map<String,Object> result = employeeService.doUpdateEmployee(employee);
			result.put("uri",goUri);
		}else if("/employee/employee-delete".equals(uri)) {
			EmployeeVO employee = new EmployeeVO();
			employee.setEmpNo(Integer.parseInt(request.getParameter("emp_no")));
			Map<String,Object> result = employeeService.doDeleteEmployee(employee);
			result.put("uri",goUri);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/common/msg");
		rd.forward(request, response);
	}
	

}
