<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div style="margin-left: 10%; margin-top: 5%;">
	<form action="/store/view.do" method="post">
		<table class="table" style="width: 610px;">
			<tr>
				<td rowspan="5" style=" width: 300px; height: 290px;">
				
					<c:set var="img" value="${storeList.imgpath}"/>
					
						<img alt="Responsive image"src="${img}"
							style="height: 290px; width: 290px; border: 1px solid gray">
					<input hidden="true" type="text" name="imgpath" value="${img}">
					
				</td>
				<td style="width: 300px; height: 50px;">
				<h3>
				${storeList.itemname}
				</h3>
				<input type="text" hidden="true" name="itemname" value="${storeList.itemname}" readonly/>
				
				</td>
			</tr>

			<tr>
				<td style="width: 300px; height: 100px;">
				${storeList.iteminfo}
					<input type="text" hidden="true" name="iteminfo" value="${storeList.iteminfo}" readonly/>
					
				</td>
			</tr>
			<tr>
				<td style="width: 300px; height: 50px; text-align: right;">
				<small>
				${storeList.itemprice} won
				</small>
				
				<input type="text" hidden="true" name="itemprice" value="${storeList.itemprice}" readonly/>
					<hr>
				</td>
			</tr>
			<tr>
				<td hidden="true">
					<input type="text" name="itemno" value="${storeList.itemno}" readonly/>
				</td>
				<td>
					<div>
						<button style="width: 300px; heigth: 100px;" class="btn btn-warning">장바구니에 담기</button>
					</div>
				</td>
			</tr>
		</table>
	</form>
</div>
