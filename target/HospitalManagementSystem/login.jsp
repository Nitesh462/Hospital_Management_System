<!DOCTYPE html>
<html>
<head>
    <title>User Login</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body class="background-image">
<div class="login-container">
    <h1 style="color: #32CD32;">Alpha Hospital</h1>

    <h2>Login</h2>
    <form action="login" method="post">
        <label>Username:</label>
        <input type="text" name="username" required><br>

        <label>Password:</label>
        <input type="password" name="password" required><br>

        <input type="submit" value="Login">
    </form>

    <p><a href="register.jsp">Create new account</a></p>

    <% if (request.getParameter("error") != null) { %>
        <p class="error">Invalid username or password.</p>
    <% } %>
</div>

</body>
</html>
