package cl.mariogonzalez.desafioacidlabs.model.request;

import java.util.List;
import lombok.Data;

@Data
public class Request {
	private List<Item> results;
}
