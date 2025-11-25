<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Create Profile – MakeMyTrip</title>

<style>
    body {
        margin: 0;
        font-family: 'Segoe UI', Arial, sans-serif;
        background: #f2f6ff;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .container {
        width: 380px;
        background: white;
        padding: 30px;
        border-radius: 12px;
        box-shadow: 0 4px 18px rgba(0,0,0,0.15);
        text-align: center;
    }

    h2 {
        margin-bottom: 20px;
        font-size: 26px;
        color: #0066cc;
    }

    input[type="text"],
    input[type="email"],
    input[type="number"] {
        width: 100%;
        padding: 14px;
        margin-top: 12px;
        font-size: 15px;
        border-radius: 8px;
        border: 1px solid #d2d6e2;
        outline: none;
    }

    input[type="text"]:focus {
        border-color: #0066cc;
        box-shadow: 0 0 4px rgba(0,102,204,0.4);
    }

    .btn {
        width: 100%;
        margin-top: 20px;
        padding: 14px;
        border: none;
        background: #007bff;
        color: white;
        border-radius: 8px;
        font-size: 17px;
        cursor: pointer;
        font-weight: bold;
    }

    .btn:hover {
        background: #0069d9;
    }

    .back-link {
        display: block;
        margin-top: 15px;
        color: #007bff;
        text-decoration: none;
        font-size: 14px;
    }

    .back-link:hover {
        text-decoration: underline;
    }
</style>
</head>

<body>

<div class="container">
    <h2>Create Your Profile</h2>

    <form action="createProfile" method="post">

        <input type="text" name="fName" placeholder="First Name" required>

        <input type="text" name="lName" placeholder="Last Name" required>

        <input type="text" name="email" placeholder="Email" required>

        <input type="text" name="phoneNumber" placeholder="Phone Number" required>

        <input type="submit" class="btn" value="Create Profile">
    </form>

    <a href="index.jsp" class="back-link">← Back to Home</a>
</div>

</body>
</html>
