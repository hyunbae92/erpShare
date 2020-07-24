package com.erp.test.service;

import java.util.List;
import java.util.Map;

public interface GradeService {
	
	Map<String, Object> doInsertGrade(Map<String,Object> grade);
	Map<String, Object> doUpdateGrade(Map<String,Object> grade);
	Map<String, Object> doDeleteGrade(Map<String,Object> grade);
	Map<String, Object> doSelectGrade(Map<String,Object> grade);
	List<Map<String, Object>> doSelectGradeList(Map<String,Object> grade);
}
