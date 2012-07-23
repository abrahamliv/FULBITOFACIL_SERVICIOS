/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upc.iluminados.dao;

import upc.iluminados.excepcion.BaseExcepcion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import upc.iluminados.modelo.AlquilerCancha;
import upc.iluminados.modelo.Cancha;
import upc.iluminados.modelo.Usuario;
import upc.iluminados.modelo.HorarioCancha;
import upc.iluminados.util.ConexionBD;

/**
 *
 * @author Carlos
 */
public class AlquilerCanchaDAO extends BaseDAO {

    public void insertar(AlquilerCancha vo) throws BaseExcepcion {
        System.out.println("CanchaDAO: insertar(Alquiler Cancha vo)");
        String query = "INSERT INTO tb_alquilercancha(idHorario, idUsuario,fecha,horaInicio,horaFin) VALUES (?,?,?,?,?)";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = (Connection) ConexionBD.obtenerConexion();
            stmt = (PreparedStatement) con.prepareStatement(query);
            stmt.setInt(1, vo.getHorarioCancha().getId());
            stmt.setInt(2, vo.getCliente().getId());
            stmt.setString(3, vo.getFecha());
            stmt.setString(4, vo.getHoraFin());
            stmt.setString(5, vo.getHoraInicio());

            int i = stmt.executeUpdate();
            if (i != 1) {
                throw new SQLException("No se pudo insertar");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new BaseExcepcion(e.getMessage());
        } finally {
            this.cerrarStatement(stmt);
            this.cerrarConexion(con);
        }
    }

    public AlquilerCancha obtener(int idHorario) throws BaseExcepcion {
        System.out.println("UsuarioDAO: obtener(String nombre)");
        AlquilerCancha vo = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "select idHorario, idUsuario,fecha,horaInicio,horaFin  from tb_alquilercancha where idHorario=?";
            con = (Connection) ConexionBD.obtenerConexion();
            stmt = (PreparedStatement) con.prepareStatement(query);
            stmt.setInt(1, idHorario);
            rs = stmt.executeQuery();
            if (rs.next()) {
                vo = new AlquilerCancha();;
//                vo.setId(rs.getInt(1));
//                vo.setNombre(rs.getString(2));
//                vo.setTarifaDiurna(rs.getDouble(3));
//                vo.setTarifaNocturna(rs.getDouble(4));

            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new BaseExcepcion(e.getMessage());
        } finally {
            this.cerrarResultSet(rs);
            this.cerrarStatement(stmt);
            this.cerrarConexion(con);
        }
        return vo;
    }

    //Francisco
    public Collection<AlquilerCancha> listar(Integer idCliente) throws BaseExcepcion {
        System.out.println("AlquilerCanchaDAO: listar(Integer idCliente)");
        Collection<AlquilerCancha> lista = new ArrayList<AlquilerCancha>();
        AlquilerCancha vo = null;
        Usuario cliente = null;
        HorarioCancha horarioCancha = null;
        Cancha cancha = null;
        
        
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "SELECT a.fecha, a.horaInicio, a.horaFin, b.idUsuario, b.nombre, b.apellidoPaterno, b.apellidoMaterno, d.nombre as canchanombre "
                    + " FROM tb_alquilercancha a, tb_usuario b, tb_horariocancha c, tb_cancha d "
                    + " Where a.idUsuario = b.idUsuario and b.tipo = 2 and a.idHorario = c.idHorario and c.idCancha = d.idCancha ";
            if(idCliente!=null){
                query = query + " and idUsuario = " + idCliente;
            }
            con = ConexionBD.obtenerConexion();
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                vo = new AlquilerCancha();
                cliente = new Usuario();
                horarioCancha = new HorarioCancha();
                cancha = new Cancha();
                 
                vo.setCliente(cliente);
                vo.setHorarioCancha(horarioCancha);
                horarioCancha.setCancha(cancha);
                
                //AlquilerCancha
                vo.setFecha(rs.getString(1));
                vo.setHoraInicio(rs.getString(2));
                vo.setHoraFin(rs.getString(3));
                
                //Cliente
                cliente.setNombre(rs.getString(5));
                
                //Cancha
                cancha.setNombre(rs.getString("canchanombre"));
             


                lista.add(vo);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new BaseExcepcion(e.getMessage());
        } finally {
            this.cerrarResultSet(rs);
            this.cerrarStatement(stmt);
            this.cerrarConexion(con);
        }
        return lista;
    }
}
