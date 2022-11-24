package com.zinabadinov.jdbclab4.controller.impl;

import com.zinabadinov.jdbclab4.controller.sold_energyController;
import com.zinabadinov.jdbclab4.domain.sold_energy;
import com.zinabadinov.jdbclab4.service.impl.sold_energyServiceImpl;
import com.zinabadinov.jdbclab4.service.sold_energyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // для того чтобы иос контейнер мог создать объект и впрыснуть его
public class sold_energyControllerImpl implements sold_energyController {

    @Autowired
    private sold_energyServiceImpl soldEnergyService;

    @Override
    public List<sold_energy> findAll() {
        return soldEnergyService.findAll();
    }

    @Override
    public Optional<sold_energy> findById(Integer id) {
        return soldEnergyService.findById(id);
    }

    @Override
    public int create(sold_energy entity) {
        return soldEnergyService.create(entity);
    }

    @Override
    public int update(Integer id, sold_energy entity) {
        return soldEnergyService.update(id, entity);
    }

    @Override
    public int delete(Integer id) {
        return soldEnergyService.delete(id);
    }
}
