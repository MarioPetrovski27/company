package com.musala.company.service.impl;

import java.util.List;

import com.musala.company.exception.DataNotFoundException;
import com.musala.company.exception.ErrorMessages;
import com.musala.company.exception.InvalidDataException;
import com.musala.company.jpa.hibernate.entities.dao.impl.CompanyDaoImpl;
import com.musala.company.jpa.hibernate.model.Company;
import com.musala.company.service.CompanyService;
import com.musala.company.validation.InputValidation;

public class CompanyServiceImpl extends InputValidation implements CompanyService {

	private CompanyDaoImpl cDao = new CompanyDaoImpl();

	public List<Company> getCompanies() {
		List<Company> l = cDao.findAll(Company.class);
		return l;
	}

	public Company getCompany(long id) {
		Company c = cDao.findByID(Company.class, id);
		if (c == null) {
			throw new DataNotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}
		return c;
	}

	public Company postCompany(Company c) {
		if (c.getName() == null) {
			throw new InvalidDataException("You must provide a name for Company.");
		} else if ((c.getLocation().length() < 2) || !(InputValidation.isAlpha(c.getLocation()))) {
			throw new InvalidDataException("Location must contain at least 2 characters that are letters");
		}
		c.setName(InputValidation.formatName(c.getName()));
		c.setLocation(InputValidation.formatName(c.getLocation()));
		cDao.save(c);
		return c;
	}

	public Company updateCompany(Company c) {
		if (c.getName() == null) {
			throw new InvalidDataException("You must provide a name for Company.");
		} else if ((c.getName().length() < 2) || !(InputValidation.isAlpha(c.getName()))) {
			throw new InvalidDataException("You must provide a name for Company.");
		} else if ((c.getLocation().length() < 2) || !(InputValidation.isAlpha(c.getLocation()))) {
			throw new InvalidDataException("Location must contain at least 2 characters that are letters");
		}
		c.setName(InputValidation.formatName(c.getName()));
		c.setLocation(InputValidation.formatName(c.getLocation()));
		cDao.update(c);
		return c;
	}

	public void deleteCompany(Company c) {
		cDao.delete(c);
	}
}
