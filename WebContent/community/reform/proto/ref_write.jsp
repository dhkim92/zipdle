<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/CSSLoader.jsp"%>
<%@include file="/include/header.jsp"%>   
<%@include file="./sidebar_write.jsp"%>   
 
<link rel="stylesheet" href="/community/reform/css/ref_write.css" />

	<!-- 로그인 되어있을 때 나타나는 글 작성 화면 -->
	
	<div class="rrow" >

		<form class="bg-light"  action="/community/reform/write.do" method="post"
			enctype="multipart/form-data" >
 
			<div class="float" > 

				<!-- 제목 입력칸 --> 
				<input  type="text" id="title" name="title" placeholder="제목을 입력해주세요" required/> 
				
				<!-- 텍스트 입력칸 -->
				<textarea  name="content" placeholder="내용을 입력해주세요" required></textarea>

				<!-- 파일 업로드 -->	
				<div class="row m-3 d-flex justify-content-between">
					<div class="float-left w-100"> 
						<div class="custom-file">
							<input type="file" class="custom-file-input" id="customFile" name="uploadFile" required="required">
							<label class="custom-file-label" for="customFile">참고 파일을 첨부해주세요</label>
						</div>
					</div>
				</div> 
			</div>	
			<br>  
			
		</form> 
		<br> 

		<div class="rrow">
			<!-- 글쓰기 확인 --> 
			<div class="text-center"> 
				<button id="btnWrite" class="blueBtn" >저장</button>  
				
				<!-- 글쓰기 취소 -->
				<button id="btnCancel" class="grayBtn" >작성 취소</button>
			</div>  
		</div>

	<br><br>
	</div> 

<%@include file="/include/scriptLoader.jsp"%>

<script>

/* 첨부파일에 이미지 원본이름 뜨게하기  */
$('.custom-file-input').on('change', function() {
	var fileName = $(this).val().split('\\').pop();
	$(this).next('.custom-file-label').addClass('selected').html(fileName);
});

</script>

<script>
$(document).ready(function() {
		// 작성 취소버튼
		$("#btnCancel").click(function() {
			history.go(-1);
		});

		// 작성 확인버튼 
		$("#btnWrite").click(function() {
			$("form").submit();
		}); 
	});
</script>
 
<%@include file="/include/footer.jsp"%>   