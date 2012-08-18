package upc.iluminados.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.view.RedirectView;

import upc.iluminados.service.Service;
import upc.iluminados.util.Constante;
import upc.iluminados.ws.excepcion.BaseExcepcion;
import upc.iluminados.ws.modelo.Usuario;

public class HomeController extends AbstractController 
{
	private static final String VISTA_HOME = "home";
	
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{	
		return new ModelAndView(VISTA_HOME);
	}
	
}