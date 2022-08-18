package com.citi.profolio.entities;

public enum StatusEnum {
    OPEN("open"),
    CLOSE("close"),
    COMPLETED("completed");

    public final String status;

    private StatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
