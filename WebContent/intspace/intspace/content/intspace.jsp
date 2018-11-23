
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/intspace/css/top3.css" />

<div class="container" style="width: 80%; height: 80%; margin-left: 1px; margin-top: 16px;">
<h1>공간별 인테리어</h1>
	<!-- 본문 시작 -->
	<div style="margin-left: 10%; top: 20px;">
	
	<c:set var="searchcheck" value="${search }" />
	<c:if test="${searchcheck eq null}">
	<!-- top3 -->
		<table class="table">  
			<tr>
				<c:forEach items="${top3}" var="top">
					<td>
						<table class="table-hover" style="cursor:pointer;">
							<tr>
								<td style="background:#D8D8D8; width:200px; height:180px;"
									onclick="location.href='/intspace/view.do?intspaceno=${top.intspaceno}'">
									<div style="text-align: center; background: white; width: 195px;">
											<div style="margin: 10px; background: white;">
												<img alt="Responsive image" src="${top.imgpath }"
													style=" height: 100px; width: 180px; border: 1px solid gray">
											</div>
									</div>


									<div style="background: white; width: 195px;">
										<div class="text-center">
											${top.title}
										</div>
									
									</div>

								</td>
							</tr>
						</table>
					</td>
				</c:forEach>
			</tr>
		</table>
	</c:if>
	<hr>

	<div>
		<!--게시글 시작  -->

		<div>
			<table class="table table-hover " style="width: 100%; cursor:pointer;">
				<tbody>
					<c:set var="intspace" value="${intspaceList}" />
					<c:forEach items="${intspaceList}" var="intspace">
						<tr id="intContent"
							onclick="location.href='/intspace/view.do?intspaceno=${intspace.intspaceno}'">
							<td style="width: 70%;">
								<ul class="pagination">
									<li style="width: 80%"><h4>${intspace.title}</h4></li>
									<li><small> (${intspace.userid }) </small></li>
								</ul>

								<ul class="pagination">
									<li><small style="color: blue;">${intspace.hashtag }</small></li>
									<li></li>
								</ul>

								<ul class="pagination">
									<li style="width: 80%;"></li>
									<li><small> 조회수 : ${intspace.counter} </small></li>
								</ul>
							</td>
							<td style="width: 30%; text-align: center;"><img
								alt="Responsive image" src="${intspace.imgpath }"
								style="width: 190px; height: 100px;"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>
</div>
