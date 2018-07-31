package com.musala.company.jpa.hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "equipment")
public class Equipment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@TableGenerator(name = "TABLE_GEN", table = "T_GENERATOR", pkColumnName = "GEN_KEY", pkColumnValue = "TEST", valueColumnName = "GEN_VALUE", initialValue = 1, allocationSize = 1)
	@Column(name = "equip_id")
	private long id;

	@Column(name = "equip_laptop", nullable = false)
	private String laptopModel;

	@Column(name = "equip_mouse")
	private String mouse;

	@Column(name = "equip_keyboard")
	private String keyboard;

	@Column(name = "equip_hasExtra", nullable = false)
	private boolean hasExtraEquipment;

	@Column(name = "equip_extraEquip")
	private String extraEquipment;

	@OneToOne(mappedBy = "equipmentEmp", cascade = CascadeType.ALL)
	// @JsonManagedReference(value="equipment-headQ")
	private Employee employee;

	@OneToOne(mappedBy = "equipmentHead", cascade = CascadeType.ALL)
	// @JsonManagedReference(value="equipment-headQ")
	private Headquarter headquarter;

	public Equipment() {
		super();
	}

	public Equipment(String laptopModel, String mouse, String keyboard, boolean hasExtraEquipment,
			String extraEquipment) {
		super();
		this.laptopModel = laptopModel;
		this.mouse = mouse;
		this.keyboard = keyboard;
		this.hasExtraEquipment = hasExtraEquipment;
		this.extraEquipment = extraEquipment;
	}

	public Equipment(long id, String laptopModel, String mouse, String keyboard, boolean hasExtraEquipment,
			String extraEquipment) {
		super();
		this.id = id;
		this.laptopModel = laptopModel;
		this.mouse = mouse;
		this.keyboard = keyboard;
		this.hasExtraEquipment = hasExtraEquipment;
		this.extraEquipment = extraEquipment;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLaptopModel() {
		return laptopModel;
	}

	public void setLaptopModel(String laptopModel) {
		this.laptopModel = laptopModel;
	}

	public String getMouse() {
		return mouse;
	}

	public void setMouse(String mouse) {
		this.mouse = mouse;
	}

	public String getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(String keyboard) {
		this.keyboard = keyboard;
	}

	public boolean isHasExtraEquipment() {
		return hasExtraEquipment;
	}

	public void setHasExtraEquipment(boolean hasExtraEquipment) {
		this.hasExtraEquipment = hasExtraEquipment;
	}

	public String getExtraEquipment() {
		return extraEquipment;
	}

	public void setExtraEquipment(String extraEquipment) {
		this.extraEquipment = extraEquipment;
	}

	@JsonIgnore
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@JsonIgnore
	public Headquarter getHeadquarter() {
		return headquarter;
	}

	public void setHeadquarter(Headquarter headquarter) {
		this.headquarter = headquarter;
	}

	@Override
	public String toString() {
		return "Equipment [id=" + id + ", laptopModel=" + laptopModel + ", mouse=" + mouse + ", keyboard=" + keyboard
				+ ", hasExtraEquipment=" + hasExtraEquipment + ", extraEquipment=" + extraEquipment + "]";
	}

}
