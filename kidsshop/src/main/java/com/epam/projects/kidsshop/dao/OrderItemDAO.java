package com.epam.projects.kidsshop.dao;

import com.epam.projects.kidsshop.entity.Order;
import com.epam.projects.kidsshop.entity.OrderItem;

import java.sql.*;

public class OrderItemDAO {
    public void addOrderItem(OrderItem orderItem) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            Class.forName("org.postgresql.Driver");
            ConnectionPool connectionPool = ConnectionPool.getInstance();
            con = connectionPool.takeConnection();
            st = con.createStatement();
            String sql = "insert into orderitem(order_id, product_id, quantity) values (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, orderItem.getOrder_id());
            ps.setInt(2, orderItem.getProduct_id());
            ps.setInt(3, orderItem.getQuantity());
            ps.executeUpdate();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
