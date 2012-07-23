/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upc.iluminados.dao;

import upc.iluminados.excepcion.BaseExcepcion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import upc.iluminados.modelo.Cancha;
import upc.iluminados.modelo.HorarioCancha;
import upc.iluminados.modelo.Local;
import upc.iluminados.util.ConexionBD;

/**
 *
 * @author Carlos
 */
public class CanchaDAO extends BaseDAO {

    public void insertar(Cancha vo, List<HorarioCancha> lista) throws BaseExcepcion {
        System.out.println("CanchaDAO: insertar(Cancha vo)");
        String query = "INSERT INTO tb_cancha(nombre, tarifadiurna,tarifanocturna,idlocal) VALUES (?,?,?,?)";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet keys = null;
        int idCancha = 0;
        try {
            //Insertar cancha
            try {
                con = ConexionBD.obtenerConexion();
                stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, vo.getNombre());
                stmt.setDouble(2, vo.getTarifaDiurna());
                stmt.setDouble(3, vo.getTarifaNocturna());
                stmt.setInt(4, vo.getLocal().getId());
                int i = stmt.executeUpdate();
                if (i != 1) {
                    throw new BaseExcepcion("Error al insertar cancha");
                }
                keys = stmt.getGeneratedKeys();
                keys.next();
                idCancha = keys.getInt(1);
                vo.setId(idCancha);

            } catch (SQLException e) {
                System.err.println(e.getMessage());
                throw new BaseExcepcion(e.getMessage());
            } finally {
                this.cerrarResultSet(keys);
                this.cerrarStatement(stmt);
            }

            //Insertar horario
            query = "INSERT INTO tb_horariocancha(dia, hora,idCancha) VALUES (?,?,?)";
            for (HorarioCancha hc : lista) {
                try {
                    stmt = con.prepareStatement(query);
                    stmt.setString(1, hc.getDia());
                    stmt.setString(2, hc.getHora());
                    stmt.setInt(3, idCancha);
                    int i = stmt.executeUpdate();
                    if (i != 1) {
                        throw new BaseExcepcion("Error al insertar horario");
                    }
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                    throw new BaseExcepcion(e.getMessage());
                } finally {
                    this.cerrarStatement(stmt);
                }

            }
        } finally {
            this.cerrarConexion(con);
        }

    }

    public Cancha obtener(String nombre, Integer idLocal) throws BaseExcepcion {
        System.out.println("CanchaDAO: obtener(String nombre)");
        Cancha vo = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "select idCancha,nombre,tarifadiurna,tarifanocturna  from tb_cancha where nombre=? and idLocal = ?";
            con = ConexionBD.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setString(1, nombre);
            stmt.setInt(2, idLocal);
            rs = stmt.executeQuery();
            if (rs.next()) {
                vo = new Cancha();
                vo.setId(rs.getInt(1));
                vo.setNombre(rs.getString(2));
                vo.setTarifaDiurna(rs.getDouble(3));
                vo.setTarifaNocturna(rs.getDouble(4));
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

    public List<HorarioCancha> listar(Integer idCancha, Integer distrito, String dia, String hora) throws BaseExcepcion {
        System.out.println("CanchaDAO: obtener(String nombre)");
        List<HorarioCancha> lista = new ArrayList<HorarioCancha>();
        HorarioCancha vo = null;
        Cancha cancha = null;
        Local local = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
//            String query = "select b.idHorario, b.dia,b.hora,a.idCancha,a.nombre,a.tarifadiurna,a.tarifanocturna, exists ( select 1 from tb_alquilercancha ac where ac.idhorario = b.idhorario ) as alquilado "
//                    + " from tb_cancha a, tb_horariocancha b, tb_local c where a.idCancha = b.idCancha and a.idLocal = c.idLocal ";

            String query = "select b.idHorario, b.dia,b.hora,a.idCancha,a.nombre,a.tarifadiurna,a.tarifanocturna, exists ( select 1 from tb_alquilercancha ac where ac.idhorario = b.idhorario AND ac.fecha = '" + dia + " ') as alquilado, c.nombre as localNombre "
                    + " from tb_cancha a, tb_horariocancha b, tb_local c where a.idCancha = b.idCancha and a.idLocal = c.idLocal ";

            if (idCancha != null) {
                query = query + " and a.idCancha = " + idCancha;
            }
            if (distrito != null) {
                query = query + " and c.distrito = " + distrito;
            }
            //if (dia != null) {
            query = query + " and b.dia = DATE_FORMAT('" + dia + "','%w')";
            //}
            if (hora != null) {
                query = query + " and b.hora = '" + hora + "'";
            }
            System.out.println("CanchaDAO: query=" + query);
            con = ConexionBD.obtenerConexion();
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                vo = new HorarioCancha();
                vo.setId(rs.getInt(1));
                vo.setDia(rs.getString(2));
                vo.setHora(rs.getString(3));
                vo.setAlquilado(rs.getInt("alquilado") == 1 ? true : false);
                cancha = new Cancha();
                cancha.setId(rs.getInt(4));
                cancha.setNombre(rs.getString(5));
                cancha.setTarifaDiurna(rs.getDouble(6));
                cancha.setTarifaNocturna(rs.getDouble(7));
                local = new Local();
                local.setNombre(rs.getString("localNombre"));
                cancha.setLocal(local);
                vo.setCancha(cancha);

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
