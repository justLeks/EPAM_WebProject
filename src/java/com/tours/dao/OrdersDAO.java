/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tours.dao;

import com.tours.entities.Order;
import java.util.List;

/**
 *
 * @author justlex
 */
public interface OrdersDAO {

    List<Order> findAll();

    void addOrder(int idTour, int idCustomer, int price);

    List<Order> findWhereUserIdEquals(int idUser);

    List<Order> findWhereTourIdEquals(int idTour);

    List<Order> findWhereDateEquals(String date);

    List<Order> findWherePriceEquals(int price);

    List<Order> findWherePaidEquals(boolean paid);

    List<Order> findWhereConfirmedEquals(boolean confirmed);
    
    void updateOrderPaid(int idOrder);
    
    void updateOrderConfirmed(int idOrder);

}
