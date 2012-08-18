package upc.iluminados.modelo.rest;

import javax.xml.bind.annotation.XmlRootElement;

import upc.iluminados.modelo.HorarioCancha;
import upc.iluminados.modelo.Usuario;


@XmlRootElement(name="AlquilerCancha")
public class AlquilerCancha {
	
	private HorarioCancha horarioCancha ;
    private Usuario cliente;
    private String fecha;
    private String horaInicio;
    private String horaFin;
    private double monto;
    private String nroTarjeta;
    private String tipoPago;
	public HorarioCancha getHorarioCancha() {
		return horarioCancha;
	}
	public void setHorarioCancha(HorarioCancha horarioCancha) {
		this.horarioCancha = horarioCancha;
	}
	public Usuario getCliente() {
		return cliente;
	}
	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public String getNroTarjeta() {
		return nroTarjeta;
	}
	public void setNroTarjeta(String nroTarjeta) {
		this.nroTarjeta = nroTarjeta;
	}
	public String getTipoPago() {
		return tipoPago;
	}
	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}
    
    
    
    

}
