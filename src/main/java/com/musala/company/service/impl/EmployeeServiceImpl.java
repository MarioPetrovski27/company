package com.musala.company.service.impl;

import java.util.List;

import com.musala.company.dto.EmployeeDto;
import com.musala.company.exception.DataNotFoundException;
import com.musala.company.exception.ErrorMessages;
import com.musala.company.exception.InvalidDataException;
import com.musala.company.jpa.hibernate.entities.dao.impl.EmployeeDaoImpl;
import com.musala.company.jpa.hibernate.model.Employee;
import com.musala.company.service.EmployeeService;
import com.musala.company.validation.InputValidation;

public class EmployeeServiceImpl extends InputValidation implements EmployeeService {

	EmployeeDaoImpl eDao = new EmployeeDaoImpl();

	public List<Employee> getEmployees() {
		List<Employee> l = eDao.findAll(Employee.class);
		return l;
	}

	public Employee getEmployee(long id) {
		Employee e = eDao.findByID(Employee.class, id);
		if (e == null) {
			throw new DataNotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}
		return e;
	}

	public EmployeeDto getEmployeeDetails(long id) {

		Employee e = eDao.findByID(Employee.class, id);
		String description = null;
		if (e == null) {
			throw new DataNotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}
		EmployeeDto edto = new EmployeeDto();
		edto.setEmployee(e);
		if (edto.getEmployee().getAge() < 5) {
			description = "vraboteniot e pocetnik treba da stekne povekje iskustvo";
		} else if ((edto.getEmployee().getAge() >= 5) && (edto.getEmployee().getAge() < 20)) {
			description = "Vratboteniot ima znacajno iskustvo vo oblasta koja ja raboti";
		} else {
			description = "Vraboteniot e pred penzija";
		}
		edto.setDescription(description);
		System.out.println(edto);

		return edto;
	}

	public Employee postEmployee(Employee e) {
		if (e.getName() == null) {
			throw new InvalidDataException("You must provide a name for Employee.");
		} else if ((e.getName().length() < 2) || !(InputValidation.isAlpha(e.getName()))) {
			throw new InvalidDataException("Name must contain at least 2 characters that are letters");
		} else if (e.getSurname() == null) {
			throw new InvalidDataException("You must provide a surname for Employee.");
		} else if ((e.getSurname().length() < 2) || !(InputValidation.isAlpha(e.getSurname()))) {
			throw new InvalidDataException("Surname must contain at least 2 characters that are letters");
		} else if (e.getPosition() == null || !(InputValidation.isAlpha(e.getName()))) {
			throw new InvalidDataException("Position can not be empty. Enter position with letters.");
		} else if (e.getAge() < 1) {
			throw new InvalidDataException("Age must contain a number that is bigger than 0");
		} else if (e.getCompany() == null) {
			throw new InvalidDataException("Employee must contain Company object");
		} else if (e.getEquipment() == null) {
			throw new InvalidDataException("Employee must contain Equipment object");
		}
		eDao.save(e);
		return e;
	}

	public Employee updateEmployee(Employee e) {
		if (e.getName() == null) {
			throw new InvalidDataException("You must provide a name for Employee.");
		} else if ((e.getName().length() < 2) || !(InputValidation.isAlpha(e.getName()))) {
			throw new InvalidDataException("Name must contain at least 2 characters that are letters");
		} else if (e.getSurname() == null) {
			throw new InvalidDataException("You must provide a surname for Employee.");
		} else if ((e.getSurname().length() < 2) || !(InputValidation.isAlpha(e.getSurname()))) {
			throw new InvalidDataException("Surname must contain at least 2 characters that are letters");
		} else if (e.getPosition() == null || !(InputValidation.isAlpha(e.getName()))) {
			throw new InvalidDataException("Position can not be empty. Enter position with letters.");
		} else if (e.getAge() < 1) {
			throw new InvalidDataException("Age must contain a number that is bigger than 0");
		} else if (e.getCompany() == null) {
			throw new InvalidDataException("Employee must contain Company object");
		} else if (e.getEquipment() == null) {
			throw new InvalidDataException("Employee must contain Equipment object");
		}
		eDao.update(e);
		return e;
	}

	public void deleteEmployee(Employee e) {
		eDao.delete(e);
	}
}
