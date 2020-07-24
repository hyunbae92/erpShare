<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/grade/grade-update" id="form">
<input type="hidden" name="grd_no" value="${grade.grd_no}">
	<table border="1">
		<tr>
			<th>직급번호</th>
			<td>${grade.grd_no}</td>
		</tr>
			<tr>
			<th>직급명</th>
			<td><input type="text" name="grd_name" value="${grade.grd_name}"></td>
		</tr>
			<tr>
			<th>비고</th>
			<td><input type="text" name="grd_desc" value="${grade.grd_desc}"></td>
	</table>
	<button>수정</button><button type="button" onclick='doDelete()'>삭제</button>
</form>
<a href="/grade/grade-list"><button>리스트</button></a>
<script>
function doDelete(){
	var obj = document.querySelector('#form');
	obj.action = "/grade/grade-delete";
	obj.submit();
}
</script>
</body>
</html>