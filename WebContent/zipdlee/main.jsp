<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/CSSLoader.jsp" %>    
<!-- CSS 삽입 -->    
<link rel="stylesheet" href="/interior/css/proto.css?ver=3">
    
    
<%@include file="../include/header.jsp" %>


<!-- carousel -->
<div class="container">
	<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
	  	<ol class="carousel-indicators">
	    	<li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
	    	<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
	    	<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
	  	</ol>
	  	
	  	<!-- slide-item -->
		<div class="carousel-inner">
	    	<div class="carousel-item active">
	      		<img class="d-block w-100" src="../img/firstslide.jpg" alt="First slide">
	      			<div class="carousel-caption d-none d-md-block">
	      				<p>#카페 #식당 #학원 #미용실</p>
	      				<a href="/interior/interior.do"><button class="btn btn-warning"><h5><b>견적 신청하러 가기</b></h5></button></a>
	      			</div>
	    	</div>
	    	<div class="carousel-item">
	      		<img class="d-block w-100" src="../img/secondslide.jpg" alt="Second slide">
	    	</div>
	   		<div class="carousel-item">
	    		<img class="d-block w-100" src="../img/thirdslide.jpg" alt="Third slide">
	    	</div>
		</div>
		
	  	<a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
	    	<span class="carousel-control-prev-icon" aria-hidden="true"></span>
	    	<span class="sr-only">Previous</span>
	  	</a>
	  	<a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
	    	<span class="carousel-control-next-icon" aria-hidden="true"></span>
	    	<span class="sr-only">Next</span>
	 	 </a>
	</div> <!-- end of carousel -->
</div>

<!-- mid-main -->
<div class="container clearfix mt-3">
		<div class="row">
		<!-- left-side -->
		<div class="col-12 col-md-6 float-left mb-3">
			<div>
				<!-- card deck -->
				<div class="card-deck">
					<div class="card pp">
				    	<img class="card-img-top" src="${istop.imgpath }" alt="Card image cap">
				    		<div class="card-body dd" onclick="location.href='/intspace/view.do?intspaceno=${istop.intspaceno}'">
				      			<h5 class="card-title">${istop.title }</h5>
				      				<span class="card-text">${istop.content }</span>
				    		</div>
				    		<div class="card-footer">
				      			<small class="text-muted" onclick="location.href='/intspace/intspace.do'">Magazine</small>
				    		</div>
				  	</div>
				  	<div class="card pp">
				    	<img class="card-img-top" src="${rftop.filePath }" alt="Card image cap">
				    		<div class="card-body dd" onclick="location.href='/community/reform/view.do?idx=${rftop.idx}'">
				      			<h5 class="card-title">${rftop.title }</h5>
				      				<p class="card-text">${rftop.content }</p>
				    		</div>
				    		<div class="card-footer">
				      			<small class="text-muted" onclick="location.href='/community/reform.do'">Community</small>
				    		</div>
				  	</div>
				</div> <!-- end of card deck -->	
			</div><!-- end of magazine information -->
		</div><!-- end of left-side -->
		
		<!-- right-side -->
		<div class="col-12 col-md-6 float-left">
			<div class="embed-responsive embed-responsive-16by9">
  				<iframe class="embed-responsive-item" src="https://www.youtube.com/embed/FqVjoANm17o" allowfullscreen></iframe>
			</div>
		</div><!-- end of right-side -->
		
	</div><!-- end of row -->
</div><!-- end of mid-main -->

<%@include file="../include/scriptLoader.jsp" %>
<!-- 자바스크립트를 여기에 넣어주세요 -->








<%@include file="../include/footer.jsp" %>



