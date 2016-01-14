package com.tours.daoimpl;

import com.tours.entities.Customer;
import com.tours.entities.Order;
import com.tours.entities.Tour;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AbstractDAO {

    protected final String SQL_SELECT = "SELECT * FROM ";
    protected PreparedStatement preparedStatement;
    protected Connection connection;
    protected ResultSet resultSet;
    private static final Logger LOGGER = Logger.getLogger(AbstractDAO.class);

    public List<Tour> findToursWhere(String columnName, int columnValue) {
        List<Tour> tourList = new ArrayList<>();
        try {
            tourList = toTourList(getResults(columnName, columnValue, "tour"));
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return tourList;
    }

    public List<Tour> findToursWhere(String columnName, String columnValue) {
        List<Tour> tourList = new ArrayList<>();
        try {
            tourList = toTourList(getResults(columnName, columnValue, "tour"));
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return tourList;
    }

    public List<Customer> findCustomersWhere(String columnName, int columnValue) {
        List<Customer> customers = new ArrayList<>();
        try {
            customers = toCustomerList(getResults(columnName, columnValue, "user"));
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return customers;
    }

    public List<Customer> findCustomersWhere(String columnName, String columnValue) {
        List<Customer> customers = new ArrayList<>();
        try {
            customers = toCustomerList(getResults(columnName, columnValue, "user"));
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return customers;
    }

    public List<Order> findOrdersWhere(String columnName, int columnValue) {
        List<Order> orders = new ArrayList<>();
        try {
            orders = toOrderList(getResults(columnName, columnValue, "orders"));
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return orders;
    }

    public List<Order> findOrdersWhere(String columnName, String columnValue) {
        List<Order> orders = new ArrayList<>();
        try {
            orders = toOrderList(getResults(columnName, columnValue, "orders"));
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return orders;
    }
    
    protected List<Tour> toTourList(ResultSet resultSet) throws SQLException {
        List<Tour> tourList = new ArrayList<>();
        Tour tour = null;
        while (resultSet.next()) {
            tour = new Tour();
            tour.setId(resultSet.getInt("idTour"));
            tour.setTourType(resultSet.getInt("idTourType"));
            tour.setHotelClass(resultSet.getInt("hotelClass"));
            tour.setPrice(resultSet.getInt("price"));
            tour.setHot((resultSet.getInt("hot") == 1));
            tour.setDestCountry(resultSet.getString("destCountry"));
            tour.setStartDay(resultSet.getString("startDay"));
            tour.setEndDay(resultSet.getString("endDay"));
            tour.setFood(resultSet.getString("food"));
            tourList.add(tour);
        }
        return tourList;
    }

    protected List<Customer> toCustomerList(ResultSet resultSet) throws SQLException {
        List<Customer> customers = new ArrayList<>();
        Customer customer = null;
        while (resultSet.next()) {
            customer = new Customer();
            customer.setIdUserType(resultSet.getInt("idUserType"));
            customer.setName(resultSet.getString("name"));
            customer.setEmail(resultSet.getString("email"));
            customer.setPassword(resultSet.getString("password"));
            customer.setId(resultSet.getInt("idUser"));
            customers.add(customer);
        }
        return customers;
    }

    protected List<Order> toOrderList(ResultSet resultSet) throws SQLException {
        List<Order> orders = new ArrayList<>();
        Order order = null;
        while (resultSet.next()) {
            order = new Order();
            order.setIdOrder(resultSet.getInt("idOrder"));
            order.setIdTour(resultSet.getInt("idTour"));
            order.setIdUser(resultSet.getInt("idUser"));
            order.setDate(resultSet.getString("date"));
            order.setPrice(resultSet.getInt("price"));
            order.setApproved(resultSet.getInt("confirmed") == 1);
            order.setPaid(resultSet.getInt("paid") == 1);
            orders.add(order);
        }
        return orders;
    }

    protected ResultSet getResults(String columnName, int columnValue, String tableName) throws SQLException {
        preparedStatement = connection.prepareStatement(SQL_SELECT + tableName + " WHERE " + columnName + "=?");
        preparedStatement.setInt(1, columnValue);
        return preparedStatement.executeQuery();
    }

    protected ResultSet getResults(String columnName, String columnValue, String tableName) throws SQLException {
        preparedStatement = connection.prepareStatement(SQL_SELECT + tableName + " WHERE " + columnName + "=?");
        preparedStatement.setString(1, columnValue);
        return preparedStatement.executeQuery();
    }
}
