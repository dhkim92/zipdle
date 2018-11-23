<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="./include/header.jsp"%>



<div class="py-5 text-center" style="background-image: url(&quot;https://pingendo.github.io/templates/sections/assets/cover_event.jpg&quot;);" >
    <div class="container py-1">
      <div class="row">
        <div class="col-md-12">
          <h3 class="mb-4 text-dark display-4 m-0 p-5">
            <b>Administrator Page</b>
          </h3>
          <div class="col">
            <ul class="lead mb-5 px-5 mx-5">
              <li>일반회원, 우수회원 등급 관리</li>
              <br>
              <li>에디터 회원 승인, 정지, 추방</li>
              <br>
              <li>스토어 물품 등록, 삭제</li>
              <br>
              <li>커뮤니티 게시물, 댓글 삭제</li>
              <br> </ul>
          </div>
          <div class="col my-5">
            <a href="/zipdlee/main.do" class="btn mx-1 btn-primary btn-lg">서비스 홈</a>
          </div>
          <div class="col my-5">
            <a href="/login/login.do" class="btn btn-lg btn-secondary mx-2">
            	로그아웃</a>
          </div>
        </div>
      </div>
    </div>
  </div>

<%@include file="./include/footer.jsp"%>
