<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<style>
	form{
		width:510px;
	}
	fieldset{
		width:400px;
		margin: 0 auto;
		padding:15px;
		border:1px solid #976451;
	}	
	legend{
		color:white;
		font-size:18px;
		font-weight: bold;
	}
	p{
		margin-bottom: 10px;
	}
	p:last-child{
		text-align: center;
	}
	label{
		width:100px;
		display: inline-block;
		color:white;
		font-size:18px;
		font-weight: bold;
	}
	p:last-child input{
		padding:3px;
		background-color: #FFC8B4;
		border: 0.5px solid #976451;
		font-size: 16px;
		font-weight: bold;
		color:white;
		border-radius: 5px;
	}
</style>
<section>
	<form action = "loginPost" method = "post">
		<fieldset>
			<legend>로그인</legend>
			<p>
				<label>아이디</label>
				<input type = "text" name = "userid">
			</p>
			<p>
				<label>비밀번호</label>
				<input type = "password" name = "userpw">
			</p>
			<p>
				<input type = "submit" value = "로그인">
			</p>
		</fieldset>
	</form>
	<c:if test="${failLogin ==null }">
		<script>
			alert("로그인에 실패하였습니다.");
		</script>
		<% session.removeAttribute("failLogin"); %>
	</c:if>
</section>
<%@ include file="../include/footer.jsp"%>