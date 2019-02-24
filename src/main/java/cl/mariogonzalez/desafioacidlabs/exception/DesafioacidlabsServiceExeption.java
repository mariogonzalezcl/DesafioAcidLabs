package cl.mariogonzalez.desafioacidlabs.exception;

public class DesafioacidlabsServiceExeption extends Exception {
	private static final long serialVersionUID = 1L;

	public DesafioacidlabsServiceExeption() {
		super();
	}

	public DesafioacidlabsServiceExeption(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DesafioacidlabsServiceExeption(String message, Throwable cause) {
		super(message, cause);
	}

	public DesafioacidlabsServiceExeption(String message) {
		super(message);
	}

	public DesafioacidlabsServiceExeption(Throwable cause) {
		super(cause);
	}
}
