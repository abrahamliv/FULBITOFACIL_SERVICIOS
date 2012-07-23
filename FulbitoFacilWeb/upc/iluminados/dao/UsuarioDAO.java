/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upc.iluminados.dao;

import upc.iluminados.excepcion.DAOExcepcion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import upc.iluminados.modelo.Usuario;
import upc.iluminados.util.ConexionBD;

/**
 *
 * @author ALUMNO
 */
public class UsuarioDAO extends BaseDAO {

    public void insertar(Usuario vo) throws DAOExcepcion {
        System.out.println("RegistroDAO: insertar(Usuario vo)");
        String query = "INSERT INTO tb_usuario(correo, clave , nombre , apellidoPaterno , apellidoMaterno , sexo , dni , direccion , distrito , fechaNacimiento , celular , tipo , estado  ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConexionBD.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setString(1, vo.getCorreo());
            stmt.setString(2, vo.getClave());
            stmt.setString(3, vo.getNombre());
            stmt.setString(4, vo.getApellidoPaterno());
            stmt.setString(5, vo.getApellidoMaterno());
            stmt.setString(6, ""+vo.getSexo());
            stmt.setString(7, vo.getDni());
            stmt.setString(8, vo.getDireccion());
            stmt.setInt(9, vo.getDistritoId());
            stmt.setString(10, vo.getFechaNacimiento());
            stmt.setString(11, vo.getCelular());
            stmt.setInt(12, vo.getTipo());
            stmt.setInt(13, vo.getEstado());

            int i = stmt.executeUpdate();
            if (i != 1) {
                throw new SQLException("No se pudo insertar");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new DAOExcepcion(e.getMessage());
        } finally {
            this.cerrarStatement(stmt);
            this.cerrarConexion(con);
        }
    }
    
     public Usuario obtener(String correo, String clave) throws DAOExcepcion {
        System.out.println("UsuarioDAO: obtener(String correo, String clave)");
        Usuario vo = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "select idUsuario, nombre, apellidoPaterno, apellidoMaterno, tipo from tb_usuario where correo=? and clave = ?";
            con = ConexionBD.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setString(1, correo);
            stmt.setString(2, clave);
            rs = stmt.executeQuery();
            if (rs.next()) {
            	vo = new Usuario();
                vo.setId(rs.getInt(1));
                vo.setNombre(rs.getString(2));
                vo.setApellidoPaterno(rs.getString(3));
                vo.setApellidoMaterno(rs.getString(4));
            	vo.setTipo(rs.getInt(5));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new DAOExcepcion(e.getMessage());
        } finally {
            this.cerrarResultSet(rs);
            this.cerrarStatement(stmt);
            this.cerrarConexion(con);
        }
        return vo;
    }

    public Usuario obtenerCorreo(String correo) throws DAOExcepcion {
        System.out.println("UsuarioDAO: obtener(String correo)");
        Usuario vo = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "select idUsuario, nombre, apellidoPaterno, apellidoMaterno from tb_usuario where correo=? ";
            con = ConexionBD.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setString(1, correo);
            rs = stmt.executeQuery();
            if (rs.next()) {
                vo = new Usuario();
                vo.setId(rs.getInt(1));
                vo.setNombre(rs.getString(2));
                vo.setApellidoPaterno(rs.getString(3));
                vo.setApellidoMaterno(rs.getString(4));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new DAOExcepcion(e.getMessage());
        } finally {
            this.cerrarResultSet(rs);
            this.cerrarStatement(stmt);
            this.cerrarConexion(con);
        }
        return vo;
    }

    public Usuario obtenerdni(String dni) throws DAOExcepcion {
        System.out.println("UsuarioDAO: obtener(String dni)");
        Usuario vo = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "select idUsuario, nombre, apellidoPaterno, apellidoMaterno from tb_usuario where dni=? ";
            con = ConexionBD.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setString(1, dni);
            rs = stmt.executeQuery();
            if (rs.next()) {
                vo.setId(rs.getInt(1));
                vo.setNombre(rs.getString(2));
                vo.setApellidoPaterno(rs.getString(3));
                vo.setApellidoMaterno(rs.getString(4));
            	vo.setTipo(rs.getInt(5));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new DAOExcepcion(e.getMessage());
        } finally {
            this.cerrarResultSet(rs);
            this.cerrarStatement(stmt);
            this.cerrarConexion(con);
        }
        return vo;
    }
}
