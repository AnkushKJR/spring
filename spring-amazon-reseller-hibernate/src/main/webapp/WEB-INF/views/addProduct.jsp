<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>
</head>
<body>

<h2>Add New Product</h2>

<form action="addProduct" method="post">
    Product Name: <input type="text" name="name"><br><br>
    Quantity: <input type="number" name="qty"><br><br>
    Price: <input type="text" name="price"><br><br>
    <button type="submit">Save</button>
</form>

<br>
<a href="home.jsp">Back to Home</a>

</body>
</html>
