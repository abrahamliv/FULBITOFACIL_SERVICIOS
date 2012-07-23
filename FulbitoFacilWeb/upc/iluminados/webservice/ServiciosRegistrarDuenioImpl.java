/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package upc.iluminados.webservice;

import javax.jws.WebService;

import upc.iluminados.excepcion.DAOExcepcion;
import upc.iluminados.modelo.AlquilerCancha;
import upc.iluminados.modelo.Bean;
import upc.iluminados.modelo.Usuario;
import upc.iluminados.negocio.UsuarioNegocio;
import upc.iluminados.util.Constante;

/**
 *
 * @author Cesar
 */

@WebService(endpointInterface = "upc.iluminados.webservice.ServiciosRegistrarDuenio")
public class ServiciosRegistrarDuenioImpl implements ServiciosRegistrarDuenio{

	private UsuarioNegocio negocio = new UsuarioNegocio();
	
	@Override
	public void registrar(Usuario vo) throws DAOExcepcion {
		negocio.insertar(vo);
	}

	

}
