package cl.mariogonzalez.desafioacidlabs.model.response;

import lombok.Data;

@Data
public class Response {
	private Items items;

	public Response() {
		this.items = new Items();
	}
	
}
