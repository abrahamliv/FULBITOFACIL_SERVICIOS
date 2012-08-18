package upc.iluminados.ws;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import upc.iluminados.ws.excepcion.BaseExcepcion;
import upc.iluminados.ws.modelo.AlquilerCancha;

@WebService(targetNamespace="http://webservice.iluminados.upc/")
public interface ServiciosConsultarHis {

	
	List<AlquilerCancha> listarConHis(@WebParam(name="cliente") String nombre,@WebParam(name="fechadesde") String fechadesde,
			@WebParam(name="fechahasta") String fechahasta) throws BaseExcepcion;
	
	
	
}
