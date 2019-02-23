package cl.mariogonzalez.desafioacidlabs.model.request;
import lombok.Data;

@Data
public class Attribute {
	
	private String id;
	private String name;
	private String value_id;
	private String value_name;
	private String attribute_group_id;
	private String attribute_group_name;
}
