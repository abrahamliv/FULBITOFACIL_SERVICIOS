/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package upc.iluminados.ws;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceClient;

import upc.iluminados.ws.excepcion.BaseExcepcion;
import upc.iluminados.ws.modelo.Usuario;

/**
 *
 * @author Cesar
 */
@WebService(targetNamespace="http://webservice.iluminados.upc/")
public interface ServiciosRegistrarDuenio {

	void registrar(@WebParam(name="duenio") Usuario vo) throws BaseExcepcion;

}
