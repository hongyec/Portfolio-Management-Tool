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

    public static StatusEnum valueOfStatus(String status) {
        for (StatusEnum e : values()) {
            if (e.status.equals(status)) {
                return e;
            }
        }
        return null;
    }
}
