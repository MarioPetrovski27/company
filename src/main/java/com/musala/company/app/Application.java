package com.musala.company.app;

import com.musala.company.dto.EmployeeDto;
import com.musala.company.jpa.hibernate.entities.dao.impl.CityDaoImpl;
import com.musala.company.jpa.hibernate.entities.dao.impl.CompanyDaoImpl;
import com.musala.company.jpa.hibernate.entities.dao.impl.EmployeeDaoImpl;
import com.musala.company.jpa.hibernate.entities.dao.impl.EquipmentDaoImpl;
import com.musala.company.jpa.hibernate.entities.dao.impl.HeadquarterDaoImpl;
import com.musala.company.jpa.hibernate.model.City;
import com.musala.company.jpa.hibernate.model.Employee;

public class Application {
	public static void main(String args[]) throws Exception {

		CompanyDaoImpl cDao = new CompanyDaoImpl();
		EmployeeDaoImpl eDao = new EmployeeDaoImpl();
		CityDaoImpl cityDao = new CityDaoImpl();
		HeadquarterDaoImpl hDao = new HeadquarterDaoImpl();
		EquipmentDaoImpl eqDao = new EquipmentDaoImpl();
		City c = cityDao.findByID(City.class, 11L);
		Employee e = eDao.findByID(Employee.class, 1L);
		EmployeeDto edto = new EmployeeDto();
		System.out.println(edto);
	}
}
