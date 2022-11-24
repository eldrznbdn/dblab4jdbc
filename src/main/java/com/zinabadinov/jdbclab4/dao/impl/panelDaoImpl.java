package com.zinabadinov.jdbclab4.dao.impl;

import com.zinabadinov.jdbclab4.dao.panelDao;
import com.zinabadinov.jdbclab4.domain.panel;
import com.zinabadinov.jdbclab4.domain.solar_station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class panelDaoImpl implements panelDao {

    public static final String FIND_ALL = "SELECT * FROM panel";
    public static final String FIND_BY_ID = "SELECT * FROM panel WHERE id=?";
    public static final String UPDATE = "UPDATE panel SET amount_of_panel=?, solar_station_id=? WHERE id=?";
    public static final String CREATE = "INSERT INTO panel (id,amount_of_panel, solar_station_id) VALUES (default,?, ?)";
    public static final String DELETE = "DELETE FROM panel WHERE id=?";

    @Autowired // вставка через поля
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<panel> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(panel.class));
    }

    @Override
    public Optional<panel> findById(Integer id) {
        Optional<panel> panel;
        try {
            panel = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(panel.class),id));
        }catch (EmptyResultDataAccessException e){
            panel = Optional.empty();
        }
        return panel;
    }

    @Override
    public int create(panel entity) {
        return jdbcTemplate.update(CREATE,entity.getAmount_of_panel(),entity.getSolar_station_id());

    }

    @Override
    public int update(Integer id, panel entity) {
        return jdbcTemplate.update(UPDATE,entity.getAmount_of_panel(),entity.getSolar_station_id(),id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE,id);
    }
}
