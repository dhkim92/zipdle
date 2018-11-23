<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 추가한것 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


 <div class="py-3">
    <div class="container">
      <h2 class="">회원 등급 관리</h2>
      <div class="row p-2 border my-5">
        <div class="col-md-12">
          <table id="table" class="table table-hover table-striped border my-2">
            <thead>
              <tr>
                <th class="text-center">선택</th>
                <th class="text-center">번호</th>
                <th class="text-center">아이디</th>
                <th class="text-center">이름</th>
                <th class="text-center">주소</th>
                <th class="text-center">이메일</th>
                <th class="text-center">회원 등급</th>
              </tr>
            </thead>
            <tbody>
            
             <c:forEach items="${userlist}" var="user">
              <tr>
              
                <td class="text-center">
                  <label class="checkbox">
                    <input type="checkbox" name="check" id="check" value="${user.userId }"> </label>
                </td>
                <td class="text-center">${user.userNo }</td>
                <td class="text-center">${user.userId }</td>
                <td class="text-center">${user.userName }</td>
                <td class="text-center">${user.userAddress }</td>
                <td class="text-center">${user.userEmail }</td>
                <td class="text-center">
                
                <c:if test="${user.userGrade==1 }">일반 회원</c:if>  
          		<c:if test="${user.userGrade==2 }">우수 회원</c:if>
          		
                
                </td>     
              </tr>
             </c:forEach> 
           
            </tbody>
          </table>
          
        </div>
      </div>
    </div>
  </div>
  
  <!-- 페이징 버튼 -->
 
 <div>
	<jsp:include page="/admin/bodysrc/userGradePaging.jsp" />
</div> 
  
  
  <div class="py-4">
    <div class="container">
      <div class="row">
        
        <div class="col-md-6 text-center">
          <Button id="btnup" class="btn w-50 btn-primary" >
            <b>Grade Up</b> 
            </Button>
        </div>
        
        
        <div class="col-md-6 text-center">
          <Button id="btndown" class="btn btn-secondary w-50" >  
              <b>Grade Down</b>
          </Button>
        </div>
      </div>
    </div>
  </div>
  
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  
  <script type="text/javascript">

// tr 클릭시 체크박스 체크 물어보기 &&찾아보기
$(document).ready(function() {
	$("table tr").click(function(){
// 		console.log($(this));
	
		$(this).find("[name='check']").prop("checked", function() {
			return !$(this).prop("checked");
		});
		console.log($(this).find("[name='check']"));
		console.log('test');
	});
});
	



$(document).ready(function() {
	// 선택체크 삭제
	$("#btnup").click(function() {
// 		console.log("클릭");
		// 선택된 체크박스
		var $checkboxes = $("input:checkbox[name='check']:checked");
		
		// 체크된 대상들을 map으로 만들고 map을 문자열로 만들기
		var map = $checkboxes.map(function() {
			return $(this).val();
		});
		var ids = map.get().join(",");
		console.log(ids);
		
		
		
		// 전송 폼
		var $form = $("<form>")
			.attr("action", "/admin/usergrade.do")
			.attr("method", "post")
			.append(
				$("<input>")
					.attr("type", "hidden")
					.attr("name", "up")
					.attr("value", ids)
					
			);
		
		$(document.body).append($form);
 		$form.submit();
	
	});
	
	
	
	// 선택체크 삭제
	$("#btndown").click(function() {
// 		console.log("클릭");
		// 선택된 체크박스
		var $checkboxes = $("input:checkbox[name='check']:checked");
		
		// 체크된 대상들을 map으로 만들고 map을 문자열로 만들기
		var map = $checkboxes.map(function() {
			return $(this).val();
		});
		var ids = map.get().join(",");
		console.log(ids);
		
	
		
		// 전송 폼
		var $form = $("<form>")
			.attr("action", "/admin/adminmain.do")
			.attr("method", "post")
			.append(
				$("<input>")
					.attr("type", "hidden")
					.attr("name", "down")
					.attr("value", ids)
					
			);
		
		$(document.body).append($form);
 		$form.submit();
	
	});
	
	
	
});
</script>
