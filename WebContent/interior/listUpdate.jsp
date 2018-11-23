<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ include file="../include/CSSLoader.jsp" %>	
	
<%@ include file="../include/header.jsp"%>





<!-- mid -->
<div class="container-fluid">
	<div class="row">
		<!-- sidebar -->
		<%@ include file="./include/sidebar2.jsp" %>
		<!-- end of sidebar -->

		<div class="col-12 col-md-10">
			<!-- insert contents -->
		<form action="/interior/list.do" method="post" enctype="multipart/form-data">
			<div class="container-fluid mt-3 bg-light">
				<div>
					<h1>공간정보</h1>
					<!-- explain contents -->
				</div>
				
			
				<div class="container clearfix" id="spaceinfo">
				
						<div class="row bg-light">
	
							<div class="float-left col h-100">
								<div class="text-center">
									<img src="./img/living.png" />
									<p>
									<h3>
										<span class="text-danger">주거공간</span>을 행복하게 <br class="mobr">바꾸고
										싶어요
									</h3>
									</p>
									
								
	
									<select class="custom-select bg-warning w-75" id="living" name="living">
										<option value="0">주거공간 선택</option>
										<option>아파트</option>
										<option>빌라</option>
										<option>주택</option>
										<option>원룸</option>
									</select>
								</div>
							</div>
							<!-- end of 주거공간 -->
	
							<div
								class="float-left col h-100 mr-3 ml-3 border-left border-right">
								<div class="text-center">
									<img src="./img/com.png" />
									<p>
									<h3>
										돈 많~이 버는<br> <span class="text-danger">상업 공간</span>을 원해요
									</h3>
									</p>
	
									<select class="custom-select bg-warning w-75" id="indu" name="indu" required="required">
										<option value="0">상업공간 선택</option>
										<option>사무실</option>
										<option>상가/매장</option>
										<option>카페/식당</option>
										<option>학원/교육</option>
										<option>간판</option>
										<option>숙박/병원</option>
										<option>기타</option>
									</select>
								</div>
							</div>
							<!-- end of 상업 공간 -->
	
							<div class="float-left col h-100">
								<div class="text-center">
									<img src="./img/partial.png" />
									<p>
									<h3>
										<span class="text-danger">부분시공</span>으로 일부만<br>교체하고 싶어요
									</h3>
									</p>
									
									<select class="custom-select bg-warning w-75" id="part" name="part" required="required">
										<option value="0">부분공간 선택</option>
										<option>도배장판</option>
										<option>욕실</option>
										<option>주방</option>
										<option>수납가구</option>
										<option>기타</option>
									</select>
									
									
								</div>
							</div>
							<!-- end of 부분시공 -->
						
						</div>
					<p class="mt-3" id="select-p"></p>
					<!-- end of row-1 -->

					<div class="row mt-5 d-flex justify-content-between">
						<div class="float-left w-25">
							
								<div class="custom-file">
									<input type="file" class="custom-file-input" id="customFile" name="uploadFile" required="required">
									<label class="custom-file-label" for="customFile">참고 파일을
										첨부해주세요</label>
								</div>
							
						</div>
						<!-- end of 첨부파일 -->




					</div>
					<!-- end of row-2 -->
				
					<div class="container mt-2 border-top justify-content-center">
						<h4 class="text-center mt-3">※ 공간 정보를 적어주세요! ※</h4>
						<div>

							<div class="input-group mb-3 mt-5">
							
								<div class="input-group-prepend">
									<span class="input-group-text">제목</span>
								</div>
							
								<input type="text" class="form-control"
									placeholder="제목을 입력해주세요" id="intName" name="intName" required="required" value="${view.intName }">
								
							</div>
							
							
							

						</div>
						<div>
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text">요청사항</span>
								</div>
								<textarea rows="10" id="content" class="form-control" aria-label="With textarea"
									placeholder="견적 관련 요청 사항을 적어주세요" name="content">${view.content }</textarea>
									
							</div>
						</div>
						
						<p id="content-p"></p>
						
						<div class="input-group mb-3 mt-5">
								<div class="input-group-prepend">
									<span class="input-group-text" id="basic-addon1">희망 견적 금액</span>
								</div>
							
								<input type="text" class="form-control"
									placeholder="원하는 견적 금액을 입력해주세요" id="intPrice" name="intPrice" size="2rem" required="required" value="${view.intPrice }">
									
						</div>
						
					</div>
						

				</div>

				<div class="row mt-2 d-flex justify-content-center clearfix">
					
						<button id="btnWrite" class="btn btn-warning text-center">수정 하기</button>
					
				</div>

			</div>
			<!-- end of 공간정보 select -->
		</form>
		<div>
				<a class="btn btn-warning m-3" href="/interior/list.do">목록</a>
		</div>
		</div>
		<!-- end of 공간정보 -->

	</div>
	<!-- end of contents -->

</div>

</div>
<!-- end of mid -->




<!-- end of contents -->

<%@include file="../include/scriptLoader.jsp"%>
<script type="text/javascript"
	src="/resources/smarteditor/js/service/HuskyEZCreator.js"></script>
<!-- 이곳에 자바스크립트를 넣으세요 -->
<script>
	/* 첨부파일에 이미지 원본이름 뜨게하기  */
	$('.custom-file-input').on('change', function() {
		var fileName = $(this).val().split('\\').pop();
		$(this).next('.custom-file-label').addClass('selected').html(fileName);
	});
</script>

<script>
	/* <select> 중복방지 */
	$("#living").change(function() {
		$("#indu").val(0);
		$("#part").val(0);
	});

	$("#indu").change(function() {
		$("#living").val(0);
		$("#part").val(0);
	});

	$("#part").change(function() {
		$("#living").val(0);
		$("#indu").val(0);
		console.log($("#part").val());
	});
	/* --------- */
</script>

<script>
/* 스마트 에디터 적용 */
	var oEditors = [];
	nhn.husky.EZCreator.createInIFrame({
		oAppRef : oEditors,
		elPlaceHolder : "content",
		sSkinURI : "/resources/smarteditor/SmartEditor2Skin.html",
		fCreator : "createSEditor2",
		htParams : {
			bUseToolbar : true, // 툴바 사용여부
			bUseVerticalResizer : false, //입력창 크기 조절바
			bUseModeChanger : true
			
		//모드 탭
		}
	});

	//‘저장’ 버튼을 누르는 등 저장을 위한 액션을 했을 때 submitContents가 호출된다고 가정한다.
	function submitContents(elClickedObj) {
		// 에디터의 내용이 textarea에 적용된다.
		oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);

		// 에디터의 내용에 대한 값 검증은 이곳에서
		// document.getElementById("ir1").value를 이용해서 처리한다.
		try {
			elClickedObj.form.submit();
		} catch (e) {
		}
	}

	$(document).ready(function() {
		$("#btnWrite").click(function() {
				submitContents($(this));
		
		});
	
		
	
	});
	
	
	
</script>






<%@include file="../include/footer.jsp"%>