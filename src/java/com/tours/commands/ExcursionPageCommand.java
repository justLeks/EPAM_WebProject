package com.tours.commands;

import com.tours.connection.DAOFactory;
import com.tours.connection.DAOS;
import com.tours.dao.TourDAO;
import com.tours.entities.Tour;
import com.tours.utils.PageManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ExcursionPageCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = PageManager.getInstance().getProperty(PageManager.EXCURSIONS);
        TourDAO tourDAO = (TourDAO)DAOFactory.getDAO(DAOS.TOUR_DAO);
        List<Tour> tourList = tourDAO.findWhereIdTourTypeEquals(2);

        request.setAttribute("availableExcursions", tourList);
        return page;
    }
}
