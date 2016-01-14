/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tours.daoimpl;

import com.tours.connection.DAOFactory;
import com.tours.dao.OrdersDAO;
import com.tours.entities.Order;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author justlex
 */
public class OrdersDAOImpl extends AbstractDAO implements OrdersDAO {

    private static final Logger LOGGER = Logger.getLogger(CustomerDAOImpl.class);

    public OrdersDAOImpl() {
        connection = DAOFactory.getInstance().getConnection();
    }

    @Override
    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT + "orders");
            resultSet = preparedStatement.executeQuery();
            orders = toOrderList(resultSet);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return orders;
    }

    @Override
    public void addOrder(int idTour, int idCustomer, int price) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            preparedStatement = connection.prepareStatement("INSERT INTO orders(idTour, idUser, date, price) VALUES(?,?,?,?)");
            preparedStatement.setInt(1, idTour);
            preparedStatement.setInt(2, idCustomer);
            preparedStatement.setString(3, dateFormat.format(Calendar.getInstance().getTime()));
            preparedStatement.setInt(4, price);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    @Override
    public List<Order> findWhereUserIdEquals(int idUser) {
        return findOrdersWhere("idUser", idUser);
    }

    @Override
    public List<Order> findWhereTourIdEquals(int idTour) {
        return findOrdersWhere("idTour", idTour);
    }

    @Override
    public List<Order> findWhereDateEquals(String date) {
        return findOrdersWhere("date", date);
    }

    @Override
    public List<Order> findWherePriceEquals(int price) {
        return findOrdersWhere("price", price);
    }

    @Override
    public List<Order> findWherePaidEquals(boolean paid) {
        return findOrdersWhere("paid", (paid) ? 1 : 0);
    }

    @Override
    public List<Order> findWhereConfirmedEquals(boolean confirmed) {
        return findOrdersWhere("confirmed", (confirmed) ? 1 : 0);
    }

    @Override
    public void updateOrderPaid(int idOrder) {
        try {
            preparedStatement = connection.prepareStatement("UPDATE orders SET paid=1 WHERE idOrder=?");
            preparedStatement.setInt(1, idOrder);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }
    
    @Override
    public void updateOrderConfirmed(int idOrder) {
        try {
            preparedStatement = connection.prepareStatement("UPDATE orders SET confirmed=1 WHERE idOrder=?");
            preparedStatement.setInt(1, idOrder);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }
}
