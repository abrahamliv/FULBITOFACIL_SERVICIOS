package upc.iluminados.modelo.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Local")
public class Local {

	
	
	 private Integer id;
	    private String nombre;
	    private Integer distritoId;
	    private String direccion;
	    private String telefono;
	    private Usuario dueno;
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
		public Integer getDistritoId() {
			return distritoId;
		}
		public void setDistritoId(Integer distritoId) {
			this.distritoId = distritoId;
		}
		public String getDireccion() {
			return direccion;
		}
		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}
		public String getTelefono() {
			return telefono;
		}
		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}
		public Usuario getDueno() {
			return dueno;
		}
		public void setDueno(Usuario dueno) {
			this.dueno = dueno;
		}
	    
	    
	    
	    
}
