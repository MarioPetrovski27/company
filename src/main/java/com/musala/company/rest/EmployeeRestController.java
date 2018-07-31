package com.musala.company.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.musala.company.dto.EmployeeDto;
import com.musala.company.jpa.hibernate.model.Employee;
import com.musala.company.service.impl.EmployeeServiceImpl;

@Path("/employee")
public class EmployeeRestController {

	private EmployeeServiceImpl esi = new EmployeeServiceImpl();

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	@GET
	public List<Employee> getEmployees() {
		return esi.getEmployees();
	}

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/show/{id}")
	@GET
	public Employee getEmployee(@PathParam("id") long id) {
		return esi.getEmployee(id);
	}

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/show/{id}/details")
	@GET
	public EmployeeDto getEmployeeDetails(@PathParam("id") long id) {
		return esi.getEmployeeDetails(id);
	}

	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/create")
	@POST
	public Employee postEmployee(Employee e) {
		return esi.postEmployee(e);
	}

	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee update(Employee e) {
		return esi.updateEmployee(e);
	}

	@DELETE
	@Path("/delete")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void deleteEmployee(Employee e) {
		esi.deleteEmployee(e);
	}
}