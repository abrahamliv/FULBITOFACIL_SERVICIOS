/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package upc.iluminados.ws;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import upc.iluminados.ws.excepcion.BaseExcepcion;
import upc.iluminados.ws.modelo.Usuario;

/**
 *
 * @author Cesar
 */
@WebService(targetNamespace="http://webservice.iluminados.upc/")
public interface ServiciosUsuario {

    @WebResult(name="usuario")
    Usuario logear(@WebParam(name="login")String login, @WebParam(name="password") String password) throws BaseExcepcion;

    
    public Usuario obtenerCliente(@WebParam(name = "codigoCliente") String codigoCliente);
}
