package com.zinabadinov.jdbclab4.dao.impl;

import com.zinabadinov.jdbclab4.dao.sold_energyDao;
import com.zinabadinov.jdbclab4.domain.sold_energy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service //чтобы можно было создавать объекты и засовывать их?тоесть спринг будет сам создавать и вставлять их
public class sold_energyDaoImpl implements sold_energyDao {
    public static final String FIND_ALL = "SELECT * FROM sold_energy";
    public static final String FIND_BY_ID = "SELECT * FROM sold_energy WHERE id=?";
    public static final String UPDATE = "UPDATE sold_energy SET amount_of_sold_energy=?, solar_station_id=? WHERE id=?";
    public static final String CREATE = "INSERT INTO sold_energy (id,amount_of_sold_energy, solar_station_id) VALUES (default,?, ?)";
    public static final String DELETE = "DELETE FROM sold_energy WHERE id=?";

    @Autowired // вставка через поля
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<sold_energy> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(sold_energy.class));
    }

    @Override
    public Optional<sold_energy> findById(Integer id) {
        Optional<sold_energy> sold_energy;
        try {
            sold_energy = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(sold_energy.class),id));
        }catch (EmptyResultDataAccessException e){
            sold_energy = Optional.empty();
        }
        return sold_energy;
    }

    @Override
    public int create(sold_energy entity) {
        return jdbcTemplate.update(CREATE,entity.getAmount_of_sold_energy(),entity.getSolar_station_id());
    }

    @Override
    public int update(Integer id, sold_energy entity) {
        return jdbcTemplate.update(UPDATE,entity.getAmount_of_sold_energy(),entity.getSolar_station_id(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE,id);
    }
}
