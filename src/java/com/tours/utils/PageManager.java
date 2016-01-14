/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tours.utils;

import java.util.ResourceBundle;

/**
 *
 * @author justlex
 */
public class PageManager {
    
    private static PageManager instance;
    private ResourceBundle resourceBundle;
    private static final String BUNDLE_NAME = "com.tours.utils.config";
    public static final String INDEX = "INDEX";
    public static final String DASHBOARD = "DASHBOARD";
    public static final String TOUR_ADDING = "TOURADDING";
    public static final String ALL_TOURS = "ALLTOURS";
    public static final String ERROR = "ERROR";
    public static final String EXCURSIONS = "EXCURSIONS";
    public static final String LOGIN = "LOGIN";
    public static final String SUCCESS = "SUCCESS";
    public static final String REGISTER = "REGISTER";
    public static final String SHOPPING = "SHOPPING";
    public static final String USER_ORDERS = "USERORDERS";
    public static final String VACATION = "VACATION";
    public static final String PERSONAL_ROOM = "PERSONALROOM";
    
    public static PageManager getInstance() {
        if (instance == null) {
            instance = new PageManager();
            instance.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }
    
    public String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
