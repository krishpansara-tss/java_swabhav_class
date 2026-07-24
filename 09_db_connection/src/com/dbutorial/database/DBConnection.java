package com.dbutorial.database;

import com.dbutorial.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private final String url = "jdbc:postgresql://localhost:5432/java-test";
    private final String username = "postgres";
    private final String password = "Temp@123456";

    private static DBConnection instance;
    private Connection connection;

    private DBConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected successfully");
        }  catch(Exception e){
            System.out.println(e);
        }
    }

    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

}
