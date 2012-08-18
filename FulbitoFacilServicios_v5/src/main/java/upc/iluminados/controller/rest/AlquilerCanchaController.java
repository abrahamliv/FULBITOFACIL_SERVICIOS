package upc.iluminados.controller.rest;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import upc.iluminados.excepcion.BaseExcepcion;
import upc.iluminados.modelo.rest.AlquilerCanchaList;
import upc.iluminados.webservice.rest.ServiciosAlquilerCancha;


@Controller
public class AlquilerCanchaController {

	
protected static Logger logger = Logger.getLogger("controller");
	
	
	
	@Resource(name="consultaHisService")
	private ServiciosAlquilerCancha serviciosAlquilerCancha;
		
	
	@RequestMapping(value="/consultashis", method=RequestMethod.GET, headers="Accept=application/xml, application/json")
	public @ResponseBody AlquilerCanchaList getConsultaHis(@PathVariable("nombre") String nombre, @PathVariable("fechadesde") String fechadesde,
			@PathVariable("fechahasta") String fechahasta) throws BaseExcepcion{
		
		logger.debug("Provider has received request to get all persons");

		AlquilerCanchaList result=new AlquilerCanchaList();
		
		result.setData(serviciosAlquilerCancha.getAll(nombre, fechadesde, fechahasta));
		
		return result;
	}
	
	@RequestMapping(value="/consultashis2", method=RequestMethod.GET, headers="Accept=application/xml, application/json")
	public @ResponseBody AlquilerCanchaList getConsultaHis() throws BaseExcepcion{
		
		logger.debug("Provider has received request to get all persons");

		AlquilerCanchaList result=new AlquilerCanchaList();
		
		result.setData(serviciosAlquilerCancha.getAll());
		
		return result;
	}
}
