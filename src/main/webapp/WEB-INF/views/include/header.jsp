<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style>
	html,body{
		height: 100%;
		background: #FFC8B4;
	}
	*{
		margin: 0;
		padding:0;
	}
	ul{
		list-style: none;
	}
	a{
		text-decoration: none;
		color:white;
	}
	header{
		width:25%;
		height: 100%;
		background: #976451;
		/* padding:20px; */
		overflow: hidden;
		position: relative;
		float: left;
	}
	div#right{
		float: left;
		width: 75%;
		height: 100%;
	}
	section{
		width: 500px;
		min-height: 83.1%;
		margin: 50px auto 0; 
	}
	div#mainHeader{
		width: 100%;
		float: left;
		height: 70%;
	}
	div#mainHeader > p{
		border-bottom: 1px solid white;
		padding-bottom: 15px;
	}
	div#mainHeader > p >a{
		font-size:25px;
		font-weight: bold;
	}
	div#mainHeader > nav > ul > li{
		padding:10px;
	}
	div#mainHeader > nav > ul > li > a{
		font-weight: bold;
		font-size:19px;
		display: block;
	}
	#hiddenMenu{
		float: left;
		height: 30%;
	}
	#hiddenMenu > span{
		display:block;
		width: 30px;
		height:30px;
		position: absolute;
		bottom: 20px;
		right: 20px;
		z-index: 100;
	}
	#hiddenMenu > span > img{
		width: 30px;
		height:30px;
		transition: all ease 1s;
	}
	#hiddenBox{
		display: none;
		width: 190px;
		height: 250px;
		background-color: #664539;
		position: absolute;
		bottom: 15px;
		right: 15px;
		padding:5px;
	}
	#hiddenBox li {
		border-bottom: 1px solid white;
		padding:10px 5px;
		color:white;
		font-size:14px;
	}
	#hiddenBox li a.user{
		font-size:18px;
		font-weight: bold;
	}
	#hiddenBox li a.loginout{
		margin-left: 10px;
		forn-size:14px;
	}
	#hiddenBox li a.loginout:hover{
		text-decoration: underline;
	}
</style>

</head>
<body>
<header>
	<div id = "mainHeader">
		<p><a href = "/">GALLERY UPLOAD PROJECT</a></p>
		<nav>
			<ul>
				<li>
					<a href = "image/listAll">Gallery</a>
				</li>
			</ul>
		</nav>
	</div>
	
	<div id = "hiddenMenu">
		<span id="menuIcon"><img src = "${pageContext.request.contextPath }/resources/image/plus_add_sign_navigation_menu-256.png"></span>
		<div id ="hiddenBox">
			<ul id = "h_SubMenu">
				<c:if test="${Auth == null }">
					<li>
						<a href = "auth/login">로그인</a>
					</li>
					<li>
						<a href = "member/reist">회원가입</a>
					</li>
				</c:if>
				<c:if test="${Auth != null }">
					<li>
						<a href = "#" class = "user">${Auth }</a>님 <a href = "auth/logout" class = "loginout">로그아웃</a>
					</li>
					<li>
						<a href = "">My Gallery</a>
					</li>
				</c:if>
			</ul>
		</div>
	</div>
</header>
<div id = "right">
<script>
	$("#hiddenMenu > span > img").click(function(){
		var t = $("#hiddenBox").css("display");
		
		if(t == "none"){
			$(this).css("transform","rotate( 45deg )");
			$("#hiddenBox").css("display","block");
		}else if(t == "block"){
			$(this).css("transform","rotate( 0deg )");
			$("#hiddenBox").css("display","none");
		}
		
		
	})
</script>