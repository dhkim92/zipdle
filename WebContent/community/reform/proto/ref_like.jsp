<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/include/CSSLoader.jsp"%>
<link rel="stylesheet" href="/community/reform/css/ref_table.css" />

<%@include file="/include/header.jsp"%>
<%@include file="./sidebar.jsp"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
<!-- 좋아요 게시물 보여주는 페이지 -->  

<div class="rrow col-10 bg-light">
	<div class="float">
		
		<!-- 제목 -->
		<br>
		<h2 class="border-bottom p-3"><b class="text-warning">${sessionScope.username }</b>님의 좋아요 게시물
<!-- 		<img src="/community/reform/img/like.png"  -->
<!-- 			style="width:40px; height:40px; align:center; -->
<!-- 				left-padding:20px;"> -->
		</h2>
		

		<table>

			<c:forEach items="${likelist }" var="like">
				<tr>
					<td>
						<h5>
							<a href="/community/reform/view.do?idx=${like.idx }">${like.title }</a>
						</h5>
						<p class="content">${like.content }</p>
						<p class="info">${like.id }·${like.wDate }</p>

					</td>

					<td width="23%"><img width="50px" height="50px"
						src="/community/reform/img/like.png" /></td>
				</tr>

			</c:forEach>
		</table>
	</div>

</div>
  
<%@include file="/include/footer.jsp"%>
