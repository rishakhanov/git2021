package com.epam.projects.kidsshop.dao;

import com.epam.projects.kidsshop.entity.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class AddProductDao {

    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    private final String SQL = "insert into product(name, category_id, section_id, brand_id, price, quantity, details) values (?, ?, ?, ?, ?, ?, ?)";

    public void addProduct(Product product) {

        try {
            Class.forName("org.postgresql.Driver");
            ConnectionPool connectionPool = ConnectionPool.getInstance();
            try (Connection con = connectionPool.takeConnection()) {
                try (PreparedStatement ps = con.prepareStatement(SQL)) {
                    ps.setString(1, product.getName());
                    ps.setLong(2, product.getCategoryId());
                    ps.setLong(3, product.getSectionId());
                    ps.setLong(4, product.getBrandId());
                    ps.setBigDecimal(5, product.getPrice());
                    ps.setInt(6, product.getQuantity());
                    ps.setString(7, product.getDetails());
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
