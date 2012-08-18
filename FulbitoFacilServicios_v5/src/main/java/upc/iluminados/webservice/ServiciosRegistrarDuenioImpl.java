/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package upc.iluminados.webservice;

import javax.jws.WebService;

import upc.iluminados.excepcion.BaseExcepcion;

import upc.iluminados.modelo.rest.Usuario;
import upc.iluminados.negocio.UsuarioNegocio;

/**
 *
 * @author Cesar
 */

@WebService(endpointInterface = "upc.iluminados.webservice.ServiciosRegistrarDuenio")
public class ServiciosRegistrarDuenioImpl implements ServiciosRegistrarDuenio{

	private UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
	
	@Override
	public void registrar(Usuario vo) throws BaseExcepcion {
		usuarioNegocio.insertar(vo);
	}

	

}
