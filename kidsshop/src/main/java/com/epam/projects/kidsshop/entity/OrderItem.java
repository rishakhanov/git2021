package com.epam.projects.kidsshop.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class OrderItem {

    private long id;
    private int order_id;
    private int product_id;
    private int quantity;
    private BigDecimal totalCost;
    private String text;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return id == orderItem.id &&
                order_id == orderItem.order_id &&
                product_id == orderItem.product_id &&
                quantity == orderItem.quantity &&
                Objects.equals(totalCost, orderItem.totalCost) &&
                Objects.equals(text, orderItem.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order_id, product_id, quantity, totalCost, text);
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", order_id=" + order_id +
                ", product_id=" + product_id +
                ", quantity=" + quantity +
                ", totalCost=" + totalCost +
                ", text='" + text + '\'' +
                '}';
    }
}
