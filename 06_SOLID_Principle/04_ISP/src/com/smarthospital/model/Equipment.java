package com.smarthospital.model;

public abstract class Equipment {
    private String id;
    private String name;
    private String status;

    public Equipment(String id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public void displayStatus() {
        System.out.printf("[Status] ID: %s | Name: %s | Status: %s%n", id, name, status);
    }
}
