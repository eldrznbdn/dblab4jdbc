package com.zinabadinov.jdbclab4.controller.impl;

import com.zinabadinov.jdbclab4.controller.instalation_dateController;
import com.zinabadinov.jdbclab4.domain.instalation_date;
import com.zinabadinov.jdbclab4.service.impl.instalation_dateServiceImpl;
import com.zinabadinov.jdbclab4.service.instalation_dateService;
import com.zinabadinov.jdbclab4.service.sold_energyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class instalation_dateControllerImpl implements instalation_dateController {

    @Autowired
    private instalation_dateServiceImpl instalationDateService;

    @Override
    public List<instalation_date> findAll() {
        return instalationDateService.findAll();
    }

    @Override
    public Optional<instalation_date> findById(Integer id) {
        return instalationDateService.findById(id);
    }

    @Override
    public int create(instalation_date entity) {
        return instalationDateService.create(entity);
    }

    @Override
    public int update(Integer id, instalation_date entity) {
        return instalationDateService.update(id, entity);
    }

    @Override
    public int delete(Integer id) {
        return instalationDateService.delete(id);
    }
}
