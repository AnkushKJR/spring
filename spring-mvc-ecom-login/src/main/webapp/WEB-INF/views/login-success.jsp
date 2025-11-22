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
      display: flex;
      justify-content: space-between;
      align-items: center;
      color: white;
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
      background: url('https://via.placeholder.com/1600x500?text=Welcome+to+Flipkart') no-repeat center/cover;
      height: 350px;
      display: flex;
      justify-content: center;
      align-items: center;
      color: white;
      font-size: 36px;
      font-weight: bold;
    }

    .content {
      padding: 30px;
    }
    .content h2 {
      margin-bottom: 10px;
      font-size: 26px;
    }
    .content p {
      font-size: 18px;
      color: #444;
    }

    .product-grid {
      margin-top: 20px;
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
      gap: 20px;
    }
    .product-card {
      background: white;
      padding: 15px;
      text-align: center;
      border-radius: 8px;
      box-shadow: 0 2px 6px rgba(0,0,0,0.1);
    }
    .product-card img {
      width: 100%;
      height: 160px;
      object-fit: cover;
      border-radius: 8px;
    }
    .product-card h4 {
      margin: 10px 0 5px;
      font-size: 18px;
    }
    .product-card p {
      color: green;
      font-weight: bold;
    }
    .product-card button {
      margin-top: 10px;
      padding: 10px 14px;
      background-color: #2874f0;
      color: white;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      font-size: 14px;
    }
  </style>
</head>
<body>

  <div class="navbar">
    <div class="logo">Flipkart</div>
    <div>
      <a href="#">Home</a>
      <a href="#">Cart</a>
      <a href="#">Profile</a>
    </div>
  </div>

  <div class="hero">Login Successful!</div>

  <div class="content">
    <h2>Welcome to the Flipkart Homepage</h2>
    <p>Browse your favourite products, offers, and deals curated just for you.</p>

    <div class="product-grid">
      <div class="product-card">
        <img src="https://via.placeholder.com/200x160?text=Mobile" />
        <h4>Smartphones</h4>
        <p>From ₹6,999</p>
        <button>Shop Now</button>
      </div>

      <div class="product-card">
        <img src="https://via.placeholder.com/200x160?text=Laptop" />
        <h4>Laptops</h4>
        <p>From ₹24,999</p>
        <button>Shop Now</button>
      </div>

      <div class="product-card">
        <img src="https://via.placeholder.com/200x160?text=TV" />
        <h4>LED TVs</h4>
        <p>From ₹9,499</p>
        <button>Shop Now</button>
      </div>

      <div class="product-card">
        <img src="https://via.placeholder.com/200x160?text=Shoes" />
        <h4>Footwear</h4>
        <p>From ₹499</p>
        <button>Shop Now</button>
      </div>
    </div>
  </div>

</body>
</html>