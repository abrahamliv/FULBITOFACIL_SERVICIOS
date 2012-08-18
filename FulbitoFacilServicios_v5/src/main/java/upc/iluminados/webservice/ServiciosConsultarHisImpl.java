package upc.iluminados.webservice;

import java.util.List;

import javax.jws.WebService;

import upc.iluminados.excepcion.BaseExcepcion;
import upc.iluminados.modelo.AlquilerCancha;
import upc.iluminados.negocio.AlquilerCanchaNegocio;



@WebService(endpointInterface = "upc.iluminados.webservice.ServiciosConsultarHis")
public class ServiciosConsultarHisImpl implements ServiciosConsultarHis {
	private AlquilerCanchaNegocio alquilerCanchaNegocio = new AlquilerCanchaNegocio();

/*
	public List<AlquilerCancha> listarConHis(String nombre, String fechadesde,
			String fechahasta) throws BaseExcepcion {

		
		List<AlquilerCancha> lista=alquilerCanchaNegocio.consultarHis(nombre, fechadesde, fechahasta);
		
		return lista;
	}
*/
	
	

}
