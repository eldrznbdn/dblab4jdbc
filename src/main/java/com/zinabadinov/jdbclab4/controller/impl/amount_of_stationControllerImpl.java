package com.zinabadinov.jdbclab4.controller.impl;

import com.zinabadinov.jdbclab4.controller.amount_of_stationController;
import com.zinabadinov.jdbclab4.domain.amount_of_station;
import com.zinabadinov.jdbclab4.service.amount_of_stationService;
import com.zinabadinov.jdbclab4.service.impl.amount_of_stationServiceImpl;
import com.zinabadinov.jdbclab4.service.sold_energyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class amount_of_stationControllerImpl implements amount_of_stationController {

    @Autowired
    private amount_of_stationServiceImpl amountOfStationService;

    @Override
    public List<amount_of_station> findAll() {
        return amountOfStationService.findAll();
    }

    @Override
    public Optional<amount_of_station> findById(Integer id) {
        return amountOfStationService.findById(id);
    }

    @Override
    public int create(amount_of_station entity) {
        return amountOfStationService.create(entity);
    }

    @Override
    public int update(Integer id, amount_of_station entity) {
        return amountOfStationService.update(id, entity);
    }

    @Override
    public int delete(Integer id) {
        return amountOfStationService.delete(id);
    }
}
