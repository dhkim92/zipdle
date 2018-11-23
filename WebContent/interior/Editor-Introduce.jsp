<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/CSSLoader.jsp" %>

<link rel="stylesheet" href="/interior/css/editor.css" />

<%@ include file="../include/header.jsp"%>




<!-- mid -->
<div class="container-fluid">
	<div class="row">
		<!-- sidebar -->
		<%@ include file="./include/sidebar3.jsp"%>
		<!-- end of sidebar -->

		<div class="col-12 col-md-10">
			<!-- insert contents -->
			<div class="container-fluid p-3 mt-3 bg-light">


				<div class="row">
					<c:forEach items="${edit }" var="editor">
						<div class="col-12 col-md-4">
							<div class="card mb-3">
									<img class="card-img" src="${editor.imgPath }"/>
									<input type="hidden" value="${editor.editNo }">

								<div
									class="card-img-overlay d-flex flex-column justify-content-between">
									<h4 class="card-title">${editor.name}</h4>
									<p class="card-text oswald">${editor.content }</p>
								</div>
							</div>
						</div>
						<!-- end of row -->
					</c:forEach>
				</div>
					<jsp:include page="paging2.jsp" />

			</div>
		</div>
		<!-- end of contents -->

	</div>

</div>
<!-- end of mid -->
<!-- end of contents -->




<%@include file="../include/scriptLoader.jsp"%>
<!-- 이곳에 자바스크립트를 넣으세요 -->

<script>

$(".card").on("click", function(){
	var editno = $(this).children("input").val();
	
	$(location).attr("href","/interior/editView.do?editNo="+editno);
});

</script>




<%@include file="../include/footer.jsp"%>
