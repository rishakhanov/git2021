package com.epam.projects.kidsshop.dao;

import com.epam.projects.kidsshop.entity.User;
import com.epam.projects.kidsshop.entity.UserLoginBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LoginUserDao {
    public String validateUser(UserLoginBean loginBean) {

        String userLoginEmail = loginBean.getUserEmail();
        String userLoginPassword = loginBean.getUserLoginPassword();

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String emailDB = "";
        String passwordDB = "";
        boolean roleDB = false;

        List<User> users=new ArrayList<>();

        try {
            Class.forName("org.postgresql.Driver");
            ConnectionPool connectionPool = ConnectionPool.getInstance();
            con = connectionPool.takeConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from userDetail");
            while (rs.next()) {

                emailDB = rs.getString(7);
                passwordDB = rs.getString(12);
                roleDB = rs.getBoolean(11);

                if(userLoginEmail.equals(emailDB) && userLoginPassword.equals(passwordDB) && (roleDB)) {
                    return "AdminRole";
                } else if(userLoginEmail.equals(emailDB) && userLoginPassword.equals(passwordDB) && (roleDB == false)) {
                    return "UserRole";
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

        return "User does not exist.";
    }
}
