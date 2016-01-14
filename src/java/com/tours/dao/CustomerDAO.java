package com.tours.dao;

import com.tours.entities.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> findAll();

    List<Customer> findWhereCustomerIdEquals(int id);
    
    List<Customer> findWhereIdUserTypeEquals(int idUserType);

    List<Customer> findWhereNameEquals(String name);

    List<Customer> findWhereEmailEquals(String email);

    List<Customer> findWherePasswordEquals(String password);

    void addCustomer(Customer person);

    void removeCustomer(int id);
}
