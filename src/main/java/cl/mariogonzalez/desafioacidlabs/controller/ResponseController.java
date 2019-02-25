package cl.mariogonzalez.desafioacidlabs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.mariogonzalez.desafioacidlabs.exception.DesafioacidlabsClientExeption;
import cl.mariogonzalez.desafioacidlabs.exception.DesafioacidlabsConverterException;
import cl.mariogonzalez.desafioacidlabs.exception.DesafioacidlabsServiceExeption;
import cl.mariogonzalez.desafioacidlabs.model.response.Response;
import cl.mariogonzalez.desafioacidlabs.service.ResponseService;

@RestController
public class ResponseController {

	@Autowired
	private ResponseService responseService;

	@RequestMapping(value = { "/items" }, method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Response> response(
			@RequestParam(name = "item_condition", required = false, defaultValue = "") String item_condition)
			throws DesafioacidlabsClientExeption, DesafioacidlabsConverterException, DesafioacidlabsServiceExeption {

		if (StringUtils.isEmpty(item_condition) && !(item_condition.equals("used") || item_condition.equals("new"))) {
			item_condition = "";
		}

		Response response = responseService.getResponse(item_condition);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@RequestMapping("/*")
	public @ResponseBody ResponseEntity<String> page() {

		String response ="Api suported :<br> GET /items?item_condition= {new|used}  attribute \"item_condition\" is optional";

		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

}
