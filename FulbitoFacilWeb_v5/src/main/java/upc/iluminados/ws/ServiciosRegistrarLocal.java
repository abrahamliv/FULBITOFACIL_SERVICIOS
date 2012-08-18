package upc.iluminados.ws;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import upc.iluminados.ws.excepcion.BaseExcepcion;
import upc.iluminados.ws.modelo.Local;

@WebService(targetNamespace="http://webservice.iluminados.upc/")
public interface ServiciosRegistrarLocal {
	void registrarLocal(@WebParam(name="local") Local vo) throws BaseExcepcion;
	
	List<Local> listar(@WebParam(name="usuarioId")Integer idUsuario) throws BaseExcepcion;

}
