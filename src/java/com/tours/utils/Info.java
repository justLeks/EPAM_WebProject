/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tours.utils;

import java.util.Objects;

/**
 *
 * @author justlex
 */
public class Info {

    private int idOrder;
    private String name;
    private int tourType;
    private int hotelClass;
    private int price;
    private boolean hot;
    private String destCountry;
    private String startDay;
    private String endDay;
    private String food;
    private int afterPrice;
    private boolean paid;
    private boolean approved;
    private String date;

    public Info(int idOrder, String name, int tourType, int hotelClass, int price, boolean hot, String destCountry, String startDay, String endDay, String food, int afterPrice, boolean paid, boolean approved, String date) {
        this.idOrder = idOrder;
        this.name = name;
        this.tourType = tourType;
        this.hotelClass = hotelClass;
        this.price = price;
        this.hot = hot;
        this.destCountry = destCountry;
        this.startDay = startDay;
        this.endDay = endDay;
        this.food = food;
        this.afterPrice = afterPrice;
        this.paid = paid;
        this.approved = approved;
        this.date = date;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTourType() {
        return tourType;
    }

    public void setTourType(int tourType) {
        this.tourType = tourType;
    }

    public int getHotelClass() {
        return hotelClass;
    }

    public void setHotelClass(int hotelClass) {
        this.hotelClass = hotelClass;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isHot() {
        return hot;
    }

    public void setHot(boolean hot) {
        this.hot = hot;
    }

    public String getDestCountry() {
        return destCountry;
    }

    public void setDestCountry(String destCountry) {
        this.destCountry = destCountry;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public int getAfterPrice() {
        return afterPrice;
    }

    public void setAfterPrice(int afterPrice) {
        this.afterPrice = afterPrice;
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
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + this.tourType;
        hash = 29 * hash + this.hotelClass;
        hash = 29 * hash + this.price;
        hash = 29 * hash + (this.hot ? 1 : 0);
        hash = 29 * hash + Objects.hashCode(this.destCountry);
        hash = 29 * hash + Objects.hashCode(this.startDay);
        hash = 29 * hash + Objects.hashCode(this.endDay);
        hash = 29 * hash + Objects.hashCode(this.food);
        hash = 29 * hash + this.afterPrice;
        hash = 29 * hash + (this.paid ? 1 : 0);
        hash = 29 * hash + (this.approved ? 1 : 0);
        hash = 29 * hash + Objects.hashCode(this.date);
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
        final Info other = (Info) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.tourType != other.tourType) {
            return false;
        }
        if (this.hotelClass != other.hotelClass) {
            return false;
        }
        if (this.price != other.price) {
            return false;
        }
        if (this.hot != other.hot) {
            return false;
        }
        if (!Objects.equals(this.destCountry, other.destCountry)) {
            return false;
        }
        if (!Objects.equals(this.startDay, other.startDay)) {
            return false;
        }
        if (!Objects.equals(this.endDay, other.endDay)) {
            return false;
        }
        if (!Objects.equals(this.food, other.food)) {
            return false;
        }
        if (this.afterPrice != other.afterPrice) {
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
        return "Info{" + "name=" + name + ", tourType=" + tourType + ", hotelClass=" + hotelClass + ", price=" + price + ", hot=" + hot + ", destCountry=" + destCountry + ", startDay=" + startDay + ", endDay=" + endDay + ", food=" + food + ", afterPrice=" + afterPrice + ", paid=" + paid + ", approved=" + approved + ", date=" + date + '}';
    }
    
    
}
