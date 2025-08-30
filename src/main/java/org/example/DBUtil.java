package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    public static final String URL = "jdbc:mysql://localhost/mydb";
    public static  final String User="root";
    public static final String Pass="Password@123";


    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, User, Pass);
    }
}