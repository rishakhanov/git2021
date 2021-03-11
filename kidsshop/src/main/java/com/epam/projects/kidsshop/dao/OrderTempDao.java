package com.epam.projects.kidsshop.dao;

import com.epam.projects.kidsshop.entity.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class OrderTempDao {

    private final String SQL = "insert into orderdetail(user_id, order_date, status, details) values (?, ?, ?, ?)";
    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());

    public void addTempOrder(Order order) {

        try {
            Class.forName("org.postgresql.Driver");
            ConnectionPool connectionPool = ConnectionPool.getInstance();
            try(Connection con = connectionPool.takeConnection()) {
                try(PreparedStatement ps = con.prepareStatement(SQL)) {
                    ps.setInt(1, order.getUser_id());
                    ps.setDate(2, Date.valueOf(order.getDate()));
                    ps.setString(3, order.getStatus());
                    ps.setString(4, order.getDetails());
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
