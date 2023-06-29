package com.example.coffeshop.model;

import com.example.coffeshop.util.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "coffee")
public class Coffee extends BisnesEntity {
    @Column(name = "description")
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "price")
    private BigDecimal price;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "create_date")
    private LocalDate createDate;
    @Column(name = "is_remove")
    private boolean isRemove;

    public Coffee() {
    }

    public Coffee(String description, Status status, BigDecimal price, LocalDate createDate, boolean isRemove) {
        this.description = description;
        this.status = status;
        this.price = price;
        this.createDate = createDate;
        this.isRemove = isRemove;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public boolean isRemove() {
        return isRemove;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public void setRemove(boolean remove) {
        isRemove = remove;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "description='" + description + '\'' +
                ", status=" + status +
                ", price=" + price +
                ", createDate=" + createDate +
                ", isRemove=" + isRemove +
                '}';
    }
}
