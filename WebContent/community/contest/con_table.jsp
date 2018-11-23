<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
   
 <!-- css --> 
<%@ include file="/include/CSSLoader.jsp"%>
<link rel="stylesheet" href="/community/contest/css/con_table.css"/>
    
<%@include file="/include/header.jsp"%>
<%@include file="/community/contest/proto/sidebar.jsp"%>      

 
<!-- 콘텐츠 시작 -->
 <c:forEach items="${conlist }" var="contest">  
	
<!-- 회색 배경으로 콘텐츠 감싸기 -->
<div class="bg-light" id="totalDiv" 
	style="
			width: 80%;
			margin: auto">
 
		<!-- 콘텐츠 시작 --> 
		<div > 
			<table> 
				<tr>
					<td style="padding-left: 50px;
								padding-top:30px;">
						<!-- 유저 프로필 사진 -->
						<c:forEach items="${userlist }" var="userlist"> 
						<c:if test="${contest.id eq userlist.userId }">
							<img id="userImg" src="${userlist.profileImg }">
<!-- 							style="width:30px; height:30px;">  			 -->
						</c:if> 
						</c:forEach>  
					</td>
					
					<td style="padding-left:15px;
								padding-top:35px;"> 
					<!-- 아이디 --> 
					<h6>${contest.id}</h6>
					</td>
				</tr> 			 			
			</table> 		  
			
			<!-- 게시물 사진 -->
			<img class="con" src="${contest.filePath}">
			
			<!-- 콘텐츠 & 해시태그 -->
			<p class="right" id="contentCls"> ${contest.content } <br>
				#${contest.hashTag} </p>
		</div>
		
<!-- 경계선 -->
<hr style="width:85%"> 

	<!-- 댓글 테이블-->
	<div>
		<table class="commentTbl" style="margin-left:80px;">
		
			<!-- 게시물에 해당하는 댓글만 보여주기  --> 
			<c:forEach items="${commentlist }" var="comment">
			<c:if test="${contest.idx eq comment.boardIdx }"> 
				<tr data-commentIdx="${comment.commentIdx }">  
					<!-- 댓글 아이디 -->
					<td>${comment.commentId } </td>
					<td>
						<fmt:setLocale value="en_us"/>
						<fmt:formatDate  
 						value="${comment.commentwDate }"  
						type="date"/> </td>  
				</tr>
				
				<tr data-commentIdx="${comment.commentIdx }"> 
					<td style="width:7%;">
					 <!-- 빈공간 -->
					</td>
					
					<!-- 댓글 내용 -->
					<td style="width:750px;">
						${comment.commentContent }
					</td>    
					
					<!-- 자신의 댓글 삭제버튼 보여주기  -->
					<td style="width:10%;">
						<c:if test="${sessionScope.login }">
							<c:if test="${sessionScope.userid eq comment.commentId}"> 
								<button class="commDeleteBtn"  onclick="deleteComment(${comment.commentIdx });" > 
									del 
								</button>         
							</c:if>  
						</c:if> 
					</td>
				</tr>  
			
			</c:if> 
			</c:forEach>  
		</table>
	</div>		
	 
	<!-- 댓글 입력창 --> 
	<div class="commentInsertCls">  
	<c:if test="${sessionScope.login }">
	<form action="/community/contest/comment/insert.do" method="post">
		<!-- 댓글 idx -->
		<input type="hidden" name="idx" value="${contest.idx }" />
		
		<!-- 댓글 아이디 -->
		<input type="hidden" name="userid" value="${sessionScope.userid }"/> 
		<br>
		
		<!-- 댓글 입력창 -->
		<input type="text" id="commentContent" name="commentContent" placeholder="댓글을 남겨보세요."> 
		
		<!-- 댓글 입력 확인버튼 -->
		<input type="submit" id="commInsertBtn" value="확인"/>   
	</form>
		
	</c:if>  
	
		<c:if test="${not sessionScope.login }">
			<input type="text" id="commentContent" name="commentContent" 
					placeholder="로그인 후 댓글을 남겨주세요.">  
		</c:if>  
		
	</div>   
	<br> 
</div>
</c:forEach> 
<!-- 콘텐츠 end -->    
    
<!-- 페이징 -->

<div class="float2 container-fluid">	 
	<div class="pageCls d-flex justify-content-center">
		<jsp:include page="/community/contest/con_paging.jsp" />
	</div>  
</div>	
 
<%@include file="/include/footer.jsp"%>   

<%@include file="/include/scriptLoader.jsp" %>

<script>   
// 댓글 삭제
function deleteComment(commentIdx) { 
	$.ajax({ 
		type: "post" 
		, url: "/community/contest/comment/delete.do"
		, dataType: "json" 
		, data: {    
			commentIdx:commentIdx
		} 
		, success: function(){ 
			$("tr[data-commentIdx='"+commentIdx+"'").remove();
		}   
	});
};

</script> 