package cl.mariogonzalez.desafioacidlabs.model.request;

import java.util.List;
import lombok.Data;

@Data
public class Item {
	private String id;
	private String title;
	private String permalink;
	private String picture;
	private Price price;
	private String  buying_mode;
	private List<Attribute> attributes;
	private Location location;
}
