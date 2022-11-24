package com.zinabadinov.jdbclab4.service.impl;

import com.zinabadinov.jdbclab4.dao.owner_sDao;
import com.zinabadinov.jdbclab4.domain.owner_s;
import com.zinabadinov.jdbclab4.service.owner_sService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class owner_sServiceImpl implements owner_sService {

    @Autowired
    private owner_sDao ownerSDao;

    @Override
    public List<owner_s> findAll() {
        return ownerSDao.findAll();
    }

    @Override
    public Optional<owner_s> findById(Integer id) {
        return ownerSDao.findById(id);
    }

    @Override
    public int create(owner_s entity) {
        return ownerSDao.create(entity);
    }

    @Override
    public int update(Integer id, owner_s entity) {
        return ownerSDao.update(id, entity);
    }

    @Override
    public int delete(Integer id) {
        return ownerSDao.delete(id);
    }
}
