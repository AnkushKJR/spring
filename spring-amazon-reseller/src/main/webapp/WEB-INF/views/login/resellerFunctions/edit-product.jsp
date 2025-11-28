<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Product</title>
</head>
<body>

<h2>Edit Product</h2>

<form action="updateProduct" method="post">

    <label>Product ID:</label><br>
    <input type="text" name="productId" value="<%= request.getAttribute("product") != null ? ((com.practice.login.bean.Product)request.getAttribute("product")).getProductId() : "" %>" readonly><br><br>

<%
com.practice.login.bean.Product p = (com.practice.login.bean.Product) request.getAttribute("product");
%>

    <label>Name:</label><br>
    <input type="text" name="productName" value="<%= p.getProductName() %>" required><br><br>

    <label>Price:</label><br>
    <input type="number" name="productPrice" step="0.01" value="<%= p.getProductPrice() %>" required><br><br>

    <label>Quantity:</label><br>
    <input type="number" name="productQuantity" value="<%= p.getProductQuantity() %>" required><br><br>

    <label>Description:</label><br>
    <textarea name="productDescription"><%= p.getProductDescription() %></textarea><br><br>

    <input type="submit" value="Update Product">

</form>

<br>
<a href="listProducts">Back</a>

</body>
</html>
