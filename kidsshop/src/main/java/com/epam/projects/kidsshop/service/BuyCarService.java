package com.epam.projects.kidsshop.service;

import com.epam.projects.kidsshop.dao.FindUserDao;
import com.epam.projects.kidsshop.dao.FindUserDaoId;
import com.epam.projects.kidsshop.dao.OrderItemDAO;
import com.epam.projects.kidsshop.dao.OrderTempDao;
import com.epam.projects.kidsshop.entity.Order;
import com.epam.projects.kidsshop.entity.OrderItem;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;

public class BuyCarService implements Service {
    String email;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        String email = request.getParameter("inputEmail");
        FindUserDao findUserDao = new FindUserDao();
        int userId = findUserDao.findUser(email);
        Order order = new Order();
        order.setUser_id(userId);
        order.setStatus("open");
        order.setDetails("details");
        OrderTempDao orderTempDao = new OrderTempDao();
        orderTempDao.addTempOrder(order);
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct_id(Integer.parseInt(request.getParameter("productId")));
        orderItem.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        FindUserDaoId findUserDaoId = new FindUserDaoId();
        int orderID = findUserDaoId.findUserId(userId);
        orderItem.setOrder_id(orderID);
        OrderItemDAO orderItemDAO = new OrderItemDAO();
        orderItemDAO.addOrderItem(orderItem);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/order.jsp");
        dispatcher.forward(request, response);
    }
}
