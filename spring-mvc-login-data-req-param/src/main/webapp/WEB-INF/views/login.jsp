<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Login | Zepto</title>
<style>
  body {
    margin: 0;
    font-family: Arial, sans-serif;
    background: #f3f0ff;
  }

  .header {
    background: #4a148c;
    padding: 18px;
    color: white;
    text-align: center;
    font-size: 26px;
    font-weight: bold;
    box-shadow: 0 2px 10px rgba(0,0,0,0.2);
  }

  .container {
    max-width: 420px;
    margin: 70px auto;
    background: white;
    padding: 35px;
    border-radius: 18px;
    box-shadow: 0 4px 18px rgba(0,0,0,0.12);
  }

  h2 {
    text-align: center;
    margin-bottom: 25px;
    color: #333;
  }

  input[type="text"],
  input[type="password"] {
    width: 100%;
    padding: 14px;
    margin-bottom: 18px;
    border: 1px solid #ccc;
    border-radius: 10px;
    font-size: 16px;
  }

  input[type="submit"] {
    width: 100%;
    padding: 14px;
    background: #4a148c;
    border: none;
    color: white;
    font-size: 18px;
    border-radius: 10px;
    cursor: pointer;
    font-weight: bold;
    transition: 0.3s;
  }

  input[type="submit"]:hover {
    background: #6a1b9a;
  }

  .note {
    text-align: center;
    color: #666;
    margin-top: 12px;
    font-size: 14px;
  }
</style>
</head>
<body>

<div class="header">Zepto Login</div>

<div class="container">
  <h2>Login</h2>

  <form action="loginValidation" method="post">
    <input type="text" name="email" placeholder="Enter email" required>
    <input type="password" name="password" placeholder="Enter password" required>
    <input type="submit" value="Login">
  </form>

  <p class="note">Fast • Simple • Secure</p>
</div>

</body>
</html>