<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: #f3f3f3; /* Fallback color if the image is not available */
            background-image: url('data:image/jpeg;base64,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'); /* Path to your background image */
            background-size: cover;
            background-position: center;
        }

        .container {
            width: 400px;
            padding: 20px;
            border-radius: 10px;
            background-color: rgba(255, 255, 255, 0.9);
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 30px;
        }

        label {
            font-weight: bold;
        }

        input[type="text"],
        input[type="password"],
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            background-color: #f9f9f9;
        }

        .btn {
            display: block;
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 5px;
            background-color: #007bff;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
	<jsp:include page="Login Header.jsp"></jsp:include>

    <div class="container">
        <h2>Login Page</h2>
        <form action="AcLoginServ">
            <select id="selector" name="accountType">
                <option selected>Select Account Type</option>
                <option>User</option>
                <option>Vendor</option>
            </select>
            <div class="mb-3 mt-3">
                <label for="email">Username:</label>
                <input type="text" class="form-control" id="email" placeholder="Enter username" name="username">
            </div>
            <div class="mb-3">
                <label for="pwd">Password:</label>
                <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pswd">
            </div>
            <button type="submit" class="btn btn-primary btn-lg">Submit</button>
        </form>
    </div>
</body>
</html>



