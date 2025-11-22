<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Flipkart | Login</title>
  <style>
    body {
      margin: 0;
      font-family: Arial, sans-serif;
      background-color: #f1f3f6;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }
    .login-box {
      width: 350px;
      background: white;
      border-radius: 8px;
      box-shadow: 0 2px 8px rgba(0,0,0,0.2);
      overflow: hidden;
      display: flex;
    }
    .left-panel {
      background-color: #2874f0;
      color: white;
      width: 40%;
      padding: 20px;
      display: flex;
      flex-direction: column;
      justify-content: center;
    }
    .left-panel h2 {
      font-size: 22px;
      margin: 0 0 10px;
    }
    .left-panel p {
      font-size: 14px;
      opacity: 0.9;
    }
    .right-panel {
      width: 60%;
      padding: 20px;
      display: flex;
      flex-direction: column;
      justify-content: center;
    }
    .right-panel input {
      width: 100%;
      padding: 10px;
      margin: 10px 0;
      border: 1px solid #ccc;
      border-radius: 4px;
      font-size: 14px;
    }
    .login-btn {
      background-color: #fb641b;
      border: none;
      padding: 12px;
      color: white;
      font-size: 16px;
      border-radius: 4px;
      cursor: pointer;
      margin-top: 10px;
    }
    .login-btn:hover {
      background-color: #e65a16;
    }
    .signup-text {
      text-align: center;
      margin-top: 15px;
      font-size: 14px;
    }
    .signup-text a {
      color: #2874f0;
      text-decoration: none;
      font-weight: bold;
    }
  </style>
</head>
<body>

  <div class="login-box">
    <div class="left-panel">
      <h2>Login</h2>
      <p>Get access to your Orders, Wishlist and Recommendations</p>
    </div>

    <div class="right-panel">
      <form action="loginValidation" method="post">
        <input type="text" name="username" placeholder="Enter Username" required />
        <input type="password" name="password" placeholder="Enter Password" required />
        <button type="submit" class="login-btn">Login</button>
      </form>
      <div class="signup-text">
        New to Flipkart? <a href="#">Create an account</a>
      </div>
    </div>
  </div>

</body>
</html>
