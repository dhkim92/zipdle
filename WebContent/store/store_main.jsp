<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/CSSLoader.jsp" %>
<%@include file="/include/header.jsp"%>


<%@include file="./store/proto/sidebar.jsp"%>
<!-- 여기!!!! -->
<c:if test="${searchChecker ne 0 }">
<%@include file="./store/content/store.jsp"%>
</c:if>
<!--  여기!!! -->
<c:if test="${searchChecker eq 0}">
<%@include file="./store/content/storeUnsearch.jsp" %>
</c:if>
<%@include file="./store/content/storeSearch&paging.jsp" %>


<%@include file="/include/scriptLoader.jsp" %>
<!--여기 스크립트  -->
<%@include file="/include/footer.jsp"%>