<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Welcome – MakeMyTrip Profile</title>

<style>
    body { 
        margin: 0;
        font-family: 'Segoe UI', Arial, sans-serif;
        background: #eef5ff;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .card {
        background: white;
        width: 420px;
        padding: 35px;
        text-align: center;
        border-radius: 14px;
        box-shadow: 0 4px 18px rgba(0,0,0,0.12);
    }

    h2 {
        margin-bottom: 10px;
        color: #007bff;
        font-size: 28px;
    }

    p {
        font-size: 17px;
        color: #333;
        margin: 10px 0;
    }

    .user-id-box {
        background: #f0f6ff;
        border-left: 4px solid #007bff;
        padding: 12px;
        margin-top: 15px;
        font-weight: 600;
        font-size: 18px;
        border-radius: 6px;
    }

    .home-btn {
        margin-top: 25px;
        display: inline-block;
        padding: 12px 20px;
        background: #007bff;
        color: white;
        border-radius: 8px;
        text-decoration: none;
        font-weight: bold;
        font-size: 16px;
    }

    .home-btn:hover {
        background: #0069d9;
    }
</style>
</head>

<body>

<div class="card">
    <h2>Welcome to MakeMyTrip!</h2>

    <p>Your profile has been created successfully.</p>

    <div class="user-id-box">
        User ID: ${userId}
    </div>

    <a href="index.jsp" class="home-btn">Go to Home</a>
</div>

</body>
</html>
