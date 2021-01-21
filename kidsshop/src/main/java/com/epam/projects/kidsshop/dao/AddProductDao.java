package com.epam.projects.kidsshop.dao;

import com.epam.projects.kidsshop.entity.Product;
import com.epam.projects.kidsshop.entity.User;

import java.sql.*;

public class AddProductDao {

    public void addProduct(Product product) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            Class.forName("org.postgresql.Driver");
            ConnectionPool connectionPool = ConnectionPool.getInstance();
            con = connectionPool.takeConnection();
            st = con.createStatement();
            String sql = "insert into product(name, category_id, section_id, brand_id, price, quantity, details) values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getName());
            ps.setLong(2, product.getCategoryId());
            ps.setLong(3, product.getSectionId());
            ps.setLong(4, product.getBrandId());
            ps.setBigDecimal(5, product.getPrice());
            ps.setInt(6, product.getQuantity());
            ps.setString(7, product.getDetails());
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
