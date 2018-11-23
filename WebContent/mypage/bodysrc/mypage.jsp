<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 추가한것 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


 <div class="py-5">
    <div class="container" id="profileC">
      <div class="row">
        <div class="col-md-6">
          <h3 class="text-center">
            <b>프로필</b>
          </h3>
        </div>
        <div class="col-md-6 text-center">
          <h3 class="">
            <b>회원 정보</b>
          </h3>
        </div>
      </div>
      
      <div class="row">
      <form class="col-md-6" action="/mypage/mypage.do" method="post" enctype="multipart/form-data">
        <div>
          <img class="d-block img-fluid rounded-circle mx-auto p-3" src="${imgPath }" style="height: 250px; width: 250px; ">

          <div class="mx-auto text-center">
                         

             <!-- 파일 경로 설정 버튼 -->
            <div class="imgfile btn btn-primary m-3" style="position: relative; overflow: hidden;">
				<b >이미지 변경</b>
			 	<input type="file" name="imgfile" 
				style="position: absolute; font-size: 0px; opacity: 0; right: 0; top: 0; cursor:pointer; height: 36px; width: 109px;"
				required="required"/>
			</div>
            
            <!-- 임시 전송 버튼 --> 
            <button class="btn btn-warning m-3">
              <b>적용</b>
            </button>

            <!-- 이미지 삭제 버튼 -->
            <a class="btn btn-secondary m-3"  href="/mypage/profile.do" title="기본 이미지로 변경">
              <b>이미지 삭제</b>
            </a>
          </div>
        </div>
        </form>
        
        
        <div class="col-md-6">
       
          <ul class="my-4">
            <li class="my-2">
              <h5><b>아이디   :</b>&nbsp;&nbsp;${requestScope.userinfo.userId }</h5>
            </li>
            <li class="my-2">
              <h5><b>생년월일   :</b>&nbsp;&nbsp;${requestScope.userinfo.userBirth }</h5>
            </li>
            <li class="my-2">
              <h5><b>이메일   :</b>&nbsp;&nbsp;${requestScope.userinfo.userEmail }</h5>
            </li>
            <li class="my-2">
              <h5><b>연락처   :</b>&nbsp;&nbsp;${requestScope.userinfo.userPhone }</h5>
            </li>
            <li class="my-2">
              <h5><b> &nbsp;주 소   :</b>&nbsp;&nbsp;${requestScope.userinfo.userAddress }</h5>
            </li>
          </ul>
          <div class="mx-auto text-center" style="margin-top: 3.8rem!important;">
            <a class="btn btn-primary m-3" href="/mypage/info.do" >
              <b class="p-0 text-center">회원정보 수정</b>
            </a>
          </div>
         
        </div>
      </div>
    </div>
  </div>
  <hr>
  <div class="py-3">
    <div class="container" id="activeC">
      <h3 class="my-4">
        <b>활동 정보</b>
      </h3>
      <div class="row">
        <div class="col-md-4">
          <img class="img-fluid d-block mx-auto" src="./img/2.jpg" width="80" height="80">
          <h4 class="display-7 text-center my-1"><a href="/basket/basket.do">${requestScope.cntCartList }</a></h4>
        </div>
        <div class="col-md-4">
          <img class="img-fluid d-block mx-auto" src="./img/3.jpg" width="80" height="80">
          <h4 class="display-7 text-center my-1"><a href="/mypage/itlist.do">${requestScope.cntIntList }</a></h4>
        </div>
        <div class="col-md-4">
          <img class="img-fluid d-block mx-auto" src="./img/4.jpg" width="80" height="80">
          <h4 class="text-center display-7 my-1"><a href="/mypage/result/usergrade.jsp">

			<c:if test="${requestScope.userinfo.userGrade==1 }">일반 회원</c:if>  
          	<c:if test="${requestScope.userinfo.userGrade==2 }">우수 회원</c:if>
          	<c:if test="${requestScope.userinfo.userGrade==3 }">에디터</c:if>
			<c:if test="${requestScope.userinfo.userGrade==4 }">관리자</c:if>

			</a></h4>
        </div>
      </div>
    </div>
  </div>
  <hr>
  <div class="py-3">
    <div class="container">
      <div class="row py-4">
        <div class="col-md-6 text-center">
          <a class="btn btn-primary m-2 w-25" href="/mypage/editor.do"><b>에디터 신청</b></a>
        </div>
        <div class="col-md-6 text-center">
          <a class="btn btn-secondary m-2 w-25" href="/mypage/delete.do"><b>회원 탈퇴</b></a>
        </div>
      </div>
    </div>
  </div>