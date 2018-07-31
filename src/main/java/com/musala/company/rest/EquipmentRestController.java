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

import com.musala.company.jpa.hibernate.model.Equipment;
import com.musala.company.service.impl.EquipmentServiceImpl;

@Path("/equipment")
public class EquipmentRestController {

	private EquipmentServiceImpl esi = new EquipmentServiceImpl();

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	@GET
	public List<Equipment> getEquipments() {

		return esi.getEquipments();
	}

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/show/{id}")
	@GET
	public Equipment getEquipment(@PathParam("id") long id) {

		return esi.getEquipment(id);
	}

	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/create")
	@POST
	public Equipment postEquipment(Equipment e) {

		return esi.postEquipment(e);
	}

	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public Equipment update(Equipment e) {

		return esi.updateEquipment(e);
	}
	
	@DELETE
	@Path("/delete")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void deleteEquipment(Equipment e) {

		esi.deleteEquipment(e);
	}
	
}
