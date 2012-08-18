package upc.iluminados.webservice;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;
import upc.iluminados.modelo.Cancha;
import upc.iluminados.modelo.HorarioCancha;
import upc.iluminados.excepcion.BaseExcepcion;
/**
*
* @author Fabio Alfaro
*/
@WebService
public interface ServiciosRegistrarCancha {
	 void registrarCancha(@WebParam(name="cancha") Cancha vo,
			 @WebParam(name="horarios") List<HorarioCancha> lista) throws BaseExcepcion ;
}
