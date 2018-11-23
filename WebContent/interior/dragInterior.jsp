<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./drag/CSSLoader.jsp" %>

<style>

.test {
	height:600px;
	width :100%;
	overflow : hidden;
}
div .post {
	float:left;
	border:1px solid black;
    
}

}
div .small{
	float:left;
	width:200px;
    height:200px;
	padding:10px 0px 0px 20px;
    background-color:#f9d716 ;
    border:1px solid black;
    box-shadow:2px 2px 2px;
    overflow: hidden;

}

div.color {
    background-color:salmon;
}

textarea {
  background-color: #f9d716  ;
/*   #f9d716 */
  border: none;
}


</style>

<%@ include file="../include/header.jsp" %>





</head>
<body>

<div class="container">
	<div class="row m-3">
		<h1>인테리어 설계를 마음껏 해보세요!</h1>
		
	</div>
	<a class="btn btn-warning m-2" href="/interior/interior.do">뒤로 가기</a>
	<div class="download d-flex justify-content-end">
	<a class="btn btn-warning m-2"href="/interior/drag.do">새로고침</a>
	<a class="btn btn-warning m-2"href="#" onclick="shotit();">저장</a>
	</div>
	
	<a href="javascript:;" class="button" id="add_new">컴포넌트 추가!</a>
		
	
	<div class="test border border-dark mb-5 h1">
<!-- 		<div class="post door"> -->
<!-- 		    <p>현관</p> -->
<!-- 		</div> -->
		 
<!-- 		<div  class="post room"> -->
<!-- 		    <p>안방</p>     -->
<!-- 		</div> -->
		 
<!-- 		<div  class="post book"> -->
<!-- 		    <p>서재</p> -->
<!-- 		</div> -->
		 
<!-- 		<div class="post toilet"> -->
<!-- 		    <p>화장실</p> -->
<!-- 		</div> -->
<!-- 		<div class="post small"> -->
<!-- 			<p>작은방</p> -->
<!-- 		</div> -->
	</div>
	
	
	
	
	
</div>


<%@include file="./drag/scriptLoader.jsp" %>


<script type="text/javascript">
$(document).ready(function(){
	$(".post").draggable({      // 드래그  
	    cursor:"move",      // 드래그 시 커서모양 
	    stack:".post",      // .post 클래스끼리의 스택 기능 
	    opacity:0.8         // 드래그 시 투명도 
	});

	$(".post").bind("dragstart",function(event, ui){
	    $(this).addClass("color");  //bgi 체인지
	});
	$(".post").bind("dragstop", function(event, ui){
	    $(this).removeClass("color");   //bgi 체인지
	});
});


</script>

<script type="text/javascript">
var img;
var shotit = function() {
	  html2canvas($(".test"), {
	  onrendered: function(canvas) {
		  $(".test").append(canvas);
	      leCanvas = document.getElementsByTagName("canvas")[0];
// 	      var img  = leCanvas.toDataURL("image/png");
	      img  = leCanvas.toDataURL("image/png");
	      
	      img.replace("image/png", "image/octet-stream");
// 	      console.log(img);
// 	      #13a6f5
// 	      '<span style="font:14px normal Helvetica, Arial; font-weight: bold; color:#13a6f5; margin-left:16px">the resulted png:</span> <br />
	      $(".test").html('<img src="'+img+'" download/>');

	      $(".download").append( $("<a>").attr("class","btn btn-warning m-2").attr("href", img).attr("download", "test.png").attr("id", "canvasimg").text('다운로드') );
	  },
	  width: 1400,
	  height: 1000
	  
	 
	});
	  
}
	
</script>

<script>



var noteTemp =  '<div class="post small">'
	+	'<a href="javascript:;" class="btn btn-danger remove">X</a>'
	+ 	'<div class="post_cnt">'
	+		'<textarea class="title h5" placeholder="이름 입력"></textarea>'
	+	'</div> '
	+'</div>';

var noteZindex = 1;
function deleteNote(){
    $(this).parent('.post').fadeOut();
    
//  .hide("puff",{ percent: 133}, 250)   
};

function newNote() {
	  $(noteTemp).hide().appendTo(".test").show("fade", 300).draggable().on('dragstart',
	    function(){
	       $(this).zIndex(++noteZindex);
	    });
	 
		$('.remove').click(deleteNote);
		
	  
		return false; 
	};

$(document).ready(function() {
    
    $(".test").height($(".test").height());
    
    $("#add_new").click(newNote);
    
    $('.remove').click(deleteNote);
    newNote();
	  
    return false;
});


</script>




<%@include file="../include/footer.jsp" %>