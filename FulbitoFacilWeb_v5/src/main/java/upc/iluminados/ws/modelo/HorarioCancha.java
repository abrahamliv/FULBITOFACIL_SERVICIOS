/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upc.iluminados.ws.modelo;


/**
 *
 * @author cdiaz
 */
public class HorarioCancha extends Bean{
    
    private Integer id;
    private String dia;
    private String hora;
    private Cancha cancha;
    private boolean alquilado; 

    public HorarioCancha() {
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the dia
     */
    public String getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(String dia) {
        this.dia = dia;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * @return the cancha
     */
    public Cancha getCancha() {
        return cancha;
    }

    /**
     * @param cancha the cancha to set
     */
    public void setCancha(Cancha cancha) {
        this.cancha = cancha;
    }

    /**
     * @return the alquilado
     */
    public boolean isAlquilado() {
        return alquilado;
    }

    /**
     * @param alquilado the alquilado to set
     */
    public void setAlquilado(boolean alquilado) {
        this.alquilado = alquilado;
    }
    
}
