/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package upc.iluminados.webservice;

import javax.jws.WebService;

import upc.iluminados.excepcion.BaseExcepcion;
import upc.iluminados.modelo.AlquilerCancha;
import upc.iluminados.negocio.AlquilerCanchaNegocio;

/**
 *
 * @author Carlos
 */

@WebService(endpointInterface = "upc.iluminados.webservice.ServiciosAlquilerCancha")
public class ServiciosAlquilerCanchaImpl implements ServiciosAlquilerCancha{
	
	private AlquilerCanchaNegocio negocio = new AlquilerCanchaNegocio();

    //@Override
    //public void alquilar(AlquilerCancha vo) throws BaseExcepcion {
    	//negocio.insertar(vo);
    //}

}
