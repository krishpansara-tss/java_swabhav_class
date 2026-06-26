package com.tssconsultancy.creational.signlton.solution.test;

import com.tssconsultancy.creational.signlton.solution.model.DBConnection;

public class Main {
    public static void main(String[] args) {
//        DBConnection connection = new DBConnection();
        DBConnection connection1 = DBConnection.getInstance();
        DBConnection connection2 = DBConnection.getInstance();
        DBConnection connection3 = DBConnection.getInstance();
        DBConnection connection4 = DBConnection.getInstance();

        System.out.println(connection1.hashCode());
        System.out.println(connection2.hashCode());
        System.out.println(connection3.hashCode());
        System.out.println(connection4.hashCode());
    }
}
