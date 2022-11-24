package com.zinabadinov.jdbclab4.service.impl;

import com.zinabadinov.jdbclab4.dao.instalation_dateDao;
import com.zinabadinov.jdbclab4.domain.instalation_date;
import com.zinabadinov.jdbclab4.service.instalation_dateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class instalation_dateServiceImpl implements instalation_dateService {

    @Autowired // перед тем как оно будет использоваться,создасться этот объект и впрыснет его
    private instalation_dateDao instalationDateDao;

    @Override
    public List<instalation_date> findAll() {
        return instalationDateDao.findAll();
    }

    @Override
    public Optional<instalation_date> findById(Integer id) {
        return instalationDateDao.findById(id);
    }

    @Override
    public int create(instalation_date entity) {
        return instalationDateDao.create(entity);
    }

    @Override
    public int update(Integer id, instalation_date entity) {
        return instalationDateDao.update(id, entity);
    }

    @Override
    public int delete(Integer id) {
        return instalationDateDao.delete(id);
    }
}
