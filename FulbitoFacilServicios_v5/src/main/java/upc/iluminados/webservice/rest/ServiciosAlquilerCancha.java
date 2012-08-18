package upc.iluminados.webservice.rest;

import java.util.List;

import upc.iluminados.excepcion.BaseExcepcion;
import upc.iluminados.modelo.rest.AlquilerCancha;

public interface ServiciosAlquilerCancha {
	

	
	public List<AlquilerCancha> getAll(String nombre, String fechadesde, String fechahasta) throws BaseExcepcion;
	
	public List<AlquilerCancha> getAll() throws BaseExcepcion;
	

}
