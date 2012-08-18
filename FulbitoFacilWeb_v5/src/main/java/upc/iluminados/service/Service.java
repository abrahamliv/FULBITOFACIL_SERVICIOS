package upc.iluminados.service;


import java.util.List;

import javax.jws.WebParam;

import upc.iluminados.ws.excepcion.BaseExcepcion;
import upc.iluminados.ws.modelo.AlquilerCancha;
import upc.iluminados.ws.modelo.Cancha;
import upc.iluminados.ws.modelo.HorarioCancha;
import upc.iluminados.ws.modelo.Local;
import upc.iluminados.ws.modelo.Usuario;

public interface Service {

	void registrarDuenio(Usuario vo) throws BaseExcepcion;
	
	Usuario logear(String login, String password) throws BaseExcepcion;
	
	List<HorarioCancha> buscarCancha(Integer idCancha,
            Integer distrito,
            String dia,
            String hora) throws BaseExcepcion;
	
	void alquilar(AlquilerCancha vo) throws BaseExcepcion ;
	
	 void registrarCancha(Cancha vo, List<HorarioCancha> lista) throws BaseExcepcion ;
	 
	 
	 
	 
	 List<AlquilerCancha> consultarHis(String user, String fechadesde, String fechahasta) throws BaseExcepcion;
	 
	 Usuario obtenerCliente(String codigo);
	 
	 void registrarLocal( Local vo) throws BaseExcepcion;
		
		List<Local> listar(Integer idUsuario) throws BaseExcepcion;

}
