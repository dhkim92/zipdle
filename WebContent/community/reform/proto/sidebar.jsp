<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- mid -->

<!-- reform sidebar -->

<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
	
<script type="text/javascript">
 		$("#myLike").click(function(){
 			location.href = "/community/reform/like.do?userid=${sessionScope.userid}"; 	 
 		});  
</script> 

<!-- 사이드바 -->

<div class="container-fluid">
	<div class="row">
		<!-- sidebar -->
		<div class="col-2 d-none d-md-block border-right border-info"
			style="min-height: 70vh;">
			<ul class="list-group list-group-flush">
				<li class="list-group-item"><a href="/community/reform.do">
					<div class="d-flex w-100 justify-content-start align-items-center">
						<span class="h5 text-dark">Community</span>
				</li>
				<li class="list-group-item">
					<a href="/community/reform.do">
						<div class="d-flex w-100 justify-content-start align-items-center btn text-dark">
							<span class="menu-collapsed text-danger">리폼 정보</span>
						</div>
				</a> <a href="/community/contest.do">
						<div class="d-flex w-100 justify-content-start align-items-center btn text-dark">
							<span class="menu-collapsed">인테리어 자랑</span>
						</div>
				</a>  
					  
	           		<!-- 로그인 성공시 글 작성화면 띄우기 -->
	           		<c:if test="${sessionScope.login }">
	           		<li class="list-group-item">
	           		<a href="/community/reform/write.do">  
	           			<div class="d-flex w-100 justify-content-start align-items-center btn text-dark">
	      				<span id="writeList">글 작성하기</span>   
					</div> 
	           		</a>  
	           		
	           		<!-- 좋아요 게시물 모아보기 -->
	           		<div class="d-flex w-100 justify-content-start align-items-center btn text-dark">
						<span class="menu-collapsed" id="myLike">MY LIKES 
							<img src="/community/reform/img/like.png"
							style="width:30px; height:30px;">
<!-- 						<img src="/community/reform/img/mylikes.jpg">  -->
						</span> 
					</div>    
					</a> 
	           		</c:if>
	           		
	           		<!-- 비 로그인시 로그인 화면 뛰우기 -->
	           		<c:if test="${not sessionScope.login }">
					<!-- 로그인 모달 -->
					<li class="list-group-item">
	           		<a href="/community/reform/proto/writeModal.jsp"> 
	           			<div class="d-flex w-100 justify-content-start align-items-center btn text-dark">
						<span class="menu-collapsed">글 작성하기</span> 
					</div> 
					</a> 
					</c:if>   

	           	</li>
			</ul>
		</div>
		<!-- end of sidebar -->

		<div class="col-12 col-md-10">