package com.citi.profolio.entities;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ticker")
public class Ticker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "companyname")
    private String companyName;
    @Column(name = "tickersymbol")
    private String tickerSymbol;
    @Column(name = "price")
    private Integer price;
    @Column(name = "timezone")
    private String timezone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @Override
    public String toString() {
        return "Ticker{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", tickerSymbol='" + tickerSymbol + '\'' +
                ", price=" + price +
                ", timezone='" + timezone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticker ticker = (Ticker) o;
        return Objects.equals(id, ticker.id) && Objects.equals(companyName, ticker.companyName) && Objects.equals(tickerSymbol, ticker.tickerSymbol) && Objects.equals(price, ticker.price) && Objects.equals(timezone, ticker.timezone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyName, tickerSymbol, price, timezone);
    }
}
