package com.example.servlet;

import com.example.model.Patient;
import com.example.util.HibernateUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;

@WebServlet("/add-patient")
public class AddPatientServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        String doctor = request.getParameter("doctor");

        Patient patient = new Patient();
        patient.setName(name);
        patient.setAge(age);
        patient.setGender(gender);
        patient.setDoctor(doctor);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(patient);
        tx.commit();
        session.close();

        // Redirect to patient list instead of form
        response.sendRedirect("view_patients.jsp");
    }
}
