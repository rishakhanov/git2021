package com.epam.projects.kidsshop.service;

import com.epam.projects.kidsshop.dao.AddUserDao;
import com.epam.projects.kidsshop.entity.User;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class AddUserService implements Service{
    private final AddUserDao userDao = new AddUserDao();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setBirthday(LocalDate.parse(request.getParameter("inputBirthday")));
        user.setIin(Long.parseLong(request.getParameter("inputIIN")));
        user.setPhone(Long.parseLong(request.getParameter("inputPhone")));
        user.setEmail(request.getParameter("inputEmail"));
        user.setAddress(request.getParameter("inputAddress"));
        user.setPassword(request.getParameter("inputPassword"));
        user.setAdminPermission(false);
        userDao.addUser(user);
        String inputEmail = request.getParameter("inputEmail");
        request.setAttribute("userEmail", inputEmail);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/signin-return.jsp");
        dispatcher.forward(request, response);
    }
}
