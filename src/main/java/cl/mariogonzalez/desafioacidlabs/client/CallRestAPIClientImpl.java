package cl.mariogonzalez.desafioacidlabs.client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import cl.mariogonzalez.desafioacidlabs.exception.DesafioacidlabsClientExeption;
import cl.mariogonzalez.desafioacidlabs.model.request.Request;

@Component
public class CallRestAPIClientImpl implements CallRestAPIClient {
	
	@Value("${desafioacid.request.url}")
	private String URL;
	
	@Override
	public Request callRestAPI() throws DesafioacidlabsClientExeption {
		RestTemplate restTemplate = new RestTemplate();
		Request request = restTemplate.getForObject(URL, Request.class);
		return request;
	}
}
