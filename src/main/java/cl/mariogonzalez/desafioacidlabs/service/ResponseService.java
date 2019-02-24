package cl.mariogonzalez.desafioacidlabs.service;

import cl.mariogonzalez.desafioacidlabs.exception.DesafioacidlabsClientExeption;
import cl.mariogonzalez.desafioacidlabs.exception.DesafioacidlabsConverterException;
import cl.mariogonzalez.desafioacidlabs.exception.DesafioacidlabsServiceExeption;
import cl.mariogonzalez.desafioacidlabs.model.response.Response;

public interface ResponseService {

	
	public Response getResponse(String item_condition) throws DesafioacidlabsClientExeption,DesafioacidlabsConverterException,DesafioacidlabsServiceExeption;
	
	
}
