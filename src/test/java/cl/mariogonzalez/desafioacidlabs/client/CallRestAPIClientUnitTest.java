package cl.mariogonzalez.desafioacidlabs.client;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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

import cl.mariogonzalez.desafioacidlabs.controller.ResponseController;
import cl.mariogonzalez.desafioacidlabs.exception.DesafioacidlabsClientExeption;
import cl.mariogonzalez.desafioacidlabs.model.request.Attribute;
import cl.mariogonzalez.desafioacidlabs.model.request.Item;
import cl.mariogonzalez.desafioacidlabs.model.request.Location;
import cl.mariogonzalez.desafioacidlabs.model.request.Price;
import cl.mariogonzalez.desafioacidlabs.model.request.Request;
import cl.mariogonzalez.desafioacidlabs.service.ResponseService;


@RunWith(SpringRunner.class)
@WebMvcTest(ResponseController.class)
public class CallRestAPIClientUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CallRestAPIClient callRestAPIClient;
    
    @MockBean
    private ResponseService responseService;

    @Test
    public void callRestAPITest() throws DesafioacidlabsClientExeption,Exception {
    	
    	Attribute attributeRequest = new Attribute();
    	
    	attributeRequest.setId("ITEM_CONDITION");
    	attributeRequest.setName("Condición del ítem");
    	attributeRequest.setValue_id( "2230284");
    	attributeRequest.setValue_name("Nuevo");
    	attributeRequest.setAttribute_group_id("DFLT");
    	attributeRequest.setAttribute_group_name("Otros");


    	
    	List<Attribute> attributesRequest = new ArrayList<Attribute>();
    	
    	attributesRequest.add(attributeRequest);
    	
    	
    	Price price = new Price();
    	
    	
    	price.setAmount(3272);
    	price.setCurrency_id("CLF");
    	price.setCurrency_symbol("UF");
    	price.setDecimal_places(0);
    	price.setDecimal_separator(",");
    	price.setThousands_separator(".");
    	
    	Location location = new Location();

    	
    	Item itemRequest = new Item();
    	
    	itemRequest.setAttributes(attributesRequest);
    	itemRequest.setBuying_mode("classified");
    	itemRequest.setId("MLC462815744");
    	itemRequest.setLocation(location);
    	itemRequest.setPermalink("https://departamento.mercadolibre.cl/MLC-462815744-sky-100-_JM");
    	itemRequest.setPicture("https://http2.mlstatic.com/D_NQ_P_670902-MLC27734041182_072018-I.jpg");
    	itemRequest.setPrice(price);
    	itemRequest.setTitle("Sky 100");
    	
    	
    	List<Item> results =  new ArrayList<Item>();
    	results.add(itemRequest);
    	
    	Request request = new Request();
    	
    	request.setResults(results);
    	
    	
        when(callRestAPIClient.callRestAPI()).thenReturn(request);
        
        
        this.mockMvc.perform(get("/items")).andDo(print()).andExpect(status().isOk());
    }
}
