<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>

<head>
<title>로그인</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="theme.css" type="text/css">
 
 <style type="text/css">
<%@ include file="./CSS/login.css" %>
</style>
 
 <script type="text/javascript"
 src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
 

 <script type="text/javascript">
 $(document).ready(function(){
	 
	 $("#idBt").click(function() {
			$(location).attr("href", "/login/idsearch.do");
		});
	 
	 $("#pwBt").click(function() {
			$(location).attr("href", "/login/pwsearch.do");
		});
	 
	 $("#joinBt").click(function() {
			$(location).attr("href", "/login/join.do");
		});
	 
	 
 });
 
 
 </script>
  
</head>

<body id="body">
  <div id="logodiv1" class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
        
		<a href="/zipdlee/main.do" title="메인으로 가기">
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
          <form  class="w-75 mx-auto h-50 py-5" action="/login/login.do" method="post">
            
            <div class="form-group">
              <label><b>아이디</b></label>
              <input type="text" name="id" class="form-control form-control-lg" placeholder="ID" required  maxlength="10"> </div>
            
            <div class="form-group">
              <label><b>비밀번호<b></b></label>
              <input type="password" name="pw" class="form-control form-control-lg" placeholder="Password" required  maxlength="15"> </div>
            
            <button id="loginBt" type="submit" class="btn btn-primary btn-block btn-lg w-75 mx-auto m-3">
              <b>로그인</b>
            </button>
      
          </form>     
        </div>
      </div>
    </div>
    <div id="btnsdiv1" class="container w-50 my-5">
      <div class="row">
        <div class="col-md-4 text-center">
          <button id="idBt" class="btn btn-primary m-2">아이디 찾기</button>
        </div>
        <div class="col-md-4 text-center">
          <button id="pwBt" class="btn btn-primary m-2" >비밀번호 수정</button>
        </div>
        <div class="col-md-4 text-center">
          <button id="joinBt" class="btn btn-primary m-2" >&nbsp;회원 가입 &nbsp;</button>
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