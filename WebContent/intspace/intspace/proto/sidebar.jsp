<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- mid -->
<div class="container-fluid">
	<div class="row">
		<!-- sidebar -->
		<div class="col-2 d-none d-md-block border-right border-info" style="min-height:70vh;">
			<ul class="list-group list-group-flush">
				<li class="list-group-item">
	               		<div class="d-flex w-100 justify-content-start align-items-center">
	                   		<span class="h5 text-dark" >Magazine</span>
				
				
				</li>
				
				<li class="list-group-item">
					<a href="/intspace/intspace.do">
	               		<div class="d-flex w-100 justify-content-start align-items-center btn text-dark">
	                   		<span class="menu-collapsed text-danger">공간별 인테리어</span>    
	               		</div>
	           		</a>
	           		
				
				<c:set var="gradechecker" value="3"/>
	           	<c:if test="${gradechecker eq grade && grade ne null}">
	           		<a href="/intspace/write.do">
	               		<div class="d-flex w-100 justify-content-start align-items-right btn text-dark">
	                   		<span class="menu-collapsed"><small>글쓰기</small></span>    
	               		</div>
	           		</a>
	            </c:if>
	            
	            <c:set var="managechecker" value="${userid}"/>
	            <c:if test="${userid eq writer &&userid ne null}">
	            
	           		<a href="/intspace/update.do?intspaceno=${viewList.intspaceno}">
	               		<div class="d-flex w-100 justify-content-start align-items-right btn text-dark">
	                   		<span class="menu-collapsed"><small>수정</small></span>    
	               		</div>
	           		</a>
	            	<a href="/intspace/delete.do?intspaceno=${viewList.intspaceno}">
	               		<div class="d-flex w-100 justify-content-start align-items-right btn text-dark">
	                   		<span class="menu-collapsed"><small>삭제</small></span>    
	               		</div>
	           		</a>
	            </c:if>
	             
				</li>
			</ul>
		</div><!-- end of sidebar -->
		
		<div class="col-12 col-md-10">