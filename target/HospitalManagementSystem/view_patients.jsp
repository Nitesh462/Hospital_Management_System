<%@ page import="java.util.List" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.query.Query" %>
<%@ page import="com.example.model.Patient" %>
<%@ page import="com.example.util.HibernateUtil" %>

<%
    org.hibernate.Session dbSession = HibernateUtil.getSessionFactory().openSession();
    Query<Patient> query = dbSession.createQuery("FROM Patient", Patient.class);
    List<Patient> patients = query.list();
    dbSession.close();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Patient List</title>
    <link rel="stylesheet" href="css/style.css">
    <style>
        
        .table-container {
            width: 90%;
            margin: 40px auto;
            background: white;
            padding: 20px;
            border-radius: 12px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        table thead {
            background-color: #009879;
            color: white;
        }

        table th, table td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: center;
        }

        table tr:nth-child(even) {
            background-color: #f4f7f8;
        }

        .nav-links {
            text-align: center;
            margin-bottom: 20px;
        }

        .nav-links a {
            margin: 0 10px;
        }
    </style>
</head>
<body class="background-image-view_patients">
    <div class="table-container">
        <h2 style="text-align: center;">All Patients</h2>
        <div class="nav-links">
            <a href="add_patient.jsp">Add Patient</a> |
            <a href="logout.jsp">Logout</a>
        </div>

        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Gender</th>
                    <th>Doctor</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (Patient p : patients) {
                %>
                <tr>
                    <td><%= p.getId() %></td>
                    <td><%= p.getName() %></td>
                    <td><%= p.getAge() %></td>
                    <td><%= p.getGender() %></td>
                    <td><%= p.getDoctor() %></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
