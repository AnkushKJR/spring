<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Make My Trip – Home</title>

    <style>
        body {
            margin: 0;
            font-family: 'Segoe UI', Arial, sans-serif;
            background: #f5f7fa;
        }

        /* Navbar */
        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 15px 40px;
            background: white;
            box-shadow: 0 1px 6px rgba(0,0,0,0.1);
        }

        .logo {
            font-size: 28px;
            font-weight: bold;
            color: #008CFF;
        }

        .navbar a {
            margin-left: 20px;
            text-decoration: none;
            color: #333;
            font-weight: 500;
        }

        .navbar a:hover {
            color: #008CFF;
        }

        /* Hero section */
        .hero {
            height: 70vh;
            background: url('https://images.unsplash.com/photo-1526778548025-fa2f459cd5c1') center/cover;
            display: flex;
            align-items: center;
            justify-content: center;
            position: relative;
        }

        .overlay {
            position: absolute;
            width: 100%;
            height: 100%;
            background: rgba(0,0,0,0.45);
        }

        .hero-box {
            position: relative;
            background: white;
            padding: 30px;
            width: 70%;
            border-radius: 12px;
            box-shadow: 0 4px 20px rgba(0,0,0,0.2);
        }

        .hero h2 {
            color: white;
            font-size: 40px;
            position: relative;
            z-index: 10;
            text-align: center;
            margin-bottom: 20px;
        }

        /* Form section */
        .form-group {
            display: flex;
            gap: 20px;
        }

        .form-group input {
            width: 100%;
            padding: 14px;
            border-radius: 7px;
            border: 1px solid #ddd;
            font-size: 15px;
        }

        .search-btn {
            margin-top: 20px;
            width: 100%;
            background: #008CFF;
            color: white;
            padding: 15px;
            font-size: 18px;
            border: none;
            border-radius: 7px;
            cursor: pointer;
            font-weight: 600;
        }

        .search-btn:hover {
            background: #0072D8;
        }

        /* Footer */
        footer {
            margin-top: 40px;
            background: #0a223d;
            padding: 30px;
            color: white;
            text-align: center;
        }
    </style>
</head>

<body>

<!-- Navbar -->
<div class="navbar">
    <div class="logo">MakeMyTrip</div>
    <div>
        <a href="createProfilePage">Create Profile</a>
        <a href="#">Login</a>
        <a href="#">Support</a>
    </div>
</div>

<!-- Hero section -->
<div class="hero">
    <div class="overlay"></div>

    <div>
        <h2>Book Flights, Hotels & Holidays</h2>

        <div class="hero-box">
            <div class="form-group">
                <input type="text" placeholder="From">
                <input type="text" placeholder="To">
            </div>

            <div class="form-group" style="margin-top: 15px;">
                <input type="date">
                <input type="date">
            </div>

            <button class="search-btn">Search</button>
        </div>
    </div>
</div>

<!-- Footer -->
<footer>
    © 2025 MakeMyTrip
</footer>

</body>
</html>
