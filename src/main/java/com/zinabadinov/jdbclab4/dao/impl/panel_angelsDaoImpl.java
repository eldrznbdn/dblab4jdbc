package com.zinabadinov.jdbclab4.dao.impl;

import com.zinabadinov.jdbclab4.dao.panel_angelsDao;
import com.zinabadinov.jdbclab4.domain.panel_angels;
import com.zinabadinov.jdbclab4.domain.solar_station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class panel_angelsDaoImpl implements panel_angelsDao {

    public static final String FIND_ALL = "SELECT * FROM panel_angels";
    public static final String FIND_BY_ID = "SELECT * FROM panel_angels WHERE id=?";
    public static final String UPDATE = "UPDATE panel_angels SET tilt=?, panel_id=? WHERE id=?";
    public static final String CREATE = "INSERT INTO panel_angels (id,tilt, panel_id) VALUES (default,?,?)";
    public static final String DELETE = "DELETE FROM panel_angels WHERE id=?";

    @Autowired // вставка через поля
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<panel_angels> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(panel_angels.class));
    }

    @Override
    public Optional<panel_angels> findById(Integer id) {
        Optional<panel_angels> panel_angels;
        try {
            panel_angels = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(panel_angels.class),id));
        }catch (EmptyResultDataAccessException e){
            panel_angels = Optional.empty();
        }
        return panel_angels;
    }

    @Override
    public int create(panel_angels entity) {
        return jdbcTemplate.update(CREATE,entity.getTilt(),entity.getPanel_id());

    }

    @Override
    public int update(Integer id, panel_angels entity) {
        return jdbcTemplate.update(UPDATE,entity.getTilt(),entity.getPanel_id(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE,id);
    }
}
