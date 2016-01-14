/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tours.commands;

import com.tours.connection.DAOFactory;
import com.tours.connection.DAOS;
import com.tours.dao.OrdersDAO;
import com.tours.utils.PageManager;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author justlex
 */
public class TourPayCommand implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = PageManager.getInstance().getProperty(PageManager.PERSONAL_ROOM);
        OrdersDAO ordersDAO = (OrdersDAO)DAOFactory.getDAO(DAOS.ORDERS_DAO);
        
        ordersDAO.updateOrderPaid(Integer.parseInt(request.getParameter("idOrder")));
        return page;
    }
    
}
