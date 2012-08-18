package upc.iluminados.controller.rest;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import upc.iluminados.excepcion.BaseExcepcion;
import upc.iluminados.modelo.rest.Usuario;
import upc.iluminados.webservice.rest.ServiciosUsuario;


public class UsuarioController {
	
protected static Logger logger = Logger.getLogger("controller");

	
	@Resource(name = "usuarioService")
	private ServiciosUsuario serviciosUsuario;

	
	
	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET, headers = "Accept=application/xml, application/json")
	public @ResponseBody Usuario getUsuario(@PathVariable("login") String login,@PathVariable("password") String password) throws BaseExcepcion{
		logger.debug("Provider has received request to get person with id: "
				+ login);

		// Call service here
		return serviciosUsuario.get(login, password);
	}

}
