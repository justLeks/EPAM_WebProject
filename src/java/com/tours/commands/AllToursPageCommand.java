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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author justlex
 */
public class AllToursPageCommand implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = PageManager.getInstance().getProperty(PageManager.ALL_TOURS);
        TourDAO tourDAO = (TourDAO)DAOFactory.getDAO(DAOS.TOUR_DAO);
        List<Tour> tourList = tourDAO.findAll();
        
        request.setAttribute("allTours", tourList);
        return page;
    }
    
}
