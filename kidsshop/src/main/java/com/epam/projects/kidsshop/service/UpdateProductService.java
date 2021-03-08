package com.epam.projects.kidsshop.service;

import com.epam.projects.kidsshop.dao.UpdateProductDao;
import com.epam.projects.kidsshop.entity.Product;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

public class UpdateProductService implements Service {

    private final UpdateProductDao productDao = new UpdateProductDao();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Product product = new Product();
        product.setId(Integer.parseInt(request.getParameter("productId")));
        product.setName(request.getParameter("productName"));
        product.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));
        product.setSectionId(Integer.parseInt(request.getParameter("sectionId")));
        product.setBrandId(Integer.parseInt(request.getParameter("brandId")));
        product.setPrice(BigDecimal.valueOf(Double.parseDouble(request.getParameter("price"))));
        product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        product.setDetails(request.getParameter("details"));
        productDao.updateProduct(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin.jsp");
        dispatcher.forward(request, response);
    }
}
