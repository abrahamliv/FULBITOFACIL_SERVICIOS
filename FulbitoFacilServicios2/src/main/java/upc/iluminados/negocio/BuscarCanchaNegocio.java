package upc.iluminados.negocio;

import java.util.List;

import upc.iluminados.dao.CanchaDAO;
import upc.iluminados.excepcion.BaseExcepcion;
import upc.iluminados.modelo.HorarioCancha;
/**
*
* @author Carlos
*/
public class BuscarCanchaNegocio {
	
	private CanchaDAO canchaDAO = new CanchaDAO();
	
    public List<HorarioCancha> listar(Integer idCancha, Integer distrito, String dia, String hora) throws BaseExcepcion {
        
        List<HorarioCancha> lista = canchaDAO.listar(idCancha, distrito, dia, hora);
        return lista;
    }

}
