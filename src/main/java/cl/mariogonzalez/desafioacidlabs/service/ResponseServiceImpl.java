package cl.mariogonzalez.desafioacidlabs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.mariogonzalez.desafioacidlabs.client.CallRestAPIClient;
import cl.mariogonzalez.desafioacidlabs.converter.ResponseConverter;
import cl.mariogonzalez.desafioacidlabs.exception.DesafioacidlabsConverterException;
import cl.mariogonzalez.desafioacidlabs.exception.DesafioacidlabsClientExeption;
import cl.mariogonzalez.desafioacidlabs.exception.DesafioacidlabsServiceExeption;
import cl.mariogonzalez.desafioacidlabs.model.request.Request;
import cl.mariogonzalez.desafioacidlabs.model.response.Response;

@Service
public class ResponseServiceImpl implements ResponseService {

	@Autowired
	CallRestAPIClient callRestAPIClient;
	
	@Autowired
	ResponseConverter responseConverter;
	
	
	@Override
	public Response getResponse() throws DesafioacidlabsClientExeption,DesafioacidlabsConverterException,DesafioacidlabsServiceExeption{
		
		
		Request request =  callRestAPIClient.callRestAPI() ;
		
		Response response = responseConverter.requestToResponse(request);
		
		return response;
	}

}
