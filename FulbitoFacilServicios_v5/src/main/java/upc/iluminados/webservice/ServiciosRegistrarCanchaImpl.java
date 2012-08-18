package upc.iluminados.webservice;
import java.util.List;

import javax.jws.WebService;
import upc.iluminados.modelo.Cancha;
import upc.iluminados.modelo.HorarioCancha;
import upc.iluminados.negocio.RegistrarCanchaNegocio;
import upc.iluminados.excepcion.BaseExcepcion;
/**
*
* @author Fabio Alfaro
*/
@WebService(endpointInterface = "upc.iluminados.webservice.ServiciosRegistrarCancha")
public class ServiciosRegistrarCanchaImpl implements ServiciosRegistrarCancha {

	RegistrarCanchaNegocio registrarCanchaNegocio = new RegistrarCanchaNegocio();
	@Override
	public void registrarCancha(Cancha vo, List<HorarioCancha> lista) throws BaseExcepcion {
		registrarCanchaNegocio.insertar(vo, lista);
	}

}
