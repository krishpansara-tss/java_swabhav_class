package com.dbutorial.services;

import com.dbutorial.database.DBConnection;
import com.dbutorial.model.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseServices {
    DBConnection dbConnection = DBConnection.getInstance();
    Connection connection = dbConnection.getConnection();

    PreparedStatement preparedStatement;

    public List<Course> getAllCourse(){
        List<Course> courseList = new ArrayList<>();

        try{
            String query = "SELECT * FROM courses";
            preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                Course course = new Course();
                course.setCourse_id(rs.getInt("course_id"));
                course.setCourse_name(rs.getString("course_name"));
                course.setCourse_author_name(rs.getString("course_author_name"));
                course.setCourse_price(rs.getDouble("course_price"));
                course.setRating(rs.getDouble("rating"));
                course.setDiscount_percentage(rs.getDouble("discount_percentage"));
                course.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());

                courseList.add(course);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return courseList;
    }

    public void addCourse(Course course){
         try{
             String query = "INSERT INTO courses(course_name, course_author_name, course_price, discount_percentage) VALUES (?, ?, ?, ?);";
             preparedStatement = connection.prepareStatement(query);
             preparedStatement.setString(1, course.getCourse_name());
             preparedStatement.setString(2, course.getCourse_author_name());
             preparedStatement.setDouble(3, course.getCourse_price());
             preparedStatement.setDouble(4, course.getDiscount_percentage());

             int cnt = preparedStatement.executeUpdate();
             if(cnt <= 0){
                 System.out.println("ERROR: Failed to insert course");
                 return;
             }
             System.out.println("Data inserted successfully");
         } catch (SQLException e) {
             System.out.println(e.getMessage());
         }
    }
}
