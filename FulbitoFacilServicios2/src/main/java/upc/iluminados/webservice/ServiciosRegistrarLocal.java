package upc.iluminados.webservice;

import javax.jws.WebParam;
import upc.iluminados.modelo.Local;

public interface ServiciosRegistrarLocal {
	void registrarLocal(@WebParam(name="registrarLocal") Local vo);

}
