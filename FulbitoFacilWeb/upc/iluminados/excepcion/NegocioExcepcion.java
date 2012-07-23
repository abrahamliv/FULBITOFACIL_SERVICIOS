package upc.iluminados.excepcion;

public class NegocioExcepcion extends Exception {

	private static final long serialVersionUID = 1L;

	public NegocioExcepcion() {
		super();
	}

	public NegocioExcepcion(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public NegocioExcepcion(String arg0) {
		super(arg0);
	}

	public NegocioExcepcion(Throwable arg0) {
		super(arg0);
	}	
}
