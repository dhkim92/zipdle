<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="writespace">
	<!-- write 전체 -->

	<form action="/intspace/write.do" method="post"
		enctype="multipart/form-data">
		<div
			style="background: white; width: 80%; margin: 5%; border: 1px solid black">
			<!-- 입력 공간 시작  -->
			<div>
				<table class="table" style="width: 100%; height: 100%;">
					<tr>
						<td><input type="text" name="title" style="width: 100%;"
							placeholder="제목을 입력하시오" /></td>
					</tr>

					<tr>
						<td style="text-align: left; height: 5em;">
							<div class="text-left">
								<div class="custom-file">
									<input type="file" class="custom-file-input" id="customFile"
										name="uploadFile" required="required"> <label
										class="custom-file-label" for="customFile">이미지를 첨부해주세요</label>
								</div>
							</div>
						</td>
					</tr>

					<tr>
						<td style="height: 30em;"><textarea type="text"
								name="content" style="width: 100%; height: 100%"
								placeholder="내용을 입력하세요"></textarea></td>
					</tr>
				</table>
			</div>

			<hr>

			<!--태그 공간  -->
			<div>
				<table class="table" style="width: 100%;">
					<tr>
						<td><input type="text" id="tag" name="tag"
							style="width: 100%;" placeholder="#태그"></td>
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






