package com.epam.projects.kidsshop.dao;

import com.epam.projects.kidsshop.entity.OrderItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class OrderItemDAO {

    private final String SQL = "insert into orderitem(order_id, product_id, quantity, total_cost) values (?, ?, ?, ?)";
    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());

    public void addOrderItem(OrderItem orderItem) {

        try {
            Class.forName("org.postgresql.Driver");
            ConnectionPool connectionPool = ConnectionPool.getInstance();
            try (Connection con = connectionPool.takeConnection()) {
                try (PreparedStatement ps = con.prepareStatement(SQL)) {
                    ps.setInt(1, orderItem.getOrder_id());
                    ps.setInt(2, orderItem.getProduct_id());
                    ps.setInt(3, orderItem.getQuantity());
                    ps.setBigDecimal(4, orderItem.getTotalCost());
                    ps.executeUpdate();
                }
                connectionPool.putback(con);
            }
        }catch (ClassNotFoundException | SQLException | ConnectionPoolException e) {
            LOGGER.error(e);
            e.printStackTrace();
        }
    }
}
