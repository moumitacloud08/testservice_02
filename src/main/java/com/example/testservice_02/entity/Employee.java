package com.example.testservice_02.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    @ManyToOne
    @JoinColumn(name ="city_id")
    private City city;

    public Employee(String name, City city) {
        this.name = name;
        this.city = city;
    }

    public Employee() {
    }
}
