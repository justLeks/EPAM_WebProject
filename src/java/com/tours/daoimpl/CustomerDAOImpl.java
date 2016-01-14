package com.tours.daoimpl;

import com.tours.connection.DAOFactory;
import com.tours.dao.CustomerDAO;
import com.tours.entities.Customer;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl extends AbstractDAO implements CustomerDAO {

    private static final Logger LOGGER = Logger.getLogger(CustomerDAOImpl.class);

    public CustomerDAOImpl() {
        connection = DAOFactory.getInstance().getConnection();
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        Customer customer = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT + "user");
            resultSet = preparedStatement.executeQuery();
            customers = toCustomerList(resultSet);
        } catch (SQLException e) {
            LOGGER.error(e, e);
        }
        return customers;
    }

    @Override
    public List<Customer> findWhereCustomerIdEquals(int id) {
        return findCustomersWhere("idUser", id);
    }

    @Override
    public List<Customer> findWhereIdUserTypeEquals(int idUserType) {
        return findCustomersWhere("idUserType", idUserType);
    }
    
    @Override
    public List<Customer> findWhereNameEquals(String name) {
        return findCustomersWhere("name", name);
    }

    @Override
    public List<Customer> findWhereEmailEquals(String email) {
        return findCustomersWhere("email", email);
    }

    @Override
    public List<Customer> findWherePasswordEquals(String password) {
        return findCustomersWhere("password", password);
    }

    @Override
    public void addCustomer(Customer person) {
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO user(name, email, password, idUserType) VALUES(?,?,?,?)");
            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getEmail());
            preparedStatement.setString(3, person.getPassword());
            preparedStatement.setInt(4, 2);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e, e);
        }
    }

    @Override
    public void removeCustomer(int id) {
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM user WHERE idUser=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e, e);
        }
    }
}

