package com.epam.projects.kidsshop.dao;

import com.epam.projects.kidsshop.entity.Cart;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CartDAO {

    private final String SQL = "select od.id, oi.id, od.user_id, od.order_date, p.name, oi.quantity, p.price, oi.total_cost, od.status from orderitem as oi\n" +
            "left outer join product as p on p.id=oi.product_id\n" +
            "left outer join orderdetail as od on od.id=oi.order_id;";

    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());

    double moneyValue;
    String item;

    public List<Cart> getCart(int userId) {

        List<Cart> cart = new ArrayList<>();

        try {
            Class.forName("org.postgresql.Driver");
            ConnectionPool connectionPool = ConnectionPool.getInstance();
            try(Connection con = connectionPool.takeConnection(); Statement st = con.createStatement()) {
                try(ResultSet rs = st.executeQuery(SQL)) {
                    while (rs.next()) {
                        if (rs.getInt(3) == userId) {
                            Cart cartDetail = new Cart();
                            cartDetail.setOrderId(rs.getInt(1));
                            cartDetail.setItemId(rs.getInt(2));
                            cartDetail.setDate(rs.getDate(4).toLocalDate());
                            cartDetail.setName(rs.getString(5));
                            cartDetail.setQuantity(rs.getInt(6));
                            item = rs.getString(7);
                            item=item.replaceAll("[,$]", "");
                            moneyValue = Double.parseDouble(item);
                            cartDetail.setPrice(BigDecimal.valueOf(moneyValue));
                            item = rs.getString(8);
                            item=item.replaceAll("[,$]", "");
                            moneyValue = Double.parseDouble(item);
                            cartDetail.setTotalCost(BigDecimal.valueOf(moneyValue));
                            cartDetail.setStatus(rs.getString(9));
                            cart.add(cartDetail);
                        }
                    }
                }
                connectionPool.putback(con);
            }
        }catch (ClassNotFoundException | SQLException | ConnectionPoolException e) {
            LOGGER.error(e);
            e.printStackTrace();
        }
        return cart;
    }
}
