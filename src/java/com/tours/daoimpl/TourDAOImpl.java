package com.tours.daoimpl;

import com.tours.connection.DAOFactory;
import com.tours.dao.TourDAO;
import com.tours.entities.Tour;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TourDAOImpl extends AbstractDAO implements TourDAO {

    private static final Logger LOGGER = Logger.getLogger(CustomerDAOImpl.class);

    public TourDAOImpl() {
        connection = DAOFactory.getInstance().getConnection();
    }

    @Override
    public List<Tour> findAll() {
        List<Tour> tourList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT + "tour");
            resultSet = preparedStatement.executeQuery();
            tourList = toTourList(resultSet);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return tourList;
    }

    @Override
    public Tour findWhereTourIdEquals(int id) {
        return findToursWhere("idTour", id).get(0);
    }

    @Override
    public List<Tour> findWhereIdTourTypeEquals(int idTourType) {
        return findToursWhere("idTourType", idTourType);
    }

    @Override
    public List<Tour> findWherePriceEquals(int price) {
        return findToursWhere("price", price);
    }

    @Override
    public List<Tour> findWhereDestCountyEquals(String destCounty) {
        return findToursWhere("destCountry", destCounty);
    }

    @Override
    public List<Tour> findWhereHotelClassEquals(int hotelClass) {
        return findToursWhere("hotelClass", hotelClass);
    }

    @Override
    public List<Tour> findWhereStartDayEquals(String startDay) {
        return findToursWhere("startDay", startDay);
    }

    @Override
    public List<Tour> findWhereEndDayEquals(String endDay) {
        return findToursWhere("endDay", endDay);
    }

    @Override
    public List<Tour> findWhereFoodEqualsEquals(String food) {
        return findToursWhere("food", food);
    }

    @Override
    public void addTour(Tour tour) {
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO tour(idTourType, hotelClass, price, hot, destCountry, startDay, endDay, food) "
                    + "VALUES(?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, tour.getTourType());
            preparedStatement.setInt(2, tour.getHotelClass());
            preparedStatement.setInt(3, tour.getPrice());
            preparedStatement.setInt(4, (tour.isHot()) ? 1 : 0);
            preparedStatement.setString(5, tour.getDestCountry());
            preparedStatement.setString(6, tour.getStartDay());
            preparedStatement.setString(7, tour.getEndDay());
            preparedStatement.setString(8, tour.getFood());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e, e);
        }
    }

    @Override
    public void removeTour(int id) {
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM tour WHERE idTour=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }
}
