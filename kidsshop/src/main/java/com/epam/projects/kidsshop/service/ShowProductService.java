package com.epam.projects.kidsshop.service;

import com.epam.projects.kidsshop.dao.ProductDaoImpl;
import com.epam.projects.kidsshop.entity.Product;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowProductService implements Service {

    private final ProductDaoImpl productDao = new ProductDaoImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userLoginEmail = request.getParameter("userEmail");
        List<Product> products = productDao.getProducts();
        request.setAttribute("productList", products);
        request.setAttribute("userEmail", userLoginEmail);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin.jsp");
        dispatcher.forward(request, response);
    }
}
