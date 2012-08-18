/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upc.iluminados.negocio;

import java.util.List;

import upc.iluminados.dao.AlquilerCanchaDAO;
import upc.iluminados.excepcion.BaseExcepcion;
import upc.iluminados.modelo.rest.AlquilerCancha;

import upc.iluminados.util.StringUtils;

/**
 *
 * @author Carlos
 */
public class AlquilerCanchaNegocio {
	
   private AlquilerCanchaDAO alquilerCanchaDAO = new AlquilerCanchaDAO();

    public void insertar(AlquilerCancha vo) throws BaseExcepcion {
	        if (StringUtils.isEmpty(vo.getFecha())) {
	            throw new BaseExcepcion("Fecha Requerido");
	        }
	        
	        if (StringUtils.isEmpty(vo.getHoraFin())) {
	            throw new BaseExcepcion("Hora Fin Requerido");
	        }
	        
	        
	        if (StringUtils.isEmpty(vo.getHoraInicio())) {
	            throw new BaseExcepcion("Hora Inicio Requerido");
	        }
	
	        AlquilerCancha cancha = alquilerCanchaDAO.obtener(vo.getHorarioCancha().getId(), vo.getFecha());
	        if (cancha != null) {
	            throw new BaseExcepcion("Cancha ya se encuentra alquilada en ese horario");
	        }
	
	        alquilerCanchaDAO.insertar(vo);
    }
    
  public List<AlquilerCancha> consultarHis(String nombre, String fechadesde, String fechahasta) throws BaseExcepcion{
    	
    	List<AlquilerCancha> lista= alquilerCanchaDAO.consultarHis(nombre, fechadesde, fechahasta);
    	
    	return lista;
    	
    }
  
  public List<AlquilerCancha> consultarHis() throws BaseExcepcion{
	  List<AlquilerCancha> lista= alquilerCanchaDAO.consultarHis();
	  return lista;
  }
}
