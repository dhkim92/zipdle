<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 리폼정보 페이징 -->

<div>
<nav>
  <ul class="pagination justify-content-center">
  
  	<!-- 이전 페이지 -->
  	<!-- 첫 페이지라면 금지 표시 -->
  	<c:if test="${paging.curPage eq 1 }"><!-- 첫페이지일때 -->
  	<li class="page-item disabled">
      <a class="page-link" href="/community/reform.do"
      	 aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
  	</c:if>
  	
  	<c:if test="${paging.curPage ne 1 }"><!-- 첫페이지가아닐때 -->
  	<li class="page-item">
      <a class="page-link" href="/community/reform.do?curPage=${paging.curPage-1 }"
       	aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    </c:if>
    
    <!-- 페이징 번호 -->
    <c:forEach begin="${paging.startPage }"
    	end="${paging.endPage }"
    	var="page">
    	
    	<c:if test="${paging.curPage eq page }">
	   	<li class="page-item active">
	   	</c:if>
	   	<c:if test="${paging.curPage ne page }">
	   	<li class="page-item">
	   	</c:if>
	   	
	   	<a class="page-link" href="/community/reform.do?curPage=${page }">
	   		${page }
	   	</a>
	   	</li>
    </c:forEach> 

    <!-- 다음 페이지 -->
  	<!-- 마지막 페이지라면 금지 표시 -->
  	<c:if test="${paging.curPage eq paging.totalPage }"><!-- 마지막 페이지일때 -->
  	<li class="page-item disabled">
      <a class="page-link" href="/community/reform.do?curPage=${paging.totalPage }"
       aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  	</c:if>
  	<c:if test="${paging.curPage ne paging.totalPage }"><!-- 마지막 페이지가아닐때 -->
  	<li class="page-item">
      <a class="page-link" href="/community/reform.do?curPage=${paging.curPage+1 }"
       aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
    </c:if> 
    
  </ul>
</nav>
</div>



