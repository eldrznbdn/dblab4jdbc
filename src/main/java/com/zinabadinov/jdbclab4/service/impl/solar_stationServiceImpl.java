package com.zinabadinov.jdbclab4.service.impl;

import com.zinabadinov.jdbclab4.dao.solar_stationDao;
import com.zinabadinov.jdbclab4.domain.solar_station;
import com.zinabadinov.jdbclab4.service.solar_stationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class solar_stationServiceImpl implements solar_stationService {

    @Autowired // перед тем как оно будет использоваться,создасться этот объект и впрыснет его
    private solar_stationDao solarStationDao;

    @Override
    public List<solar_station> findAll() {
        return solarStationDao.findAll();
    }

    @Override
    public Optional<solar_station> findById(Integer id) {
        return solarStationDao.findById(id);
    }

    @Override
    public int create(solar_station entity) {
        return solarStationDao.create(entity);
    }

    @Override
    public int update(Integer id, solar_station entity) {
        return solarStationDao.update(id, entity);
    }

    @Override
    public int delete(Integer id) {
        return solarStationDao.delete(id);
    }
}
