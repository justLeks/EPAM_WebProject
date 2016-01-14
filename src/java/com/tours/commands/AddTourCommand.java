/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tours.commands;

import com.tours.connection.DAOFactory;
import com.tours.connection.DAOS;
import com.tours.dao.TourDAO;
import com.tours.entities.Tour;
import com.tours.utils.PageManager;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author justlex
 */
public class AddTourCommand implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = PageManager.getInstance().getProperty(PageManager.DASHBOARD);
        Tour tour = new Tour();
        TourDAO tourDAO = (TourDAO)DAOFactory.getDAO(DAOS.TOUR_DAO);
        
        tour.setTourType(Integer.parseInt(request.getParameter("tourType")));
        tour.setHotelClass(Integer.parseInt(request.getParameter("hotelClass")));
        tour.setPrice(Integer.parseInt(request.getParameter("price")));
        tour.setDestCountry(request.getParameter("destCountry"));
        tour.setStartDay(request.getParameter("startDay"));
        tour.setEndDay(request.getParameter("endDay"));
        tour.setFood(request.getParameter("food"));
        tour.setHot((Integer.parseInt(request.getParameter("hot")) == 1));

        tourDAO.addTour(tour);
        return page;
    }    
}
