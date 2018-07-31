package com.musala.company.exception;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.musala.company.jpa.hibernate.model.ErrorMessage;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	public GenericExceptionMapper() {
		System.out.println("Mapper created");
	}
	public Response toResponse(Throwable exception) {
		String timestamp = new SimpleDateFormat("MM, yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), Status.INTERNAL_SERVER_ERROR.toString(), timestamp);
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorMessage).build();
	}

}
