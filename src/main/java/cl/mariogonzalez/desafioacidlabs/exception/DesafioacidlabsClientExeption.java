package cl.mariogonzalez.desafioacidlabs.exception;

public class DesafioacidlabsClientExeption extends Exception {

	private static final long serialVersionUID = 1L;

	public DesafioacidlabsClientExeption() {
		super();
	}

	public DesafioacidlabsClientExeption(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DesafioacidlabsClientExeption(String message, Throwable cause) {
		super(message, cause);
	}

	public DesafioacidlabsClientExeption(String message) {
		super(message);
	}

	public DesafioacidlabsClientExeption(Throwable cause) {
		super(cause);
	}
	
}
