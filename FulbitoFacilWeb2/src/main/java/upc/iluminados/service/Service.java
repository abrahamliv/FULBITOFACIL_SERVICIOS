package upc.iluminados.service;


import upc.iluminados.ws.excepcion.BaseExcepcion;
import upc.iluminados.ws.modelo.Usuario;

public interface Service {

	void registrarDuenio(Usuario vo) throws BaseExcepcion;
}
