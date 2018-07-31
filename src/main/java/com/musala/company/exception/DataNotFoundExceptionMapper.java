package com.musala.company.exception;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.musala.company.jpa.hibernate.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	public DataNotFoundExceptionMapper() {
		System.out.println("Mapper created");
	}

	public Response toResponse(DataNotFoundException exception) {
		String timestamp = new SimpleDateFormat("MM, yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), Status.NOT_FOUND.toString(), timestamp);
		return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
	};
	

}
