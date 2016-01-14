/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tours.commands;

import com.tours.connection.DAOFactory;
import com.tours.connection.DAOS;
import com.tours.dao.OrdersDAO;
import com.tours.dao.TourDAO;
import com.tours.entities.Customer;
import com.tours.entities.Order;
import com.tours.utils.Info;
import com.tours.utils.PageManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author justlex
 */
public class PersonalRoomPageCommand implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = PageManager.getInstance().getProperty(PageManager.PERSONAL_ROOM);
        OrdersDAO ordersDAO = (OrdersDAO)DAOFactory.getDAO(DAOS.ORDERS_DAO);
        TourDAO tourDAO = (TourDAO)DAOFactory.getDAO(DAOS.TOUR_DAO);
        Customer user = (Customer)request.getSession().getAttribute("user");
        
        List<Order> orders = ordersDAO.findWhereUserIdEquals(user.getId());
        List<Info> infos = new ArrayList<>();
        
        for (Order order : orders) {
            infos.add(new Info(
                    order.getIdOrder(),
                    user.getName(),
                    tourDAO.findWhereTourIdEquals(order.getIdTour()).getTourType(),
                    tourDAO.findWhereTourIdEquals(order.getIdTour()).getHotelClass(),
                    tourDAO.findWhereTourIdEquals(order.getIdTour()).getPrice(),
                    tourDAO.findWhereTourIdEquals(order.getIdTour()).isHot(),
                    tourDAO.findWhereTourIdEquals(order.getIdTour()).getDestCountry(),
                    tourDAO.findWhereTourIdEquals(order.getIdTour()).getStartDay(),
                    tourDAO.findWhereTourIdEquals(order.getIdTour()).getEndDay(),
                    tourDAO.findWhereTourIdEquals(order.getIdTour()).getFood(),
                    order.getPrice(),
                    order.isPaid(),
                    order.isApproved(),
                    order.getDate()
            ));
        }
        
        request.getSession().setAttribute("userOrders", infos);
        return page;
    }
    
    
}
