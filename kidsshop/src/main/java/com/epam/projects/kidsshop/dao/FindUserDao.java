package com.epam.projects.kidsshop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FindUserDao {

    private final String SQL = "select * from userdetail";

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
            e.printStackTrace();
        }
        return result;
    }
}
