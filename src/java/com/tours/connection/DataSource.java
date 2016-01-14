package com.tours.connection;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

    private static final Logger LOGGER = Logger.getLogger(DataSource.class);

    private final String DRIVER = "org.gjt.mm.mysql.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=UTF-8";
    private final String USER = "root";
    private final String PASSWORD = "";

    public DataSource() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            LOGGER.error(e, e);
        }
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            LOGGER.error(e, e);
        }
        return connection;
    }
}
