package com.epam.projects.kidsshop.service;

import com.epam.projects.kidsshop.dao.*;
import com.epam.projects.kidsshop.entity.Order;
import com.epam.projects.kidsshop.entity.OrderItem;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

public class BuyCarService implements Service {

    private final FindUserDao findUserDao = new FindUserDao();
    private final OrderTempDao orderTempDao = new OrderTempDao();
    private final FindUserDaoId findUserDaoId = new FindUserDaoId();
    private final OrderItemDAO orderItemDAO = new OrderItemDAO();
    private final FindProductPriceDAO findProductPriceDAO = new FindProductPriceDAO();
    public static boolean orderExist;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String jspName = request.getParameter("jspName");
        String email = request.getParameter("userEmail");
        request.setAttribute("userEmail", email);
        int userId = findUserDao.findUser(email);

        if (!orderExist) {
            Order order = new Order();
            order.setUser_id(userId);
            order.setDate(LocalDate.now());
            order.setStatus("open");
            order.setDetails("details");
            orderTempDao.addTempOrder(order);
            orderExist = true;
        }

        OrderItem orderItem = new OrderItem();
        orderItem.setProduct_id(Integer.parseInt(request.getParameter("carId")));
        orderItem.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        int orderID = findUserDaoId.findUserId(userId);
        orderItem.setOrder_id(orderID);
        BigDecimal totalCost =   findProductPriceDAO.findProductPrice(orderItem.getProduct_id()).multiply(BigDecimal.valueOf(orderItem.getQuantity()));
        orderItem.setTotalCost(totalCost);
        orderItemDAO.addOrderItem(orderItem);
        RequestDispatcher dispatcher = request.getRequestDispatcher(jspName);
        dispatcher.forward(request, response);
    }
}
