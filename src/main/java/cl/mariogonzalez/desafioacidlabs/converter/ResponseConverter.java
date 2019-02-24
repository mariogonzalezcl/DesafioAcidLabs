package cl.mariogonzalez.desafioacidlabs.converter;

import java.util.List;

import cl.mariogonzalez.desafioacidlabs.exception.DesafioacidlabsConverterException;
import cl.mariogonzalez.desafioacidlabs.model.request.Attribute;
import cl.mariogonzalez.desafioacidlabs.model.request.Request;
import cl.mariogonzalez.desafioacidlabs.model.response.Response;

public interface ResponseConverter {

	public Response requestToResponse(Request request)throws DesafioacidlabsConverterException;
	
	public List<cl.mariogonzalez.desafioacidlabs.model.response.Attribute> listAttrRequestToAttrResponse(List<Attribute> attributesRequest) throws DesafioacidlabsConverterException;

	
}
