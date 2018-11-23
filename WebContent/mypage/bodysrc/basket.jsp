<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div id="basketboard"><!--본문 시작 -->
	<div id="storebasket">
		<table>
			<tr>
				<td>
					<div>
						장바구니
					</div>
				</td>
				<td>
					<div>
						(물품수 카운트)
					</div>
				</td>
			</tr>
		</table>
	</div>
	<hr>
	
<div> <!--장바구니 물품 -->
	
	<div id="ititem">
		<table>
			<tr>
				<td>
					<div>
						체크 공간
					</div>
				</td>
				
				<td>
					<div>
						<img alt="Responsive image" src="./bear.jpg" style="height:90px; width:150px;">
					</div>
				</td>
				
				<td>
					<div id="itemname">
						곰인형					
					</div>
				</td>
					
				<td>
					<div id="itmeamount">
						<table border="1">
							<tr>
								<td>
									<div style="text-align: center; width:30px;">
										+
									</div>
								</td>
								
								<td>
									<div style="text-align: center; width:30px;">
										1
									</div>
								</td>
								
								<td>
									<div style="text-align: center; width:30px;">
										-
									</div>
								</td>
							</tr>
						</table>
					</div>
				</td>
				
				<td>
					<div id="itemprice">
						10,000 won
					</div>
				</td>
			</tr>
		</table>
	</div><!-- 물품 끝  -->
	<hr>
	
	<div><!-- 총 금액  -->
		<table>
			<tr>
				<td>
					<div id="chargetable">
						총상품 금액
					</div>
				</td>
				
				<td>
					<div id="chargevalue">
						금액 출력
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div id="chargetable">
						배송비
					</div>
				</td>
				
				<td>
					<div id="chargevalue">
						금액 출력
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div id="chargetable">
						결제 금액
					</div>
				</td>
				
				<td>
					<div id="chargevalue">
						금액 출력
					</div>
				</td>
			</tr>
		</table>
	</div>
	
	
	<div>
		<table>
			<tr>
				<td style="width:200px; height:50px; border:1px solid black;">선택 제품 삭제 버튼</td>
				<td style="width:200px; height:50px; border:1px solid black;" >주문하기 버튼</td>
				<td style="width:200px; height:50px; border:1px solid black;">계속 쇼핑하기 버튼</td>
			</tr>
		</table>
	</div>

</div>
</div>
