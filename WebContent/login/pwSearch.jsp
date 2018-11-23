<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<title>비밀번호 찾기</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="theme.css" type="text/css"> 

<style type="text/css">
<%@ include file="./CSS/pwSerch.css" %>
</style>


</head>

<body id="body">
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">

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
        
          <form class="w-75 mx-auto" action="/login/pwsearch.do" method="post">
            
            <div class="form-group">
              <label><b>아이디</b></label>
              <input type="text" name="id" class="form-control" placeholder="ID" required  maxlength="10"> </div>
            
            <div class="form-group">
              <label><b>이름</b></label>
              <input type="text" name="name" class="form-control" placeholder="Name" required  maxlength="5"> </div>

            <div class="form-group" >
              <label><b>이메일</b></label>
              <input type="email" name="email" class="form-control" placeholder="Email" required  maxlength="20"> </div>
           
            <div class="form-group">
              <label><b>연락처</b></label>
              <input type="text" name="phone" class="form-control" placeholder="Phone number" required  maxlength="13"> </div>
            
     <hr>          
            <div class="form-group">
              <label><b>변경 비밀번호</b></label>
              <input type="password" name="pw" class="form-control" placeholder="Password" required  maxlength="15"> 
            </div>  
            
            <div class="form-group">
              <label><b>비밀번호 확인</b></label>
              <input type="password" name="repw" class="form-control" placeholder="Password" required  maxlength="15"> 
            </div>  
            
            
            <button id="pwSerchBt" type="submit" class="btn btn-primary btn-block btn-lg mx-auto w-50">
              <b>비밀번호 수정</b>
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