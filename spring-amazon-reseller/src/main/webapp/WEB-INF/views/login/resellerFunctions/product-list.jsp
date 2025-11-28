<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.practice.login.bean.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List Page</title>
</head>
<body>	

<h2>Your Products</h2>

<a href="addProduct">Add New Product</a>
<br><br>

<table border="1" cellpadding="10">
    <tr>
        <th>Product ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Description</th>
        <th>Actions</th>
    </tr>

<%
    // Fetch the list sent from controller
    List<com.practice.login.bean.Product> products = (List<com.practice.login.bean.Product>) request.getAttribute("products");

    if (products != null && !products.isEmpty()) {

        for (Product p : products) {
%>

    <tr>
        <td><%= p.getProductId() %></td>
        <td><%= p.getProductName() %></td>
        <td><%= p.getProductPrice() %></td>
        <td><%= p.getProductQuantity() %></td>
        <td><%= p.getProductDescription() %></td>

        <td>
            <a href="editProduct?id=<%= p.getProductId() %>">Edit</a> |
            <a href="deleteProduct?id=<%= p.getProductId() %>">Delete</a>
        </td>
    </tr>

<%
        }
    } else {
%>

    <tr>
        <td colspan="6">No products available.</td>
    </tr>

<%
    }
%>

</table>

<br>
<a href="home-redirect">Back to Home</a>

</body>
</html>
