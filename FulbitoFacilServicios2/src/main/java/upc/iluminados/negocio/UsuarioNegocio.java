/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upc.iluminados.negocio;

import upc.iluminados.dao.UsuarioDAO;
import upc.iluminados.excepcion.BaseExcepcion;
import upc.iluminados.modelo.Usuario;
import upc.iluminados.util.StringUtils;

/**
 *
 * @author Cesar
 */
public class UsuarioNegocio {
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public void insertar(Usuario vo) throws BaseExcepcion{

        if (StringUtils.isEmpty(vo.getCorreo())) {
            throw new BaseExcepcion("Correo Requerido");
        }
        if (StringUtils.isEmpty(vo.getDni())) {
            throw new BaseExcepcion("Dni Requerido");
        }

        if (StringUtils.isEmpty(vo.getClave())) {
            throw new BaseExcepcion("Clave Requerida");
        }

        if (StringUtils.isEmpty(vo.getNombre())) {
            throw new BaseExcepcion("Nombres Requeridos");
        }
        if (StringUtils.isEmpty(vo.getApellidoPaterno())) {
            throw new BaseExcepcion("Apellido Paterno Requerido");
        }
        if (StringUtils.isEmpty(vo.getApellidoMaterno())) {
            throw new BaseExcepcion("Apellido Materno Requerido");
        }
        Usuario usuario = usuarioDAO.obtenerCorreo(vo.getCorreo());
        if (usuario != null) {
            throw new BaseExcepcion("El correo ya existe");
        }
        if (usuarioDAO.obtenerdni(vo.getDni()) != null) {
            throw new BaseExcepcion("El DNI ya existe");
        }

        usuarioDAO.insertar(vo);
    }
    
    public Usuario obtener(String correo, String clave) throws BaseExcepcion {
        return usuarioDAO.obtener(correo, clave);
    }
}
