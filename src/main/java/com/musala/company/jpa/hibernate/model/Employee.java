package com.musala.company.jpa.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity(name = "employee")
@Table
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@TableGenerator(name = "TABLE_GEN", table = "T_GENERATOR", pkColumnName = "GEN_KEY", pkColumnValue = "TEST", valueColumnName = "GEN_VALUE", initialValue = 1, allocationSize = 1)
	@Column(name = "emp_id")
	private long id;

	@Column(name = "emp_name", nullable = false)
	private String name;

	@Column(name = "emp_surname", nullable = false)
	private String surname;

	@Column(name = "emp_position", nullable = false)
	private String position;

	@Column(name = "emp_age", nullable = false)
	private int age;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "comp_id", nullable = false)
	// @JsonManagedReference(value="company-employee")
	private Company companyEmp;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "equipment_id", nullable = false)
	// @JsonBackReference(value="equipment-employee")
	private Equipment equipmentEmp;

	public Employee() {
		super();
	}

	public Employee(int id, String name, String surname, String position, int age, Company companyEmp,
			Equipment equipmentEmp) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.position = position;
		this.age = age;
		this.companyEmp = companyEmp;
		this.equipmentEmp = equipmentEmp;
	}

	public Employee(String name, String surname, String position, int age, Company companyEmp, Equipment equipmentEmp) {
		super();
		this.name = name;
		this.surname = surname;
		this.position = position;
		this.age = age;
		this.companyEmp = companyEmp;
		this.equipmentEmp = equipmentEmp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Company getCompany() {
		return companyEmp;
	}

	public void setCompany(Company companyEmp) {
		this.companyEmp = companyEmp;
	}

	public Equipment getEquipment() {
		return equipmentEmp;
	}

	public void setEquipment(Equipment equipmentEmp) {
		this.equipmentEmp = equipmentEmp;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", surname=" + surname + ", position=" + position + ", age="
				+ age + "]";
	}

}
