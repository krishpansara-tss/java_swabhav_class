package com.tssconsultancy.core.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
@Entity
@Table(name = "students")
public class Student {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @JoinColumn(name = "address_id")
    @OneToOne(cascade = CascadeType.PERSIST)
    private Address address;

    @Column(name = "age")
    private Integer age;

    @Column(name = "isActive")
    private boolean isActive = true;

    @JsonIgnore
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Course> enrolledCourse;

}
