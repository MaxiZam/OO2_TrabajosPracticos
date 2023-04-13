package ar.unrn.eje2;

class NoSuchEntryException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoSuchEntryException() {
		super();
	}

	public NoSuchEntryException(String mensaje) {
		super(mensaje);
	}
}
