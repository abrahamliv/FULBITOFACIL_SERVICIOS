/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upc.iluminados.modelo;

/**
 *
 * @author cdiaz
 */
public class Local extends Bean{

    private Integer id;
    private String nombre;
    private Integer distritoId;
    private String direccion;
    private String telefono;
    private Usuario dueno;

    public Local() {
    }

    public Local(Integer id) {
        this.id = id;
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
     * @return the distritoId
     */
    public Integer getDistritoId() {
        return distritoId;
    }

    /**
     * @param distritoId the distritoId to set
     */
    public void setDistritoId(Integer distritoId) {
        this.distritoId = distritoId;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the dueno
     */
    public Usuario getDueno() {
        return dueno;
    }

    /**
     * @param dueno the dueno to set
     */
    public void setDueno(Usuario dueno) {
        this.dueno = dueno;
    }
    
}