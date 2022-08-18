package com.citi.profolio.entities;

public enum ActionEnum {
    BUY("buy"),
    SELL("sell");

    public final String action;

    private ActionEnum(String action) {
        this.action = action;
    }

    public String getAction() {
        return this.action;
    }
}
