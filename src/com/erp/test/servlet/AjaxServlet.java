package com.erp.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.test.service.SelectAddressService;
import com.erp.test.service.impl.SelectAddressServiceImpl;
import com.google.gson.Gson;

public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SelectAddressService selectAddressService = new SelectAddressServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		List<String> sidoList = selectAddressService.doSelectSidoList(null);
		Gson gson = new Gson();
		String str = gson.toJson(sidoList);
		pw.print(str);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
