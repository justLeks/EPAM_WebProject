package com.tours.dao;

import com.tours.entities.Tour;

import java.util.List;

public interface TourDAO {

    List<Tour> findAll();

    Tour findWhereTourIdEquals(int id);

    List<Tour> findWhereIdTourTypeEquals(int idTourType);

    List<Tour> findWhereHotelClassEquals(int hotelClass);

    List<Tour> findWherePriceEquals(int price);

    List<Tour> findWhereDestCountyEquals(String destCounty);

    List<Tour> findWhereStartDayEquals(String startDay);

    List<Tour> findWhereEndDayEquals(String endDay);

    List<Tour> findWhereFoodEqualsEquals(String food);

    void addTour(Tour tour);

    void removeTour(int id);
    
}
