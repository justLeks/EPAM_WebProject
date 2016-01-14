/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tours.commands;

import com.tours.connection.DAOFactory;
import com.tours.dao.CustomerDAO;
import com.tours.connection.DAOS;
import com.tours.entities.Customer;
import com.tours.utils.PageManager;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author justlex
 */
public class LoginCheckCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = PageManager.getInstance().getProperty(PageManager.INDEX);
        CustomerDAO customerDao = (CustomerDAO)DAOFactory.getDAO(DAOS.CUSTOMER_DAO);
        String userEmail = request.getParameter("login");
        String userPass = request.getParameter("password");

        List<Customer> usersEmail = customerDao.findWhereEmailEquals(userEmail);
        
        if(usersEmail.size() == 0) {
            return PageManager.getInstance().getProperty(PageManager.LOGIN);
        }
       
        if(userEmail == "" || !userEmail.matches("^[\\S]+@[\\S]+\\.[\\S]+$") || userPass == "") {
            return PageManager.getInstance().getProperty(PageManager.LOGIN);
        }
        
        if (!usersEmail.get(0).getPassword().equals(userPass)) {
            page = PageManager.getInstance().getProperty(PageManager.ERROR);;
        } else {
            Customer user = usersEmail.get(0);
            request.getSession().setAttribute("user", user);
        }

        return page;
    }
}
