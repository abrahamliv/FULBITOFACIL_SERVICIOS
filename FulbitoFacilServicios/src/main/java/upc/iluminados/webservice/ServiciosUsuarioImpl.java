/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package upc.iluminados.webservice;

import javax.jws.WebService;
import upc.iluminados.modelo.Usuario;

/**
 *
 * @author Ada
 */

@WebService(endpointInterface = "upc.iluminados.webservice.ServiciosUsuario")
public class ServiciosUsuarioImpl implements ServiciosUsuario{

    @Override
    public Usuario obtenerUsuario(String login, String password) {
        Usuario result = new Usuario();
        return result;
    }

}
