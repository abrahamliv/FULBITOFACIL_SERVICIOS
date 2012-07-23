/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package upc.iluminados.webservice;

import javax.jws.WebParam;
import javax.jws.WebService;

import upc.iluminados.excepcion.BaseExcepcion;
import upc.iluminados.modelo.Usuario;

/**
 *
 * @author Cesar
 */
@WebService
public interface ServiciosRegistrarDuenio {

	void registrar(@WebParam(name="duenio") Usuario vo) throws BaseExcepcion;

}
