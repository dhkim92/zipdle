<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="writespace">
	<!-- write 전체 -->

	<form action="/admin/EditStoreAdd.do" method="post"
		enctype="multipart/form-data">
		<div
			style="background: white; width: 80%; margin: 5%; border: 1px solid black">
			<!-- 입력 공간 시작  -->
			<div>
				<table style="width: 100%;">
					<tr>
						<td>
							<div class="text-left">
								<div class="custom-file">
									<input type="file" class="custom-file-input" id="customFile"
										name="uploadFile" required="required"> <label
										class="custom-file-label" for="customFile">이미지를 등록해
										주세요</label>
								</div>
							</div>
						</td>
					</tr>

					<tr>
						<td><input type="text" name="itemname" style="width: 100%;"
							placeholder="상품 이름을 입력하세요" /></td>
					</tr>

					<tr>
						<td><input type="text" name="itemprice" style="width: 100%;"
							placeholder="상품 가격을 입력하세요" /></td>
					</tr>


					<tr>
						<td><input type="text" name="iteminfo" style="width: 100%;"
							placeholder="상품 설명을 입력하세요" /></td>
					</tr>
				</table>
			</div>

			<hr>

			<div>
				<table>
					<tr>
						<td style="height:50px;"><input type="text" id="tag" name="tag"
							style="width: 100%;" placeholder="#태그"></td>
					</tr>
					<tr>
						<td></td>
					</tr>
				</table>
			</div>
			<!--태그 공간  -->


		</div>
		<!-- 입력 공간 끝 -->
		<div style="margin: 5%;">
			<button class="btn btn-warning" type="submit" value="Submit">저장하기</button>
		</div>
	</form>
</div>
<!--본문 끝  -->

<%@include file="/admin/include/footer.jsp"%>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>




<script>
	/* 첨부파일에 이미지 원본이름 뜨게하기  */
	$('.custom-file-input').on('change', function() {
		var fileName = $(this).val().split('\\').pop();
		$(this).next('.custom-file-label').addClass('selected').html(fileName);
	});
</script>
