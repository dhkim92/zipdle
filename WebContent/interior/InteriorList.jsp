<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ include file="../include/CSSLoader.jsp" %>
    
    
<%@ include file="../include/header.jsp" %>



<!-- mid -->
<div class="container-fluid">
	<div class="row">
		<!-- sidebar -->
		<%@ include file="./include/sidebar2.jsp" %>
		<!-- end of sidebar -->
		
		<div class="col-12 col-md-10">
			<!-- insert contents -->
			<div class="container-fluid bg-light mt-3">
				<div class="d-flex justify-content-between">
					<h1>견적현황</h1> <!-- explain contents -->
					<button id="btnWrite" class="btn btn-black m-2">견적 신청</button>
				</div>
				
				<!-- 견적현황 게시판 -->
				<div class="clearfix">
					<table class="table table-bordered table-hover">
						<thead class="bg-warning">
							<tr>
								<th>번호</th>
								<th>작성일자</th>
								<th>견적 명</th>
								<th>구분</th>
								<th>작성자</th>
								<th>조회수</th>
							</tr>
						</thead>
						<tbody>
						
							<c:forEach items="${intList}" var="intlist">
		   						<tr>
						     		<th>${intlist.listNo}</th>
						     		<td>${intlist.writtenDate}</td>
						     		<td><a href="/interior/listView.do?listNo=${intlist.listNo}">${intlist.intName}</a></td>
						     		<td>${intlist.intSpace}</td>
						     	<c:if test="${intlist.writer eq null }">
									<td>비회원</td>
								</c:if>
								<c:if test="${intlist.writer ne null }">
									<td>${intlist.writer}</td>
								</c:if>
						     		
						     		<td>${intlist.hit}</td>
						   		</tr>
		  					</c:forEach>
						</tbody>
					</table> <!-- end of table -->	
				</div>
				<jsp:include page="paging.jsp" />
			</div><!-- end of contents -->
		
		</div>
	
	</div><!-- end of row -->

</div><!-- end of mid -->








<!-- end of contents -->

<%@include file="../include/scriptLoader.jsp" %>
<!-- 이곳에 자바스크립트를 넣으세요 -->
<script>

$("#btnWrite").click(function(){
		$(location).attr("href","/interior/write.do");
	})
	
	$("table").on("click", "tr", function(){
		var listno = $(this).children("th").eq(0).text();
		
		$(location).attr("href","/interior/listView.do?listNo="+listno);
	});

</script>



<%@include file="../include/footer.jsp" %>

