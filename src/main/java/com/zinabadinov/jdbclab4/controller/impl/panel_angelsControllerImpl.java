package com.zinabadinov.jdbclab4.controller.impl;

import com.zinabadinov.jdbclab4.controller.panel_angelsController;
import com.zinabadinov.jdbclab4.domain.panel_angels;
import com.zinabadinov.jdbclab4.service.impl.panel_angelsServiceImpl;
import com.zinabadinov.jdbclab4.service.panel_angelsService;
import com.zinabadinov.jdbclab4.service.sold_energyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class panel_angelsControllerImpl implements panel_angelsController {

    @Autowired
    private panel_angelsServiceImpl panelAngelsService;

    @Override
    public List<panel_angels> findAll() {
        return panelAngelsService.findAll();
    }

    @Override
    public Optional<panel_angels> findById(Integer id) {
        return panelAngelsService.findById(id);
    }

    @Override
    public int create(panel_angels entity) {
        return panelAngelsService.create(entity);
    }

    @Override
    public int update(Integer id, panel_angels entity) {
        return panelAngelsService.update(id, entity);
    }

    @Override
    public int delete(Integer id) {
        return panelAngelsService.delete(id);
    }
}
