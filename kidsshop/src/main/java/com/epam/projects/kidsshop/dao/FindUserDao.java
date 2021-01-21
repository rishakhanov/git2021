package com.epam.projects.kidsshop.dao;

import com.epam.projects.kidsshop.entity.User;
import com.epam.projects.kidsshop.entity.UserLoginBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FindUserDao {
    public int findUser(String email) {

        String userLoginEmail = email;

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String emailDB = "";

        try {
            Class.forName("org.postgresql.Driver");
            ConnectionPool connectionPool = ConnectionPool.getInstance();
            con = connectionPool.takeConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from userdetail");
            while (rs.next()) {
                emailDB = rs.getString(7);

                if(userLoginEmail.equals(emailDB)) {
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
