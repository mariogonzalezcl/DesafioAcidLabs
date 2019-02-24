package cl.mariogonzalez.desafioacidlabs.exception;

public class DesafioacidlabsConverterException extends Exception {
	private static final long serialVersionUID = 1L;

	public DesafioacidlabsConverterException() {
		super();
	}

	public DesafioacidlabsConverterException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DesafioacidlabsConverterException(String message, Throwable cause) {
		super(message, cause);
	}

	public DesafioacidlabsConverterException(String message) {
		super(message);
	}

	public DesafioacidlabsConverterException(Throwable cause) {
		super(cause);
	}
}
