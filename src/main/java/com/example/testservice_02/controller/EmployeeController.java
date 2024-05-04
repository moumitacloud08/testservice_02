package com.example.testservice_02.controller;

import com.example.testservice_02.dao.CityDao;
import com.example.testservice_02.dao.EmployeeDao;
import com.example.testservice_02.ds.Employees;
import com.example.testservice_02.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    CityDao cityDao;

    @GetMapping("/employees")
    public Employees getEmployee(){
        return new Employees(employeeDao.findAll());
    }

    public void putEmployee(){

    }
}
