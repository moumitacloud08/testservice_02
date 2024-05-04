package com.example.testservice_02.dao;

import com.example.testservice_02.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {
}
