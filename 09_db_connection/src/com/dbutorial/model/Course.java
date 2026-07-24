package com.dbutorial.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Course {
    private int course_id;
    private String course_name;
    private String  course_author_name;
    private double course_price;
    private double discount_percentage;
    private double rating;
    private LocalDateTime created_at;

    public Course() {}

    public Course( String course_name, String course_author_name, double course_price, double discount_percentage) {
        this.course_name = course_name;
        this.course_author_name = course_author_name;
        this.course_price = course_price;
        this.discount_percentage = discount_percentage;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_author_name() {
        return course_author_name;
    }

    public void setCourse_author_name(String course_author_name) {
        this.course_author_name = course_author_name;
    }

    public double getCourse_price() {
        return course_price;
    }

    public void setCourse_price(double course_price) {
        this.course_price = course_price;
    }

    public double getDiscount_percentage() {
        return discount_percentage;
    }

    public void setDiscount_percentage(double discount_percentage) {
        this.discount_percentage = discount_percentage;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id=" + course_id +
                ", course_name='" + course_name + '\'' +
                ", course_author_name='" + course_author_name + '\'' +
                ", course_price=" + course_price +
                ", discount_percentage=" + discount_percentage +
                ", rating=" + rating +
                ", created_at=" + created_at +
                '}';
    }
}
