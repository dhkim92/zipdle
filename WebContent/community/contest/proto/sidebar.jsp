<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- mid -->
 
<!-- contest sidebar --> 

<div class="container-fluid"> 
	<div class="row">
		<!-- sidebar -->
		<div class="col-2 d-none d-md-block border-right border-info" style="min-height:70vh;">
			<ul class="list-group list-group-flush">
				<li class="list-group-item">
	               		<div class="d-flex w-100 justify-content-start align-items-center">
	                   		<span class="h5 text-dark" >Community</span>
	                   	</div>
				</li>
				<li class="list-group-item">
					<a href="/community/reform.do"> 
	               		<div class="d-flex w-100 justify-content-start align-items-center btn text-dark">
	                   		<span class="menu-collapsed ">리폼 정보</span>    
	               		</div>
	           		</a>
	           		<a href="/community/contest.do">
	               		<div class="d-flex w-100 justify-content-start align-items-center btn text-dark">
	                   		<span class="menu-collapsed text-danger">인테리어 자랑</span>    
	               		</div>
	           		</a> 
				</li>		
				
	           		<c:if test="${sessionScope.login}">
	           		<li class="list-group-item">
	           		 <a href="/community/contest/write.do"> 
	               		<div class="d-flex w-100 justify-content-start align-items-center btn text-dark">
	                   		<span class="menu-collapsed">글 작성하기</span>      
	               		</div> 
	           		</a>
	           		</c:if>
	           		
	           		<c:if test="${not sessionScope.login }">
	           		<li class="list-group-item">
	           		<a href="/community/reform/proto/writeModal.jsp"> 
	           			<div class="d-flex w-100 justify-content-start align-items-center btn text-dark">
						<span class="menu-collapsed">글 작성하기</span>
						</div>
	           		</a>
	           		</li>
	           		</c:if>
	           		          		
				</li>
			</ul>
		</div><!-- end of sidebar -->
		
		<div class="col-12 col-md-10">