package com.musala.company.service.impl;

import java.util.List;

import com.musala.company.exception.DataNotFoundException;
import com.musala.company.exception.ErrorMessages;
import com.musala.company.exception.InvalidDataException;
import com.musala.company.jpa.hibernate.entities.dao.impl.EquipmentDaoImpl;
import com.musala.company.jpa.hibernate.model.Equipment;
import com.musala.company.service.EquipmentService;

public class EquipmentServiceImpl implements EquipmentService {

	EquipmentDaoImpl eqDao = new EquipmentDaoImpl();

	public List<Equipment> getEquipments() {
		List<Equipment> l = eqDao.findAll(Equipment.class);
		return l;
	}

	public Equipment getEquipment(long id) {
		Equipment e = eqDao.findByID(Equipment.class, id);
		if (e == null) {
			throw new DataNotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}
		return e;
	}

	public Equipment postEquipment(Equipment e) {
		if (e.getLaptopModel() == null) {
			throw new InvalidDataException("Equipment must contain a Laptop Model.");
		}
		eqDao.save(e);
		return e;
	}

	public Equipment updateEquipment(Equipment e) {
		if (e.getLaptopModel() == null) {
			throw new InvalidDataException("Equipment must contain a Laptop Model.");
		}
		eqDao.update(e);
		return e;
	}

	public void deleteEquipment(Equipment e) {
		eqDao.delete(e);
	}
}
