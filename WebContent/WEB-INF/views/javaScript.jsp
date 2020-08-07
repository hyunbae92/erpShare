<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
var person = '{"name":"김현배","age":"29","address":"서울시 중랑구 망우본동","hobby":"사랑"}';

person = JSON.parse(person);
alert(person.name+','+person.age+','+person.address+','+person.hobby);
</script>
</body>
</html>