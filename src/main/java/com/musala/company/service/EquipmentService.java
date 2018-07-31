package com.musala.company.service;

import java.util.List;

import com.musala.company.jpa.hibernate.model.Equipment;

public interface EquipmentService {

	public List<Equipment> getEquipments();

	public Equipment getEquipment(long id);

	public Equipment postEquipment(Equipment e);

	public Equipment updateEquipment(Equipment e);

	public void deleteEquipment(Equipment e);
}
