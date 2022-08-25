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

    public Order(Date createdDate, Date completedDate, Double marketPrice, Date goodTill, String priceType, String action, String status, Integer numShare, Integer tickerId) {
        this.createdDate = createdDate;
        this.completedDate = completedDate;
        this.marketPrice = marketPrice;
        this.goodTill = goodTill;
        this.priceType = priceType;
        this.action = action;
        this.status = status;
        this.numShare = numShare;
        this.tickerId = tickerId;
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

    public Integer getNumShare(){
        return numShare;
    }

    public void setNumShare(Integer numShare){
        this.numShare = numShare;
    }

    public Integer getTickerId() {
        return tickerId;
    }

    public void setTickerId(Integer tickerId) {
        this.tickerId = tickerId;
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
                ", number of shares='" + numShare + '\''+
                ", tickerId=" + tickerId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && createdDate.equals(order.createdDate) && Objects.equals(completedDate, order.completedDate) && marketPrice.equals(order.marketPrice) && goodTill.equals(order.goodTill) && priceType.equals(order.priceType) && action.equals(order.action) && status.equals(order.status) && numShare.equals(order.numShare) && tickerId.equals(order.tickerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdDate, completedDate, marketPrice, goodTill, priceType, action, status, numShare, tickerId);
    }
}
