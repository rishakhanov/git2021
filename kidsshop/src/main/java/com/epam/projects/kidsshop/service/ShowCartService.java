package com.epam.projects.kidsshop.service;

import com.epam.projects.kidsshop.dao.CartDAO;
import com.epam.projects.kidsshop.dao.FindUserDao;
import com.epam.projects.kidsshop.entity.Cart;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class ShowCartService implements Service {

    private final CartDAO cartDAO = new CartDAO();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        String userLoginEmail = request.getParameter("userEmail");
        FindUserDao findUserDao = new FindUserDao();
        int userId = findUserDao.findUser(userLoginEmail);
        List<Cart> cart = cartDAO.getCart(userId);
        request.setAttribute("cartList", cart);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cart.jsp");
        dispatcher.forward(request, response);
    }
}
