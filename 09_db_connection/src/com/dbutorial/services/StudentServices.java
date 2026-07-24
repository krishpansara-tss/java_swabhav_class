package com.dbutorial.services;

import com.dbutorial.dao.StudentDAO;
import com.dbutorial.database.DBConnection;
import com.dbutorial.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentServices {
    DBConnection dbConnection = DBConnection.getInstance();
    Connection connection = dbConnection.getConnection();

    StudentDAO studentDAO = new StudentDAO();

    PreparedStatement preparedStatement;
    Statement statement;

    public List<Student> readStudent(){
        List<Student> studentList = new ArrayList<>();
        try {
            statement = connection.createStatement();

            String query = "SELECT * FROM student_db";
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setAge(rs.getInt(3));
                studentList.add(student);
            }

        } catch (SQLException e) {
            System.out.println("EXCEPTION: " + e);
        }

        return studentList;
    }


    public void insertStudent(Student student){
        try {

            studentDAO.insertStudent(student);
            System.out.println("Data inserted successfully");

        } catch (SQLException e) {
            System.out.println("EXCEPTION: " + e);
        }
    }

    public void deleteStudent(int studentId) {
        try {
            if (!studentDAO.existsById(studentId)) {
                System.out.println("ERROR: Student with ID " + studentId + " does not exist");
                return;
            }

            int rowsAffected = studentDAO.deleteStudent(studentId);

            if (rowsAffected > 0) {
                System.out.println("Student deleted successfully");
            } else {
                System.out.println("Failed to delete student");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateStudent(int studentId, String name, int age){
        try {
            String query = "UPDATE student_db SET student_name = ?, age = ?  WHERE student_id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setInt(3, studentId);

            int done = preparedStatement.executeUpdate();
            if(done == 0){
                System.out.println("ERROR: Student Not Found");
                return;
            }

            System.out.println("Student Updated with ID: " + studentId);
        } catch (SQLException e) {
            System.out.println("EXCEPTION: " + e);
        }
    }

    public void enrollStudent(int studentId, int courseId){
        String query = "INSERT INTO student_courses(course_id, student_id) VALUES (?, ?);";
        try{

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, courseId);
            preparedStatement.setInt(2, studentId);
            int cnt = preparedStatement.executeUpdate();
            if(cnt <= 0) {
                System.out.println("ERROR: Failed to enroll the Course");
                return;
            }
            System.out.println("Course enrolled Successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
