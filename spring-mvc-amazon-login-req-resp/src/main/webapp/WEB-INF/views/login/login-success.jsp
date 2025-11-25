<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Success | Amazon Style</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        margin: 0;
        padding: 0;
    }

    .container {
        width: 350px;
        margin: 70px auto;
        background: #fff;
        border: 1px solid #ddd;
        padding: 25px 30px;
        border-radius: 8px;
        text-align: center;
    }

    .logo {
        text-align: center;
        margin-top: 30px;
    }

    .logo h2 {
        font-family: 'Arial Black';
        color: #111;
        margin-bottom: 5px;
    }

    .success {
        font-size: 20px;
        font-weight: bold;
        color: #007600;
        margin-bottom: 15px;
    }

    .session-box {
        margin-top: 10px;
        padding: 10px;
        background: #f9f9f9;
        border-radius: 5px;
        border: 1px solid #ddd;
        font-size: 14px;
    }

    .btn {
        margin-top: 20px;
        display: inline-block;
        background-color: #f0c14b;
        border: 1px solid #a88734;
        padding: 10px 20px;
        font-size: 15px;
        border-radius: 4px;
        text-decoration: none;
        color: #111;
    }

    .btn:hover {
        background-color: #e2b33b;
    }
</style>

</head>
<body>

    <div class="logo">
        <h2>amazon<span style="color:#f0c14b;">.in</span></h2>
    </div>

    <div class="container">
        <p class="success">✔ Login Successful</p>

        <div class="session-box">
            <p><strong>Your Session ID:</strong></p>
            <p>${sessionId}</p>
        </div>

        <a href="login" class="btn">Go to Home</a>
    </div>

</body>
</html>
