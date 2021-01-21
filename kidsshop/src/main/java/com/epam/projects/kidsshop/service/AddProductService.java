package com.epam.projects.kidsshop.service;

import com.epam.projects.kidsshop.dao.AddProductDao;
import com.epam.projects.kidsshop.entity.Product;
import javafx.util.converter.BigDecimalStringConverter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;

public class AddProductService implements Service {
    AddProductDao productDao = new AddProductDao();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        Product product = new Product();
        product.setName(request.getParameter("productName"));
        product.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));
        product.setSectionId(Integer.parseInt(request.getParameter("sectionId")));
        product.setBrandId(Integer.parseInt(request.getParameter("brandId")));
        product.setPrice(BigDecimal.valueOf(Double.parseDouble(request.getParameter("price"))));
        product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        product.setDetails(request.getParameter("details"));
        productDao.addProduct(product);
        String email = request.getParameter("adminEmail");
        String password = request.getParameter("adminPassword");
        request.setAttribute("userEmail", email);
        request.setAttribute("inputLoginPassword", password);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin.jsp");
        dispatcher.forward(request, response);
    }
}
