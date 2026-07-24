package com.tssconsultancy.core.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Computer {
    private String company;
    private HardDisk hardDisk;

    @Autowired
    public Computer(@Value("Gigabyte") String company, HardDisk hardDisk) {
        this.company = company;
        this.hardDisk = hardDisk;
    }

    public Computer(){}

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public HardDisk getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(HardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "company='" + company + '\'' +
                ", hardDisk=" + hardDisk +
                '}';
    }
}
