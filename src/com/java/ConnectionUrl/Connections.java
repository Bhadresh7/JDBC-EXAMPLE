package com.java.ConnectionUrl;

import java.sql.*;

public class Connections {
    final static String URL = "jdbc:mysql://localhost:3306/userdetails";
    final static String USERNAME = "root";
    final static String PASSWORD = "bhadreshpalani";
    final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private Connection con = null;

    public Connection loadDriver() {
        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    // Close the connection
    public void closeConnection() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
