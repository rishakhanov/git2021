package com.epam.projects.kidsshop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FindUserDaoId {
    public int findUserId(int userId) {

        int userLoginId = userId;

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        int userIdDB = 0;

        try {
            Class.forName("org.postgresql.Driver");
            ConnectionPool connectionPool = ConnectionPool.getInstance();
            con = connectionPool.takeConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from orderdetail");
            while (rs.next()) {
                userIdDB = rs.getInt(2);

                if(userLoginId == userIdDB) {
                    return rs.getInt(1);
                }
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

        return 0;
    }
}
