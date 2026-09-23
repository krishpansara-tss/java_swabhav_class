package com.tssconsultancy.core.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Table(name = "instructors")
@RequiredArgsConstructor
@Data
public class Instructor {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long instructorId;

    @Column
    private String instructorName;

    @Column
    private Double salary;

    @Column
    private String designation;

    @Column(name = "isActive")
    private boolean isActive = true;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, mappedBy = "instructor", fetch = FetchType.LAZY)
    private List<Course> courseList;
}
