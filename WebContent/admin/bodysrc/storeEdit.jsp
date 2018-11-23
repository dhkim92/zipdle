<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div style="width: 60%; height: 80%; margin-left: 15%; margin-top: 5%">
	<!--본문 시작 -->

	<div class="container">
	<h2>스토어 아이템 리스트</h2>
	
		<div>
			<table class="table table-hover " id="table" style="width: 100%;">
				<tbody>
					<c:forEach items="${storeList}" var="store">
						<tr style="cursor:pointer;">
						
							<td>
								<div style="align-content: center;">
									<input type="checkbox" name="check" value="${store.itemno}" />
								</div>
							</td>
							<td style="width: 30%; text-align: center;"><img
								alt="Responsive image" src="${store.imgpath }"
								style="width: 33%;"></td>

							<td style="width: 70%;">
								<ul class="pagination">
									<li style="width: 80%">${store.itemname}</li>
								</ul>

								<ul class="pagination">
									<li><small>${store.hashtag }</small></li>
								</ul>

								<ul class="pagination">
									<li>${store.itemprice}</li>
								</ul>
							</td>
						
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

<!--본문 끝  -->
<!-- right sidebar -->
<div style="position: fixed; bottom: 30%; right:3%; z-index: 99999; background:#D8D8D8; border: 1px solid gray;">

	<table  style="margin-left: 5px; margin-right: 5px; margin-bottom: 10px; margin-top: 10px;">
		<tr>
			<td>
			<form action="/admin/EditStoreAdd.do">
				<button id="btnadd"  class="btn btn-warning" >아이템 추가</button>
			</form>
			</td>
		</tr>
		<tr>
			<td >
				
				<button id="btnDelete"  class="btn btn-warning">아이템 삭제</button>
			</td>
		</tr>
	</table>
	
</div>

<div>
	<jsp:include page="/admin/bodysrc/storePaging.jsp" />
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>


 
<script type="text/javascript">

// tr 클릭시 체크박스 체크 물어보기 &&찾아보기
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
	



$(document).ready(function() {
	// 선택체크 삭제
	$("#btnDelete").click(function() {
// 		console.log("클릭");
		// 선택된 체크박스
		var $checkboxes = $("input:checkbox[name='check']:checked");
		
		// 체크된 대상들을 map으로 만들고 map을 문자열로 만들기
		var map = $checkboxes.map(function() {
			return $(this).val();
		});
		var names = map.get().join(",");
		console.log(names);
		
		// 전송 폼
		var $form = $("<form>")
			.attr("action", "/admin/StoreDelete.do")
			.attr("method", "get")
			.append(
				$("<input>")
					.attr("type", "hidden")
					.attr("name", "names")
					.attr("value", names)
			);
		$(document.body).append($form);
 		$form.submit();
	
	});
});
</script>

<%@include file="/include/footer.jsp"%>

