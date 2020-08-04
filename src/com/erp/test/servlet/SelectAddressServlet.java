package com.erp.test.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.test.service.SelectAddressService;
import com.erp.test.service.impl.SelectAddressServiceImpl;

public class SelectAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SelectAddressService selectAddressService = new SelectAddressServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if("/div".equals(uri)) {
		String sido = request.getParameter("sido");
		List<String> sidoList = selectAddressService.doSelectSidoList(null);
		request.setAttribute("sidoList", sidoList);
		if(sido!=null) {
			List<String> gugunList = selectAddressService.doSelectGugunList(sido);
			request.setAttribute("gugunList", gugunList);
			String gugun = request.getParameter("gugun");
			if(gugun!=null) {
				List<String> dongList = selectAddressService.doSelectDongList(sido, gugun);
				request.setAttribute("dongList", dongList);
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/div");
		rd.forward(request, response);
		}
		if("/test".equals(uri)) {
			String sido = request.getParameter("sido");
			List<String> sidoList = selectAddressService.doSelectSidoList(null);
			request.setAttribute("sidoList", sidoList);
			if(sido!=null) {
				List<String> gugunList = selectAddressService.doSelectGugunList(sido);
				request.setAttribute("gugunList", gugunList);
				String gugun = request.getParameter("gugun");
				if(gugun!=null) {
					List<String> dongList = selectAddressService.doSelectDongList(sido, gugun);
					request.setAttribute("dongList", dongList);
				}
			}
			RequestDispatcher rd = request.getRequestDispatcher("/views/test");
			rd.forward(request, response);
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
