package com.zinabadinov.jdbclab4.service.impl;

import com.zinabadinov.jdbclab4.dao.sold_energyDao;
import com.zinabadinov.jdbclab4.domain.sold_energy;
import com.zinabadinov.jdbclab4.service.sold_energyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class sold_energyServiceImpl implements sold_energyService {

   @Autowired // перед тем как оно будет использоваться,создасться этот объект и впрыснет его
   private sold_energyDao soldEnergyDao;

    @Override
    public List<sold_energy> findAll() {
        return soldEnergyDao.findAll();
    }

    @Override
    public Optional<sold_energy> findById(Integer id) {
        return soldEnergyDao.findById(id);
    }

    @Override
    public int create(sold_energy entity) {
        return soldEnergyDao.create(entity);
    }

    @Override
    public int update(Integer id, sold_energy entity) {
        return soldEnergyDao.update(id, entity);
    }

    @Override
    public int delete(Integer id) {
        return soldEnergyDao.delete(id);
    }
}
