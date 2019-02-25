package cl.mariogonzalez.desafioacidlabs.converter;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


import org.springframework.stereotype.Component;

import cl.mariogonzalez.desafioacidlabs.exception.DesafioacidlabsConverterException;
import cl.mariogonzalez.desafioacidlabs.model.request.Request;
import cl.mariogonzalez.desafioacidlabs.model.request.Attribute;
import cl.mariogonzalez.desafioacidlabs.model.response.Item;
import cl.mariogonzalez.desafioacidlabs.model.response.Response;

@Component
public class ResponseConverterImpl implements ResponseConverter {
	
	@Override
	public Response requestToResponse(Request request) throws DesafioacidlabsConverterException{
		
		Response response = new Response();
		
		List<Item> news = new ArrayList<Item>();
		List<Item> used = new ArrayList<Item>();
		
		for(cl.mariogonzalez.desafioacidlabs.model.request.Item itemRequest : request.getResults()) {
			
			Item itemResponse = new Item();
			
			itemResponse.setId(itemRequest.getId());
			itemResponse.setTitle(itemRequest.getTitle());
			itemResponse.setPermalink(itemRequest.getPermalink());
			itemResponse.setAmount(itemRequest.getPrice().getAmount());
			
			itemResponse.setAttributes(this.listAttrRequestToAttrResponse(itemRequest.getAttributes()));
			
			Predicate<Attribute> predicateId = a-> a.getId().equals("ITEM_CONDITION");
			Predicate<Attribute> predicateValue = a-> a.getValue_name().equals("Nuevo");
			Attribute  attribute = itemRequest.getAttributes().stream().filter(predicateId).filter(predicateValue).findFirst().orElse(null);
			
			if(attribute != null) {
				news.add(itemResponse);
			}else {
				used.add(itemResponse);
			}
						
		}
		
		response.getItems().put("new", news);
		response.getItems().put("used", used);

		return response;
	}
	
	
	private List<cl.mariogonzalez.desafioacidlabs.model.response.Attribute> listAttrRequestToAttrResponse(List<Attribute> attributesRequest) throws DesafioacidlabsConverterException {

		List<cl.mariogonzalez.desafioacidlabs.model.response.Attribute> attributesResponse = new ArrayList<cl.mariogonzalez.desafioacidlabs.model.response.Attribute>(); 
		
		for (Attribute attributeRequest : attributesRequest) {
				cl.mariogonzalez.desafioacidlabs.model.response.Attribute attributeResponse = new cl.mariogonzalez.desafioacidlabs.model.response.Attribute();
				attributeResponse.setId(attributeRequest.getId());
				attributeResponse.setName(attributeRequest.getName());
				attributeResponse.setValue_name(attributeRequest.getValue_name());
				
				attributesResponse.add(attributeResponse);
		}
		
		return attributesResponse;
	}


}
