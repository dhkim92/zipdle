<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 추가한것 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12 m-1">
          <h3><b>회원 탈퇴</b></h3>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12 m-3">
          <p class="lead"><a href="/mypage/mypage.do"><b id="idb">${sessionScope.username}</b></a> &nbsp;님의 회원 탈퇴 페이지 입니다.</p>
        </div>
      </div>
<hr>        
    </div>
  </div>
  <form action="/mypage/delete.do" method="post">
  
  
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h6 class=""><b>비밀번호 확인</b></h6>
        </div>
      </div>
      <div id="row1" class="row">
        <div class="col-md-12">
          <input type="password" name="password" class="form-control w-50" placeholder="Password" required  maxlength="15"> </div>
      </div>    
    </div>
  </div>
  
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h6 class=""><b>이름 확인</b></h6>
        </div>
      </div>
      <div id="row1" class="row">
        <div class="col-md-12">
          <input type="text" name="name" class="form-control w-50" placeholder="Name" required  maxlength="5"> </div>
      </div> 
    </div>
  </div>
  
   <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h6 class=""><b>연락처 확인</b></h6>
        </div>
      </div>
      <div id="row1" class="row">
        <div class="col-md-12">
          <input type="text" name="phone" class="form-control w-50" placeholder="Phone Number" required  maxlength="13"> </div>
      </div>    
    </div>
  </div>
  
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h6 class=""><b>이메일 확인</b></h6>
        </div>
      </div>
      <div id="row1" class="row">
        <div class="col-md-12">
          <input type="email" name="email" class="form-control w-50" placeholder="Email" required  maxlength="20"> </div>
      </div>
    </div>
  </div>
  
  <!-- btn -->
  <div class="py-5" >
    <div class="container">
      <div class="row">
        <div class="col-md-12 text-center">
          <button id="deleteBtn" type="submit" class="btn btn-primary w-25">
           <b>회원 탈퇴</b>
          </button>         
        </div>
      </div>
    </div>
  </div>

</form>