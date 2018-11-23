<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

		<div>
			<!--검색시작  -->


	<div>
		<jsp:include page="/store/util/paging.jsp" />
	</div>



	<div >
		<form action="/store/storepaging.do" method="post">
			<ul class="pagination justify-content-end" >
				<li class="text-right"><input class="form-control" type="text" id="search"
					name="search" placeholder="검색" />
				</li>
				<li>
					<button id="btnSearch" class="btn">
						<img alt="Responsive image" src="/intspace/img/glass.png"
							style="width: 28px; height: 28px;">
					</button>
				</li>
			</ul>
		</form>
	</div>




</div>
		</div><!--게시글 본문 종료 -->
	