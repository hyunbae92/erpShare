package com.erp.test.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erp.test.dao.GradeDAO;
import com.erp.test.dao.impl.GradeDAOImpl;
import com.erp.test.service.GradeService;

public class GradeServiceImpl implements GradeService {
	private GradeDAO gradeDAO = new GradeDAOImpl();
	Map<String,Object> rMap = new HashMap<>();
	@Override
	public Map<String, Object> doInsertGrade(Map<String, Object> grade) {
		int result = gradeDAO.insertGrade(grade);
		rMap.put("cnt",result);
		rMap.put("msg",(result == 1) ? "입력 성공" : "입력 실패");
		return rMap;
	}

	@Override
	public Map<String, Object> doUpdateGrade(Map<String, Object> grade) {
		int result = gradeDAO.updateGrade(grade);
		rMap.put("cnt",result);
		rMap.put("msg",(result == 1) ? "수정 성공" : "수정 실패");
		return rMap;
	}

	@Override
	public Map<String, Object> doDeleteGrade(Map<String, Object> grade) {
		int result = gradeDAO.deleteGrade(grade);
		rMap.put("cnt",result);
		rMap.put("msg",(result == 1) ? "삭제 성공" : "삭제 실패");
		return rMap;
	}

	@Override
	public Map<String, Object> doSelectGrade(Map<String, Object> grade) {
		return gradeDAO.selectGrade(grade);
	}

	@Override
	public List<Map<String, Object>> doSelectGradeList(Map<String, Object> grade) {
		return gradeDAO.selectGradeList(grade);
	}

}
