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
import upc.iluminados.ws.modelo.Cancha;
import upc.iluminados.ws.modelo.Local;
import upc.iluminados.ws.modelo.Usuario;

public class RegistrarLocalController extends AbstractController 
{
	private static final Logger logger = Logger.getLogger(RegistrarLocalController.class);
	

	private static final String VISTA_REGISTRAR_LOCAL = "RegistrarLocal";
	
	private static final String PARAMETRO_ACCION = "accion";
	private static final String ACCION_GUARDAR = "guardar";
	
	private Service service;
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		logger.debug("Accion es: " + request.getParameter(PARAMETRO_ACCION));
		
		if(esAccionGuardar(request))
		{
			return registrarLocal(request);
		}
		else
		{
        	return new ModelAndView(VISTA_REGISTRAR_LOCAL);
		}
		
	}

	
	private ModelAndView registrarLocal(HttpServletRequest request) {
		//Obtener atributos de la cancha
        String nombre = request.getParameter("nombre");
        String direccion = request.getParameter("direccion");
        String distrito = request.getParameter("distrito");
        String dire_google = request.getParameter("dire_google");
        String telefono = request.getParameter("telefono");
        Usuario usuario = (Usuario) request.getSession().getAttribute(Constante.SESION_USUARIO);
		

        try {
            //Registrar Local
            Local local = new Local();

            local.setNombre(nombre);
            local.setDireccion(direccion);
            local.setDistritoId(Integer.valueOf(distrito));
            local.setTelefono(telefono);
            local.setDueno(usuario);

            service.registrarLocal(local);
            request.setAttribute("mensaje", "registro exitoso");
        	return new ModelAndView("home");
        } catch (BaseExcepcion ex) {
        	request.setAttribute("error", ex.getMessage());
        	return new ModelAndView(VISTA_REGISTRAR_LOCAL);
        }

	}
	
	
	/**
	 * @param request
	 * @return
	 */
	private boolean esAccionGuardar(HttpServletRequest request)
	{
		return ACCION_GUARDAR.equals(request.getParameter(PARAMETRO_ACCION));
	}

	
	/**
	 * @param service
	 */
	public void setService(Service service)
	{
		this.service = service;
	}
	
}