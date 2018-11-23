<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" 
integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" 
crossorigin="anonymous"></script>


</head>
<body>

<!-- Button trigger modal -->
<button type="button" id="modalBtn" style="display: none;"class="btn btn-primary" 
				data-toggle="modal" data-target="#modal" data-backdrop="static" data-keyboard="false">
</button>

 <script type="text/javascript">


 jQuery(document).ready(function() {
	$("#modalBtn").click();
});

 	
</script>


<!-- Modal -->

<div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="modaltitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="modaltitle"><b>회원 등급 수정 결과</b></h5>
      </div>
      
      
      
      

				<c:if test="${requestScope.grade eq 2 }">
				<div class="modal-body">
				        
				        	<h4>ID : ${requestScope.userid }</h4>
							<br>
							회원 등급을 <b style="size: 1.3rem;">우수 회원</b> 으로 승급 하였습니다.  
				        
				      </div>
				
				</c:if>      
				           
				<c:if test="${requestScope.grade eq 1 }">
				<div class="modal-body">
				        
				        	<h4>ID : ${requestScope.userid }</h4>
							<br>
							회원 등급을 <b style="size: 1.3rem;">일반 회원</b> 으로 강등 하였습니다.  
				        
				      </div>
				
				</c:if>             
      
      <div class="modal-footer">
        <a href="/admin/usergrade.do"><button type="button" class="btn btn-secondary" >닫기</button></a>
      </div>
    </div>
  </div>
</div> <!-- model div end  -->


</body>

<link rel="stylesheet" 
href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" 
crossorigin="anonymous">

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" 
integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" 
crossorigin="anonymous"></script>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" 
integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" 
crossorigin="anonymous"></script>


</html>