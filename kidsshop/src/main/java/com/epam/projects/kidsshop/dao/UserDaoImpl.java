package com.epam.projects.kidsshop.dao;

import com.epam.projects.kidsshop.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl {

    public List<User> getUsers() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();

        try {
            Class.forName("org.postgresql.Driver");
            ConnectionPool connectionPool = ConnectionPool.getInstance();
            con = connectionPool.takeConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from userDetail");
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setFirstName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setBirthday(rs.getDate(4).toLocalDate());
                user.setIin(rs.getString(5));
                user.setPhone(rs.getString(6));
                user.setEmail(rs.getString(7));
                user.setAddress(rs.getString(8));
                user.setDetails(rs.getString(9));
                user.setStatus(rs.getString(10));
                user.setAdminPermission(rs.getBoolean(11));
                users.add(user);
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

        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }

        return users;
    }
}
