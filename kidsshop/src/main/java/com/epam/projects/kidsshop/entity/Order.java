package com.epam.projects.kidsshop.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Order {

    private long id;
    private int user_id;
    private LocalDate date;
    private String status;
    private BigDecimal totalCost;
    private String details;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                user_id == order.user_id &&
                Objects.equals(date, order.date) &&
                Objects.equals(status, order.status) &&
                Objects.equals(totalCost, order.totalCost) &&
                Objects.equals(details, order.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, date, status, totalCost, details);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", totalCost=" + totalCost +
                ", details='" + details + '\'' +
                '}';
    }
}
