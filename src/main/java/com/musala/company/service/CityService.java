package com.musala.company.service;

import java.util.List;

import com.musala.company.jpa.hibernate.model.City;

public interface CityService {

	public List<City> getCities();

	public City getCity(long id);

	public City postCity(City c);

	public City updateCity(City c);

	public void deleteCity(City c);
}
