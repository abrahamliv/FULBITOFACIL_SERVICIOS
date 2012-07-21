package upc.iluminados.webservice;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import upc.iluminados.modelo.AlquilerCancha;
import upc.iluminados.modelo.Usuario;

@WebService
public interface ServiciosConsultaHis {

	@WebResult(name="historico01")
	List<AlquilerCancha> listarConHis(@WebParam(name="cliente") String nombre,@WebParam(name="fechadesde") String fechadesde,
			@WebParam(name="fechahasta") String fechahasta);
	
	Usuario obtenerCliente(String id);
	
	
}
