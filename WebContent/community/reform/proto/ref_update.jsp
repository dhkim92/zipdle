<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/CSSLoader.jsp"%> 
<link rel="stylesheet" href="/community/reform/css/ref_update.css"/>
    
<%@include file="/include/header.jsp"%>
<%@include file="./sidebar.jsp"%>
  
<!-- 리폼 정보방 게시글 수정하기 -->  
  
<div class="rrow">  
    
<form class="bg-light" action="/community/reform/update.do" method="post"
		enctype="multipart/form-data" style="height: 1000px;"> 
	<input type="hidden" id="idx" name="idx" value="${reform.idx }">   
	  
	<div class="float"> 
	
		<h1>게시글 수정하기</h1> 
	 
		<!-- 제목 -->
		<input type="text" id="title" name="title" value="${reform.title }" required/> 

		<!-- 내용 -->
		<textarea id="content" name="content" required>${reform.content }</textarea>

		<div class="row m-3 d-flex justify-content-between">
			<div class="float-left w-100"> 
				<div class="custom-file">
					<input type="file" class="custom-file-input" id="customFile" name="filePath" required>
					<label class="custom-file-label" for="customFile">참고 파일을 첨부해주세요</label> 
				</div>
			</div>
		</div> 
	</div>
	</form>   
	<br>
		
	<div class="rrow">
		<div class="text-center"> 
			<!-- 수정 -->
			<button class="blueBtn" id="btnWrite" >저장</button>  
				
			<!-- 수정 취소 -->
			<button class="grayBtn" id="btnCancel">작성 취소</button>
		
<!-- 			<button id="btnWrite" class="btn btn-primary">수정</button> -->
<!-- 			<input type="button" id="btnCancel" value="취소" ></input> -->
		
		</div>
	</div>
	
	<br><br> 
 
</div>


<%@include file="/include/scriptLoader.jsp"%>
<script>

$(document).ready(function() {
	$("#btnCancel").click(function() { // 수정 취소
		history.go(-1);
	});
	
	$("#btnWrite").click(function() { // 수정 확인 
		$("form").submit();	
	});
}); 

$(document).ready(function() {
	$("#btnWrite").click(function() { 
		submitContents($(this));
	});
});

</script> 

  
<%@include file="/include/footer.jsp"%>     
