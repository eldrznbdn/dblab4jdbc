package com.zinabadinov.jdbclab4.service.impl;

import com.zinabadinov.jdbclab4.dao.panelDao;
import com.zinabadinov.jdbclab4.domain.panel;
import com.zinabadinov.jdbclab4.service.panelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class panelServiceImpl implements panelService {

    @Autowired
    private panelDao panelDao;

    @Override
    public List<panel> findAll() {
        return panelDao.findAll();
    }

    @Override
    public Optional<panel> findById(Integer id) {
        return panelDao.findById(id);
    }

    @Override
    public int create(panel entity) {
        return panelDao.create(entity);
    }

    @Override
    public int update(Integer id, panel entity) {
        return panelDao.update(id, entity);
    }

    @Override
    public int delete(Integer id) {
        return panelDao.delete(id);
    }
}
