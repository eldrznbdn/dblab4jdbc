package com.zinabadinov.jdbclab4.dao.impl;

import com.zinabadinov.jdbclab4.dao.amount_of_stationDao;
import com.zinabadinov.jdbclab4.domain.amount_of_station;
import com.zinabadinov.jdbclab4.domain.solar_station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class amount_of_stationDaoImpl implements amount_of_stationDao {

    public static final String FIND_ALL = "SELECT * FROM amount_of_station";
    public static final String FIND_BY_ID = "SELECT * FROM amount_of_station WHERE id=?";
    public static final String UPDATE = "UPDATE amount_of_station SET amount=?, owner_s_id=? WHERE id=?";
    public static final String CREATE = "INSERT INTO amount_of_station (id,amount, owner_s_id) VALUES (default,?,?)";
    public static final String DELETE = "DELETE FROM amount_of_station WHERE id=?";

    @Autowired // вставка через поля
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<amount_of_station> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(amount_of_station.class));

    }

    @Override
    public Optional<amount_of_station> findById(Integer id) {
        Optional<amount_of_station> amount_of_station;
        try {
            amount_of_station = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(amount_of_station.class),id));
        }catch (EmptyResultDataAccessException e){
            amount_of_station = Optional.empty();
        }
        return amount_of_station;
    }

    @Override
    public int create(amount_of_station entity) {
        return jdbcTemplate.update(CREATE,entity.getAmount(),entity.getOwner_s_id());

    }

    @Override
    public int update(Integer id, amount_of_station entity) {
        return jdbcTemplate.update(UPDATE,entity.getAmount(),entity.getOwner_s_id(),id);

    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE,id);
    }
}
