/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tours.commands;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 *
 * @author justlex
 */
public class DangerousCommand implements Command{
    
    private static final Logger LOGGER = Logger.getLogger(DangerousCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        try {
            throw new Exception("dangerous exception");
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return null;
    }
}
