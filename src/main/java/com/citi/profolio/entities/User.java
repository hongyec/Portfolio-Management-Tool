package com.citi.profolio.entities;

import java.util.Objects;

public class User {
    private String name;
    private Double balance;
    private Double overallGrowth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getOverallGrowth() {
        return overallGrowth;
    }

    public void setOverallGrowth(Double overallGrowth) {
        this.overallGrowth = overallGrowth;
    }

    public User(String name, Double balance, Double overallGrowth) {
        this.name = name;
        this.balance = balance;
        this.overallGrowth = overallGrowth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(balance, user.balance) && Objects.equals(overallGrowth, user.overallGrowth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, balance, overallGrowth);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", overallGrowth=" + overallGrowth +
                '}';
    }
}
