<!-- 커뮤니티 메뉴의 메인 페이지 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 

<%@ include file="/include/CSSLoader.jsp"%>
<link rel="stylesheet" href="/community/reform/css/ref_table.css" />

<%@include file="/include/header.jsp"%>
<%@include file="/community/reform/proto/sidebar.jsp"%>

<!-- 리폼정보방 -->

<div class="rrow">
	<div class="float1">

	<div class="tableCls"> 
		<table> 

			<c:forEach items="${reformlist }" var="reform">
				<tr>
					<td>
						<!-- 제목 -->
						<h5>
							<a class="readCls" href="/community/reform/view.do?idx=${reform.idx }">${reform.title }</a>
						</h5>  
						
						<!-- 콘텐츠 -->
						<p class="content">  
							<a class="readCls" href="/community/reform/view.do?idx=${reform.idx }">
							${reform.content }</a>
						</p>
						
						<!-- 유저 정보 -->
						<div class="info">
							<a class="readCls" href="/community/reform/view.do?idx=${reform.idx }">
							by.${reform.id }
						</a> 
						</div>   
					</td> 
  					
					<td width="23%">
					<a href="/community/reform/view.do?idx=${reform.idx }">
						<img width="200px" height="150px"
							src="${reform.filePath }" />
					</a>
					</td>   
					
				</tr>
				
			</c:forEach>
 
		</table>
		</div >
	</div>

	<div class="float2 container-fluid">	 
		<div class="pageCls d-flex justify-content-center">
			<jsp:include page="/community/paging.jsp" />
		</div>
	</div>	
</div> 

<%@include file="/include/scriptLoader.jsp"%>

<script>
$(document).ready(function() {
	// 글쓰기 버튼 
	$("#btnWrite").click(function() {
		location.href = "/community/reform/write.do"; 
	});

	// 	jquery on 함수
	//  $(selector).on(event, chldSelector, data, function, map) 
	$("#myLike").click(function(){
		location.href = "/community/reform/like.do?userid=${sessionScope.userid}"; 	 
	});  
	
}); 

</script>

<%@include file="/include/footer.jsp"%>

