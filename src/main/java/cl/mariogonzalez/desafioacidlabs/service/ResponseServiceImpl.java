package cl.mariogonzalez.desafioacidlabs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.mariogonzalez.desafioacidlabs.client.CallRestAPIClient;
import cl.mariogonzalez.desafioacidlabs.exception.DesafioacidlabsClientExeption;
import cl.mariogonzalez.desafioacidlabs.exception.DesafioacidlabsServiceExeption;
import cl.mariogonzalez.desafioacidlabs.model.request.Request;
import cl.mariogonzalez.desafioacidlabs.model.response.Response;

@Service
public class ResponseServiceImpl implements ResponseService {

	@Autowired
	CallRestAPIClient callRestAPIClient;
	
	
	@Override
	public Response getResponse() throws DesafioacidlabsClientExeption,DesafioacidlabsServiceExeption{
		
		
		Request request =  callRestAPIClient.callRestAPI() ;
		
		
		return null;
	}

}
