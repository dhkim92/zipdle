<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!-- view 전체 -->

<div style="width: 80%; margin: 5%; background: white;">
	<!-- 입력 공간 시작  -->
	<hr>

	<table style="height: 10%;">
		<tr>
			<td style="width: 100%"><h2>${viewList.title}</h2></td>
			<td style="text-align: right;"><small>작성자 <br>
					${viewList.userid}
			</small></td>
		</tr>
	</table>
	<hr>


	<!--사진 input  -->
	<div style="text-align: center;">
		<img alt="Responsive image" src="${viewList.imgpath}"
			style="width: 600px; height: 400px;">
	</div>
	<hr>



	<!--게시글 본문  -->
	<div style="width: 100%; height: 20%;">
		<div id="textinput">${viewList.content}</div>
	</div>

	<hr>


	<!--태그 공간  -->
	<div>
		<div style="height: 10%; text-align: right;">
			<a href="/intspace/intspace.do?search=${viewList.hashtag}">
				${viewList.hashtag } </a>
		</div>
	</div>
</div>


<!--본문 끝  -->
