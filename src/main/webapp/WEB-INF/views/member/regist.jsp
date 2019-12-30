<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.err{
		color:red;
		font-size: 12px;
		display: none;
	}
	
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
	<form action = "regist" method = "post">
		<fieldset>
			<legend>회원가입</legend>
			<p id = "idP">
				<label>아이디</label>
				<input type = "text" name = "userid" placeholder="영문+숫자 6자 이상 15자 이내">
				<button type = "button" id="ok" data-chek = "false">중복확인</button>
				<span class = "err">※ 아이디를 입력하세요 ※</span>
			</p>
			<p>
				<label>비밀번호</label>
				<input type = "password" name = "userpw">
				<span class = "err">※ 비밀번호를 입력하세요 ※</span>
			</p>
			<p>
				<label>비밀번호 확인</label>
				<input type = "password" name = "pwok">
				<span class = "err">※ 비밀번호 확인을 입력하세요 ※</span>
			</p>
			<p>
				<label>이름</label>
				<input type = "text" name = "usernm">
				<span class = "err">※ 이름을 입력하세요 ※</span>
			</p>
			<p>
				<label>이메일</label>
				<input type = "email" name = "email">
				<span class = "err">※ 이메일을 입력하세요 ※</span>
			</p>
			<p>
				<label>전화번호</label>
				<input type = "tel" name = "tel">
				<span class = "err">※ 전화번호를 입력하세요 ※</span>
			</p>
			<p>
				<input type = "submit" value = "등록">
			</p>
		</fieldset>
	</form>
<script>
	$("form").submit(function(){
		var userid = $("input[name='userid']").val(); 
		var userpw = $("input[name='userpw']").val();
		var pwok = $("input[name='pwok']").val();
		var ok = $("#ok").attr("data-chek");
		var count=0 ;
		$("input[name]").not("input[name='userid']").each(function(i,obj){
			if($(obj).val() == ""){
				$(obj).next(".err").css("display","block");
				//return false;//each함수 나감
				count++;
			}
		})
		if(count > 0){
			return false;
		}               
		
		//아이디 입력칸이 비었을 경우
		if(userid == ""){
			$("input[name='userid']").next().next(".err").css("display","block");
			return false;
		}
		//비밀번호와 비밀번호 확인이 다를 경우
		if(userpw != pwok){
			alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
			return false;
		}
		
		//중복확인을 안눌렀을 경우
		if(ok == "false"){
			alert("중복확인을 하십시오.");
			return false;
		}
		
	})
	var idcheck = 0;
	
	$("#ok").click(function(){
		$(this).attr("data-chek","true");
		
		var userid = $("input[name='userid']").val(); 
		var userpw = $("input[name='userpw']").val();
		var pwok = $("input[name='pwok']").val();
		var usernm = $("input[name='usernm']").val();
		var email = $("input[name='email']").val();
		var tel = $("input[name='tel']").val();
		
		
		
		$.ajax({
			url:"chek",
			type:"get",
			data:{"userid":userid},
			dataType:"text",
			success:function(res){
				console.log(res);
				$(".okID").remove();
				var $span = $("<span>").addClass("okID")
										.css("color","red")
										.css("font-size","12px");
				
				if(res=="success"){
					$("#idP").append($span.text("사용가능한 아이디입니다."));
				}else if(res=="fail"){
					$("#idP").append($span.text("이미 존재하는 아이디 입니다."));
					return false;
				}
			},
			error:function(e){
				console.log(e);
			}
		})
	})
</script>	
	
</body>
</html>