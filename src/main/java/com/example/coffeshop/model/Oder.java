package com.example.coffeshop.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "oders")
public class Oder extends BisnesEntity {
    private String nameOrganization;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "create_date")
    private LocalDate createDate;
    @ManyToOne(cascade = CascadeType.ALL)
    private Client client;
    @ManyToOne(cascade = CascadeType.ALL)
    private Coffee coffee;

    public Oder() {
    }

    public Oder(String nameOrganization, LocalDate createDate, Client client, Coffee coffee) {
        this.nameOrganization = nameOrganization;
        this.createDate = createDate;
        this.client = client;
        this.coffee = coffee;
    }

    public String getNameOrganization() {
        return nameOrganization;
    }

    public void setNameOrganization(String nameOrganization) {
        this.nameOrganization = nameOrganization;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String toString() {
        return "Oder{" +
                "nameOrganization='" + nameOrganization + '\'' +
                ", createDate=" + createDate +
                ", client=" + client +
                ", coffee=" + coffee +
                '}';
    }
}
