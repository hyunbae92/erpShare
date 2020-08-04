package com.erp.test.service;

import java.util.List;

public interface SelectAddressService {

	List<String> doSelectSidoList(String sido);
	List<String> doSelectGugunList(String sido);
	List<String> doSelectDongList(String sido, String gugun);
}
