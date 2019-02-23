package cl.mariogonzalez.desafioacidlabs.model.response;

import java.util.List;
import lombok.Data;

@Data
public class Item {
	private String id;
	private String title;
	private String permalink;
	private long amount;
	private List<Attribute> attributes;
	
}
