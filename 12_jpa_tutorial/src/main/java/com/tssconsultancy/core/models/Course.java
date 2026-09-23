package com.tssconsultancy.core.models;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@RequiredArgsConstructor
@Data
@Entity
@Table(name = "courses")
@ToString(onlyExplicitlyIncluded = true)
public class Course {
    @Column
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long courseId;

    @Column
    private String courseName;

    @Column
    private Double fees;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id")
    @JsonIgnore
    private Instructor instructor;

    @Column(name = "isActive")
    private boolean isActive = true;

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledCourse", fetch = FetchType.LAZY)
    private List<Student> enrolledStudents;

    @ToString.Include(name = "instructorName")
    public String getInstructorName() {
        return instructor != null ? instructor.getInstructorName() : null;
    }
}
