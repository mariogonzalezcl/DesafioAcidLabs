package cl.mariogonzalez.desafioacidlabs.converter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cl.mariogonzalez.desafioacidlabs.exception.DesafioacidlabsConverterException;
import cl.mariogonzalez.desafioacidlabs.model.request.Attribute;
import cl.mariogonzalez.desafioacidlabs.model.request.Item;
import cl.mariogonzalez.desafioacidlabs.model.request.Location;
import cl.mariogonzalez.desafioacidlabs.model.request.Price;
import cl.mariogonzalez.desafioacidlabs.model.request.Request;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResponseConverterIntegrationTest {
    
    @Autowired
    private ResponseConverter ResponseConverter;

    @Test
    public void requestToResponseTest() throws DesafioacidlabsConverterException {
    	
    	Attribute attribute = new Attribute();
    	
    	attribute.setId("ITEM_CONDITION");
    	attribute.setName("Condición del ítem");
    	attribute.setValue_id( "2230284");
    	attribute.setValue_name("Nuevo");
    	attribute.setAttribute_group_id("DFLT");
    	attribute.setAttribute_group_name("Otros");


    	
    	List<Attribute> attributes = new ArrayList<Attribute>();
    	
    	attributes.add(attribute);
    	
    	
    	Price price = new Price();
    	
    	
    	price.setAmount(3272);
    	price.setCurrency_id("CLF");
    	price.setCurrency_symbol("UF");
    	price.setDecimal_places(0);
    	price.setDecimal_separator(",");
    	price.setThousands_separator(".");
    	
    	Location location = new Location();

    	
    	Item item = new Item();
    	
    	item.setAttributes(attributes);
    	item.setBuying_mode("classified");
    	item.setId("MLC462815744");
    	item.setLocation(location);
    	item.setPermalink("https://departamento.mercadolibre.cl/MLC-462815744-sky-100-_JM");
    	item.setPicture("https://http2.mlstatic.com/D_NQ_P_670902-MLC27734041182_072018-I.jpg");
    	item.setPrice(price);
    	item.setTitle("Sky 100");
    	
    	
    	List<Item> results =  new ArrayList<Item>();
    	results.add(item);
    	
    	Request request = new Request();
    	
    	request.setResults(results);
    	
    	
    	
        assertThat(ResponseConverter.requestToResponse(request).getItems().get("new").get(0).getId()).contains("MLC462815744");
        
    }
}
