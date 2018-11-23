<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

</head>
<body>
<!-- logo -->
<div class="container">
	<div class="row">
		<div class="col text-center">
			<img src="/include/img/3.jpg" class="img-fluid" alt="Responsive image" />
		</div>
	</div>
</div> <!-- end of logo -->

<!-- navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom border-info">
  <a class="navbar-brand mx-5" href="#">ZipdelE</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse text-center" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active mr-3">
        <a class="nav-link" href="/zipdlee/main.do">Home</a>
      </li>
      <li class="nav-item mr-3">
        <a class="nav-link" href="/intspace/intspace.do">Magazine</a>
      </li>
      <li class="nav-item mr-3">
        <a class="nav-link" href="/interior/interior.do">Interior</a>
      </li>
      <li class="nav-item mr-3">
        <a class="nav-link" href="/community/reformlist.do">Community</a>
      </li>
      <li class="nav-item mr-3">
        <a class="nav-link" href="/store/storepaging.do">Store</a>
      </li>
      <li class="nav-item  mr-3 dropdown">
        <a class="nav-link dropdown-toggle" id="navbarDropdown" href=""  data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          My Page
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="/mypage/mypage.do">내 정보</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="/mypage/itlist.jsp">내 견적</a>
          <a class="dropdown-item" href="/basket/basket.do">장바구니</a>
        </div>
      </li>
      
    </ul>
    
	<!-- 로그인일때 환영 메세지 호출 -->
  	<c:if test="${sessionScope.login}">
  	<b><a href="/mypage/info.do">${sessionScope.username }</a></b><small>&nbsp;님 환영합니다.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</small>
  	</c:if> 

    <a href="/mypage/mypage.do"><img class="icon mr-4" id="user" title="내 정보" src="/icon/user.png"></a>
	<a href="/basket/basket.do"><img class="icon mr-4" id="cart" title="장바구니" src="/icon/cart.png"></a>
	<!-- 비로그인 상태일때 로그인 버튼 보여주기 -->
	<c:if test="${not sessionScope.login}">
	<a href="/login/login.do"><img class="icon mr-5" id="login" title="로그인" src="/icon/login.png"></a>
	</c:if>
	<!-- 로그인일때 로그아웃버튼 보여주기 -->
	<c:if test="${sessionScope.login}">
	<a href="/login/logout.do"><img class="icon mr-5" id="logout" title="로그아웃" src="/icon/logout.png"></a>
	</c:if>
	
  </div>
</nav> <!-- end of navbar -->