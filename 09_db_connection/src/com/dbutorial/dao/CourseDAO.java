package com.dbutorial.dao;

import com.dbutorial.database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseDAO {
    Connection connection;
    PreparedStatement preparedStatement;

    public CourseDAO() {
        this.connection = DBConnection.getInstance().getConnection();
    }

    public boolean existsById(int courseId) {
        String query = "SELECT 1 FROM courses WHERE course_id = ?";

        try{
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, courseId);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                return rs.next();
            }

        }  catch (SQLException e) {
            throw new RuntimeException("Error checking course existence", e);
        }
    }
}
