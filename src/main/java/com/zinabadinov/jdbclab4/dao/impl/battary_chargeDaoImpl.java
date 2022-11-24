package com.zinabadinov.jdbclab4.dao.impl;

import com.zinabadinov.jdbclab4.dao.battary_chargeDao;
import com.zinabadinov.jdbclab4.domain.battary_charge;
import com.zinabadinov.jdbclab4.domain.solar_station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class battary_chargeDaoImpl implements battary_chargeDao {

    public static final String FIND_ALL = "SELECT * FROM battary_charge";
    public static final String FIND_BY_ID = "SELECT * FROM battary_charge WHERE id=?";
    public static final String UPDATE = "UPDATE battary_charge SET type_of_charge=?,solar_station_id=? WHERE id=?";
    public static final String CREATE = "INSERT INTO battary_charge (id,type_of_charge, solar_station_id) VALUES (default,?,?)";
    public static final String DELETE = "DELETE FROM battary_charge WHERE id=?";

    @Autowired // вставка через поля
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<battary_charge> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(battary_charge.class));

    }

    @Override
    public Optional<battary_charge> findById(Integer id) {
        Optional<battary_charge> battary_charge;
        try {
            battary_charge = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(battary_charge.class),id));
        }catch (EmptyResultDataAccessException e){
            battary_charge = Optional.empty();
        }
        return battary_charge;
    }

    @Override
    public int create(battary_charge entity) {
        return jdbcTemplate.update(CREATE,entity.getType_of_charge(),entity.getSolar_station_id());
    }

    @Override
    public int update(Integer id, battary_charge entity) {
        return jdbcTemplate.update(UPDATE,entity.getType_of_charge(),entity.getSolar_station_id(), id);

    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE,id);
    }
}
