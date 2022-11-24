package com.zinabadinov.jdbclab4.controller.impl;

import com.zinabadinov.jdbclab4.controller.owner_sController;
import com.zinabadinov.jdbclab4.domain.owner_s;
import com.zinabadinov.jdbclab4.service.impl.owner_sServiceImpl;
import com.zinabadinov.jdbclab4.service.owner_sService;
import com.zinabadinov.jdbclab4.service.sold_energyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class owner_sControllerImpl implements owner_sController {

    @Autowired
    private owner_sServiceImpl ownerSService;

    @Override
    public List<owner_s> findAll() {
        return ownerSService.findAll();
    }

    @Override
    public Optional<owner_s> findById(Integer id) {
        return ownerSService.findById(id);
    }

    @Override
    public int create(owner_s entity) {
        return ownerSService.create(entity);
    }

    @Override
    public int update(Integer id, owner_s entity) {
        return ownerSService.update(id, entity);
    }

    @Override
    public int delete(Integer id) {
        return ownerSService.delete(id);
    }
}
