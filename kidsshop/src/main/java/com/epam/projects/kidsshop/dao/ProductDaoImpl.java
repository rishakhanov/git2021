package com.epam.projects.kidsshop.dao;

import com.epam.projects.kidsshop.entity.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl {

    private final String SQL = "select p.id, p.name, p.category_id, c.category_name, p.section_id, " +
            "s.section_name, p.brand_id, b.brand_name, p.price, p.quantity, p.details from product as p\n" +
            "left outer join category as c on p.category_id=c.id\n" +
            "left outer join section as s on p.section_id=s.id\n" +
            "left outer join brand as b on p.brand_id=b.id;";

    public List<Product> getProducts() {

        List<Product> products = new ArrayList<>();

        try {
            Class.forName("org.postgresql.Driver");
            ConnectionPool connectionPool = ConnectionPool.getInstance();
            try(Connection con = connectionPool.takeConnection(); Statement st = con.createStatement()) {
                try(ResultSet rs = st.executeQuery(SQL)) {
                    while (rs.next()) {
                        Product productDetail = new Product();
                        productDetail.setId(rs.getInt(1));
                        productDetail.setName(rs.getString(2));
                        productDetail.setCategoryId(rs.getInt(3));
                        productDetail.setCategory(rs.getString(4));
                        productDetail.setSectionId(rs.getInt(5));
                        productDetail.setSection(rs.getString(6));
                        productDetail.setBrandId(rs.getInt(7));
                        productDetail.setBrand(rs.getString(8));
                        productDetail.setPrice(rs.getBigDecimal(9));
                        productDetail.setQuantity(rs.getInt(10));
                        productDetail.setDetails(rs.getString(11));
                        products.add(productDetail);
                    }
                }
                connectionPool.putback(con);
            }
        }catch (ClassNotFoundException | SQLException | ConnectionPoolException e) {
            e.printStackTrace();
        }
        return products;
    }
}
