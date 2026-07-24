package com.tssconsultancy.core.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Computer {
    private String companey;
    private final Harddisk harddisk;

    public Computer(String companey, Harddisk harddisk) {
        this.companey = companey;
        this.harddisk = harddisk;
    }

//    public Computer() {
//    }

    public String getCompaney() {
        return companey;
    }

    @Value("Gigabyte")
    public void setCompaney(String companey) {
        this.companey = companey;
    }

    public Harddisk getHarddisk() {
        return harddisk;
    }

//    @Autowired
//    public void setHarddisk(Harddisk harddisk) {
//        this.harddisk = harddisk;
//    }

    @Override
    public String toString() {
        return "Computer{" +
                "companey='" + companey + '\'' +
                ", harddisk=" + harddisk +
                '}';
    }
}
