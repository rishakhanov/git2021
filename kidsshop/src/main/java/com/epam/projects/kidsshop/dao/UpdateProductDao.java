package com.epam.projects.kidsshop.dao;

import com.epam.projects.kidsshop.entity.Product;

import java.sql.*;

public class UpdateProductDao {

    public void updateProduct(Product product) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            Class.forName("org.postgresql.Driver");
            ConnectionPool connectionPool = ConnectionPool.getInstance();
            con = connectionPool.takeConnection();
            st = con.createStatement();
            String sql = "update product "
                            + "set name=?, category_id=?, section_id=?, brand_id=?, price=?, quantity=?, details=? "
                            + "where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getName());
            ps.setLong(2, product.getCategoryId());
            ps.setLong(3, product.getSectionId());
            ps.setLong(4, product.getBrandId());
            ps.setBigDecimal(5, product.getPrice());
            ps.setInt(6, product.getQuantity());
            ps.setString(7, product.getDetails());
            ps.setInt(8, (int)product.getId());
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
