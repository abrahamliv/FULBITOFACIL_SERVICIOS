package upc.iluminados.webservice;
import java.util.List;

import javax.jws.WebService;

import upc.iluminados.excepcion.BaseExcepcion;
import upc.iluminados.modelo.Local;
import upc.iluminados.negocio.LocalNegocio;
/**
*
* @author Fabio Alfaro
*/
@WebService(endpointInterface = "upc.iluminados.webservice.ServiciosRegistrarLocal")
public class ServiciosRegistrarLocalImpl implements ServiciosRegistrarLocal {

	LocalNegocio localNegocio = new LocalNegocio();
	
	@Override
	public void registrarLocal(Local vo) throws BaseExcepcion{		
		localNegocio.insertar(vo);
	}

	@Override
	public List<Local> listar(Integer idUsuario) throws BaseExcepcion {
		// TODO Auto-generated method stub
		return localNegocio.listar(idUsuario);
	}
}
