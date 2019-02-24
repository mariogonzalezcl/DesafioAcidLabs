package cl.mariogonzalez.desafioacidlabs.converter;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import org.springframework.stereotype.Component;

import cl.mariogonzalez.desafioacidlabs.model.request.Item;
import cl.mariogonzalez.desafioacidlabs.model.request.Request;
import cl.mariogonzalez.desafioacidlabs.model.response.Response;

@Component
public class ResponseConverterImpl implements ResponseConverter {

	
	
	@Override
	public Response getResponse(Request request) {
		
		Response response = new Response();
		
		for(Item item : request.getResults()) {
			
			
			
		}
		
		
		return null;
	}

}
