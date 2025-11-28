<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>
</head>
<body>

	<h2>Add Product</h2>
	
	<form action="saveProduct" method="post">
	
		<input type="text" name="productId" placeholder="Enter Product ID"><br>
		<input type="text" name="productName" placeholder="Enter Product Name"><br>
		<input type="number" name="productPrice" placeholder="Enter Product Price"><br>
		<input type="text" name="productDescription" placeholder="Enter Product Description"><br>
		<input type="number" name="productQuantity" placeholder="Enter Product Quantity"><br>
		
		<input type="submit" value="Save Product">
		
	</form>

</body>
</html>