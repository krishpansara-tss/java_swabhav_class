package com.tssconsultancy.creational.signlton.solution.model;

public class DBConnection {
    private static DBConnection connection = null;
    private DBConnection(){
    }

    public static DBConnection getInstance(){
        if( connection == null){
            System.out.println("Connection wa null but now it is now established");
            connection = new DBConnection();
        }

        System.out.println("Returning the connection");
        return connection;
    }
}
