package upc.iluminados.webservice.rest;

import java.util.List;

import org.springframework.stereotype.Service;

import upc.iluminados.excepcion.BaseExcepcion;
import upc.iluminados.modelo.rest.AlquilerCancha;
import upc.iluminados.negocio.AlquilerCanchaNegocio;

@Service("AlquilerCancha")
public class ServiciosAlquilerCanchaImpl implements ServiciosAlquilerCancha {
	
	private AlquilerCanchaNegocio alquilerCanchaNegocio = new AlquilerCanchaNegocio();
	

	@Override
	public List<AlquilerCancha> getAll(String nombre, String fechadesde,
			String fechahasta) throws BaseExcepcion {
		// TODO Auto-generated method stub
		List<AlquilerCancha> lista=alquilerCanchaNegocio.consultarHis(nombre, fechadesde, fechahasta);
		
		return lista;
	}


	@Override
	public List<AlquilerCancha> getAll() throws BaseExcepcion {
		// TODO Auto-generated method stub
		return null;
	}

}
