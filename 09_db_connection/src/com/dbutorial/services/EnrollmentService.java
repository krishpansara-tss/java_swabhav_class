package com.dbutorial.services;

import com.dbutorial.database.DBConnection;

import java.sql.Connection;

public class EnrollmentService {
    DBConnection dbConnection = DBConnection.getInstance();
    Connection connection = dbConnection.getConnection();



    public void enrollStudent(){

    }
}
