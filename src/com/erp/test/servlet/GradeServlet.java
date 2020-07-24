package com.erp.test.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.test.service.GradeService;
import com.erp.test.service.impl.GradeServiceImpl;

public class GradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private GradeService gradeService = new GradeServiceImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if("/grade/grade-list".equals(uri)) {
			request.setAttribute("gradeList", gradeService.doSelectGradeList(null));
			RequestDispatcher rd = request.getRequestDispatcher("/views/grade/grade-list");
			rd.forward(request, response);
			return;
		}
		if("/grade/grade-view".equals(uri)) {
			Map<String,Object> gMap = new HashMap<>();
			gMap.put("grd_no", request.getParameter("grd_no"));
			request.setAttribute("grade", gradeService.doSelectGrade(gMap));
			RequestDispatcher rd = request.getRequestDispatcher("/views/grade/grade-view");
			rd.forward(request, response);
			return;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		request.setCharacterEncoding("UTF-8");
		if("/grade/grade-delete".equals(uri)) {
			Map<String,Object> gMap = new HashMap<>();
			gMap.put("grd_no", request.getParameter("grd_no"));
			Map<String,Object> rMap = gradeService.doDeleteGrade(gMap);
			rMap.put("uri", "/grade/grade-list");
			request.setAttribute("result", rMap);
		}else if("/grade/grade-update".equals(uri)) {
			Map<String,Object> gMap = new HashMap<>();
			gMap.put("grd_no", request.getParameter("grd_no"));
			gMap.put("grd_name", request.getParameter("grd_name"));
			gMap.put("grd_desc", request.getParameter("grd_desc"));
			Map<String,Object> rMap = gradeService.doUpdateGrade(gMap);
			rMap.put("uri", "/grade/grade-list");
			request.setAttribute("result", rMap);
		}else if("/grade/grade-insert".equals(uri)) {
			Map<String,Object> gMap = new HashMap<>();
			gMap.put("grd_no", request.getParameter("grd_no"));
			gMap.put("grd_name", request.getParameter("grd_name"));
			gMap.put("grd_desc", request.getParameter("grd_desc"));
			Map<String,Object> rMap = gradeService.doInsertGrade(gMap);
			rMap.put("uri", "/grade/grade-list");
			request.setAttribute("result", rMap);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/common/msg");
		rd.forward(request, response);
	}

}
