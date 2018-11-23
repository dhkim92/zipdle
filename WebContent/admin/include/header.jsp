<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous" />


<style type="text/css">



</style>
</head>
<body>
<!-- logo -->
<div class="container">
	<div class="row">
		<div class="col text-center">
			<img src="/admin/include/img/3.jpg" class="img-fluid" alt="Responsive image" />
		</div>
	</div>
</div> <!-- end of logo -->

<!-- navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-warning">
  <a class="navbar-brand mx-5" href="/admin/adminmain.do">
  <b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Administrator&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse text-center" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item mr-3">
        <a class="nav-link" href="/admin/usergrade.do">UserGrade</a>
      </li>
 
      <li class="nav-item mr-3">
        <a class="nav-link" href="/admin/editor.do">Editor</a>
      </li>

      <li class="nav-item mr-3">
        <a class="nav-link" href="/admin/company.do">Interior</a>
      </li>
      <li class="nav-item mr-3">
        <a class="nav-link" href="/admin/editContest.do">Community</a>
      </li>
      <li class="nav-item mr-3">
        <a class="nav-link" href="/admin/EditStore.do">Store</a>
      </li>
    
    <!-- 마이페이지 활용 안함
      <li class="nav-item  mr-3 dropdown">
        <a class="nav-link dropdown-toggle" href="/SEMI/myPage/mypage.jsp" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          My Page
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="/SEMI/myPage/mypage.jsp">내 정보</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="/SEMI/myPage/itlist.jsp">내 견적</a>
          <a class="dropdown-item" href="/SEMI/myPage/basket.jsp">장바구니</a>
        </div>
      </li>
     -->  
    </ul>
    <c:if test="${sessionScope.login}">
  	<b><a href="/mypage/info.do">${sessionScope.username}&nbsp;</a></b><small>님 환영합니다.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</small>
  	</c:if>
   <!--  <a href="/SEMI/myPage/mypage.jsp"><img class="icon mr-3" id="user" title="내 정보" src="/SEMI/icon/user.png"></a>
	<a href="/SEMI/basket/basket_main.jsp"><img class="icon mr-3" id="cart" title="장바구니" src="/SEMI/icon/cart.png"></a>
	<a href="/login/login.do"><img class="icon mr-5" id="login" title="로그인" src="/SEMI/icon/login.png"></a> -->
  </div>
</nav> <!-- end of navbar -->