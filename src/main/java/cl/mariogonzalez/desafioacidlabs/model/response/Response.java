package cl.mariogonzalez.desafioacidlabs.model.response;

import java.util.HashMap;
import java.util.List;

import lombok.Data;

@Data
public class Response {
	private HashMap<String, List<Item>> items;

	public Response() {
		this.items = new HashMap<String, List<Item>>();
	}
	
}
