package com.musala.company.dto;

import java.time.LocalTime;

import com.musala.company.jpa.hibernate.model.Employee;

public class EmployeeDto {

	private Employee employee; 
	
	private String description;

	private LocalTime timestamp;

	public EmployeeDto() {
		super();
		this.timestamp = LocalTime.now();
	}

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalTime timestamp) {
		this.timestamp = timestamp;
	}



	public Employee getEmployee() {
		return employee;
	}



	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	

}
