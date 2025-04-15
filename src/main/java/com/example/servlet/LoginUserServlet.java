package com.example.servlet;

import com.example.model.User;
import com.example.util.HibernateUtil;
import com.example.util.PasswordUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.IOException;

@WebServlet("/login")
public class LoginUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<User> query = session.createQuery("FROM User WHERE username = :username", User.class);
        query.setParameter("username", username);
        User user = query.uniqueResult();
        session.close();

        if (user != null && PasswordUtil.checkPassword(password, user.getPassword())) {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("user", user);
            response.sendRedirect("add_patient.jsp");
        } else {
            response.sendRedirect("login.jsp?error=true");
        }
    }
}
