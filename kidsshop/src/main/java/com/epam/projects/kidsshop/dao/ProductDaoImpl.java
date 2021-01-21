package com.epam.projects.kidsshop.dao;

import com.epam.projects.kidsshop.entity.Product;
import com.epam.projects.kidsshop.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl {

    public List<Product> getProducts() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        List<Product> products = new ArrayList<>();

        try {
            Class.forName("org.postgresql.Driver");
            ConnectionPool connectionPool = ConnectionPool.getInstance();
            con = connectionPool.takeConnection();
            st = con.createStatement();
            //rs = st.executeQuery("select * from product");
            rs = st.executeQuery("select p.id, p.name, p.category_id, c.category_name, p.section_id, " +
                    "s.section_name, p.brand_id, b.brand_name, p.price, p.quantity, p.details from product as p\n" +
                    "left outer join category as c on p.category_id=c.id\n" +
                    "left outer join section as s on p.section_id=s.id\n" +
                    "left outer join brand as b on p.brand_id=b.id;");
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
        return products;
    }
}
