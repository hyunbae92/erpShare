<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/head.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
 		<th>사원번호</th>
 		<th>사원명</th>
 		<th>직급</th>
 		<th>재직여부</th>
	</tr>
	<c:forEach items="${employeeList}" var="employee">
		<tr>
			<td>${employee.empNo}</td>
			<td><a href="/employee/employee-view?emp_no=${employee.empNo}">${employee.empName}</a></td>
			<td>${employee.grdName}</td>
			<td>${employee.empActive}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>