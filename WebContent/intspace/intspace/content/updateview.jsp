<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="writespace">
	<!-- write 전체 -->

	<form action="/intspace/update.do" id="saveUpdate" method="post"
		enctype="multipart/form-data">
		<input type="hidden" name="intspaceno"
			value="${updateinfo.intspaceno }" />

		<div
			style="background: white; width: 80%; margin: 5%; border: 1px solid black">
			<!-- 입력 공간 시작  -->
			<div>
				<table style="width: 100%; height: 100%;">
					<tr>
						<td><input type="text" name="title" style="width: 100%;"
							value="${updateinfo.title}" /></td>
					</tr>

					<tr>
						<td>
							<br>
							<div class="text-left">
								<div class="custom-file">
									<input type="file" class="custom-file-input" id="customFile"
										name="uploadFile" required="required"> <label
										class="custom-file-label" for="customFile">이미지를 수정해 주세요</label>
								</div>
							</div>
							<hr>

						</td>
					</tr>

					<tr>
						<td style="height: 20em;"><textarea type="text"
								name="content" style="width: 100%; height: 100%">${updateinfo.content}</textarea></td>
					</tr>
				</table>
			</div>

			<hr>

			<!--태그 공간  -->
			<div>
				<table>
					<tr>
						<td><input type="text" id="tag" name="tag"
							style="width: 100%; margin: 3px;" value="${updateinfo.hashtag}"></td>
					</tr>
					<tr>
						<td></td>
					</tr>
				</table>
			</div>



		</div>
		<!-- 입력 공간 끝 -->
		<div style="width: 80%; margin: 5%;" class="text-right">
			<button type="submit" value="Submit" class="btn btn-warning">저장하기</button>
		</div>
	</form>
</div>
<!--본문 끝  -->
