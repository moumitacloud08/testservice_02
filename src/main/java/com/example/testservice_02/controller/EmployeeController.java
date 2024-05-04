package com.example.testservice_02.controller;

import com.example.testservice_02.dao.CityDao;
import com.example.testservice_02.dao.EmployeeDao;
import com.example.testservice_02.ds.EmployeePutRequest;
import com.example.testservice_02.ds.Employees;
import com.example.testservice_02.entity.City;
import com.example.testservice_02.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    CityDao cityDao;

    @GetMapping("/employees")
    public Employees getEmployee(){
        return new Employees(employeeDao.findAll());
    }

    @PutMapping("/employees")
    public void putEmployee(@RequestBody EmployeePutRequest employeePutRequest){
        String requestedCity = employeePutRequest.getCity();
        Optional<City> city= cityDao.findByName(requestedCity);

        City employeeCity = city.orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Employee city [%s] not found",requestedCity))
        );

        employeeDao.save(new Employee(employeePutRequest.getName(), employeeCity));
    }
}
