/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tours.entities;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author justlex
 */
public class Order implements Serializable{

    private int idOrder;
    private int idTour;
    private int idUser;
    private int price;
    private boolean paid;
    private boolean approved;
    private String date;

    public Order() {
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdTour() {
        return idTour;
    }

    public void setIdTour(int idTour) {
        this.idTour = idTour;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.idOrder;
        hash = 89 * hash + this.idTour;
        hash = 89 * hash + this.idUser;
        hash = 89 * hash + this.price;
        hash = 89 * hash + (this.paid ? 1 : 0);
        hash = 89 * hash + (this.approved ? 1 : 0);
        hash = 89 * hash + Objects.hashCode(this.date);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (this.idOrder != other.idOrder) {
            return false;
        }
        if (this.idTour != other.idTour) {
            return false;
        }
        if (this.idUser != other.idUser) {
            return false;
        }
        if (this.price != other.price) {
            return false;
        }
        if (this.paid != other.paid) {
            return false;
        }
        if (this.approved != other.approved) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Order{" + "idOrder=" + idOrder + ", idTour=" + idTour + ", idUser=" + idUser + ", price=" + price + ", paid=" + paid + ", approved=" + approved + ", date=" + date + '}';
    }
    
}
