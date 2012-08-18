/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upc.iluminados.negocio;

import upc.iluminados.dao.LocalDAO;
import upc.iluminados.excepcion.BaseExcepcion;
import java.util.List;
import upc.iluminados.modelo.Local;
import upc.iluminados.util.StringUtils;

/**
 *
 * @author falfaro
 */
public class LocalNegocio {

    private LocalDAO localDAO = new LocalDAO();

    public void insertar(Local vo) throws BaseExcepcion {

        if (StringUtils.isEmpty(vo.getNombre())) {
            throw new BaseExcepcion("Nombre Requerido");
        }
        if (StringUtils.isEmpty(vo.getDireccion())) {
            throw new BaseExcepcion("Dirección Requerido");
        }

        if (StringUtils.isEmpty(vo.getTelefono())) {
            throw new BaseExcepcion("Teléfono Requerido");
        }

        if (vo.getDistritoId() == 0) {
            throw new BaseExcepcion("Distrito Requerido");
        }

        if (vo.getDueno()== null || vo.getDueno().getId() == null) {
            throw new BaseExcepcion("Duenio Requerido");
        }
        Local local = localDAO.obtener(vo.getNombre(), vo.getDueno().getId());
        if (local != null) {
            throw new BaseExcepcion("Este Nombre de Local ya se registro para este Usuario");
        }
        localDAO.insertar(vo);
    }

    public List<Local> listar(Integer idUsuario) throws BaseExcepcion {
        return localDAO.listar(idUsuario);
    }
}