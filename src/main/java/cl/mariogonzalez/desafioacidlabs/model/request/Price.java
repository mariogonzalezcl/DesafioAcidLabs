package cl.mariogonzalez.desafioacidlabs.model.request;
import lombok.Data;

@Data
public class Price {
	private String currency_id;
	private String currency_symbol;
	private long amount;
	private String decimal_separator;
	private String thousands_separator;
	private int decimal_places;
}
