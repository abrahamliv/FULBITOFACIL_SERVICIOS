/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package upc.iluminados.webservice;

import javax.jws.WebService;

import upc.iluminados.excepcion.BaseExcepcion;
import upc.iluminados.modelo.Usuario;
import upc.iluminados.negocio.UsuarioNegocio;

/**
 *
 * @author Cesar
 */

@WebService(endpointInterface = "upc.iluminados.webservice.ServiciosUsuario")
public class ServiciosUsuarioImpl implements ServiciosUsuario{
	
	private UsuarioNegocio usuarioNegocio = new UsuarioNegocio();

    @Override
    public Usuario logear(String login, String password) throws BaseExcepcion {
        return usuarioNegocio.obtener(login, password);
    }

}
