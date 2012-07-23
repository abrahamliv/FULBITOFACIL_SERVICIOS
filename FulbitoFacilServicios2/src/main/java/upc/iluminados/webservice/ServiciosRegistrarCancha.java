package upc.iluminados.webservice;

import javax.jws.WebParam;
import javax.jws.WebService;
import upc.iluminados.modelo.Cancha;
/**
*
* @author Fabio Alfaro
*/
@WebService
public interface ServiciosRegistrarCancha {
	 void registrarCancha(@WebParam(name="registrarCancha") Cancha vo);
}
