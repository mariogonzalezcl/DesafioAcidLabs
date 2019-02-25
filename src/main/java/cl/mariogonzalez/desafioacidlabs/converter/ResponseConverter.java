package cl.mariogonzalez.desafioacidlabs.converter;

import cl.mariogonzalez.desafioacidlabs.exception.DesafioacidlabsConverterException;
import cl.mariogonzalez.desafioacidlabs.model.request.Request;
import cl.mariogonzalez.desafioacidlabs.model.response.Response;

public interface ResponseConverter {

	public Response requestToResponse(Request request)throws DesafioacidlabsConverterException;
	

	
}
