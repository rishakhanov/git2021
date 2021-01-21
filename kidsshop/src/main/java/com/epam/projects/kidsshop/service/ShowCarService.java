package com.epam.projects.kidsshop.service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class ShowCarService implements Service {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        String userLoginEmail = request.getParameter("inputEmail");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/cars.jsp");
        dispatcher.forward(request, response);
    }
}
