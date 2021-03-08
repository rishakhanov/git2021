package com.epam.projects.kidsshop.service;

import com.epam.projects.kidsshop.dao.LoginUserDao;
import com.epam.projects.kidsshop.dao.ProductDaoImpl;
import com.epam.projects.kidsshop.entity.Product;
import com.epam.projects.kidsshop.entity.UserLoginBean;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LoginService implements Service {

    private final LoginUserDao loginDao = new LoginUserDao();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        String userLoginEmail = request.getParameter("userEmail");
        String userLoginPassword = request.getParameter("inputLoginPassword");
        UserLoginBean loginBean = new UserLoginBean();
        loginBean.setUserEmail(userLoginEmail);
        loginBean.setUserLoginPassword(userLoginPassword);

        try {
            String userValidate = loginDao.validateUser(loginBean);

            if(userValidate.equals("AdminRole")) {
                final ProductDaoImpl productDao = new ProductDaoImpl();
                List<Product> products = productDao.getProducts();
                request.setAttribute("productList", products);
                request.setAttribute("userEmail", userLoginEmail);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/admin.jsp");
                dispatcher.forward(request, response);

            } else if(userValidate.equals("UserRole")) {
                request.setAttribute("userEmail", userLoginEmail);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
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
