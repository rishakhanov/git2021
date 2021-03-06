package com.epam.projects.kidsshop.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FindProductPriceDAO {

    private final String SQL = "select * from product";
    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());

    public BigDecimal findProductPrice(int productId) {
        BigDecimal result = null;
        int userLoginId = productId;
        int productIdDB = 0;

        try {
            Class.forName("org.postgresql.Driver");
            ConnectionPool connectionPool = ConnectionPool.getInstance();
            try (Connection con = connectionPool.takeConnection(); Statement st = con.createStatement()) {
                try (ResultSet rs = st.executeQuery(SQL)) {
                    while (rs.next()) {
                        productIdDB = rs.getInt(1);
                        if (userLoginId == productIdDB) {
                            result = rs.getBigDecimal(6);
                        }
                    }
                }
                connectionPool.putback(con);
            }
        }catch (ClassNotFoundException | SQLException | ConnectionPoolException e) {
            LOGGER.error(e);
            e.printStackTrace();
        }
        return result;
    }
}
