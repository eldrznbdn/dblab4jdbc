package com.zinabadinov.jdbclab4.service.impl;

import com.zinabadinov.jdbclab4.dao.battary_chargeDao;
import com.zinabadinov.jdbclab4.dao.sold_energyDao;
import com.zinabadinov.jdbclab4.domain.battary_charge;
import com.zinabadinov.jdbclab4.service.battary_chargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class battary_chargeServiceImpl implements battary_chargeService {

    @Autowired // перед тем как оно будет использоваться,создасться этот объект и впрыснет его
    private battary_chargeDao battaryChargeDao;

    @Override
    public List<battary_charge> findAll() {
        return battaryChargeDao.findAll();
    }

    @Override
    public Optional<battary_charge> findById(Integer id) {
        return battaryChargeDao.findById(id);
    }

    @Override
    public int create(battary_charge entity) {
        return battaryChargeDao.create(entity);
    }

    @Override
    public int update(Integer id, battary_charge entity) {
        return battaryChargeDao.update(id, entity);
    }

    @Override
    public int delete(Integer id) {
        return battaryChargeDao.delete(id);
    }
}
