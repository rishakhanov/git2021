package com.epam.projects.kidsshop.controller;

import com.epam.projects.kidsshop.service.Service;
import com.epam.projects.kidsshop.service.factory.ServiceFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class ShopController extends HttpServlet {

    private final ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestUri = req.getRequestURI().toLowerCase();

        Service currentService = serviceFactory.getService(requestUri);

        try {
            currentService.execute(req, resp);
        } catch (ParseException | SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
