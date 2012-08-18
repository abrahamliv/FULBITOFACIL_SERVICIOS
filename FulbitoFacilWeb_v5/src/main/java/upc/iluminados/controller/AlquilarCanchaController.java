package upc.iluminados.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.view.RedirectView;

import upc.iluminados.service.Service;
import upc.iluminados.util.Constante;
import upc.iluminados.ws.excepcion.BaseExcepcion;
import upc.iluminados.ws.modelo.AlquilerCancha;
import upc.iluminados.ws.modelo.Cancha;
import upc.iluminados.ws.modelo.HorarioCancha;
import upc.iluminados.ws.modelo.Local;
import upc.iluminados.ws.modelo.Usuario;

public class AlquilarCanchaController extends AbstractController 
{
	private static final Logger logger = Logger.getLogger(AlquilarCanchaController.class);
	

	private static final String VISTA_ALQUILER_CANCHA = "AlquilerCancha";
	
	private static final String PARAMETRO_ACCION = "accion";
	private static final String ACCION_ALQUILAR = "alquilar";
	private static final String ACCION_PAGAR = "pagar";
	
	private Service service;
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		logger.debug("Accion es: " + request.getParameter(PARAMETRO_ACCION));
		
//		if(esAccionAlquilar(request))
//		{
//	        setAttributeToModel(request, "alquilerCancha", request.getAttribute("alquilerCancha"));
//	        return new ModelAndView(VISTA_ALQUILER_CANCHA, getModel(request));
//			
//		}
//		else 
			if(esAccionPagar(request))
		{
			 try {
				pagar(request);
				return new ModelAndView(new RedirectView("home.do"));
	        } catch (Exception ex) {
	        	setAttributeToModel(request, "error", ex.getMessage());
	        	 return new ModelAndView(VISTA_ALQUILER_CANCHA, getModel(request));
	        }
		}
		
		return new ModelAndView(VISTA_ALQUILER_CANCHA);
	}
	
	
	public void pagar(HttpServletRequest request) throws BaseExcepcion{
		String nroTarjeta = request.getParameter("nroTarjeta");
		String tipoPago = request.getParameter("tipoPago");
		double monto = Double.parseDouble(request.getParameter("monto"));
		//AlquilerCancha alquilerCancha = (AlquilerCancha) getModel(request).get("alquilerCancha");
		AlquilerCancha alquilerCancha = (AlquilerCancha) request.getSession().getAttribute("alquilerCancha");
		alquilerCancha.setNroTarjeta(nroTarjeta);
		alquilerCancha.setTipoPago(tipoPago);
		alquilerCancha.setMonto(monto);
		alquilerCancha.setCliente((Usuario)request.getSession().getAttribute(Constante.SESION_USUARIO));
		service.alquilar(alquilerCancha);
	}



	/**
	 * @param request
	 * @param name
	 * @param value
	 */
	private void setAttributeToModel(HttpServletRequest request, String name, Object value)
	{
		logger.debug("Guardando en sesion el objeto " + value + " con nombre '" + name + "'");
		getModel(request).put(name, value);
	}
	
	@SuppressWarnings("unchecked")
	private Map<String, Object> getModel(HttpServletRequest request)
	{
		Map<String, Object> model = (Map<String, Object>) request.getSession().getAttribute("model");
		
		if(model == null)
		{
			model = new HashMap<String, Object>();
			request.getSession().setAttribute("model", model);
			
			return model;
		}
		
		return model;
	}
	
	/**
	 * @param request
	 * @return
	 */
	private boolean esAccionAlquilar(HttpServletRequest request)
	{
		return ACCION_ALQUILAR.equals(request.getParameter(PARAMETRO_ACCION));
	}

	/**
	 * @param request
	 * @return
	 */
	private boolean esAccionPagar(HttpServletRequest request)
	{
		return ACCION_PAGAR.equals(request.getParameter(PARAMETRO_ACCION));
	}
	
	/**
	 * @param service
	 */
	public void setService(Service service)
	{
		this.service = service;
	}
	
}