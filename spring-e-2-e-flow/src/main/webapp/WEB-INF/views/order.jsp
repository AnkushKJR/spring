<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Page</title>
</head>
<body>

	<form action="placeOrder" method="post">
		<input type="text" name="item" placeholder="Enter Item Name"> <br>
		<input type="text" name="qty" placeholder="Enter Quantity"> <br>
		<input type="text" name="price" placeholder="Enter Price"> <br>
		<input type="text" name="address" placeholder="Enter Address"> <br>
		<input type="submit" value="place order">
	</form>

</body>
</html>