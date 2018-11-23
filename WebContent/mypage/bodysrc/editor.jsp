<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 추가한것 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12 m-1">
          <h3><b>에디터 신청</b></h3>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12 m-3">
          <p class="lead"><a href="/mypage/mypage.do"><b>${sessionScope.username}</b></a> 님의 에디터 신청 페이지 입니다.</p>
        </div>
      </div>
<hr>        
    </div>
  </div>
  <form action="/mypage/editor.do" method="post" enctype="multipart/form-data">
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h6 class=""><b>사업자 등록번호</b></h6>
        </div>
      </div>
      <div id="row1" class="row">
        <div class="col-md-12">
          <input type="text" name="resiNo" class="form-control w-50" placeholder="Business Number" required  maxlength="9"> </div>
      </div>
    </div>
  </div>
  
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h6 class=""><b>상 호</b></h6>
        </div>
      </div>
      <div id="row1" class="row">
        <div class="col-md-12">
          <input type="text" name="name" class="form-control w-50" placeholder="Sign" required  maxlength="10"> </div>
      </div>    
    </div>
  </div>
  
   <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h6 class=""><b>대표자</b></h6>
        </div>
      </div>
      <div id="row1" class="row">
        <div class="col-md-12">
          <input type="text" name="manager" class="form-control w-50" placeholder="Manager" required  maxlength="5"> </div>
      </div>    
    </div>
  </div>
  
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h6 class=""><b>소재지</b></h6>
        </div>
      </div>
      <div id="row1" class="row">
        <div class="col-md-12">
          <input type="text" name="address" class="form-control w-50" placeholder="Location" required> </div>
      </div>
    </div>
  </div>
  
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h6 class=""><b>회사 연락처</b></h6>
        </div>
      </div>
      <div id="row1" class="row">
        <div class="col-md-12">
          <input type="text" name="phonenum" class="form-control w-50" placeholder="ex) 010-1234-5678" required  maxlength="13"> </div>
      </div> 
    </div>
  </div>
  
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h6 class=""><b>에디터 소개</b></h6>
        </div>
      </div>
      <div id="row1" class="row">
        <div class="col-md-12">
          <input type="text" name="content" class="form-control w-50" placeholder="간략한 소개를 써주세요." > </div>
      </div> 
    </div>
  </div>
  
  <!-- imgPath -->
  
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h6 class=""><b>이미지 등록</b></h6>
        </div>
      </div>
      <hr>
      <div id="row1" class="row">
        <div class="col-md-12">
          <input type="file" name="uploadfile" class="w-50" > </div>
      </div> 
    </div>
  </div>
  
  <!-- btn -->
  <div class="py-5" >
    <div class="container">
      <div id="editBt" class="row">
        <div class="col-md-12 text-center">
          <button id="editorBt" type="submit" class="btn btn-primary w-25" href="#">
           <b>에디터 신청</b>
          </button>         
        </div>
      </div>
    </div>
  </div>
</form>
