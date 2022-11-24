package com.zinabadinov.jdbclab4.dao.impl;

import com.zinabadinov.jdbclab4.dao.instalation_dateDao;
import com.zinabadinov.jdbclab4.domain.instalation_date;
import com.zinabadinov.jdbclab4.domain.solar_station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class instalation_dateDaoImpl implements instalation_dateDao {

    public static final String FIND_ALL = "SELECT * FROM instalation_date";
    public static final String FIND_BY_ID = "SELECT * FROM instalation_date WHERE id=?";
    public static final String UPDATE = "UPDATE instalation_date SET ins_date=?, solar_station_id=? WHERE id=?";
    public static final String CREATE = "INSERT INTO instalation_date (id,ins_date, solar_station_id) VALUES (default,?,?)";
    public static final String DELETE = "DELETE FROM instalation_date WHERE id=?";

    @Autowired // вставка через поля
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<instalation_date> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(instalation_date.class));
    }

    @Override
    public Optional<instalation_date> findById(Integer id) {
        Optional<instalation_date> instalation_date;
        try {
            instalation_date = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(instalation_date.class),id));
        }catch (EmptyResultDataAccessException e){
            instalation_date = Optional.empty();
        }
        return instalation_date;
    }

    @Override
    public int create(instalation_date entity) {
        return jdbcTemplate.update(CREATE,entity.getIns_date(),entity.getSolar_station_id());

    }

    @Override
    public int update(Integer id, instalation_date entity) {
        return jdbcTemplate.update(UPDATE,entity.getIns_date(),entity.getSolar_station_id(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE,id);
    }
}
