/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tours.tags;

import java.io.IOException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import org.apache.log4j.Logger;

/**
 *
 * @author justlex
 */
public class FooterTag extends TagSupport {
    
    private static final Logger LOGGER = Logger.getLogger(FooterTag.class);

    public int doStartTag() {
        String createdBy = "<p align=\"center\">Created by Pavlo Yatsura</p>";
        String year = "<p align=\"center\">2015</p>";

        try {
            JspWriter out = pageContext.getOut();
            out.write(createdBy);
            out.write(year);
        } catch (IOException e) {
            LOGGER.error(e);
        }

        return SKIP_BODY;
    }
}
