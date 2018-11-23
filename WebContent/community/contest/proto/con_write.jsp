<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/CSSLoader.jsp"%>
<link rel="stylesheet" href="/community/contest/css/con_write.css" />
    
<%@include file="/include/header.jsp"%>
<%@include file="/community/contest/proto/sidebar.jsp"%> 
 
<div class="rrow"> 

	<form class="bg-light" action="/community/contest/write.do" method="post"
		enctype="multipart/form-data">
  
		<div class="float">
			
			<!-- 내용 -->		 
			<input type="text" id="content" name="content" placeholder="내용" /> 
			<!-- 해시태그 -->
			<input type="text" id="hashTag" name="hashTag" placeholder="#해시태그" /><br> 

		<div class="row m-3 d-flex justify-content-between">
					<div class="float-left w-100"> 
						<div class="custom-file">
							<input type="file" class="custom-file-input" id="customFile" name="uploadFile" required="required">
							<label class="custom-file-label" for="customFile">참고 파일을 첨부해주세요</label>
						</div>
					</div>
				</div> 
			</div>
		</form> 
	
	<br>
	<div class="rrow">
		<div class="text-center">
			<!-- 업로드 확인 -->
<!-- 			<input type="submit"  id="btnWrite" value="업로드"/>   -->
			<button id="btnWrite" class="blueBtn" >업로드</button>  
				
			<!-- 업로드 취소 --> 
			<button id="btnCancel" class="grayBtn" >취소</button> 
		</div> 
	</div>
	<br><br><br>
		   
<%@include file="/include/scriptLoader.jsp"%>

<script>
	$(document).ready(function(){
		$("#btnCancel").click(function(){ 
			history.go(-1); 
		})
		
		$("#btnWrite").click(function() {
			$("form").submit();
		}); 
	}); 

</script>

<script>

/* 첨부파일에 이미지 원본이름 뜨게하기  */ 
$('.custom-file-input').on('change', function() {
	var fileName = $(this).val().split('\\').pop();
	$(this).next('.custom-file-label').addClass('selected').html(fileName);
}); 

</script>
		

<%@include file="/include/footer.jsp"%>   