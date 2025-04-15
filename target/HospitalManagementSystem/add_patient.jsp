<!DOCTYPE html>
<html>
<head>
    <title>Add Patient</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body class="background-image-add_patient">
<div class="container">
    <h2>Add Patient Details</h2>
    <p><a href="view_patients.jsp">View Patients</a> | <a href="logout.jsp">Logout</a></p>

    <form action="add-patient" method="post">
        <label>Name:</label>
        <input type="text" name="name" required>

        <label>Age:</label>
        <input type="number" name="age" required>

        <label>Gender:</label>
        <select name="gender">
            <option value="Male">Male</option>
            <option value="Female">Female</option>
        </select>

        <label>Doctor Name:</label>
        <input type="text" name="doctor" required>

        <input type="submit" value="Add Patient">
    </form>

    <% if (request.getParameter("success") != null) { %>
        <p class="success">Patient added successfully!</p>
    <% } %>
</div>
</body>
</html>
