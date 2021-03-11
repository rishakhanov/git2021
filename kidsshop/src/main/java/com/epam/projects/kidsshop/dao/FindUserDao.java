package com.epam.projects.kidsshop.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FindUserDao {

    private final String SQL = "select * from userdetail";
    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());

    public int findUser(String email) {
        int result = 0;
        String emailDB = "";

        try {
            Class.forName("org.postgresql.Driver");
            ConnectionPool connectionPool = ConnectionPool.getInstance();
            try(Connection con = connectionPool.takeConnection(); Statement st = con.createStatement()) {
                try (ResultSet rs = st.executeQuery(SQL)) {
                    while (rs.next()) {
                        emailDB = rs.getString(7);
                        if (email.equals(emailDB)) {
                            result =  rs.getInt(1);
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
