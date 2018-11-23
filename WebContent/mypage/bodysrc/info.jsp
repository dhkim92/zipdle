<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12 m-1">
          <h3 class="">
            <b>회원정보 수정</b>
          </h3>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12 m-3">
          <p class="lead"><a href="/mypage/mypage.do"><b>${sessionScope.username}</b></a> 님의 회원정보 수정 페이지 입니다.</p>
        </div>
      </div>
 <hr id="hr"> 
    </div>
  </div>
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h4 class="">
            <b>비밀번호 수정</b>
          </h4>
        </div>
      </div>
      	<form action="/mypage/info/infopw.do" method="post">
      <div id="row1" class="row">
        <div class="col-md-2">
          <p class="lead m-1">비밀번호 &nbsp;:</p>
        </div>
        <div class="col-md-6">
          <input type="password" name="password" class="form-control" placeholder="password" required  maxlength="15">
        </div>
      </div>
      <div class="row" style=" margin-top: 10px; ">
        <div class="col-md-2">
          <p class="lead m-1">비밀번호 확인 &nbsp;:</p>
        </div>
        <div class="col-md-6">
          <input type="password" name="repassword" class="form-control" placeholder="password" required  maxlength="15">
        </div>
      </div>
      <div id="chBt" class="row m-5">
        <div class="col-md-12">
          <button class="btn btn-primary w-25 m-2" href="#">비밀번호 수정</button>
        </div>
      </div>
      </form>
  <hr id="hr">     
    </div>
  </div>
 <form action="/mypage/info.do" method="post">
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h4 class="">
            <b>연락처 정보</b>
          </h4>
        </div>
      </div>
      <div id="row1" class="row">
        <div class="col-md-2">
          <p class="lead m-1">연락처 &nbsp;:</p>
        </div>
        <div class="col-md-6 m-1">
          <p class="lead">${requestScope.userinfo.userPhone }</p>
        </div>
      </div>
      <div class="row">
        <div class="col-md-2">
          <p class="lead m-1">변경할 연락처 &nbsp;:</p>
        </div>
        <div class="col-md-6">
          <input type="text" name="phone" class="form-control" placeholder="ex) 010-1234-5678" required  maxlength="13">
        </div>
      </div>
     
 
    </div>
  </div>
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h4 class="">
            <b>이메일 정보</b>
          </h4>
        </div>
      </div>
      <div id="row1" class="row">
        <div class="col-md-2">
          <p class="lead m-1">이메일 &nbsp;:</p>
        </div>
        <div class="col-md-6 m-1">
          <p class="lead">${requestScope.userinfo.userEmail}</p>
        </div>
      </div>
      <div class="row">
        <div class="col-md-2">
          <p class="lead m-1">변경할 이메일 &nbsp;:</p>
        </div>
        <div class="col-md-6">
          <input type="email" name="email" class="form-control" placeholder="email" required  maxlength="20">
        </div>
      </div>
      
      
    </div>
  </div>
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h4 class="">
            <b>주소 정보</b>
          </h4>
        </div>
      </div>
      <div id="row1" class="row">
        <div class="col-md-2">
          <p class="lead m-1">주소 &nbsp;:</p>
        </div>
        <div class="col-md-6 m-1">
          <p class="lead">${requestScope.userinfo.userAddress}</p>
        </div>
      </div>
      <div class="row">
        <div class="col-md-2">
          <p class="lead m-1">변경할 주소 &nbsp;:</p>
        </div>
        <div class="col-md-6">
          <input type="text" name="address" class="form-control" placeholder="address" required  maxlength="20">
        </div>
      </div>
      <div id="chBt" class="row m-5">
        <div class="col-md-12">
          <button class="btn btn-primary w-25 m-2" href="#">회원 정보 수정</button>
        </div>
      </div>
    </div>
  </div>
  </form>
