package com.erp.test.service.impl;

import java.util.List;

import com.erp.test.dao.SelectAddressDAO;
import com.erp.test.dao.impl.SelectAddressDAOImpl;
import com.erp.test.service.SelectAddressService;

public class SelectAddressServiceImpl implements SelectAddressService {
	private SelectAddressDAO selectAddressDao = new SelectAddressDAOImpl();
	@Override
	public List<String> doSelectSidoList(String sido) {
		return selectAddressDao.selectSidoList(sido);
	}

	@Override
	public List<String> doSelectGugunList(String sido) {
		return selectAddressDao.selectGugunList(sido);
	}

	@Override
	public List<String> doSelectDongList(String sido, String gugun) {
		return selectAddressDao.selectDongList(sido, gugun);
	}

}
