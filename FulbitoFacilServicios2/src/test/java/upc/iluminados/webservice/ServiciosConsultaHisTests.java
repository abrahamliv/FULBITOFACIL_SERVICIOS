package upc.iluminados.webservice;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import upc.iluminados.modelo.AlquilerCancha;
import upc.iluminados.modelo.Usuario;

public class ServiciosConsultaHisTests {
	
	
	
	private ServiciosConsultaHis service;
	
	
	
	
	public ServiciosConsultaHisTests(){
		ApplicationContext fabrica = new ClassPathXmlApplicationContext("fabrica-test.xml");
		service = (ServiciosConsultaHis) fabrica.getBean("clienteServiciosConsultarHis");

		
	}
	
	
	@Test
	public void listar(){
		
		Usuario cli01=new Usuario();
		cli01=service.obtenerCliente("1");
		
		AlquilerCancha alquiler=(AlquilerCancha) service.listarConHis("","","");
	}

}
