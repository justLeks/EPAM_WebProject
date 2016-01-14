package com.tours.entities;

import java.io.Serializable;

public class Tour implements Serializable {

    private int id;
    private int tourType;
    private int hotelClass;
    private int price;
    private boolean hot;
    private String destCountry;
    private String startDay;
    private String endDay;
    private String food;

    public Tour() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTourType(int tourType) {
        this.tourType = tourType;
    }

    public int getTourType() {
        return tourType;
    }

    public int getHotelClass() {
        return hotelClass;
    }

    public void setHotelClass(int hotelClass) {
        this.hotelClass = hotelClass;
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

    public void setHot(boolean hot) {
        this.hot = hot;
    }

    public boolean isHot() {
        return hot;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tour tour = (Tour) o;

        if (id != tour.id) return false;
        if (tourType != tour.tourType) return false;
        if (hotelClass != tour.hotelClass) return false;
        if (price != tour.price) return false;
        if (hot != tour.hot) return false;
        if (!destCountry.equals(tour.destCountry)) return false;
        if (!startDay.equals(tour.startDay)) return false;
        if (!endDay.equals(tour.endDay)) return false;
        return food.equals(tour.food);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + tourType;
        result = 31 * result + hotelClass;
        result = 31 * result + price;
        result = 31 * result + (hot ? 1 : 0);
        result = 31 * result + destCountry.hashCode();
        result = 31 * result + startDay.hashCode();
        result = 31 * result + endDay.hashCode();
        result = 31 * result + food.hashCode();
        return result;
    }

    @Override
    public String
    toString() {
        return "Tour{" +
                "id=" + id +
                ", tourType=" + tourType +
                ", hotelClass=" + hotelClass +
                ", price=" + price +
                ", hot=" + hot +
                ", destCountry='" + destCountry + '\'' +
                ", startDay='" + startDay + '\'' +
                ", endDay='" + endDay + '\'' +
                ", food='" + food + '\'' +
                '}';
    }
}
