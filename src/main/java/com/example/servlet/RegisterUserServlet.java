package com.example.servlet;

import com.example.model.User;
import com.example.model.Role;
import com.example.util.HibernateUtil;
import com.example.util.PasswordUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;

@WebServlet("/register")
public class RegisterUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String roleParam = request.getParameter("role");

        // Hash the password
        String hashedPassword = PasswordUtil.hashPassword(password);

        // Convert role string to Role enum
        Role role = Role.valueOf(roleParam.toUpperCase());

        User user = new User();
        user.setUsername(username);
        user.setPassword(hashedPassword);
        user.setRole(role);

        // Save to DB
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        session.close();

        response.sendRedirect("login.jsp"); // Go to login page after successful registration
    }
}
