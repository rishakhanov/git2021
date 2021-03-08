package com.epam.projects.kidsshop.dao;

import com.epam.projects.kidsshop.entity.Product;
import java.sql.*;

public class UpdateProductDao {

    private final String SQL = "update product "
            + "set name=?, category_id=?, section_id=?, brand_id=?, price=?, quantity=?, details=? "
            + "where id=?";

    public void updateProduct(Product product) {

        try {
            Class.forName("org.postgresql.Driver");
            ConnectionPool connectionPool = ConnectionPool.getInstance();
            try(Connection con = connectionPool.takeConnection(); Statement st = con.createStatement()) {
                try(PreparedStatement ps = con.prepareStatement(SQL)) {
                    ps.setString(1, product.getName());
                    ps.setLong(2, product.getCategoryId());
                    ps.setLong(3, product.getSectionId());
                    ps.setLong(4, product.getBrandId());
                    ps.setBigDecimal(5, product.getPrice());
                    ps.setInt(6, product.getQuantity());
                    ps.setString(7, product.getDetails());
                    ps.setInt(8, (int) product.getId());
                    ps.executeUpdate();
                }
                connectionPool.putback(con);
            }
        }catch (ClassNotFoundException | SQLException | ConnectionPoolException e) {
            e.printStackTrace();
        }
    }
}
