package com.example.testservice_02.ds;

import com.example.testservice_02.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employees {
    private Iterable<Employee> employees;

    public Employees() {
    }
}
