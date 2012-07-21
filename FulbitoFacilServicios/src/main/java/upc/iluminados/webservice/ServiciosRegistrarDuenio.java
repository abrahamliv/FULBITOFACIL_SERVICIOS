/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package upc.iluminados.webservice;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import upc.iluminados.modelo.AlquilerCancha;
import upc.iluminados.modelo.Bean;
import upc.iluminados.modelo.Usuario;

/**
 *
 * @author Cesar
 */
@WebService
public interface ServiciosRegistrarDuenio {

	@WebResult(name="result")
	Bean registrar(@WebParam(name="duenio") Usuario vo);

}
