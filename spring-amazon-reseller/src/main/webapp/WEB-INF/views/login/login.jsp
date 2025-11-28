<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	
	<p style="color:red">${msg}</p>
	
	<form action="loginResellerProfile" method="post">
	
		<input type="text" name="userId" placeholder="Enter User ID"> <br>
		<input type="text" name="password" placeholder="Enter Password"> <br>
		<input type="submit" value="login">
		
	</form>
	
</body>
</html>