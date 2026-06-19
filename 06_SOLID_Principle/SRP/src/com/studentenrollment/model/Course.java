package com.studentenrollment.model;

public class Course {
    private String courseName;
    private String courseType;
    private int courseDurationInWeek;
    private int availableSeats;
    private double baseFee;

    public Course(String courseName, String courseType, int courseDurationInWeek, double baseFee, int availableSeats) {
        this.courseName = courseName;
        this.courseType = courseType;
        this.courseDurationInWeek = courseDurationInWeek;
        this.availableSeats = availableSeats;
        this.baseFee = baseFee;
    }

    public String getCourseName() {
        return courseName;
    }

    public double getBaseFee() {
        return baseFee;
    }

    public String getCourseType() {
        return courseType;
    }

    public int getCourseDurationInWeek() {
        return courseDurationInWeek;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void decrementSeats(){
        this.availableSeats--;
    }
}
