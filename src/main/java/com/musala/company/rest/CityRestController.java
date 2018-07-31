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

import com.musala.company.jpa.hibernate.model.City;
import com.musala.company.service.impl.CityServiceImpl;

@Path("/city")
public class CityRestController {

	private CityServiceImpl csi = new CityServiceImpl();

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	@GET
	public List<City> getCities() {

		return csi.getCities();
	}

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/show/{id}")
	@GET
	public City getCity(@PathParam("id") long id) {

		return csi.getCity(id);
	}

	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/create")
	@POST
	public City postCity(City c) {

		return csi.postCity(c);
	}

	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public City update(City c) {

		return csi.updateCity(c);
	}
	
	@DELETE
	@Path("/delete")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void deleteCity(City c) {
		
		csi.deleteCity(c);
	}
}
