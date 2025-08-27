<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h1>회원가입</h1>
	<hr>
	<form action="memberJoinOk" method="post">
		아이디 : <input type="text" name="id"> <br><br>
		비밀번호 : <input type="password" name="password"> <br><br>
		비밀번호 확인 : <input type="password" name="confirmPassword"> <br><br>
		이름 : <input type="text" name="name"> <br><br>
		나이 : <input type="text" name="age"> <br><br>
		이메일 : <input type="text" name="email"> <br><br>
		<input type="submit" value="가입하기"> 
	</form>
	<hr>
	<c:if test="${not empty signupError }">
		<span style="color: red;">${signupError }</span><br>
		<ul>
			<c:forEach items="${errorMsg }" var="e">
				<li>${errorMsg }</li>
			</c:forEach>
		</ul>	
	</c:if>
</body>
</html>