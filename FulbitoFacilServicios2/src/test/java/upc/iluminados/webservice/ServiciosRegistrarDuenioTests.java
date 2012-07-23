package upc.iluminados.webservice;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import upc.iluminados.excepcion.BaseExcepcion;
import upc.iluminados.modelo.Bean;
import upc.iluminados.modelo.Usuario;
import static org.junit.Assert.*;


public class ServiciosRegistrarDuenioTests {
	
	private ServiciosRegistrarDuenio service;
	
	public ServiciosRegistrarDuenioTests(){
		ApplicationContext fabrica = new ClassPathXmlApplicationContext("fabrica-test.xml");
		service = (ServiciosRegistrarDuenio) fabrica.getBean("clienteServiciosRegistrarDuenio");
	}
	
    @Test
	public void registrar() throws BaseExcepcion{
    	Usuario duenio = new Usuario();
    	service.registrar(duenio);
	}

}
