package com.epam.projects.kidsshop.dao;

import com.epam.projects.kidsshop.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class AddUserDao {

    private final String SQL = "insert into userDetail(first_name, last_name, birthday, iin, phone, email, address, password_details, is_admin) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());

    public void addUser(User user) {

        try {
            Class.forName("org.postgresql.Driver");
            ConnectionPool connectionPool = ConnectionPool.getInstance();
            try (Connection con = connectionPool.takeConnection()) {
                try (PreparedStatement ps = con.prepareStatement(SQL)) {
                    ps.setString(1, user.getFirstName());
                    ps.setString(2, user.getLastName());
                    ps.setDate(3, Date.valueOf(user.getBirthday()));
                    ps.setLong(4, user.getIin());
                    ps.setLong(5, user.getPhone());
                    ps.setString(6, user.getEmail());
                    ps.setString(7, user.getAddress());
                    ps.setString(8, user.getPassword());
                    ps.setBoolean(9, user.isAdminPermission());
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
