/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upc.iluminados.negocio;

import upc.iluminados.dao.AlquilerCanchaDAO;
import upc.iluminados.excepcion.BaseExcepcion;
import upc.iluminados.modelo.AlquilerCancha;
import upc.iluminados.util.StringUtils;

/**
 *
 * @author Carlos
 */
public class AlquilerCanchaNegocio {
	
   private AlquilerCanchaDAO alquilerCanchaDAO = new AlquilerCanchaDAO();

    public void insertar(AlquilerCancha vo) throws BaseExcepcion {
	    	if (vo.getHorarioCancha().getCancha() == null || vo.getHorarioCancha().getCancha().getId() == null) { 
	            throw new BaseExcepcion("Cancha Requerido");
	        }
	       
	        if (StringUtils.isEmpty(vo.getFecha())) {
	            throw new BaseExcepcion("Fecha Requerido");
	        }
	        
	        if (StringUtils.isEmpty(vo.getHoraFin())) {
	            throw new BaseExcepcion("Hora Fin Requerido");
	        }
	        
	        
	        if (StringUtils.isEmpty(vo.getHoraInicio())) {
	            throw new BaseExcepcion("Hora Inicio Requerido");
	        }
	
	        AlquilerCancha cancha = alquilerCanchaDAO.obtener(vo.getHorarioCancha().getId());
	        if (cancha != null) {
	            throw new BaseExcepcion("Identificador de Cancha ya existe");
	        }
	
	        alquilerCanchaDAO.insertar(vo);
    }
}
