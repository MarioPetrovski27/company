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

import com.musala.company.jpa.hibernate.model.Company;
import com.musala.company.service.impl.CompanyServiceImpl;

@Path("/company")
public class CompanyRestController {

	private CompanyServiceImpl csi = new CompanyServiceImpl();

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	@GET
	public List<Company> getCompanies() {

		return csi.getCompanies();
	}

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/show/{id}")
	@GET
	public Company getCompany(@PathParam("id") long id) {

		return csi.getCompany(id);
	}

	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/create")
	@POST
	public Company postCompany(Company c) {
		return csi.postCompany(c);
	}

	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public Company update(Company c) {
		return csi.updateCompany(c);
	}

	@DELETE
	@Path("/delete")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void deleteCompany(Company c) {
		csi.deleteCompany(c);
	}
}
