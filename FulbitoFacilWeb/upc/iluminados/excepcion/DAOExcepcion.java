package upc.iluminados.excepcion;

public class DAOExcepcion extends Exception {

	private static final long serialVersionUID = 1L;

	public DAOExcepcion() {
		super();
	}

	public DAOExcepcion(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public DAOExcepcion(String arg0) {
		super(arg0);
	}

	public DAOExcepcion(Throwable arg0) {
		super(arg0);
	}	
}
