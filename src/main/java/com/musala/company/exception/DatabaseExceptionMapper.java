package com.musala.company.exception;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.musala.company.jpa.hibernate.model.ErrorMessage;

@Provider
public class DatabaseExceptionMapper implements ExceptionMapper<DatabaseException> {

	public DatabaseExceptionMapper() {
		System.out.println("Mapper created");
	}

	public Response toResponse(DatabaseException exception) {
		String timestamp = new SimpleDateFormat("MM, yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), Status.SERVICE_UNAVAILABLE.toString(),
				timestamp);
		return Response.status(Status.SERVICE_UNAVAILABLE).entity(errorMessage).build();
	}
}
