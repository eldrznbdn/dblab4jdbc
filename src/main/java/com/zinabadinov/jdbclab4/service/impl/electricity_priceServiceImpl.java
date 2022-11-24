package com.zinabadinov.jdbclab4.service.impl;

import com.zinabadinov.jdbclab4.dao.electricity_priceDao;
import com.zinabadinov.jdbclab4.dao.sold_energyDao;
import com.zinabadinov.jdbclab4.domain.electricity_price;
import com.zinabadinov.jdbclab4.service.electricity_priceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class electricity_priceServiceImpl implements electricity_priceService {

    @Autowired // перед тем как оно будет использоваться,создасться этот объект и впрыснет его
    private electricity_priceDao electricityPriceDao;

    @Override
    public List<electricity_price> findAll() {
        return electricityPriceDao.findAll();
    }

    @Override
    public Optional<electricity_price> findById(Integer id) {
        return electricityPriceDao.findById(id);
    }

    @Override
    public int create(electricity_price entity) {
        return electricityPriceDao.create(entity);
    }

    @Override
    public int update(Integer id, electricity_price entity) {
        return electricityPriceDao.update(id, entity);
    }

    @Override
    public int delete(Integer id) {
        return electricityPriceDao.delete(id);
    }
}
