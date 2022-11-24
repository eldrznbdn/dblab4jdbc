package com.zinabadinov.jdbclab4.controller.impl;

import com.zinabadinov.jdbclab4.controller.electricity_priceController;
import com.zinabadinov.jdbclab4.domain.electricity_price;
import com.zinabadinov.jdbclab4.service.electricity_priceService;
import com.zinabadinov.jdbclab4.service.impl.electricity_priceServiceImpl;
import com.zinabadinov.jdbclab4.service.sold_energyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class electricity_priceControllerImpl implements electricity_priceController {

    @Autowired
    private electricity_priceServiceImpl electricityPriceService;

    @Override
    public List<electricity_price> findAll() {
        return electricityPriceService.findAll();
    }

    @Override
    public Optional<electricity_price> findById(Integer id) {
        return electricityPriceService.findById(id);
    }

    @Override
    public int create(electricity_price entity) {
        return electricityPriceService.create(entity);
    }

    @Override
    public int update(Integer id, electricity_price entity) {
        return electricityPriceService.update(id, entity);
    }

    @Override
    public int delete(Integer id) {
        return electricityPriceService.delete(id);
    }
}
