<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div.sido{ 
	border: 3px solid red ;
	width : 180px;
	text-align : center;
	font-size : 20px; 
	float : left;
	margin-left : 5px;
	margin-right : 5px;
	margin-bottom : 10px;
	cursor : pointer;
}
div.gugun{ 
	border: 3px solid red ;
	width : 140px;
	text-align : center;
	font-size : 15px; 
	float : left;
	margin-left : 5px;
	margin-right : 5px;
	margin-bottom : 10px;
	cursor : pointer;
}
div.dong{ 
	border: 3px solid red ;
	width : 100px;
	text-align : center;
	font-size : 10px; 
	float : left;
	margin-left : 5px;
	margin-right : 5px;
	margin-bottom : 10px;
	cursor : pointer;
}
div.selected{
	background-color:pink;
	color : white;
} 


</style>
</head>
<body>
<div class="sido
<c:if test="${param.sido==null}">selected</c:if>
">전체</div>
<c:forEach items="${sidoList}" var="sido" varStatus="sidoIdx">
	<div class="sido
		<c:if test="${param.sido==sido}">
 		selected
		</c:if>" onclick='selectGugun(this)' data-sido="${sido}" id="sido">
		<c:if test="${fn:contains(sido,'충청') || fn:contains(sido,'경상') || fn:contains(sido,'전라')}">
			${fn:substring(sido,0,1)}${fn:substring(sido,2,3)}
		</c:if>
		<c:if test="${!fn:contains(sido,'충청') && !fn:contains(sido,'경상') && !fn:contains(sido,'전라')}">
			${fn:substring(sido,0,2)}
		</c:if> 
		<c:if test="${sidoIdx.count%8==0}">
			<br>
		</c:if>
	</div>
</c:forEach>
<div class="gugun
<c:if test="${param.gugun==null}">
 selected
</c:if>
">전체</div>
<c:forEach items="${gugunList}" var="gugun" varStatus="gugunIdx">
	<div class="gugun
		<c:if test="${param.gugun==gugun}">
 		selected
		</c:if>" onclick='selectDong(this)' data-gugun="${gugun}">
			${gugun} 
		<c:if test="${gugunIdx.count%8==0}">
			<br>
		</c:if>
	</div>
</c:forEach>

<div class="dong 
<c:if test="${param.dong==null}">
 selected
</c:if>
">전체</div>
<c:forEach items="${dongList}" var="dong" varStatus="dongIdx">
	<div class="dong
	<c:if test="${param.dong==dong}">
	 selected
	</c:if>
	" onclick='select(this)' data-dong="${dong}">
			${dong} 
		<c:if test="${dongIdx.count%8==0}">
			<br>
		</c:if>
	</div>
</c:forEach>
</body>
<script >
function selectGugun(sidoObj){
	var sido = sidoObj.getAttribute('data-sido');
	location.href="/div?sido="+sido;
}
function selectDong(gugunObj){
	var gugun = gugunObj.getAttribute('data-gugun');
	var sido = document.querySelector('.sido.selected').getAttribute('data-sido')
	location.href= "/div?sido="+ sido +"&gugun=" + gugun;
}
function select(dongObj){
	var dong = dongObj.getAttribute('data-dong');
	location.href= "/div?sido=${param.sido}&gugun=${param.gugun}&dong=" + dong;
}
</script>
</html>