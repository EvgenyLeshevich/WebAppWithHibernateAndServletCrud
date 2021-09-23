package com.evgeniy.web.crud.hibernate;

import com.evgeniy.web.crud.hibernate.entity.Country;
import com.evgeniy.web.crud.hibernate.entity.User;
import com.evgeniy.web.crud.hibernate.services.CountryService;
import com.evgeniy.web.crud.hibernate.services.UserService;
import com.evgeniy.web.crud.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public class App {
    public static void main(String[] args) {
        UserService userService = new UserService();
        CountryService countryService = new CountryService();
        Country countryBelarus = new Country("Belarus");
        countryService.add(countryBelarus);

        User user = new User("Evgeniy", "Leshevich");
        user.setCountry(countryBelarus);
        userService.add(user);

    }
}
