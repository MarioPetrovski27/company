package com.musala.company.service.impl;

import java.util.List;

import com.musala.company.exception.DataNotFoundException;
import com.musala.company.exception.ErrorMessages;
import com.musala.company.exception.InvalidDataException;
import com.musala.company.jpa.hibernate.entities.dao.impl.HeadquarterDaoImpl;
import com.musala.company.jpa.hibernate.model.Headquarter;
import com.musala.company.service.HeadquarterService;
import com.musala.company.validation.InputValidation;

public class HeadquarterServiceImpl extends InputValidation implements HeadquarterService {

	private HeadquarterDaoImpl hDao = new HeadquarterDaoImpl();

	public List<Headquarter> getHeadquarters() {
		List<Headquarter> l = hDao.findAll(Headquarter.class);
		return l;
	}

	public Headquarter getHeadquarter(long id) {
		Headquarter h = hDao.findByID(Headquarter.class, id);
		if (h == null) {
			throw new DataNotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}
		return h;
	}

	public Headquarter postHeadquarter(Headquarter h) {
		if (h.getName() == null) {
			throw new InvalidDataException("You must provide a name for Headquarter.");
		} else if ((h.getName().length() < 2) || !(InputValidation.isAlpha(h.getName()))) {
			throw new InvalidDataException("Name must contain at least 2 characters that are letters");
		} else if (h.getSurname() == null) {
			throw new InvalidDataException("You must provide a surname for Employee.");
		} else if ((h.getSurname().length() < 2) || !(InputValidation.isAlpha(h.getSurname()))) {
			throw new InvalidDataException("Name must contain at least 2 characters that are letters");
		} else if (h.getPosition() == null || !(InputValidation.isAlpha(h.getName()))) {
			throw new InvalidDataException("Position can not be empty. Enter position with letters.");
		} else if (h.getAge() < 1) {
			throw new InvalidDataException("Age must contain a number that is bigger than 0");
		} else if (h.getCompany() == null) {
			throw new InvalidDataException("Employee must contain Company object");
		} else if (h.getEquipment() == null) {
			throw new InvalidDataException("Employee must contain Equipment object");
		}
		hDao.save(h);
		return h;
	}

	public Headquarter updateHeadquarter(Headquarter h) {
		if (h.getName() == null) {
			throw new InvalidDataException("You must provide a name for Headquarter.");
		} else if ((h.getName().length() < 2) || !(InputValidation.isAlpha(h.getName()))) {
			throw new InvalidDataException("Name must contain at least 2 characters that are letters");
		} else if (h.getSurname() == null) {
			throw new InvalidDataException("You must provide a surname for Employee.");
		} else if ((h.getSurname().length() < 2) || !(InputValidation.isAlpha(h.getSurname()))) {
			throw new InvalidDataException("Name must contain at least 2 characters that are letters");
		} else if (h.getPosition() == null || !(InputValidation.isAlpha(h.getName()))) {
			throw new InvalidDataException("Position can not be empty. Enter position with letters.");
		} else if (h.getAge() < 1) {
			throw new InvalidDataException("Age must contain a number that is bigger than 0");
		} else if (h.getCompany() == null) {
			throw new InvalidDataException("Employee must contain Company object");
		} else if (h.getEquipment() == null) {
			throw new InvalidDataException("Employee must contain Equipment object");
		}
		hDao.update(h);
		return h;
	}

	public void deleteHeadquarter(Headquarter h) {
		hDao.delete(h);
	}
}
