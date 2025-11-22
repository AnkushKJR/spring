<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Flipkart | Login Failed</title>
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

    .fail-box {
      width: 380px;
      background: white;
      border-radius: 10px;
      text-align: center;
      padding: 30px 20px;
      box-shadow: 0 2px 8px rgba(0, 0, 0, 0.2);
    }

    .fail-box h2 {
      color: #d32f2f;
      font-size: 26px;
      margin-bottom: 10px;
    }

    .fail-box p {
      font-size: 16px;
      color: #444;
      margin-bottom: 20px;
    }

    .retry-btn {
      background-color: #2874f0;
      color: white;
      padding: 12px 20px;
      border: none;
      font-size: 15px;
      border-radius: 5px;
      cursor: pointer;
      text-decoration: none;
      display: inline-block;
    }

    .retry-btn:hover {
      background-color: #1e5ec8;
    }

    .icon {
      font-size: 50px;
      color: #d32f2f;
      margin-bottom: 15px;
    }
  </style>
</head>
<body>

  <div class="fail-box">
    <div class="icon">&#9888;</div>
    <h2>Login Failed!</h2>
    <p>Incorrect username or password.<br>Please try again.</p>
    <a href="login" class="retry-btn">Try Again</a>
  </div>

</body>
</html>