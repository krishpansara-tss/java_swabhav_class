package com.tssconsultancy.core.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Harddisk {
    private Integer capacity;

    public Harddisk(Integer capacity) {
        this.capacity = capacity;
    }

    public Harddisk() {
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Harddisk{" +
                "capacity=" + capacity +
                '}';
    }
}
