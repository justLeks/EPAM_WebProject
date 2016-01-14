/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tours.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import org.apache.log4j.Logger;

/**
 *
 * @author justlex
 */
public class SessionListener implements ServletRequestListener{

    private static final Logger LOGGER = Logger.getLogger(SessionListener.class);

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        LOGGER.error(sre);
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        LOGGER.info(sre);
    }
    
    
    
}
