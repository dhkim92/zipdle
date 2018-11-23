<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/admin/include/header.jsp"%>


<!-- 여기!!!! -->
<div class="py-3">
    <div class="container">
      <h2 class="">업체 리스트</h2>
      <div class="row p-2 border my-5">
        <div class="col-md-12">
          <table class="table table-hover table-striped border my-2">
            <thead>
              <tr>
                <th class="text-center">선택</th>
                <th class="text-center">번호</th>
                <th class="text-center">상호명</th>
                <th class="text-center">사업자 등록번호</th>
                <th class="text-center">대표자</th>
                <th class="text-center">소재지</th>
                <th class="text-center">회사연락처</th>
              </tr>
            </thead>
            <tbody>
            
            <c:forEach items="${edit }" var="editor">
              <tr>
                <td class="text-center">
                  <label class="checkbox-inline">
                    <input id="chkBox" type="checkbox" name="check" value="${editor.editNo }"> </label>
                </td>
                <td class="text-center" id="editNo">${editor.editNo }</td>
                <td class="text-center">${editor.name }</td>
                <td class="text-center">${editor.resiNo }</td>
                <td class="text-center">${editor.manager }</td>
                <td class="text-center">${editor.address }</td>
                <td class="text-center">${editor.phonenum }</td>
              </tr>
           </c:forEach>
              
              
              
            </tbody>
          </table>
          
          
	<jsp:include page="editorModal.jsp" />


          
          
          
          
        </div>
      </div>
    </div>
  </div>
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <jsp:include page="paging3.jsp"/>
      </div> 
    </div>
  </div>
  <div class="py-4">
    <div class="container">
      <div class="row">
        <div class="col-md-6 text-center">
        </div>
        <div class="col-md-6 text-center">
          <button id="btnStop" class="btn btn-primary w-25" >업체 정지</button>
        </div>
        
      </div>
    </div>
  </div>
  
  
<%@include file="./include/scriptLoader.jsp" %>

<script>
$(document).ready(function(){
	
	$("#btnStop").click(function(){
		
		console.log("눌림");
		
		var $chkBox = $("input:checkbox[name='check']:checked");//
		
		var map = $chkBox.map(function() {
			return $(this).val();
		});
		
		var names = map.get().join(",");
		console.log(names);
		
		if(names==null || names==""){
			$("#testModal").modal();
				return;
		}
		
		var $form = $("<form>")
		.attr("action", "/admin/stopCompany.do")
		.attr("method", "post")
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
<!--  여기!!! -->

<%@include file="/admin/include/footer.jsp"%>