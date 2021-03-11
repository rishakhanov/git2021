package com.epam.projects.kidsshop.dao;

import com.epam.projects.kidsshop.entity.OrderItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class DeleteOrderItemDao {

    private final String selectSQL = "select * from orderitem";
    private final String deleteSQL = "delete from orderitem where id=?";
    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());

    public void deleteOrderItem(OrderItem orderItem) {
        long id = orderItem.getId();

        try {
            Class.forName("org.postgresql.Driver");
            ConnectionPool connectionPool = ConnectionPool.getInstance();
            try(Connection con = connectionPool.takeConnection(); Statement st = con.createStatement()) {
                try (ResultSet rs = st.executeQuery(selectSQL)) {
                    while (rs.next()) {
                        if (id == (rs.getInt(1))) {
                            try (PreparedStatement ps = con.prepareStatement(deleteSQL)) {
                                ps.setLong(1, id);
                                ps.executeUpdate();
                            }
                        }
                    }
                }
                connectionPool.putback(con);
            }
        }catch (ClassNotFoundException | SQLException | ConnectionPoolException e) {
            LOGGER.error(e);
            e.printStackTrace();
        }
    }
}
