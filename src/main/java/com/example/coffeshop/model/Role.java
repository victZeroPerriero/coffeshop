package com.example.coffeshop.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "roles")
public class Role extends BisnesEntity {
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole role;
}
