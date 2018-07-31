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

@Entity
@Table(name = "headquarter")
public class Headquarter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@TableGenerator(name = "TABLE_GEN", table = "T_GENERATOR", pkColumnName = "GEN_KEY", pkColumnValue = "TEST", valueColumnName = "GEN_VALUE", initialValue = 1, allocationSize = 1)
	@Column(name = "headq_id")
	private long id;

	@Column(name = "headq_name", nullable = false)
	private String name;

	@Column(name = "headq_surname", nullable = false)
	private String surname;

	@Column(name = "headq_age", nullable = false)
	private int age;

	@Column(name = "headq_position", nullable = false)
	private String postition;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "comp_id", nullable = false)
//	@JsonManagedReference(value="company-headQ")
	private Company companyHead;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "equipment_id", nullable = false)
//	@JsonBackReference(value="equipment-headQ")
	private Equipment equipmentHead;

	public Headquarter() {
		super();
	}

	public Headquarter(String name, String surname, int age, String postition, Company companyHead,
			Equipment equipmentHead) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.postition = postition;
		this.companyHead = companyHead;
		this.equipmentHead = equipmentHead;
	}

	public Headquarter(long id, String name, String surname, int age, String postition, Company companyHead,
			Equipment equipmentHead) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.postition = postition;
		this.companyHead = companyHead;
		this.equipmentHead = equipmentHead;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPosition() {
		return postition;
	}

	public void setPosition(String postition) {
		this.postition = postition;
	}

	public Company getCompany() {
		return companyHead;
	}

	public void setCompany(Company companyHead) {
		this.companyHead = companyHead;
	}

	public Equipment getEquipment() {
		return equipmentHead;
	}

	public void setEquipment(Equipment equipmentHead) {
		this.equipmentHead = equipmentHead;
	}

	@Override
	public String toString() {
		return "Headquarter [id=" + id + ", name=" + name + ", surname=" + surname + ", age=" + age + ", postition="
				+ postition + "]";
	}

}
