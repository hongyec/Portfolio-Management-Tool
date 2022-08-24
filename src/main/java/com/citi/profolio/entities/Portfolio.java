package com.citi.profolio.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "portfolio")
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="tickerid")
    private Integer tickerId;

    @Column(name="numshare")
    private Integer numShare;

    public Portfolio() {

    }

    public Portfolio(Integer id, Integer tickerId, Integer numShare) {
        this.id = id;
        this.tickerId = tickerId;
        this.numShare = numShare;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTickerId() {
        return tickerId;
    }

    public void setTickerId(Integer tickerId) {
        this.tickerId = tickerId;
    }

    public Integer getNumShare() {
        return numShare;
    }

    public void setNumShare(Integer numShare) {
        this.numShare = numShare;
    }

    @Override
    public String toString() {
        return "Share{" +
                "id=" + id +
                ", tickerId=" + tickerId +
                ", numShare=" + numShare +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Portfolio portfolio = (Portfolio) o;
        return id.equals(portfolio.id) && tickerId.equals(portfolio.tickerId) && numShare.equals(portfolio.numShare);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tickerId, numShare);
    }
}
