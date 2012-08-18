package upc.iluminados.ws.excepcion;

public class BaseExcepcion extends Exception {

	private static final long serialVersionUID = 1L;

	public BaseExcepcion() {
		super();
	}

	public BaseExcepcion(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public BaseExcepcion(String arg0) {
		super(arg0);
	}

	public BaseExcepcion(Throwable arg0) {
		super(arg0);
	}	
}
