/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upc.iluminados.negocio;

import upc.iluminados.dao.UsuarioDAO;
import upc.iluminados.excepcion.DAOExcepcion;
import upc.iluminados.modelo.Usuario;
import upc.iluminados.util.StringUtils;

/**
 *
 * @author Alumno
 */
public class UsuarioNegocio {

    UsuarioDAO usuarioDAO = new UsuarioDAO();

    public void insertar(Usuario vo) throws DAOExcepcion {

        if (StringUtils.isEmpty(vo.getCorreo())) {
            throw new DAOExcepcion("Correo Requerido");
        }
        if (StringUtils.isEmpty(vo.getDni())) {
            throw new DAOExcepcion("Dni Requerido");
        }

        if (StringUtils.isEmpty(vo.getClave())) {
            throw new DAOExcepcion("Clave Requerida");
        }

        if (StringUtils.isEmpty(vo.getNombre())) {
            throw new DAOExcepcion("Nombres Requeridos");
        }
        if (StringUtils.isEmpty(vo.getApellidoPaterno())) {
            throw new DAOExcepcion("Apellido Paterno Requerido");
        }
        if (StringUtils.isEmpty(vo.getApellidoMaterno())) {
            throw new DAOExcepcion("Apellido Materno Requerido");
        }
        
        Usuario usuario = usuarioDAO.obtenerCorreo(vo.getCorreo());
        if (usuario != null) {
            throw new DAOExcepcion("El correo ya existe");
        }
        if (usuarioDAO.obtenerdni(vo.getDni()) != null) {
            throw new DAOExcepcion("El DNI ya existe");
        }

        usuarioDAO.insertar(vo);
    }
}
