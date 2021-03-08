package com.epam.projects.kidsshop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FindUserDaoId {

    private final String SQL = "select * from orderdetail order by id asc";

    public int findUserId(int userId) {
        int result = 0;
        int userIdDB = 0;

        try {
            Class.forName("org.postgresql.Driver");
            ConnectionPool connectionPool = ConnectionPool.getInstance();
            try (Connection con = connectionPool.takeConnection(); Statement st = con.createStatement()) {
                try (ResultSet rs = st.executeQuery(SQL)) {
                    while (rs.next()) {
                        userIdDB = rs.getInt(2);
                        if (userId == userIdDB) {
                            result = rs.getInt(1);
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
