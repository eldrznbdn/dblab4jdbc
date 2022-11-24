package com.zinabadinov.jdbclab4.service.impl;

import com.zinabadinov.jdbclab4.dao.panel_angelsDao;
import com.zinabadinov.jdbclab4.domain.panel_angels;
import com.zinabadinov.jdbclab4.service.panel_angelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class panel_angelsServiceImpl implements panel_angelsService {

    @Autowired // перед тем как оно будет использоваться,создасться этот объект и впрыснет его
    private panel_angelsDao panelAngelsDao;

    @Override
    public List<panel_angels> findAll() {
        return panelAngelsDao.findAll();
    }

    @Override
    public Optional<panel_angels> findById(Integer id) {
        return panelAngelsDao.findById(id);
    }

    @Override
    public int create(panel_angels entity) {
        return panelAngelsDao.create(entity);
    }

    @Override
    public int update(Integer id, panel_angels entity) {
        return panelAngelsDao.update(id, entity);
    }

    @Override
    public int delete(Integer id) {
        return panelAngelsDao.delete(id);
    }
}
