package com.epam.projects.kidsshop.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Cart {
    private long id;
    private long orderId;
    private long itemId;
    private LocalDate date;
    private String name;
    private int quantity;
    private BigDecimal price;
    private BigDecimal totalCost;
    private String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return id == cart.id &&
                orderId == cart.orderId &&
                itemId == cart.itemId &&
                quantity == cart.quantity &&
                Objects.equals(date, cart.date) &&
                Objects.equals(name, cart.name) &&
                Objects.equals(price, cart.price) &&
                Objects.equals(totalCost, cart.totalCost) &&
                Objects.equals(status, cart.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderId, itemId, date, name, quantity, price, totalCost, status);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", itemId=" + itemId +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", totalCost=" + totalCost +
                ", status='" + status + '\'' +
                '}';
    }
}
