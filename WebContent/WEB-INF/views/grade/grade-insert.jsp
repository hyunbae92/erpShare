<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/grade/grade-insert">
	<table border="1">
		<tr>
			<th>직급번호</th>
			<td>자동입력됩니다.</td>
		</tr>
			<tr>
			<th>직급명</th>
			<td><input type="text" name="grd_name"></td>
		</tr>
			<tr>
			<th>비고</th>
			<td><input type="text" name="grd_desc"></td>
		</tr>
	</table>
	<button>입력</button>
</form>
<a href="/grade/grade-list"><button>취소</button></a>
</body>
</html>