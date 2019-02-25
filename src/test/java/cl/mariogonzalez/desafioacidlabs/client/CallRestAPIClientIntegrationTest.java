package cl.mariogonzalez.desafioacidlabs.client;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cl.mariogonzalez.desafioacidlabs.exception.DesafioacidlabsClientExeption;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CallRestAPIClientIntegrationTest {
    
	@Autowired
	CallRestAPIClient callRestAPIClient;

    @Test
    public void callRestAPITest() throws DesafioacidlabsClientExeption {
    	
        assertThat(callRestAPIClient.callRestAPI().getResults()).isNotEmpty();
        
    }
}
