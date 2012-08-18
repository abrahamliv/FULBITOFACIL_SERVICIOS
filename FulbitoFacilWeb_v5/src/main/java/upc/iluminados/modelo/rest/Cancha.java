package upc.iluminados.modelo.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Cancha")
public class Cancha {

	
	
	private Integer id;
    private String nombre;
    private double tarifaDiurna;
    private double tarifaNocturna;
    private Local local;
    private String rutaFoto;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getTarifaDiurna() {
		return tarifaDiurna;
	}
	public void setTarifaDiurna(double tarifaDiurna) {
		this.tarifaDiurna = tarifaDiurna;
	}
	public double getTarifaNocturna() {
		return tarifaNocturna;
	}
	public void setTarifaNocturna(double tarifaNocturna) {
		this.tarifaNocturna = tarifaNocturna;
	}
	public Local getLocal() {
		return local;
	}
	public void setLocal(Local local) {
		this.local = local;
	}
	public String getRutaFoto() {
		return rutaFoto;
	}
	public void setRutaFoto(String rutaFoto) {
		this.rutaFoto = rutaFoto;
	}
    
    
    
}
