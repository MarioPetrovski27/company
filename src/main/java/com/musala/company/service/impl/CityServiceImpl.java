package com.musala.company.service.impl;

import java.util.List;

import com.musala.company.exception.DataNotFoundException;
import com.musala.company.exception.ErrorMessages;
import com.musala.company.exception.InvalidDataException;
import com.musala.company.jpa.hibernate.entities.dao.impl.CityDaoImpl;
import com.musala.company.jpa.hibernate.model.City;
import com.musala.company.service.CityService;
import com.musala.company.validation.InputValidation;

public class CityServiceImpl extends InputValidation implements CityService {

	CityDaoImpl cityDao = new CityDaoImpl();

	public List<City> getCities() {
		List<City> l = cityDao.findAll(City.class);
		return l;
	}

	public City getCity(long id) {
		City c = cityDao.findByID(City.class, id);
		if (c == null) {
			throw new DataNotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}
		return c;
	}

	public City postCity(City c) {
		if (c.getName() == null) {
			throw new InvalidDataException("You must provide city`s name");
		} else if ((c.getName().length() < 2) || !(InputValidation.isAlpha(c.getName()))) {
			throw new InvalidDataException("Name of the city must contain at least 2 characters that are letters");
		}
		cityDao.save(c);
		return c;
	}

	public City updateCity(City c) {
		if (c.getName() == null) {
			throw new InvalidDataException("You must provide city`s name");
		} else if ((c.getName().length() < 2) || !(InputValidation.isAlpha(c.getName()))) {
			throw new InvalidDataException("Name of the city must contain at least 2 characters that are letters");
		}
		cityDao.update(c);
		return c;
	}

	public void deleteCity(City c) {
		cityDao.delete(c);
	}
}
