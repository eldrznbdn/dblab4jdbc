package com.zinabadinov.jdbclab4.dao.impl;

import com.zinabadinov.jdbclab4.dao.electricity_priceDao;
import com.zinabadinov.jdbclab4.domain.electricity_price;
import com.zinabadinov.jdbclab4.domain.solar_station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class electricity_priceDaoImpl implements electricity_priceDao {

    public static final String FIND_ALL = "SELECT * FROM electricity_price";
    public static final String FIND_BY_ID = "SELECT * FROM electricity_price WHERE id=?";
    public static final String UPDATE = "UPDATE electricity_price SET price=?, solar_station_id=? WHERE id=?";
    public static final String CREATE = "INSERT INTO electricity_price (id,price, solar_station_id) VALUES (default,?,?)";
    public static final String DELETE = "DELETE FROM electricity_price WHERE id=?";

    @Autowired // вставка через поля
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<electricity_price> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(electricity_price.class));
    }

    @Override
    public Optional<electricity_price> findById(Integer id) {
        Optional<electricity_price> electricity_price;
        try {
            electricity_price = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(electricity_price.class),id));
        }catch (EmptyResultDataAccessException e){
            electricity_price = Optional.empty();
        }
        return electricity_price;
    }

    @Override
    public int create(electricity_price entity) {
        return jdbcTemplate.update(CREATE,entity.getPrice(),entity.getSolar_station_id());

    }

    @Override
    public int update(Integer id, electricity_price entity) {
        return jdbcTemplate.update(UPDATE,entity.getPrice(),entity.getSolar_station_id(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE,id);
    }
}
