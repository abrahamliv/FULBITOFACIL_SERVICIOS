package upc.iluminados.webservice;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import upc.iluminados.excepcion.BaseExcepcion;
import upc.iluminados.modelo.AlquilerCancha;
import upc.iluminados.modelo.Usuario;

public class ServiciosConsultarHisTests {
	
	
	
	private ServiciosConsultarHis service;
	
	
	
	
	public ServiciosConsultarHisTests(){
		ApplicationContext fabrica = new ClassPathXmlApplicationContext("fabrica-test2.xml");
		service = (ServiciosConsultarHis) fabrica.getBean("clienteServiciosConsultarHis");

		
	}
	
	
	@Test
	public void listar() throws BaseExcepcion{
		
		Usuario cli01=new Usuario();
		
		List<AlquilerCancha> lista=null;
	/*	
		lista=service.listarConHis("Abraham", "2012-03-03", "2012-03-03");

for (AlquilerCancha ac : lista) {
	System.out.println(ac.getFecha()+""+ac.getCliente().getApellidoPaterno());
}
*/
		//cli01=service.obtenerCliente("1");
		
		//AlquilerCancha alquiler=(AlquilerCancha) service.listarConHis("","","");
	}

}
