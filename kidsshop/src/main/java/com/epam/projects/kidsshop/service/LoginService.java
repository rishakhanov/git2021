package com.epam.projects.kidsshop.service;

import com.epam.projects.kidsshop.dao.LoginUserDao;
import com.epam.projects.kidsshop.dao.ProductDaoImpl;
import com.epam.projects.kidsshop.entity.Product;
import com.epam.projects.kidsshop.entity.UserLoginBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class LoginService implements Service {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, SQLException {

        String userLoginEmail = request.getParameter("inputEmail");
        String userLoginPassword = request.getParameter("inputLoginPassword");

        UserLoginBean loginBean = new UserLoginBean();

        loginBean.setUserEmail(userLoginEmail);
        loginBean.setUserLoginPassword(userLoginPassword);

        LoginUserDao loginDao = new LoginUserDao();

        try {
            String userValidate = loginDao.validateUser(loginBean);

            if(userValidate.equals("AdminRole")) {
                ProductDaoImpl productDao = new ProductDaoImpl();
                List<Product> products = productDao.getProducts();
                request.setAttribute("productList", products);
                request.setAttribute("userEmail", userLoginEmail);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/admin.jsp");
                dispatcher.forward(request, response);

            } else if(userValidate.equals("UserRole")) {
                request.setAttribute("userEmail", userLoginEmail);
                request.setAttribute("inputEmail", userLoginEmail);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("errorMessage", userValidate);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            }
        } catch (IOException exception1) {
            exception1.printStackTrace();
        } catch (Exception exception2) {
            exception2.printStackTrace();
        }
    }
}
