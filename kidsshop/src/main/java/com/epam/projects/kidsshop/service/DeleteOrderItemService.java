package com.epam.projects.kidsshop.service;

import com.epam.projects.kidsshop.dao.CartDAO;
import com.epam.projects.kidsshop.dao.DeleteOrderItemDao;
import com.epam.projects.kidsshop.dao.FindUserDao;
import com.epam.projects.kidsshop.entity.Cart;
import com.epam.projects.kidsshop.entity.OrderItem;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class DeleteOrderItemService implements Service {

    private final DeleteOrderItemDao deleteOrderItemDao = new DeleteOrderItemDao();
    private final CartDAO cartDAO = new CartDAO();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(Long.parseLong(request.getParameter("orderItemId")));
        deleteOrderItemDao.deleteOrderItem(orderItem);
        String userLoginEmail = request.getParameter("userEmail");
        FindUserDao findUserDao = new FindUserDao();
        int userId = findUserDao.findUser(userLoginEmail);
        List<Cart> cart = cartDAO.getCart(userId);
        request.setAttribute("cartList", cart);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cart.jsp");
        dispatcher.forward(request, response);
    }
}
