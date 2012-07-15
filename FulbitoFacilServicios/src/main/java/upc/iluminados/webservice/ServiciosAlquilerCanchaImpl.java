/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package upc.iluminados.webservice;

import javax.jws.WebService;
import upc.iluminados.modelo.AlquilerCancha;

/**
 *
 * @author alumnos
 */

@WebService(endpointInterface = "upc.iluminados.webservice.ServiciosAlquilerCancha")
public class ServiciosAlquilerCanchaImpl implements ServiciosAlquilerCancha{

    @Override
    public void alquilar(AlquilerCancha vo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
