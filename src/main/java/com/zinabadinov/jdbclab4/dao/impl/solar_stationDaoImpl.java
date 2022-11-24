package com.zinabadinov.jdbclab4.dao.impl;

import com.zinabadinov.jdbclab4.dao.solar_stationDao;
import com.zinabadinov.jdbclab4.domain.solar_station;
import com.zinabadinov.jdbclab4.domain.sold_energy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class solar_stationDaoImpl implements solar_stationDao {

    public static final String FIND_ALL = "SELECT * FROM solar_station";
    public static final String FIND_BY_ID = "SELECT * FROM solar_station WHERE id=?";
    public static final String UPDATE = "UPDATE solar_station SET country=?, type_station=?,capacity=? WHERE id=?";
    public static final String CREATE = "INSERT INTO solar_station (id,country, type_station,capacity) VALUES (default,?,?, ?)";
    public static final String DELETE = "DELETE FROM solar_station WHERE id=?";

    @Autowired // вставка через поля
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<solar_station> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(solar_station.class));
    }

    @Override
    public Optional<solar_station> findById(Integer id) {
        Optional<solar_station> sold_energy;
        try {
            sold_energy = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(solar_station.class),id));
        }catch (EmptyResultDataAccessException e){
            sold_energy = Optional.empty();
        }
        return sold_energy;
    }

    @Override
    public int create(solar_station entity) {
        return jdbcTemplate.update(CREATE,entity.getCountry(),entity.getType_station(),entity.getCapacity());
    }

    @Override
    public int update(Integer id, solar_station entity) {
        return jdbcTemplate.update(UPDATE,entity.getCountry(),entity.getType_station(),entity.getCapacity(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE,id);
    }
}
