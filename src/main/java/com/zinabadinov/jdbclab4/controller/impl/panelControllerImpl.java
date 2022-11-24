package com.zinabadinov.jdbclab4.controller.impl;

import com.zinabadinov.jdbclab4.controller.panelController;
import com.zinabadinov.jdbclab4.domain.panel;
import com.zinabadinov.jdbclab4.service.impl.panelServiceImpl;
import com.zinabadinov.jdbclab4.service.panelService;
import com.zinabadinov.jdbclab4.service.sold_energyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class panelControllerImpl implements panelController {

    @Autowired
    private panelServiceImpl panelService;

    @Override
    public List<panel> findAll() {
        return panelService.findAll();
    }

    @Override
    public Optional<panel> findById(Integer id) {
        return panelService.findById(id);
    }

    @Override
    public int create(panel entity) {
        return panelService.create(entity);
    }

    @Override
    public int update(Integer id, panel entity) {
        return panelService.update(id, entity);
    }

    @Override
    public int delete(Integer id) {
        return panelService.delete(id);
    }
}
