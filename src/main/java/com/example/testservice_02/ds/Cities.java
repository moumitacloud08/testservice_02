package com.example.testservice_02.ds;

import com.example.testservice_02.entity.City;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cities {
    private Iterable<City> cities;

    public Cities() {
    }
}
