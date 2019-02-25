package cl.mariogonzalez.desafioacidlabs.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cl.mariogonzalez.desafioacidlabs.exception.DesafioacidlabsClientExeption;
import cl.mariogonzalez.desafioacidlabs.exception.DesafioacidlabsConverterException;
import cl.mariogonzalez.desafioacidlabs.exception.DesafioacidlabsServiceExeption;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResponseServiceIntegrationTest {
    
    @Autowired
    private ResponseService responseService;

    @Test
    public void getResponseTest() throws DesafioacidlabsClientExeption,DesafioacidlabsConverterException,DesafioacidlabsServiceExeption {
    	
        assertThat(responseService.getResponse("new").getItems().get("new")).isNotEmpty();
        
    }
}
