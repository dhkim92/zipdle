<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- mid -->

<!-- reform sidebar -->

<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript"> 
$(document).ready(function() {  
 		$("#myLike").click(function(){
 			location.href = "/community/reform/like.do?userid=${sessionScope.userid}"; 	 
 		});  
 
 		$("#btnList").click(function() { // 목록보기
 			$(location).attr("href", "/community/reform.do");  
 		});
 			    
 		$("#btnUpdate").click(function(){ // 글 수정하기
 			$(location).attr("href", "/community/reform/update.do?idx="+${reform.idx}); 
 		});   
 			 
 		$("#btnDelete").click(function() { // 글 삭제하기
 			$(location).attr("href", "/community/reform/delete.do?idx="+${reform.idx}); 
 		});       
});  
 		 
</script>

<!-- 글 읽고 있을때의 사이드바 -->

<div class="container-fluid">
	<div class="row">

		<!-- sidebar -->
		<div class="col-2 d-none d-md-block border-right border-info"
			style="min-height: 70vh;">
			<ul class="list-group list-group-flush">
				<li class="list-group-item">
					<div class="d-flex w-100 justify-content-start align-items-center">
						<a href="/community/reform.do"> <span class="h5 text-dark">Community
						</span>
						</a>
					</div>
				</li>

				<!-- 리폼 정보 -->
				<li class="list-group-item"><a href="/community/reform.do">
						<div
							class="d-flex w-100 justify-content-start align-items-center btn text-dark">
							<span class="menu-collapsed text-danger">리폼 정보</span>
						</div>
					</a> 
					
				<!-- 인테리어 자랑 --> 
					<a href="/community/contest.do">
						<div
							class="d-flex w-100 justify-content-start align-items-center btn text-dark">
							<span class="menu-collapsed">인테리어 자랑</span>
						</div>
				</a> 
				
				<!-- 로그인 상태에서 바로 글 작성 --> 
					<c:if test="${sessionScope.login}">
						<li class="list-group-item"><a
							href="/community/reform/write.do">
								<div class="d-flex w-100 justify-content-start align-items-center btn text-dark">
									<span class="menu-collapsed">글 작성하기</span>
								</div>
						</a>

						<c:if test="${reform.id eq sessionScope.userid}">
							<!-- 본인 글 수정가능 -->
							<div class="d-flex w-100 justify-content-start align-items-center btn text-dark">
								<span class="menu-collapsed" id="btnUpdate">글 수정하기</span>
							</div>

				 			<!-- 본인 글 삭제가능 -->
							<div
								class="d-flex w-100 justify-content-start align-items-center btn text-dark">
								<span class="menu-collapsed" id="btnDelete">글 삭제하기</span>
							</div>
						</c:if>
					</c:if> 
					
					<!-- 비 로그인 상태에서 로그인 화면으로 넘어감  --> 
					<c:if
						test="${not sessionScope.login }">
						<li class="list-group-item"><a href="/login/login.do">
								<div
									class="d-flex w-100 justify-content-start align-items-center btn text-dark">
									<span class="menu-collapsed">글 작성하기</span>
								</div>
						</a></li>

					</c:if> 
					
					<!-- 좋아요 게시물 모아보기 --> 
					<c:if test="${sessionScope.login }">
						<li class="list-group-item">
							<div
								class="d-flex w-100 justify-content-start align-items-center btn text-dark">
								<span class="menu-collapsed" id="myLike">MY LIKES <img
									src="/community/reform/img/like.png" style="width:30px; height:30px;">
								</span>
							</div>
						</li>
					</c:if>
			</ul>
		</div>  
	
<!-- end of sidebar -->
