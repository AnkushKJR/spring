<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Zepto - Welcome</title>
  <style>
    body {
      margin: 0;
      font-family: Arial, sans-serif;
      background: #f5f5f5;
    }

    .header {
      background: #4a148c;
      padding: 20px;
      color: white;
      text-align: center;
      font-size: 28px;
      font-weight: bold;
      letter-spacing: 1px;
      box-shadow: 0 2px 10px rgba(0,0,0,0.2);
    }

    .container {
      max-width: 900px;
      margin: 60px auto;
      background: white;
      padding: 40px;
      border-radius: 16px;
      box-shadow: 0 4px 20px rgba(0,0,0,0.1);
      text-align: center;
    }

    h2 {
      color: #333;
      font-size: 30px;
      margin-bottom: 10px;
    }

    p {
      color: #555;
      font-size: 18px;
      margin-bottom: 30px;
    }

    .login-btn {
      display: inline-block;
      background: #4a148c;
      color: white;
      padding: 14px 28px;
      border-radius: 10px;
      text-decoration: none;
      font-size: 18px;
      font-weight: bold;
      transition: 0.3s;
    }

    .login-btn:hover {
      background: #6a1b9a;
    }

    .hero {
      margin-top: 40px;
    }

    .hero img {
      width: 80%;
      max-width: 350px;
      border-radius: 20px;
      box-shadow: 0 4px 18px rgba(0,0,0,0.15);
    }
  </style>
</head>

<body>
  <div class="header">Zepto</div>

  <div class="container">
    <h2>Welcome to Zepto!</h2>
    <p>Your fast grocery delivery partner. Order anything you need in minutes.</p>

    <a href="login" class="login-btn">Login</a>

    <div class="hero">
      <img src="https://via.placeholder.com/350x220.png?text=Zepto+Grocery+Delivery" alt="Grocery Delivery" />
    </div>
  </div>
</body>
</html>
