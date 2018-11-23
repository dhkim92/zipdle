<!-- 커뮤니티 메뉴의 메인 페이지 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 

<%@include file="./include/header.jsp"%>

<div  style="width: 60%; height: 80%; margin-left: 15%; margin-top: 5%">
<div>

		<h2>리폼</h2>
	
		<table class="table table-hover" id="table"> 

			<c:forEach items="${reformlist }" var="reform">
				<tr>
					<td>
						<div style="align-content: center;">
							<input type="checkbox" name="check" value="${reform.idx }" />
						</div>
					</td>
					<td>
						<h5>
							${reform.title}
						</h5>
						<p class="content">${reform.content }</p>
						<div class="info">by.${reform.id }</div> 
					</td> 
  
					<td width="23%"><img width="200px" height="150px"
						src="${reform.filePath }" /></td>  
				</tr>
				
			</c:forEach>
 
		</table>
		</div >
	 
		<div class="pageCls d-flex justify-content-center">
			<jsp:include page="./bodysrc/reformPaging.jsp" />
		</div>
	
</div>

<div style="position: fixed; bottom: 30%; right:3%; z-index: 99999; background:#D8D8D8; border: 1px solid gray;">

	<table  style="margin-left: 5px; margin-right: 5px; margin-bottom: 10px; margin-top: 10px;">
		<tr>
			<td>
				<button id="btnDelete"  class="btn btn-warning" style="width: 100%;">아이템 삭제</button>
			</td>
		</tr>
		<tr>
			<td>
				<form action="/admin/editContest.do">
					<button id="btnadd"  class="btn btn-warning" >인테리어 자랑</button>
				</form>
			</td>
		</tr>
		
	</table>
	
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>



<script>
//---line select && delete----

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
			.attr("action", "/admin/reformDelete.do")
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

//----------------------------


</script>

<%@include file="./include/footer.jsp"%>
