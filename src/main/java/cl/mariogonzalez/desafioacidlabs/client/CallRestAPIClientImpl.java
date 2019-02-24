package cl.mariogonzalez.desafioacidlabs.client;


import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import cl.mariogonzalez.desafioacidlabs.exception.DesafioacidlabsClientExeption;
import cl.mariogonzalez.desafioacidlabs.model.request.Request;

@Component
public class CallRestAPIClientImpl implements CallRestAPIClient {
	
	 private final static Logger LOGGER = Logger.getLogger("cl.mariogonzalez.desafioacidlabs.client.CallRestServiceImpl");

	@Value("${desafioacid.request.url}")
	private String URL;
	
	@Override
	public Request callRestAPI() throws DesafioacidlabsClientExeption {
		RestTemplate restTemplate = new RestTemplate();
		Request request = restTemplate.getForObject(URL, Request.class);
		LOGGER.info(request.toString());
		return request;
	}


}
