package com.zinabadinov.jdbclab4.dao.impl;

import com.zinabadinov.jdbclab4.dao.owner_sDao;
import com.zinabadinov.jdbclab4.domain.owner_s;
import com.zinabadinov.jdbclab4.domain.solar_station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class owner_sDaoImpl implements owner_sDao {

    public static final String FIND_ALL = "SELECT * FROM owner_s";
    public static final String FIND_BY_ID = "SELECT * FROM owner_s WHERE id=?";
    public static final String UPDATE = "UPDATE owner_s SET name=?, surname=? WHERE id=?";
    public static final String CREATE = "INSERT INTO owner_s (id,name, surname) VALUES (default,?,?)";
    public static final String DELETE = "DELETE FROM owner_s WHERE id=?";

    @Autowired // вставка через поля
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<owner_s> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(owner_s.class));

    }

    @Override
    public Optional<owner_s> findById(Integer id) {
        Optional<owner_s> owner_s;
        try {
            owner_s = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(owner_s.class),id));
        }catch (EmptyResultDataAccessException e){
            owner_s = Optional.empty();
        }
        return owner_s;
    }

    @Override
    public int create(owner_s entity) {
        return jdbcTemplate.update(CREATE,entity.getName(),entity.getSurname());
    }

    @Override
    public int update(Integer id, owner_s entity) {
        return jdbcTemplate.update(UPDATE,entity.getName(),entity.getSurname(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE,id);
    }
}
