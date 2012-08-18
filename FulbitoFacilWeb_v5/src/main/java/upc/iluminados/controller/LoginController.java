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

public class LoginController extends AbstractController 
{
	private static final Logger logger = Logger.getLogger(LoginController.class);
	

	private static final String VISTA_LOGIN = "login";
	
	private static final String PARAMETRO_ACCION = "accion";
	private static final String ACCION_LOGEAR = "logear";
	
	private Service service;
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		logger.debug("Accion es: " + request.getParameter(PARAMETRO_ACCION));
		
		if(esAccionLoguear(request))
		{
			try{
				Usuario usuario = logear(request);
				request.getSession().setAttribute(Constante.SESION_USUARIO, usuario);
				return new ModelAndView(new RedirectView("home.do"));
			}catch(BaseExcepcion ex){
				request.setAttribute("error", ex.getMessage());
			}
		}
		
		return new ModelAndView(VISTA_LOGIN);
	}

	
	
	private Usuario logear(HttpServletRequest request) throws BaseExcepcion {
		// TODO Auto-generated method stub
		String login = request.getParameter("login");
        String password = request.getParameter("password");
       
        return service.logear(login, password);
        
	}

	
	
	/**
	 * @param request
	 * @return
	 */
	private boolean esAccionLoguear(HttpServletRequest request)
	{
		return ACCION_LOGEAR.equals(request.getParameter(PARAMETRO_ACCION));
	}
	
	
	/**
	 * @param service
	 */
	public void setService(Service service)
	{
		this.service = service;
	}
	
}