<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body class="background-image-register">
<div class="container">
    <h2>Register</h2>
    <form action="register" method="post">
        <label>Username:</label>
        <input type="text" name="username" required>

        <label>Password:</label>
        <input type="password" name="password" required>

        <label>Role:</label>
        <select name="role">
            <option value="admin">Admin</option>
            <option value="doctor">Doctor</option>
            <option value="receptionist">Receptionist</option>
        </select>

        <input type="submit" value="Register">
    </form>
    <p>Already have an account? <a href="login.jsp">Login here</a></p>
</div>
</body>
</html>
