<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="theme.css" type="text/css">

<style type="text/css">
<%@ include file="./CSS/join.css" %>
</style>

</head>


<body id="body" >
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
        <!-- 이미지 클릭 태그 -->
		<a href="/login/login.do" title="로그인 화면으로 가기">
	 	<img class="img-fluid d-block p-2 text-center"
	  	src="/login/img/3.jpg">
		</a> 
		
        </div>
        <div class="col-md-4"></div>
      </div>
    </div>
  </div>
  <div class="py-5">
    <div class="container">
      <div class="row w-75 mx-auto">
        <div class="col-md-12">
          <form class="w-75 mx-auto" action="/login/join.do" method="post">
           
            <div class="form-group">
              <label><b>아이디</b></label>
              <input type="text" name="id" class="form-control" placeholder="ID" required  maxlength="10"> </div>
           
            <div class="form-group">
              <label><b>비밀번호</b></label>
              <input type="password" name="pw" class="form-control" placeholder="Password" required  maxlength="15"> </div>
           
            <div class="form-group">
              <label><b>비밀번호 확인</b></label>
              <input type="password" name="repw" class="form-control" placeholder="Password" required  maxlength="15"> </div>
           
            <div class="form-group">
              <label><b>이름</b></label>
              <input type="text" name="name" class="form-control" placeholder="Name" required  maxlength="5"> </div>
    
            <div class="form-group">
            <label><b>생년 월일</b></label>
            <input type="number" name="birth" class="form-control" placeholder="ex) 931122" required  maxlength="6">           
            </div>
             
            <div class="form-group">
              <label><b>이메일</b></label>
              <input type="email" name="email" class="form-control" placeholder="Email" required  maxlength="20"> </div>
            
            <div class="form-group">
              <label><b>연락처</b></label>
              <input type="text" name="phone" class="form-control" placeholder="ex) 010-1234-5678" required  maxlength="13"> </div>
            
            <div class="form-group">
              <label><b>주소</b></label>
              <input type="text" name="address" class="form-control" placeholder="Address" required  maxlength="20"> </div>
            
            <button id="joinBt" type="submit" class="btn btn-primary btn-block btn-lg mx-auto w-50">
              <b>회원 가입</b>
            </button>
          
          </form>
        </div>
      </div>
    </div>
  </div>
</body>

<link rel="stylesheet" 
href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" 
crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" 
integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" 
crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" 
integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" 
crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" 
integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" 
crossorigin="anonymous"></script>


</html>