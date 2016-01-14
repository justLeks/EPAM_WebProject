/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tours.commands;

import com.tours.connection.DAOFactory;
import com.tours.connection.DAOS;
import com.tours.dao.OrdersDAO;
import com.tours.entities.Customer;
import com.tours.entities.Order;
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
public class OrderTourCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = PageManager.getInstance().getProperty(PageManager.SUCCESS);
        Customer user = (Customer) request.getSession().getAttribute("user");
        double discount = 1;

        if (user == null) {
            return PageManager.getInstance().getProperty(PageManager.LOGIN);
        }

        OrdersDAO ordersDAO = (OrdersDAO) DAOFactory.getDAO(DAOS.ORDERS_DAO);
        List<Order> userOrders = ordersDAO.findWhereUserIdEquals(user.getId());

        if (userOrders.size() >= 10) {
            discount = 0.5;
        } else if (userOrders.size() >= 5) {
            discount = 0.7;
        } else if (userOrders.size() >= 3) {
            discount = 0.85;
        }

        ordersDAO.addOrder(Integer.parseInt(request.getParameter("idTour")),
                Integer.parseInt(request.getParameter("idUser")),
                (int) (Double.parseDouble((request.getParameter("tourPrice"))) * discount));

        return page;
    }

}
