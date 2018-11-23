<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/CSSLoader.jsp" %>    
    
<%@ include file="../include/header.jsp" %>


<%@ include file="./include/sidebar2.jsp" %>

		
		<div class="col-12 col-md-10">
			<!-- insert contents -->
				<!-- insert interior image -->
			<div class="container">
				<div class="row">
					<div class="col text-center">
						<img src="${intList.imgPath }" class="img-fluid" alt="Responsive image" style="width:100%; height:500px"/>
					</div>
				</div>
			</div> <!-- end of interior image -->
			
			<div class="container-fluid bg-light mt-3">
				<div class="bg-light">
					<h1>
						[<span class="text-warning">${intList.intSpace }</span>] ${intList.intName }
					</h1> <!-- explain contents -->
				</div>
				
				<!-- 게시판 내용 -->
				<div class="container mt-5 mb-5">
					<!-- 이미지 -->
					<div class="row">
						<div class="col-12 col-md-6 d-flex justify-content-center">
							<img src="/include/img/3.jpg" />
						</div>
						<div class="col-12 col-md-6">
							<div class="d-flex float-left">
								<div class="mt-3 mr-5 text-warning">
									<p>공간</p>
									<p>작성자</p>
									<p>작성날짜</p>
									<p>견적희망금액</p>
								</div>
								<div class="mt-3 ml-5">
									<p>${intList.intSpace }</p>
								<c:if test="${intList.writer eq null }">
									<p>비회원</p>
								</c:if>
								<c:if test="${intList.writer ne null }">
									<p>${intList.writer }</p>
								</c:if>
									<p>${intList.writtenDate }</p>
									<p>${intList.intPrice }</p>
								</div>
							</div>
						</div>
					</div>
					
					<div class="row mt-5 border-top">
						<h2 class=" mt-5 text-warning">[요청 사항]</h2>
					</div>
					
					<div class="row mt-5 d-flex justify-content-center">
						
							<h3 class="mt-5 mb-5">${intList.content}</h3>
						
					
					</div>
				</div>
				<div>
						<a class="btn btn-warning m-3" href="/interior/list.do">목록</a>
							<c:if test="${sessionScope.username eq intList.writer}">
								<button id="btnUpdate" class="btn btn-warning">수정</button>
								<button id="btnDelete" class="btn btn-warning m-3">삭제</button>
							</c:if>
					</div>
			</div><!-- end of contents -->
			
		</div>
	
	</div><!-- end of row -->

</div><!-- end of mid -->






<!-- end of contents -->

<%@include file="../include/scriptLoader.jsp" %>
<!-- 이곳에 자바스크립트를 넣으세요 -->

<script>
$(document).ready(function(){
	$("#btnUpdate").click(function(){
		$(location).attr("href","/interior/listUpdate.do?listNo="+${intList.listNo});
	});
	
	$("#btnDelete").click(function(){
		$(location).attr("href","/interior/listDelete.do?listNo="+${intList.listNo});
	});
});
</script>




<%@include file="../include/footer.jsp" %>


