/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package upc.iluminados.ws;

import javax.jws.WebParam;
import javax.jws.WebService;

import upc.iluminados.ws.excepcion.BaseExcepcion;
import upc.iluminados.ws.modelo.AlquilerCancha;

/**
 *
 * @author Carlos
 */
@WebService(targetNamespace="http://webservice.iluminados.upc/")
public interface ServiciosAlquilerCancha {

    void alquilar(@WebParam(name="alquilerCancha") AlquilerCancha vo) throws BaseExcepcion ;

}
