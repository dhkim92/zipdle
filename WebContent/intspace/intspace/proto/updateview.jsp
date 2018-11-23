<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/include/CSSLoader.jsp" %>
<%@include file="/include/header.jsp"%>
<%@include file="./sidebar.jsp"%>

<!-- 여기!!!! -->
<%@include file="/intspace/intspace/content/updateview.jsp"%>
<!--  여기!!! -->

<%@include file="/include/scriptLoader.jsp" %>
<!--여기 스크립트  -->

<script>
	/* 첨부파일에 이미지 원본이름 뜨게하기  */
	$('.custom-file-input').on('change', function() {
		var fileName = $(this).val().split('\\').pop();
		$(this).next('.custom-file-label').addClass('selected').html(fileName);
	});
</script>
<%@include file="/include/footer.jsp"%>