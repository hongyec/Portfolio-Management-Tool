package com.citi.profolio.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="createddate")
    private Date createdDate;

    @Column(name="completeddate")
    private Date completedDate;

    @Column(name="marketprice")
    private Double marketPrice;

    @Column(name="goodtill")
    private Date goodTill;

    @Column(name="pricetype")
    private String priceType;

    @Column(name="action")
    private String action;

    @Column(name="status")
    private String status;

    @Column(name="tickerid")
    private Integer tickerId;

    @Column(name="numshare")
    private Integer numShare;

    public Order() {

    }

    public Order(int id, Date createdDate, Date completedDate, Double marketPrice, Date goodTill, String priceType, String action, String status, Integer tickerId, Integer numShare) {
        this.id = id;
        this.createdDate = createdDate;
        this.completedDate = completedDate;
        this.marketPrice = marketPrice;
        this.goodTill = goodTill;
        this.priceType = priceType;
        this.action = action;
        this.status = status;
        this.tickerId = tickerId;
        this.numShare = numShare;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Date getGoodTill() {
        return goodTill;
    }

    public void setGoodTill(Date goodTill) {
        this.goodTill = goodTill;
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public void setNumShare(Integer numShares) {
        this.numShare = numShares;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", createdDate=" + createdDate +
                ", completedDate=" + completedDate +
                ", marketPrice=" + marketPrice +
                ", goodTill=" + goodTill +
                ", priceType='" + priceType + '\'' +
                ", action='" + action + '\'' +
                ", status='" + status + '\'' +
                ", tickerId=" + tickerId +
                ", numShare=" + numShare +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && Objects.equals(createdDate, order.createdDate) && Objects.equals(completedDate, order.completedDate) && Objects.equals(marketPrice, order.marketPrice) && Objects.equals(goodTill, order.goodTill) && Objects.equals(priceType, order.priceType) && Objects.equals(action, order.action) && Objects.equals(status, order.status) && Objects.equals(tickerId, order.tickerId) && Objects.equals(numShare, order.numShare);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdDate, completedDate, marketPrice, goodTill, priceType, action, status, tickerId, numShare);
    }
}
