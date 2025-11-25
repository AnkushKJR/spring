<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login | Amazon Style</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        margin: 0;
        padding: 0;
    }

    .container {
        width: 350px;
        margin: 60px auto;
        background: #fff;
        border: 1px solid #ddd;
        padding: 25px 30px;
        border-radius: 8px;
    }

    .logo {
        text-align: center;
        margin-bottom: 20px;
    }

    .logo img {
        width: 120px;
    }

    label {
        font-size: 14px;
        font-weight: bold;
    }

    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 10px;
        margin-top: 5px;
        margin-bottom: 18px;
        border: 1px solid #a6a6a6;
        border-radius: 4px;
        font-size: 14px;
    }

    .login-btn {
        width: 100%;
        background-color: #f0c14b;
        border: 1px solid #a88734;
        padding: 10px;
        font-size: 15px;
        border-radius: 4px;
        cursor: pointer;
    }

    .login-btn:hover {
        background-color: #e2b33b;
    }

    .help-text {
        font-size: 12px;
        margin-top: 15px;
        color: #0066c0;
    }
</style>

</head>
<body>

    <div class="logo">
        <!-- Amazon-like text logo -->
        <h2 style="font-family: 'Arial Black'; color: #111;">amazon<span style="color:#f0c14b;">.in</span></h2>
    </div>

    <div class="container">

        <form action="loginValidation" method="post">

            <label>Username</label>
            <input type="text" name="username" placeholder="Enter Username" required>

            <label>Password</label>
            <input type="password" name="password" placeholder="Enter Password" required>

            <input type="submit" class="login-btn" value="Login">

        </form>

        <div class="help-text">
            <a href="#">Forgot Password?</a>
        </div>

    </div>

</body>
</html>
