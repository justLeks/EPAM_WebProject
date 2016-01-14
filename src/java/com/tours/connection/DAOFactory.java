package com.tours.connection;

import com.tours.daoimpl.AbstractDAO;
import com.tours.daoimpl.CustomerDAOImpl;
import com.tours.daoimpl.OrdersDAOImpl;
import com.tours.daoimpl.TourDAOImpl;

public class DAOFactory {

    private static DataSource dataSource = null;

    public static DataSource getInstance() {
        if (dataSource == null)
            dataSource = new DataSource();
        return dataSource;
    }

    public static AbstractDAO getDAO (DAOS dao) {
        switch (dao) {
            case CUSTOMER_DAO: 
                return new CustomerDAOImpl();
            case TOUR_DAO: 
                return new TourDAOImpl();
            case ORDERS_DAO: 
                return new OrdersDAOImpl();
            default:
                return null;
        }
    }
}
