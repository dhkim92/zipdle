<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/include/CSSLoader.jsp" %>
<%@include file="/include/header.jsp"%>
<%@include file="./intspace/proto/sidebar.jsp"%>

<!-- 여기!!!! -->
<c:if test="${searchChecker ne 0 }">
<%@include file="./intspace/content/intspace.jsp"%>
</c:if>
<c:if test="${searchChecker eq 0}">
<%@include file="./intspace/content/intspaceUnsearch.jsp" %>
</c:if>
<%@include file="./intspace/content/intspaceSearch&paging.jsp" %>

<!--  여기!!! -->

<%@include file="/include/scriptLoader.jsp" %>
<!--여기 스크립트  -->
	
<%@include file="/include/footer.jsp"%>