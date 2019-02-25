package cl.mariogonzalez.desafioacidlabs.converter;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import cl.mariogonzalez.desafioacidlabs.client.CallRestAPIClient;
import cl.mariogonzalez.desafioacidlabs.controller.ResponseController;
import cl.mariogonzalez.desafioacidlabs.exception.DesafioacidlabsConverterException;
import cl.mariogonzalez.desafioacidlabs.model.request.Location;
import cl.mariogonzalez.desafioacidlabs.model.request.Price;
import cl.mariogonzalez.desafioacidlabs.model.request.Request;
import cl.mariogonzalez.desafioacidlabs.model.response.Attribute;
import cl.mariogonzalez.desafioacidlabs.model.response.Item;
import cl.mariogonzalez.desafioacidlabs.model.response.Response;
import cl.mariogonzalez.desafioacidlabs.service.ResponseService;

@RunWith(SpringRunner.class)
@WebMvcTest(ResponseController.class)
public class ResponseConverterUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ResponseConverter responseConverter;
    
    @MockBean
    private ResponseService responseService;
    
    
    @MockBean
    CallRestAPIClient callRestAPIClient;


    @Test
    public void requestToResponseTest() throws DesafioacidlabsConverterException,Exception {
    	
    	Response response = new Response();
    	
    	List<Attribute> attributes =  new ArrayList<Attribute>();
    	
    	Attribute attribute = new Attribute();
    	
    	attribute.setId("ITEM_CONDITION");
    	attribute.setName("Condición del ítem");
    	attribute.setValue_name("Nuevo");
    	
    	attributes.add(attribute);
    	
    	Item item = new Item();
    	
    	item.setId("MLC462815744");
    	item.setTitle("title");
    	item.setPermalink("https://departamento.mercadolibre.cl/MLC-462815744-sky-100-_JM");
    	item.setAmount(3272);
    	item.setAttributes(attributes);
    	
    	List<Item> news = new ArrayList<Item>();
    	news.add(item);
    	
    	response.getItems().put("new",news);
    	
    
    	
    	
    	cl.mariogonzalez.desafioacidlabs.model.request.Attribute attributeRequest = new cl.mariogonzalez.desafioacidlabs.model.request.Attribute();
    	
    	attributeRequest.setId("ITEM_CONDITION");
    	attributeRequest.setName("Condición del ítem");
    	attributeRequest.setValue_id( "2230284");
    	attributeRequest.setValue_name("Nuevo");
    	attributeRequest.setAttribute_group_id("DFLT");
    	attributeRequest.setAttribute_group_name("Otros");


    	
    	List<cl.mariogonzalez.desafioacidlabs.model.request.Attribute> attributesRequest = new ArrayList<cl.mariogonzalez.desafioacidlabs.model.request.Attribute>();
    	
    	attributesRequest.add(attributeRequest);
    	
    	
    	Price price = new Price();
    	
    	
    	price.setAmount(3272);
    	price.setCurrency_id("CLF");
    	price.setCurrency_symbol("UF");
    	price.setDecimal_places(0);
    	price.setDecimal_separator(",");
    	price.setThousands_separator(".");
    	
    	Location location = new Location();

    	
    	cl.mariogonzalez.desafioacidlabs.model.request.Item itemRequest = new cl.mariogonzalez.desafioacidlabs.model.request.Item();
    	
    	itemRequest.setAttributes(attributesRequest);
    	itemRequest.setBuying_mode("classified");
    	itemRequest.setId("MLC462815744");
    	itemRequest.setLocation(location);
    	itemRequest.setPermalink("https://departamento.mercadolibre.cl/MLC-462815744-sky-100-_JM");
    	itemRequest.setPicture("https://http2.mlstatic.com/D_NQ_P_670902-MLC27734041182_072018-I.jpg");
    	itemRequest.setPrice(price);
    	itemRequest.setTitle("Sky 100");
    	
    	
    	List<cl.mariogonzalez.desafioacidlabs.model.request.Item> results =  new ArrayList<cl.mariogonzalez.desafioacidlabs.model.request.Item>();
    	results.add(itemRequest);
    	
    	Request request = new Request();
    	
    	request.setResults(results);
    	
    	

    	
    	when(callRestAPIClient.callRestAPI()).thenReturn(request);
        when(responseConverter.requestToResponse(any(Request.class))).thenReturn(response);
        when(responseService.getResponse(any(String.class))).thenReturn(response);
        
        this.mockMvc.perform(get("/items?item_condition=new")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("new")));
    }
}
