<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %><!-- <body> -->

<style>
 	.content{
		padding-top:82px;
		padding-left:500px;
		position:relative;
		height:900px;
	}
	
	.btn{
		background-color: black;
		color: white;
		width: 50px;
		height: 30px;
		margin: 10px;
	}
</style>

<div class="content">
	<ul>
		<li><a href="${cp}/coupon/list">쿠폰관리</a></li>
		<li><a href="${cp}/order/list">주문관리</a></li>
		<li><a href="${cp}/admin/chart.jsp">매출관리</a></li>
		<li><a href="${cp}/manager/list">회원 관리</a></li>
	</ul>
</div>

<%@include file="../include/footer.jsp" %><!-- </body> -->