/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package upc.iluminados.webservice;

import java.util.List;
import javax.jws.WebService;

import upc.iluminados.excepcion.BaseExcepcion;
import upc.iluminados.modelo.HorarioCancha;
import upc.iluminados.negocio.BuscarCanchaNegocio;

/**
 *
 * @author Carlos
 */

@WebService(endpointInterface = "upc.iluminados.webservice.ServiciosBuscarCancha")
public class ServiciosBuscarCanchaImpl implements ServiciosBuscarCancha{
	
	private BuscarCanchaNegocio negocio = new BuscarCanchaNegocio();

    @Override
    public List<HorarioCancha> listar(Integer idCancha, Integer distrito, String dia, String hora) throws BaseExcepcion {
    	
    	return negocio.listar(idCancha, distrito, dia, hora);
    }

}
