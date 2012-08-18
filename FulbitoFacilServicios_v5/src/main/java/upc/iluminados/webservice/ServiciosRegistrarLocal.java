package upc.iluminados.webservice;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import upc.iluminados.excepcion.BaseExcepcion;
import upc.iluminados.modelo.Local;

@WebService
public interface ServiciosRegistrarLocal {
	void registrarLocal(@WebParam(name="local") Local vo) throws BaseExcepcion;
	
	List<Local> listar(@WebParam(name="usuarioId")Integer idUsuario) throws BaseExcepcion;

}
