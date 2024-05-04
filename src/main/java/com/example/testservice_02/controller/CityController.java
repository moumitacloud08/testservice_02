package com.example.testservice_02.controller;

import com.example.testservice_02.dao.CityDao;
import com.example.testservice_02.ds.Cities;
import com.example.testservice_02.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    @Autowired
    private CityDao cityDao;

    @GetMapping("/cities")
    public Cities getCities() {
        return new Cities(cityDao.findAll());
    }

    @PutMapping("/cities")
    public void putCity(@RequestBody City city) {
        cityDao.save(city);
    }
}
