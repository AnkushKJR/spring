<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Login Successful | Zepto</title>
<style>
  body {
    margin: 0;
    font-family: Arial, sans-serif;
    background: #f3f0ff;
  }

  .header {
    background: #4a148c;
    padding: 20px;
    color: white;
    text-align: center;
    font-size: 26px;
    font-weight: bold;
    letter-spacing: 1px;
    box-shadow: 0 2px 10px rgba(0,0,0,0.2);
  }

  .container {
    max-width: 1000px;
    margin: 40px auto;
    background: white;
    padding: 35px;
    border-radius: 18px;
    box-shadow: 0 4px 18px rgba(0,0,0,0.12);
  }

  h2 {
    color: #4a148c;
    font-size: 30px;
    margin-bottom: 10px;
  }

  p {
    color: #444;
    font-size: 18px;
    margin-bottom: 25px;
  }

  .products {
    display: grid;
    grid-template-columns: repeat(auto-fill, minmax(220px, 1fr));
    gap: 20px;
    margin-top: 30px;
  }

  .product-card {
    background: #faf7ff;
    border-radius: 14px;
    padding: 20px;
    text-align: center;
    box-shadow: 0 2px 8px rgba(0,0,0,0.12);
    transition: 0.3s;
  }

  .product-card:hover {
    transform: translateY(-4px);
    box-shadow: 0 4px 14px rgba(0,0,0,0.15);
  }

  .product-card img {
    width: 120px;
    border-radius: 10px;
    margin-bottom: 10px;
  }

  .product-card h3 {
    font-size: 20px;
    margin: 8px 0;
    color: #333;
  }

  .product-card p {
    font-size: 16px;
    color: #555;
    margin-bottom: 12px;
  }

  .btn {
    background: #4a148c;
    color: white;
    padding: 10px 22px;
    border-radius: 10px;
    font-size: 16px;
    text-decoration: none;
    transition: 0.3s;
    font-weight: bold;
  }

  .btn:hover {
    background: #6a1b9a;
  }
</style>
</head>
<body>
  <div class="header">Zepto</div>

  <div class="container">
    <h2>Login Successful!</h2>
    <p>Welcome back! Here are today's fresh picks:</p>

    <div class="products">
      <div class="product-card">
        <img src="https://via.placeholder.com/150" />
        <h3>Fresh Apples</h3>
        <p>₹120 / kg</p>
        <a href="#" class="btn">Add to Cart</a>
      </div>

      <div class="product-card">
        <img src="https://via.placeholder.com/150" />
        <h3>Organic Milk</h3>
        <p>₹65 / litre</p>
        <a href="#" class="btn">Add to Cart</a>
      </div>

      <div class="product-card">
        <img src="https://via.placeholder.com/150" />
        <h3>Bread Loaf</h3>
        <p>₹40</p>
        <a href="#" class="btn">Add to Cart</a>
      </div>

      <div class="product-card">
        <img src="https://via.placeholder.com/150" />
        <h3>Eggs Pack (12)</h3>
        <p>₹78</p>
        <a href="#" class="btn">Add to Cart</a>
      </div>
    </div>
  </div>
</body>
</html>
