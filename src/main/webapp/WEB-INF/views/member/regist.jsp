<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "regist" method = "post">
		<fieldset>
			<legend>회원가입</legend>
			<p>
				<label>아이디</label>
				<input type = "text" name = "userid">
			</p>
			<p>
				<label>비밀번호</label>
				<input type = "password" name = "userpw">
			</p>
			<p>
				<label>비밀번호 확인</label>
				<input type = "password" name = "pwok">
			</p>
			<p>
				<label>이름</label>
				<input type = "text" name = "usernm">
			</p>
			<p>
				<label>이메일</label>
				<input type = "email" name = "email">
			</p>
			<p>
				<label>전화번호</label>
				<input type = "tel" name = "tel">
			</p>
			<p>
				<input type = "submit" value = "등록">
			</p>
		</fieldset>
	</form>
</body>
</html>