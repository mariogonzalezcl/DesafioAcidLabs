package cl.mariogonzalez.desafioacidlabs.controller;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import cl.mariogonzalez.desafioacidlabs.controller.ResponseController;
import cl.mariogonzalez.desafioacidlabs.exception.DesafioacidlabsClientExeption;
import cl.mariogonzalez.desafioacidlabs.exception.DesafioacidlabsConverterException;
import cl.mariogonzalez.desafioacidlabs.exception.DesafioacidlabsServiceExeption;
import cl.mariogonzalez.desafioacidlabs.model.response.Attribute;
import cl.mariogonzalez.desafioacidlabs.model.response.Item;
import cl.mariogonzalez.desafioacidlabs.model.response.Response;

@RunWith(SpringRunner.class)
@WebMvcTest(ResponseController.class)
public class ResponseControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ResponseController responseController;

    @Test
    public void responseTest() throws DesafioacidlabsClientExeption, DesafioacidlabsConverterException, DesafioacidlabsServiceExeption,Exception {
    	
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
    	
    	
        when(responseController.response(any(String.class))).thenReturn(new ResponseEntity<Response>(response,HttpStatus.OK));
        
        this.mockMvc.perform(get("/items?item_condition=new")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("new")));
    }
}
