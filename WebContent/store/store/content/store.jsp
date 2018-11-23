<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="container" style="width: 80%; height: 80%; margin-left: 1px; margin-top: 16px;">
	<!--본문 시작 -->
	<h1>스토어</h1>
		<div style="margin-left: 10%; top: 20px;">
			<table class="table table-hover " style="width: 100%;">
				<tbody>
					<c:forEach items="${storeList}" var="store">
						<tr id="intContent" style="cursor:pointer;"
							onclick="location.href='/store/view.do?itemno=${store.itemno}'">
							<td style="width: 30%; text-align: center;"><img
								alt="Responsive image" src="${store.imgpath }"
								style="width: 200px; height: 130px; border: 1px solid gray"></td>
								
							<td style="width: 70%; ">
								<ul class="pagination">
									<li style="width: 80%"><h3>${store.itemname}</h3></li>
								</ul>

								<ul class="pagination justify-content-end">
									<li><small style="color: blue;">${store.hashtag }</small></li>
								</ul>

								<ul class="pagination justify-content-end">
									<li>${store.itemprice} won</li>
								</ul>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	
<!--본문 끝  -->
