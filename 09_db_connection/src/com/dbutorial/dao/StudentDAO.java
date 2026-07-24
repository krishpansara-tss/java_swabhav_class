package com.dbutorial.dao;

import com.dbutorial.database.DBConnection;
import com.dbutorial.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;
    public StudentDAO() {
        this.connection = DBConnection.getInstance().getConnection();
    }

    public int insertStudent(Student student) throws SQLException {
        String query = "INSERT INTO student_db(student_name, age) VALUES(?, ?)";

        preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, student.getName());
        preparedStatement.setInt(2, student.getAge());

        preparedStatement.executeUpdate();

        return 0;
    }

    public int deleteStudent(int studentId) throws SQLException {
        String query = "DELETE FROM student_db WHERE student_id = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, studentId);

        return preparedStatement.executeUpdate();
    }


    public boolean existsById(int studentId) {
        String query = "SELECT 1 FROM student_db WHERE student_id = ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, studentId);

            try(ResultSet rs = ps.executeQuery()){
                return rs.next();
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error checking student existence", e);
        }
    }
}
