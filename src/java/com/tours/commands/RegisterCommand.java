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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author justlex
 */
public class RegisterCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = PageManager.getInstance().getProperty(PageManager.INDEX);
        CustomerDAO customerDAO = (CustomerDAO)DAOFactory.getDAO(DAOS.CUSTOMER_DAO);
        Customer user = new Customer();
        
        user.setName(request.getParameter("name"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        user.setIdUserType(2);
        
        customerDAO.addCustomer(user);
        return page;
    }
}
