<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/CSSLoader.jsp" %>
	
<%@ include file="../include/header.jsp"%>





<!-- mid -->
<div class="container-fluid">
	<div class="row">
		<!-- sidebar -->
		<%@ include file="./include/sidebar3.jsp"%>
		<!-- end of sidebar -->

		<div class="col-12 col-md-10">
			<!-- insert contents -->
			<div class="container-fluid bg-light mt-3">
				<div class="bg-light">
					<h2>
						<strong>[${editList.name}]</strong> <span class="text-warning">인증된
							업체</span> ${editList.address }
					</h2>
					<!-- explain contents -->
				</div>

				<!-- 게시판 내용 -->
				<div class="container mt-5 mb-5">
					<!-- 이미지 -->
					<div class="row">
						<div class="col-12 d-flex justify-content-center">
							<img src="${editList.imgPath }"
								style="width: 600px; height: 300px" />
						</div>
					</div>
					<div class="row border-top border-dark mt-5">
						<div class="col-12 col-md-6 mt-5 d-flex justify-content-center">
							<div class="text-danger text-bold">
								<p>에디터 등록번호</p>
								<p>상호 명</p>
								<p>대표자</p>
								<p>사업자 등록 번호</p>
								<p>위 치</p>
								<p>문의 전화</p>
							</div>
						</div>
						<div class="col-12 col-md-6 mt-5">
							<div>
								<p>${editList.editNo }
								<p>${editList.name }
								<p>${editList.manager }
								<p>${editList.resiNo }
								<p>${editList.address }
								<p>${editList.phonenum }
							
							</div>
						</div>
					</div>
					<div class="row mt-5 border-top d-flex justify-content-center">
						<h3 class="mt-5">${editList.content }</h3>
					
					</div>
				</div>
					<div>
						<a class="btn btn-warning m-3" href="/interior/edit.do">목록</a>
<%-- 							<c:if test="${sessionScope.nick eq editList.manager}"> --%>
<!-- 								<button id="btnUpdate" class="btn btn-warning">수정</button> -->
<!-- 								<button id="btnDelete" class="btn btn-warning m-3">삭제</button> -->
<%-- 							</c:if> --%>
					</div>
			</div>
			<!-- end of contents -->
		
		</div>
	
	</div>
	<!-- end of row -->

</div><!-- end of mid -->






<!-- end of contents -->
<%@include file="../include/scriptLoader.jsp" %>
<!-- 이곳에 자바스크립트를 넣으세요 -->
<script>
// $(document).ready(function(){
// 	$("#btnUpdate").click(function(){
// 		$(location).attr("href","/interior/editUpdate.do?editNo="+${editList.editNo});
// 	});
	
// 	$("#btnDelete").click(function(){
// 		$(location).attr("href","/interior/editDelete.do?editNo="+${editList.editNo});
// 	});
// });
</script>



<%@include file="../include/footer.jsp" %>

