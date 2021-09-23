package com.evgeniy.web.crud.hibernate.services;

import com.evgeniy.web.crud.hibernate.dao.CountryDao;
import com.evgeniy.web.crud.hibernate.entity.Country;

import java.util.List;

public class CountryService implements Services<Country, Long>{
    CountryDao countryDao = new CountryDao();
    @Override
    public void add(Country entity) {
        countryDao.add(entity);
    }

    @Override
    public void update(Country entity) {
        countryDao.update(entity);
    }

    @Override
    public Country searchById(Long id) {
        Country country = countryDao.searchById(id);
        return country;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Country> searchAll() {
        List<Country> countries = countryDao.searchAll();
        return countries;
    }

    @Override
    public void deleteAll() {
        countryDao.deleteAll();
    }
}
