<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../include/header.jsp" %>
<style type="text/css">
	#wrap{width:1000px; margin:auto; position:relative; top:200px; align-content: center; text-align : center; }
	#wrap a{text-decoration: none; color:white;}
	h2{color:white; margin:10px;}
	h3{color:white; margin:15px;}
	.button{border-style:none; padding:8px; width:60px; height:25px; border:0; cursor:pointer; outline:none;
	 background-color:black; color:white; font-weight:bold; font-size:15px; border-radius:15px;}
	 h1{color:white; margin-bottom:30px;}
</style>

<div id="wrapper" style="width:100%; height:1100px; background-color: black;">
	<div id="wrap">
		<h1>배송지 관리</h1>
		<c:choose>
			<c:when test="${code=='success' }">
				<h3>요청 작업을 성공적으로 마쳤습니다</h3>
			</c:when>
			<c:otherwise>
				<h2>죄송합니다.</h2>
				<h3>요청 작업중 오류가 발생했습니다</h3>
			</c:otherwise>
		</c:choose>
		<a href="${pageContext.request.contextPath }/address/list" class="button">주소 리스트로 돌아가기</a>
	</div>
</div>
<script>
var buttons = document.getElementsByClassName("button");
for(let i= 0; i<buttons.length; i++){
	buttons[i].addEventListener("mouseover", function(e) {
		e.target.style="background-color: #353535;";
	}, false)
}
for(let i= 0; i<buttons.length; i++){
	buttons[i].addEventListener("mouseout", function(e) {
		e.target.style="background-color: black;";
	}, false)
}
</script>

<%@include file="../include/footer.jsp" %>