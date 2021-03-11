package com.epam.projects.kidsshop.dao;

import com.epam.projects.kidsshop.entity.UserLoginBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginUserDao {

    private final String SQL = "select * from userDetail";
    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());

    public String validateUser(UserLoginBean loginBean) {
        String result = "User does not exist.";
        String userLoginEmail = loginBean.getUserEmail();
        String userLoginPassword = loginBean.getUserLoginPassword();
        String emailDB = "";
        String passwordDB = "";
        boolean roleDB;

        try {
            Class.forName("org.postgresql.Driver");
            ConnectionPool connectionPool = ConnectionPool.getInstance();
            try(Connection con = connectionPool.takeConnection(); Statement st = con.createStatement()) {
                try(ResultSet rs = st.executeQuery(SQL)) {
                    while (rs.next()) {
                        emailDB = rs.getString(7);
                        passwordDB = rs.getString(12);
                        roleDB = rs.getBoolean(11);
                        if (userLoginEmail.equals(emailDB) && userLoginPassword.equals(passwordDB) && (roleDB)) {
                            result = "AdminRole";
                        } else if (userLoginEmail.equals(emailDB) && userLoginPassword.equals(passwordDB) && (!roleDB)) {
                            result = "UserRole";
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
