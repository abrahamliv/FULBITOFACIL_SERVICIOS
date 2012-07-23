/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upc.iluminados.modelo;

/**
 *
 * @author cdiaz
 */
public class Cancha extends Bean{
    
    private Integer id;
    private String nombre;
    private double tarifaDiurna;
    private double tarifaNocturna;
    private Local local;
    private String rutaFoto;

    public Cancha() {
        local = new Local();
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the tarifaDiurna
     */
    public double getTarifaDiurna() {
        return tarifaDiurna;
    }

    /**
     * @param tarifaDiurna the tarifaDiurna to set
     */
    public void setTarifaDiurna(double tarifaDiurna) {
        this.tarifaDiurna = tarifaDiurna;
    }

    /**
     * @return the tarifaNocturna
     */
    public double getTarifaNocturna() {
        return tarifaNocturna;
    }

    /**
     * @param tarifaNocturna the tarifaNocturna to set
     */
    public void setTarifaNocturna(double tarifaNocturna) {
        this.tarifaNocturna = tarifaNocturna;
    }

    /**
     * @return the local
     */
    public Local getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(Local local) {
        this.local = local;
    }

    /**
     * @return the rutaFoto
     */
    public String getRutaFoto() {
        return rutaFoto;
    }

    /**
     * @param rutaFoto the rutaFoto to set
     */
    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
    }
}
