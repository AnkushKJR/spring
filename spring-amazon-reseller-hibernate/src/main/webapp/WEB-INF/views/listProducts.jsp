<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products List</title>
</head>
<body>

<h2>Your Product List</h2>

<a href="addProduct">Add New Product</a><br><br>

<table border="1" cellpadding="7">
    <tr>
        <th>Name</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Actions</th>
    </tr>

    <c:forEach var="p" items="${list}">
        <tr>
            <td>${p.name}</td>
            <td>${p.qty}</td>
            <td>${p.price}</td>
            <td>
                <a href="edit/${p.id}">Edit</a> |
                <a href="delete/${p.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>

</table>

<br>
<a href="home.jsp">Back to Home</a>

</body>
</html>
