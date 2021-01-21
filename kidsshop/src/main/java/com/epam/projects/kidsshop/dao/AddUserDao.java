package com.epam.projects.kidsshop.dao;

import com.epam.projects.kidsshop.entity.User;

import java.sql.*;

public class AddUserDao {

    public void addUser(User user) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            Class.forName("org.postgresql.Driver");
            ConnectionPool connectionPool = ConnectionPool.getInstance();
            con = connectionPool.takeConnection();
            st = con.createStatement();
            String sql = "insert into userDetail(first_name, last_name, birthday, iin, phone, email, address, password_details, is_admin) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setDate(3, Date.valueOf(user.getBirthday()));
            ps.setString(4, user.getIin());
            ps.setString(5, user.getPhone());
            ps.setString(6, user.getEmail());
            ps.setString(7, user.getAddress());
            ps.setString(8, user.getPassword());
            ps.setBoolean(9, user.isAdminPermission());
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
