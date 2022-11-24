package com.zinabadinov.jdbclab4.controller.impl;

import com.zinabadinov.jdbclab4.controller.solar_stationController;
import com.zinabadinov.jdbclab4.domain.solar_station;
import com.zinabadinov.jdbclab4.service.impl.solar_stationServiceImpl;
import com.zinabadinov.jdbclab4.service.solar_stationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class solar_stationControllerImpl implements solar_stationController {

    @Autowired
    private solar_stationServiceImpl solarStationService;

    @Override
    public List<solar_station> findAll() {
        return solarStationService.findAll();
    }

    @Override
    public Optional<solar_station> findById(Integer id) {
        return solarStationService.findById(id);
    }

    @Override
    public int create(solar_station entity) {
        return solarStationService.create(entity);
    }

    @Override
    public int update(Integer id, solar_station entity) {
        return solarStationService.update(id, entity);
    }

    @Override
    public int delete(Integer id) {
        return solarStationService.delete(id);
    }
}
