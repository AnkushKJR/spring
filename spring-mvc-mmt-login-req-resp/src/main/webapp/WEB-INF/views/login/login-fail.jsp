<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Failed | Amazon Style</title>

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

    .error {
        font-size: 20px;
        font-weight: bold;
        color: #cc0000;
        margin-bottom: 15px;
    }

    .message {
        font-size: 14px;
        margin-bottom: 20px;
        color: #333;
    }

    .btn {
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
        <p class="error">✘ Login Failed</p>
        <p class="message">Username or Password is incorrect. Please try again.</p>

        <a href="login" class="btn">Login Again</a>
    </div>

</body>
</html>
