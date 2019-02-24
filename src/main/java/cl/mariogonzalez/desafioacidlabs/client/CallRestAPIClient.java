package cl.mariogonzalez.desafioacidlabs.client;

import org.springframework.stereotype.Component;

import cl.mariogonzalez.desafioacidlabs.exception.DesafioacidlabsClientExeption;
import cl.mariogonzalez.desafioacidlabs.model.request.Request;

@Component
public interface CallRestAPIClient {
	
	public Request callRestAPI() throws DesafioacidlabsClientExeption;
	
}
