package com.epam.projects.kidsshop.dao;

import com.epam.projects.kidsshop.entity.Order;

import java.sql.*;
import java.time.LocalDate;

public class OrderTempDao {
    public void addTempOrder(Order order) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            Class.forName("org.postgresql.Driver");
            ConnectionPool connectionPool = ConnectionPool.getInstance();
            con = connectionPool.takeConnection();
            st = con.createStatement();
            String sql = "insert into orderdetail(user_id, status, details) values (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, order.getUser_id());
            ps.setString(2, order.getStatus());
            ps.setString(3, order.getDetails());
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
