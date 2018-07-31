package com.musala.company.service;

import java.util.List;

import com.musala.company.dto.EmployeeDto;
import com.musala.company.jpa.hibernate.model.Employee;

public interface EmployeeService {
	
	public List<Employee> getEmployees();

	public Employee getEmployee(long id);
	
	public EmployeeDto getEmployeeDetails(long id);

	public Employee postEmployee(Employee e);

	public Employee updateEmployee(Employee e);

	public void deleteEmployee(Employee e);
}
