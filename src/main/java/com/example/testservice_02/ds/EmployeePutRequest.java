package com.example.testservice_02.ds;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeePutRequest {
    private String name;
    private String city;

    public EmployeePutRequest() {
    }
}
