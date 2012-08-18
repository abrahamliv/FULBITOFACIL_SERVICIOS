package upc.iluminados.webservice.rest;

import java.util.List;

import upc.iluminados.excepcion.BaseExcepcion;
import upc.iluminados.modelo.rest.Usuario;

public interface ServiciosUsuario {

	
	public List<Usuario> getAll();
	public Usuario get(String login, String pasword) throws BaseExcepcion;
	public Usuario add(Usuario user);
	public Boolean delete(String id);
	public Boolean edit(Usuario user);
	
	
	
}
