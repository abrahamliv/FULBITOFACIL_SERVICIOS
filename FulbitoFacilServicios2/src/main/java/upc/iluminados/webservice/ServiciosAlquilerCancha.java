/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package upc.iluminados.webservice;

import javax.jws.WebParam;
import javax.jws.WebService;

import upc.iluminados.excepcion.BaseExcepcion;
import upc.iluminados.modelo.AlquilerCancha;

/**
 *
 * @author Carlos
 */
@WebService
public interface ServiciosAlquilerCancha {

    void alquilar(@WebParam(name="alquilerCancha") AlquilerCancha vo) throws BaseExcepcion ;

}
