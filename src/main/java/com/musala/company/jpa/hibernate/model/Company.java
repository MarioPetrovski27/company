package com.musala.company.jpa.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@TableGenerator(name = "TABLE_GEN", table = "T_GENERATOR", pkColumnName = "GEN_KEY", pkColumnValue = "TEST", valueColumnName = "GEN_VALUE", initialValue = 1, allocationSize = 1)
	@Column(name = "comp_id")
	private long id;

	@Column(name = "comp_name", nullable = false)
	private String name;

	@Column(name = "comp_desc")
	private String description;

	@Column(name = "comp_type")
	private String type;

	@Column(name = "comp_location", nullable = false)
	private String location;

//	@JsonBackReference(value="company-employee")
	@OneToMany(mappedBy = "companyEmp", cascade = CascadeType.ALL)
	private List<Employee> employees = new ArrayList<Employee>();

//	@JsonBackReference(value="company-headQ")
	@OneToMany(mappedBy = "companyHead", cascade = CascadeType.ALL)
	private List<Headquarter> headquarters = new ArrayList<Headquarter>();

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "companies")
//	@JsonBackReference(value="company-city")
	List<City> cities = new ArrayList<City>();

	public Company() {
		super();
	}

	public Company(long id, String name, String description, String type, String location) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.type = type;
		this.location = location;
	}

	public Company(String name, String description, String type, String location) {
		super();
		this.name = name;
		this.description = description;
		this.type = type;
		this.location = location;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	@JsonIgnore
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	@JsonIgnore
	public List<Headquarter> getHeadquarters() {
		return headquarters;
	}

	public void setHeadquarters(List<Headquarter> headquarters) {
		this.headquarters = headquarters;
	}
	@JsonIgnore
	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", description=" + description + ", type=" + type
				+ ", location=" + location + "]";
	}

}
