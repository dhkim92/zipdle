<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="bg-gray" style="align-content: center; margin-top: 20px; margin-left: 15px;">
<h1>장바구니</h1>
	<!--본문 시작 -->
	<div style="margin: 30px;">
		<!--장바구니 물품 -->
		<table class="table" >
			<tr>
				<th
					style="border: 2px solid white; width: 35px; height: 40px; text-align: center;" class="bg-warning">선택</th>
				<th
					style="border: 2px solid white; width: 120px; height: 40px; text-align: center;" class="bg-warning">사진</th>
				<th
					style="border: 2px solid white; width: 120px; height: 40 px; text-align: center;" class="bg-warning">상품명</th>
				<th
					style="border: 2px solid white; width: 100px; height: 40 px; text-align: center;" class="bg-warning">수량</th>
				<th
					style="border: 2px solid white; width: 60px; height: 40 px; text-align: center;" class="bg-warning">합계
				</th>
			</tr>
		</table>
			
		<table  class="table table-hover" style="cursor: pointer; margin: 2px; width: 100%">
			
			<c:forEach items="${basketList}" var="Basket">
			
				<tr>
					<td style="width: 45px; ">
						<div class="text-center">
							<input type="checkbox" name="check" value="${Basket.basketno}" />
						</div>
					</td>
					<td style="width: 140px;">
						<div class="text-center">
							<img alt="Responsive image" src="${Basket.imgpath }"
								style="height: 50px; width: 100px; border: 1px solid gray">
						</div>
					</td>

					<td style="width: 140px;">
						<div style="text-align: center;"><h5>${Basket.basketname}</h5></div>
					</td>

					<td style="width: 100px;">
						<div>
							<form action="/basket/basket.do" method="post">
								<ul class="pagination justify-content-center">
									<li>
										<button style="width: 32px;" name="checker" value="1">+</button>
									</li>
									<li><input type="text" readonly name="basketamount"
										value="${Basket.basketamount}"
										style="width: 32px; text-align: center"> <input
										type="text" hidden="true" name="basketno"
										value="${Basket.basketno}" /></li>
									<li>
										<button style="width: 32px;" name="checker" value="2">-</button>
									</li>
								</ul>
							</form>
						</div>
					</td>

					<td id="price" style="text-align: right; width: 70px;">
						${Basket.basketprice * Basket.basketamount} won <c:set var="price"
							value="${Basket.basketprice * Basket.basketamount}"></c:set> <c:set
							var="totalprice" value="${totalprice + price }"></c:set>
					</td>
				</tr>

			</c:forEach>
		</table>
			
			<table class="table" >

			<tr>
				<td colspan="7">
					<div id="chargetable" style="text-align: right;"><h4>배송비</h4></div>
				</td>

				<td colspan="1">
					<div id="chargevalue" style="text-align: right;">
						<c:if test="${grade.userGrade==1 }">5000 won</c:if>
						<c:if test="${grade.userGrade>1 }">0 won</c:if>
					</div>
				</td>
			</tr>

			<tr>
				<td colspan="7">
					<div id="chargetable" style="text-align: right;"><h4>총 결제 금액</h4></div>
				</td>

				<td colspan="1">
					<div id="chargevalue" style="text-align: right;">
						<c:if test="${grade.userGrade==1 }">${totalprice + 5000} won</c:if>
						<c:if test="${grade.userGrade>1 }">${totalprice} won</c:if>
					</div>
				</td>
			</tr>
		</table>


		<c:set var="totalprice" value="0"></c:set>


		<!-- 물품 끝  -->

		<div>
			<!-- 총 금액  -->
			<table>

			</table>
		</div>
		<hr>


		<div class="text-center">

			<table style="width: 100%; margin: 20px;">
				<tr>
					<td style="height: 50px; width: 215px;">
						<button id="btnDelete" class="btn btn-warning">선택 제품 삭제</button>
					</td>
<!-- 					<td style="height: 50px; width: 215px;"> -->
<!-- 						<button>주문하기</button> -->
<!-- 					</td> -->
					<td style="height: 50px; width: 215px;">
						<form action="/store/storepaging.do" method="get" >
							<div>
								<button class="btn btn-warning">계속 쇼핑하기</button>
							</div>
						</form>
					</td>
				</tr>
			</table>

		</div>

	</div>
</div>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">

$(document).ready(function() {
	$("table tr").click(function(){
// 		console.log($(this));
	
		$(this).find("[name='check']").prop("checked", function() {
			return !$(this).prop("checked");
		});
// 		console.log($(this).find("[name='check']"));
// 		console.log('test');
	});
});

	$(document)
			.ready(
					function() {
						// 선택체크 삭제
						$("#btnDelete")
								.click(
										function() {
											// 		console.log("클릭");
											// 선택된 체크박스
											var $checkboxes = $("input:checkbox[name='check']:checked");

											// 체크된 대상들을 map으로 만들고 map을 문자열로 만들기
											var map = $checkboxes
													.map(function() {
														return $(this).val();
													});
											var names = map.get().join(",");
											console.log(names);

											// 전송 폼
											var $form = $("<form>").attr(
													"action",
													"/basket/delete.do").attr(
													"method", "get").append(
													$("<input>").attr("type",
															"hidden").attr(
															"name", "names")
															.attr("value",
																	names));
											$(document.body).append($form);
											$form.submit();

										});
					});
</script>





