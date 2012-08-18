package upc.iluminados.webservice.rest;

import java.util.List;

import upc.iluminados.excepcion.BaseExcepcion;
import upc.iluminados.modelo.rest.Usuario;
import upc.iluminados.negocio.UsuarioNegocio;

public class ServiciosUsuarioImpl implements ServiciosUsuario {

	private UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
	
	
	@Override
	public List<Usuario> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario get(String login, String password)  throws BaseExcepcion{
		// TODO Auto-generated method stub
		 return usuarioNegocio.obtener(login, password);
	}

	@Override
	public Usuario add(Usuario user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean edit(Usuario user) {
		// TODO Auto-generated method stub
		return null;
	}

}
