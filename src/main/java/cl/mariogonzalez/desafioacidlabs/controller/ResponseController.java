package cl.mariogonzalez.desafioacidlabs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.mariogonzalez.desafioacidlabs.exception.DesafioacidlabsClientExeption;
import cl.mariogonzalez.desafioacidlabs.exception.DesafioacidlabsServiceExeption;
import cl.mariogonzalez.desafioacidlabs.model.response.Response;
import cl.mariogonzalez.desafioacidlabs.service.ResponseService;

@RestController
public class ResponseController {
	
	@Autowired
	private ResponseService responseService;
	
	@RequestMapping(value = { "/"}, method = RequestMethod.GET) 
	public @ResponseBody ResponseEntity<Response> response() throws DesafioacidlabsClientExeption,DesafioacidlabsServiceExeption{
		
		Response response = responseService.getResponse();
		
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}
	
}