package cl.mariogonzalez.desafioacidlabs.model.request;
import lombok.Data;

@Data
public class Location {
	private Country country;
	private State state;
	private City city;
	private Neighborhood neighborhood;
	private String address_line;
	private String zip_code;
	private double latitude;
	private double longitude;
}
