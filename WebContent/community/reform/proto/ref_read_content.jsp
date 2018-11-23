<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="/include/CSSLoader.jsp"%>
<link rel="stylesheet" href="/community/reform/css/ref_read.css" />

<style type="text/css">
.like {  
	border: 1px solid blue;  
 	background-image: url("/community/reform/img/like.png");   
/* 	background: url('https://cdn.pixabay.com/photo/2013/07/13/10/50/heart-157895_960_720.png'); */
}   
.unlike {
	border: 1px solid red; 
 	background: url('/community/reform/img/unlike.png'); 
/* 	background: url('https://thumb1.shutterstock.com/display_pic_with_logo/962095/556120846/stock-vector-vector-heart-shape-frame-with-brush-painting-isolated-on-white-background-556120846.jpg'); */
}
 </style>

<%@include file="/include/header.jsp"%>
<%@include file="./sidebar_read.jsp"%> 
 
<div class="col-10 bg-light" style=" border:40px solid white;">  

	<!-- 제목 -->
	<div> 
		<h1>${reform.title }</h1>
		<p class="idCls">by. ${reform.id } ${reform.wDate } </p> 
		<hr>  
	</div> 
	<!-- 제목 end --> 
	
	<!-- 내용 -->
	<div>
	<p class="contentCls">${reform.content }</p>
	</div>
	
	<div>
	<img class="imgCls"  src="${reform.filePath }">
	</div>
	<!-- 내용 end --> 

	<!-- 좋아요 -->
	<div class="likeCls"> 
		
		<!-- 로그인 상태에서 추천버튼 -->
		<c:if test="${login }">
		<SPAN id="recommendTotal">${recommendTotal }
		</span> 
			<button id="btnRecommend" >좋아요</button> 
		</c:if> 
	</div>
	<!-- 좋아요 end -->
	<hr>


	<!-- 댓글 보기  -->
	<div class="commentCls">
		<table>
			<div>    
			<c:forEach items="${commentlist }" var="comment">
			
			<!-- 유저 프로필 사진 -->
			<tr data-commentIdx="${comment.commentIdx }"> 		 
				<c:forEach items="${userlist }" var="userlist">
					<c:if test="${comment.commentId eq userlist.userId }">
				 		<td style="width:7%;"> 
				 			<img id="dot" src="${userlist.profileImg }"  
				 				style="width:30px; height:30px;">             
				 		</td>	 
				 	</c:if>     
			</c:forEach>   
				 	
				 		<!-- 댓글 아이디 및 날짜 -->
						<td class="commentid">  
							${comment.commentId } ·
							<fmt:setLocale value="en_us"/> 
							<fmt:formatDate   
							value="${comment.commentwDate }" 
							type="date"/>  
						</td>  
				</tr>    
							  
				<tr data-commentIdx="${comment.commentIdx }">  
					<td style="width:7%;"> 
						<!-- 빈 공간 -->
					</td>
				
					<td style="width: 750px;">    
						${comment.commentContent }
					</td> 
					
				
					<td style="width:10%;"> 
						<!-- 자신의 댓글 삭제버튼 -->
						<c:if test="${sessionScope.login }">
						<c:if test="${sessionScope.userid eq comment.commentId }">
							<button class="commDeleteBtn" onclick="deleteComment(${comment.commentIdx });">
							del 
							</button>
						</c:if> 
						</c:if> 
					</td> 				
				</tr>	
				
			</c:forEach>  
			</div>		 	
		</table>
	</div>
	<!-- 댓글 보기 end -->
	
	<!-- 댓글 입력 --> 
	
		<div class="commentInsertCls">
		<c:if test="${sessionScope.login }">
			<input type="text" id="commentContent" placeholder="댓글을 남겨주세요"> 
			<input type="button" id="commInsertBtn" value="확인" />   
		</c:if>
		 
		<c:if test="${not sessionScope.login }">  
			<input type="text" id="commentContent" placeholder="로그인 후 댓글을 남겨주세요">   
		</c:if>
		
		</div>
	<!-- 댓글 입력 end --> 

	<div> 
		<hr>
		<button id="btnList">목록 보기</button>
		<br><br>
 
	</div>
</div>

<%@include file="/include/scriptLoader.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {  
		$("#likeList").click(function(){ // 좋아요 게시물 모아보기
			$(location).attr("href", "/community/reform/like.do?userid=${sessionScope.userid}");
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
		 
		// 추천한 게시글이면 "추천 취소"로 보이도록 설정
		// 추천하지 않은 게시글이면 "추천"으로 보이도록 설정 
		if(${recommend }) { //추천상태  
			$("#btnRecommend")  
				.addClass("btn-secondary")
				.removeClass("btn-danger") 
				.text("좋아요 취소");  
		} else {	//추천 안 한상태  
			$("#btnRecommend") 
				.addClass("btn-danger")
				.removeClass("btn-secondary")  
				.text("좋아요"); 
		} 
		 
		// 추천 버튼 클릭 이벤트 처리 
		$("#btnRecommend").click(function() {
			$.ajax({
				type: "get"
				, url: "/community/reform/recommend.do"
				, dataType: "json"
				, data: { 
					idx: '${reform.idx }'
				} 
				, success: function(data) { 
	 				console.log("recommend jsp success");
					console.log(data);
					 
					//추천 버튼 색상 변경
					$("#btnRecommend")
						.toggleClass("btn-secondary") 
						.toggleClass("btn-danger"); 

					//추천수 갱신
					$("#recommendTotal").text(data.recommendNum);
					 
					//추천 버튼 텍스트 변경 
					if(data.result) {
						 
						$("#btnRecommend").text("좋아요 취소");  
						$("#btnRecommend").addClass("like"); 
						$("#btnRecommend").removeClass("unlike");
					} else {
						$("#btnRecommend").text("좋아요"); 
						$("#btnRecommend").addClass("unlike");
						$("#btnRecommend").removeClass("like");
					} 
				}
				, error: function(e) {
	 				console.log("recommend jsp fail");
					
					console.log(e.responseText);
				}
			});
		});
		
		// 댓글 입력 
		$("#commInsertBtn").click(function() { 
			// 게시글 번호.... ${board.boardno } 
	 		console.log($("#commentWriter").val());
	 		console.log($("#commentContent").val()); 
			
			$form = $("<form>").attr({
				action: "/community/reform/comment/insert.do",
				method: "post"
			}).append(
				$("<input>").attr({ // 게시물 번호 
					type:"hidden", 
		  			name:"idx",
					value:"${reform.idx }"
				})
			).append(   
				$("<input>").attr({ // 댓글 작성자
					type:"hidden",
					name:"userid",
					value:"${sessionScope.userid }"
				})
			) 
			.append(
				$("<textarea>") // 댓글 내용
					.attr("name", "content")
					.css("display", "none")
					.text($("#commentContent").val())
			);
			$(document.body).append($form);
			$form.submit();
			
		});
	});    
	
	$(document).ready(function(){
		$("#btnRecommend").click(function(){
			
		});
	}); 
	    
	// 댓글 삭제
	function deleteComment(commentIdx) {
		console.log()
		$.ajax({ 
			type: "post"
			, url: "/community/reform/comment/delete.do"
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
	<%@include file="/include/footer.jsp"%>   
