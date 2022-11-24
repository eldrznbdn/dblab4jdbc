package com.zinabadinov.jdbclab4.service.impl;

import com.zinabadinov.jdbclab4.dao.amount_of_stationDao;
import com.zinabadinov.jdbclab4.domain.amount_of_station;
import com.zinabadinov.jdbclab4.service.amount_of_stationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class amount_of_stationServiceImpl implements amount_of_stationService {

    @Autowired // перед тем как оно будет использоваться,создасться этот объект и впрыснет его
    private amount_of_stationDao amountOfStationDao;

    @Override
    public List<amount_of_station> findAll() {
        return amountOfStationDao.findAll();
    }

    @Override
    public Optional<amount_of_station> findById(Integer id) {
        return amountOfStationDao.findById(id);
    }

    @Override
    public int create(amount_of_station entity) {
        return amountOfStationDao.create(entity);
    }

    @Override
    public int update(Integer id, amount_of_station entity) {
        return amountOfStationDao.update(id, entity);
    }

    @Override
    public int delete(Integer id) {
        return amountOfStationDao.delete(id);
    }
}
