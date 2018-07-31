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

import com.musala.company.jpa.hibernate.model.Headquarter;
import com.musala.company.service.impl.HeadquarterServiceImpl;

@Path("/headquarter")
public class HeadquarterRestController {

	private HeadquarterServiceImpl hsi = new HeadquarterServiceImpl();

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	@GET
	public List<Headquarter> getHeadquarters() {
		return hsi.getHeadquarters();
	}

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/show/{id}")
	@GET
	public Headquarter getHeadquarter(@PathParam("id") long id) {
		return hsi.getHeadquarter(id);
	}

	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/create")
	@POST
	public Headquarter postHeadquarter(Headquarter h) {
		return hsi.postHeadquarter(h);
	}

	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public Headquarter updateHeadquarter(Headquarter h) {
		return hsi.updateHeadquarter(h);
	}
	
	@DELETE
	@Path("/delete")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void deleteHeadquarter(Headquarter h) {
		hsi.deleteHeadquarter(h);
	}
}
