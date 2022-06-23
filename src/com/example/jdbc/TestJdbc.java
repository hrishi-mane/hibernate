package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {
        String jdbc = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
        String user = "hbstudent";
        String pass = "hbstudent";


        try {
            System.out.println("Trying to connect to database...." + jdbc);
            Connection myConn = DriverManager.getConnection(jdbc, user, pass);
            System.out.println("Connection successful");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
