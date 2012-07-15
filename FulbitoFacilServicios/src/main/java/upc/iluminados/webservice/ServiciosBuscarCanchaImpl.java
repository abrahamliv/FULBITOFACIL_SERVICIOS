/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package upc.iluminados.webservice;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;

import upc.iluminados.modelo.Cancha;
import upc.iluminados.modelo.HorarioCancha;

/**
 *
 * @author Ada
 */

@WebService(endpointInterface = "upc.iluminados.webservice.ServiciosBuscarCancha")
public class ServiciosBuscarCanchaImpl implements ServiciosBuscarCancha{

    @Override
    public List<HorarioCancha> listar(Integer idCancha, Integer distrito, String dia, String hora) {
    	List<HorarioCancha> lista = new ArrayList<HorarioCancha>();
    	HorarioCancha hc = new HorarioCancha();
    	Cancha cancha = new Cancha();
    	cancha.setNombre("canchita 1");
    	hc.setCancha(cancha);
    	hc.setId(Integer.valueOf(1));
    	hc.setDia("2012-07-18");
    	hc.setHora("18:00");
    	lista.add(hc);
    	return lista;
    }

}
