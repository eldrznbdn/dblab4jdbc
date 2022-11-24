package com.zinabadinov.jdbclab4.controller.impl;

import com.zinabadinov.jdbclab4.controller.battary_chargeController;
import com.zinabadinov.jdbclab4.domain.battary_charge;
import com.zinabadinov.jdbclab4.service.battary_chargeService;
import com.zinabadinov.jdbclab4.service.electricity_priceService;
import com.zinabadinov.jdbclab4.service.impl.battary_chargeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class battary_chargeControllerImpl implements battary_chargeController {

    @Autowired
    private battary_chargeServiceImpl battaryChargeService;

    @Override
    public List<battary_charge> findAll() {
        return battaryChargeService.findAll();
    }

    @Override
    public Optional<battary_charge> findById(Integer id) {
        return battaryChargeService.findById(id);
    }

    @Override
    public int create(battary_charge entity) {
        return battaryChargeService.create(entity);
    }

    @Override
    public int update(Integer id, battary_charge entity) {
        return battaryChargeService.update(id, entity);
    }

    @Override
    public int delete(Integer id) {
        return battaryChargeService.delete(id);
    }
}
