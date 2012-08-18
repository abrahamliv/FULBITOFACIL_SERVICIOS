package upc.iluminados.ws;


import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import upc.iluminados.ws.excepcion.BaseExcepcion;
import upc.iluminados.ws.modelo.Cancha;
import upc.iluminados.ws.modelo.HorarioCancha;
/**
*
* @author Fabio Alfaro
*/
@WebService(targetNamespace="http://webservice.iluminados.upc/")
public interface ServiciosRegistrarCancha {
	 void registrarCancha(@WebParam(name="cancha") Cancha vo,
			 @WebParam(name="horarios") List<HorarioCancha> lista) throws BaseExcepcion ;
}
