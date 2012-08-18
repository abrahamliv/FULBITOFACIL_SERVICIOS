package upc.iluminados.negocio;

import java.util.List;

import upc.iluminados.dao.CanchaDAO;
import upc.iluminados.excepcion.BaseExcepcion;
import upc.iluminados.modelo.Cancha;
import upc.iluminados.modelo.HorarioCancha;
import upc.iluminados.util.StringUtils;


public class RegistrarCanchaNegocio {
	
	private CanchaDAO canchaDAO = new CanchaDAO();
	
	public void insertar(Cancha vo, List<HorarioCancha> lista) throws BaseExcepcion {
        if (vo.getLocal() == null || vo.getLocal().getId() == null) {
            throw new BaseExcepcion("Local Requerido");
        }
        if (StringUtils.isEmpty(vo.getNombre())) {
            throw new BaseExcepcion("Nombre Requerido");
        }
        if (vo.getTarifaDiurna() == 0.0) {
            throw new BaseExcepcion("Tarifa diruna Requerido");
        }
        if (vo.getTarifaNocturna() == 0.0) {
            throw new BaseExcepcion("Tarifa diruna Requerido");
        }
        if (lista == null || lista.isEmpty()) {
            throw new BaseExcepcion("Horario Requerido");
        }

        Cancha cancha = canchaDAO.obtener(vo.getNombre(), vo.getLocal().getId());
        if (cancha != null) {
            throw new BaseExcepcion("Cancha ya existe");
        }
        canchaDAO.insertar(vo, lista);
    }

}
