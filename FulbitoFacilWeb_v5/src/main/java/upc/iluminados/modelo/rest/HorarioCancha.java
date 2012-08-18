package upc.iluminados.modelo.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="HorarioCancha")
public class HorarioCancha {
	
	private Integer id;
	private String dia;
	private String hora;
	private Cancha cancha;
	private boolean alquilado;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public Cancha getCancha() {
		return cancha;
	}
	public void setCancha(Cancha cancha) {
		this.cancha = cancha;
	}
	public boolean isAlquilado() {
		return alquilado;
	}
	public void setAlquilado(boolean alquilado) {
		this.alquilado = alquilado;
	}
	
	

}
