<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Product</title>
</head>
<body>

<h2>Edit Product</h2>

<form action="/update" method="post">

    <input type="hidden" name="id" value="${p.id}">

    Name: <input type="text" name="name" value="${p.name}"><br><br>
    Quantity: <input type="number" name="qty" value="${p.qty}"><br><br>
    Price: <input type="text" name="price" value="${p.price}"><br><br>

    <button type="submit">Update</button>
</form>

<br>
<a href="/listProducts">Back</a>

</body>
</html>
