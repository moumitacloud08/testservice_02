package com.example.testservice_02.dao;

import com.example.testservice_02.entity.City;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CityDao extends CrudRepository<City, Integer> {

    public Optional<City> findByName(String name) ;
}
