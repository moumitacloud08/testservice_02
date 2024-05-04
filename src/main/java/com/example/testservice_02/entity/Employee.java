package com.example.testservice_02.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
public class Employee {

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
