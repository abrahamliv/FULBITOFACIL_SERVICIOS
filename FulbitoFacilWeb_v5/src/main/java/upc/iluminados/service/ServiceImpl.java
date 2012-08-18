package upc.iluminados.service;

import java.util.List;

import upc.iluminados.ws.ServiciosAlquilerCancha;
import upc.iluminados.ws.ServiciosBuscarCancha;
import upc.iluminados.ws.ServiciosConsultarHis;
import upc.iluminados.ws.ServiciosRegistrarCancha;
import upc.iluminados.ws.ServiciosRegistrarDuenio;
import upc.iluminados.ws.ServiciosRegistrarLocal;
import upc.iluminados.ws.ServiciosUsuario;
import upc.iluminados.ws.excepcion.BaseExcepcion;
import upc.iluminados.ws.modelo.AlquilerCancha;
import upc.iluminados.ws.modelo.Cancha;
import upc.iluminados.ws.modelo.HorarioCancha;
import upc.iluminados.ws.modelo.Local;
import upc.iluminados.ws.modelo.Usuario;

public class ServiceImpl implements Service{
	
	private ServiciosRegistrarDuenio serviciosRegistrarDuenio;
	
	private ServiciosUsuario serviciosUsuario;
	
	private ServiciosBuscarCancha serviciosBuscarCancha;
	
	private ServiciosAlquilerCancha serviciosAlquilerCancha;
	
	private ServiciosRegistrarCancha serviciosRegistrarCancha;
	
	private ServiciosRegistrarLocal serviciosRegistrarLocal;

	private ServiciosConsultarHis serviciosConsultarHis;
	
	public ServiciosRegistrarLocal getServiciosRegistrarLocal() {
		return serviciosRegistrarLocal;
	}

	public void setServiciosRegistrarLocal(
			ServiciosRegistrarLocal serviciosRegistrarLocal) {
		this.serviciosRegistrarLocal = serviciosRegistrarLocal;
	}

	public void setServiciosRegistrarCancha(
			ServiciosRegistrarCancha serviciosRegistrarCancha) {
		this.serviciosRegistrarCancha = serviciosRegistrarCancha;
	}

	public void setServiciosRegistrarDuenio(
			ServiciosRegistrarDuenio serviciosRegistrarDuenio) {
		this.serviciosRegistrarDuenio = serviciosRegistrarDuenio;
	}

	public void setServiciosUsuario(ServiciosUsuario serviciosUsuario) {
		this.serviciosUsuario = serviciosUsuario;
	}

	public void setServiciosBuscarCancha(ServiciosBuscarCancha serviciosBuscarCancha) {
		this.serviciosBuscarCancha = serviciosBuscarCancha;
	}

	public void setServiciosAlquilerCancha(
			ServiciosAlquilerCancha serviciosAlquilerCancha) {
		this.serviciosAlquilerCancha = serviciosAlquilerCancha;
	}
	
	
	public void setServiciosConsultarHis(ServiciosConsultarHis  serviciosConsultarHis){
		this.serviciosConsultarHis=serviciosConsultarHis;
	}
	

	@Override
	public void registrarDuenio(Usuario vo) throws BaseExcepcion {
        vo.setTipo(Integer.valueOf(1));
        vo.setEstado(Integer.valueOf(1));
		serviciosRegistrarDuenio.registrar(vo);
	}

	@Override
	public Usuario logear(String login, String password) throws BaseExcepcion {
		// TODO Auto-generated method stub
		return serviciosUsuario.logear(login, password);
	}

	@Override
	public List<HorarioCancha> buscarCancha(Integer idCancha, Integer distrito,
			String dia, String hora) throws BaseExcepcion {
		// TODO Auto-generated method stub
		return serviciosBuscarCancha.listar(idCancha, distrito, dia, hora);
	}

	@Override
	public void alquilar(AlquilerCancha vo) throws BaseExcepcion {
		// TODO Auto-generated method stub
		serviciosAlquilerCancha.alquilar(vo);
		
	}
	

	@Override
	public void registrarCancha(Cancha vo,List<HorarioCancha> lista) throws BaseExcepcion {
		serviciosRegistrarCancha.registrarCancha(vo,lista);
	}
	
	

	@Override
	public List<AlquilerCancha> consultarHis(String user, String fechadesde, String fechahasta)
			throws BaseExcepcion {
		// TODO Auto-generated method stub
		return  serviciosConsultarHis.listarConHis(user, fechadesde, fechahasta);
	}

	@Override
	public Usuario obtenerCliente(String codigo) {
		// TODO Auto-generated method stub
		return serviciosUsuario.obtenerCliente(codigo);
	}

	@Override
	public void registrarLocal(Local vo) throws BaseExcepcion {
		// TODO Auto-generated method stub
		serviciosRegistrarLocal.registrarLocal(vo);
		
	}

	@Override
	public List<Local> listar(Integer idUsuario) throws BaseExcepcion {
		// TODO Auto-generated method stub
		return serviciosRegistrarLocal.listar(idUsuario);
	}
	
	
	
	
}
