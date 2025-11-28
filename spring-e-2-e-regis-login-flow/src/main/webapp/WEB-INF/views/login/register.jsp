<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
	<h2>Register below</h2>
	
	<form action="registerUserDetails" method="post"> <br>
		<input type="text" name="fName" placeholder="Enter First Name"> <br>
		<input type="text" name="lName" placeholder="Enter Last Name"> <br>
		<input type="text" name="phoneNumber" placeholder="Enter Phone Number"> <br>
		<input type="text" name="address" placeholder="Enter address"> <br>
		<input type="submit" value="register">
	</form>

</body>
</html>