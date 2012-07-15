/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package upc.iluminados.webservice;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import upc.iluminados.modelo.Usuario;

/**
 *
 * @author Ada
 */
@WebService
public interface ServiciosUsuario {

    @WebResult(name="usuario")
    Usuario obtenerUsuario(@WebParam(name="login")String login, @WebParam(name="password") String password);

}
