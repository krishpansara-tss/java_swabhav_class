package com.tssconsultancy.core.reposetory;

import com.tssconsultancy.core.dto.InstructorCourseCountDTO;
import com.tssconsultancy.core.models.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor,Long> {
    @Query("SELECT COUNT(c) FROM Course c WHERE c.instructor.instructorId = :id")
    int getCountByInstructorId(Long id);

    @Query("""
        SELECT i.instructorName, COUNT(c)
        FROM Instructor i
        LEFT JOIN i.courseList c
        GROUP BY i.instructorId, i.instructorName
    """)
    List<Object[]> getAllInstructorCourseCount();
}
