<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Reseller Account</title>
</head>
<body>
	
	<form action="createResellerProfile" method="post">
		
		<input type="text" name="registeredCompanyName" placeholder="Enter Registered Company Name"> <br>
		<input type="text" name="address" placeholder="Enter Address"> <br>
		<input type="text" name="gstNum" placeholder="Enter GST Number"> <br>
		<input type="text" name="password" placeholder="Enter Password"> <br>
		<input type="submit" value="Create">
		
	</form>
	
</body>
</html>