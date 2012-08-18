package upc.iluminados.webservice;

import java.util.List;

import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import upc.iluminados.excepcion.BaseExcepcion;
import upc.iluminados.modelo.HorarioCancha;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:fabrica-test.xml"})
public class ServiciosBuscarCanchaTests {
	
//	@Autowired
	private ServiciosBuscarCancha service;
	
	public ServiciosBuscarCanchaTests(){
		ApplicationContext fabrica = new ClassPathXmlApplicationContext("fabrica-test.xml");
		service = (ServiciosBuscarCancha) fabrica.getBean("clienteServiciosBuscarCancha");
	}
	
    @Test
	public void listar() throws BaseExcepcion{
    	Integer idCancha = Integer.valueOf(1);
    	Integer distrito = Integer.valueOf(1);
    	String dia = "2012-02-15";
        String hora = null;
        List<HorarioCancha> lista = null;
		
    	lista = service.listar(idCancha, distrito, dia, hora);
    	
    	 for (HorarioCancha hc : lista) {
             System.out.println("idHorario=" + hc.getId() + "|dia=" + hc.getDia() + "|hora=" + hc.getHora() + "|cancha=" + hc.getCancha().getNombre() + "|alquilado=" + (hc.isAlquilado() ? "Si" : "No"));
         }
	}

}
