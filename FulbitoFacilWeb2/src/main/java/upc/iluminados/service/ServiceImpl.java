package upc.iluminados.service;

import upc.iluminados.ws.ServiciosRegistrarDuenio;
import upc.iluminados.ws.excepcion.BaseExcepcion;
import upc.iluminados.ws.modelo.Usuario;

public class ServiceImpl implements Service{
	
	private ServiciosRegistrarDuenio serviciosRegistrarDuenio;

	public void setServiciosRegistrarDuenio(
			ServiciosRegistrarDuenio serviciosRegistrarDuenio) {
		this.serviciosRegistrarDuenio = serviciosRegistrarDuenio;
	}

	@Override
	public void registrarDuenio(Usuario vo) throws BaseExcepcion {
        vo.setTipo(Integer.valueOf(1));
        vo.setEstado(Integer.valueOf(1));
		serviciosRegistrarDuenio.registrar(vo);
	}
	
	

}
