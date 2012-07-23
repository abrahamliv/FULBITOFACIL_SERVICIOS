/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upc.iluminados.ws.modelo;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author cdiaz
 */
public class AlquilerCancha extends Bean{
    
    private HorarioCancha horarioCancha ;
    private Usuario cliente;
    private String fecha;
    private String horaInicio;
    private String horaFin;

    public AlquilerCancha() {
        horarioCancha = new HorarioCancha();
    }

    /**
     * @return the horarioCancha
     */
    public HorarioCancha getHorarioCancha() {
        return horarioCancha;
    }

    /**
     * @param horarioCancha the horarioCancha to set
     */
    public void setHorarioCancha(HorarioCancha horarioCancha) {
        this.horarioCancha = horarioCancha;
    }

    /**
     * @return the cliente
     */
    public Usuario getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the horaInicio
     */
    public String getHoraInicio() {
        return horaInicio;
    }

    /**
     * @param horaInicio the horaInicio to set
     */
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * @return the horaFin
     */
    public String getHoraFin() {
        return horaFin;
    }

    /**
     * @param horaFin the horaFin to set
     */
    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }
    
 
}
