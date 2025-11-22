<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Flipkart | Home</title>
  <style>
    body {
      margin: 0;
      font-family: Arial, sans-serif;
      background-color: #f1f3f6;
    }
    .navbar {
      background-color: #2874f0;
      padding: 15px 30px;
      color: white;
      display: flex;
      justify-content: space-between;
      align-items: center;
    }
    .navbar .logo {
      font-size: 24px;
      font-weight: bold;
    }
    .navbar a {
      color: white;
      text-decoration: none;
      margin-left: 20px;
      font-size: 16px;
    }
    .hero {
      background: url('https://via.placeholder.com/1600x500?text=Big+Sale+Banner') no-repeat center/cover;
      height: 400px;
      display: flex;
      justify-content: center;
      align-items: center;
      color: white;
      font-size: 40px;
      font-weight: bold;
    }
    .products-section {
      padding: 30px;
    }
    .section-title {
      font-size: 24px;
      margin-bottom: 20px;
    }
    .product-grid {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
      gap: 20px;
    }
    .product-card {
      background: white;
      padding: 15px;
      border-radius: 8px;
      text-align: center;
      box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
    }
    .product-card img {
      width: 100%;
      height: 180px;
      object-fit: cover;
      border-radius: 6px;
    }
    .product-card h4 {
      margin: 10px 0;
      font-size: 16px;
    }
    .product-card p {
      color: green;
      font-weight: bold;
      margin: 5px 0;
    }
    .product-card button {
      background-color: #2874f0;
      color: white;
      border: none;
      padding: 10px 15px;
      border-radius: 5px;
      cursor: pointer;
    }
  </style>
</head>
<body>
  <div class="navbar">
    <div class="logo">Flipkart</div>
    <div>
      <a href="login">Login</a>
      <a href="#">Cart</a>
      <a href="#">More</a>
    </div>
  </div>

  <div class="hero">Big Sale is Live!</div>

  <div class="products-section">
    <div class="section-title">Featured Products</div>
    <div class="product-grid">
      <div class="product-card">
        <img src="https://via.placeholder.com/200x180?text=Product+1" />
        <h4>Product Name 1</h4>
        <p>₹999</p>
        <button>Buy Now</button>
      </div>
      <div class="product-card">
        <img src="https://via.placeholder.com/200x180?text=Product+2" />
        <h4>Product Name 2</h4>
        <p>₹1,299</p>
        <button>Buy Now</button>
      </div>
      <div class="product-card">
        <img src="https://via.placeholder.com/200x180?text=Product+3" />
        <h4>Product Name 3</h4>
        <p>₹799</p>
        <button>Buy Now</button>
      </div>
      <div class="product-card">
        <img src="https://via.placeholder.com/200x180?text=Product+4" />
        <h4>Product Name 4</h4>
        <p>₹499</p>
        <button>Buy Now</button>
      </div>
    </div>
  </div>
</body>
</html>
