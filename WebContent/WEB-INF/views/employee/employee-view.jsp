<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/head.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/employee/employee-update" id="frm">
<input type="hidden" name="emp_no" value="${employee.empNo}">
<table border="1">
	<tr>
		<th>사원번호</th>
		<td>${employee.empNo}</td>
	</tr>
	<tr>
		<th>사원이름</th>
		<td><input type="text" name="emp_name" value="{employee.empName}"></td>
	</tr>
	<tr>
		<th>월급</th>
		<td><input type="text" name="emp_salary" value="{employee.empSalary}"></td>
	</tr>
	<tr>
		<th>입사일</th>
		<td><input type="text" name="emp_credat" value="{employee.empCredat}"></td>
	</tr>
	<tr>
		<th>직급</th>
			<td>
			<select name="grd_no">
				<c:forEach items="${gradeList}" var="grade">
					<option value="${grade.grd_no}">${grade.grd_name}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<th>재직여부</th>
		<td><input type="text" name="emp_active" value="{employee.empActive}"></td>
	</tr>
</table>
<button>수정</button><button type="button" onclick='doDelete()'>삭제</button>
</form>
</body>
<script>
	function doDelete(){
		var frmObj = document.QuerySelector('#frm');
		frmObj.action = "/employee/employee-delete";
		frmObj.submit();
	}
</script>
</html>










