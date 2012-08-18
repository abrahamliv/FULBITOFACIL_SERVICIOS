package upc.iluminados.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

public class BuscarCanchaController extends AbstractController 
{
	private static final Logger logger = Logger.getLogger(BuscarCanchaController.class);
	

	private static final String VISTA_BUSCAR_CANCHA = "BuscarCancha";
	private static final String VISTA_ALQUILER_CANCHA = "AlquilerCancha";
	
	private static final String PARAMETRO_ACCION = "accion";
	private static final String ACCION_BUSCAR = "buscar";
	private static final String ACCION_ALQUILAR = "alquilar";
	
	private Service service;
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		logger.debug("Accion es: " + request.getParameter(PARAMETRO_ACCION));
		
		if(esAccionBuscar(request))
		{
			String distrito = request.getParameter("distrito");
            String dia = request.getParameter("dia");
            String hora = request.getParameter("hora");
            List<HorarioCancha> listado = new ArrayList<HorarioCancha>();
            
            try {
                listado = service.buscarCancha(null, (distrito != null && !distrito.equals("")) ? Integer.parseInt(distrito) : null, dia, (hora != null && !hora.equals("")) ? hora : null);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            request.getSession().setAttribute("listado", listado);
            request.setAttribute("distrito", distrito);
            request.getSession().setAttribute("dia", dia);
            request.setAttribute("hora", hora);
			return new ModelAndView(VISTA_BUSCAR_CANCHA);
		}
		else if(esAccionAlquilar(request))
		{
			AlquilerCancha alquilerCancha = new AlquilerCancha();
			int horarioId = Integer.parseInt(request.getParameter("horarioId"));
			String fecha = (String)request.getSession().getAttribute("dia");
			List<HorarioCancha> listado = (List<HorarioCancha>) request.getSession().getAttribute("listado");
			for(HorarioCancha hc: listado){

				if(hc.getId().intValue() == horarioId){
					alquilerCancha.setHorarioCancha(hc);
					alquilerCancha.setHoraInicio(hc.getHora());
					alquilerCancha.setFecha(fecha);
					alquilerCancha.setHoraFin(getHoraFin(hc.getHora()));
					alquilerCancha.setMonto(esNocturno(hc.getHora())?hc.getCancha().getTarifaNocturna():hc.getCancha().getTarifaDiurna());
					request.getSession().setAttribute("alquilerCancha", alquilerCancha);
					break;
				}
				
				
			}
			return new ModelAndView(VISTA_ALQUILER_CANCHA);
		} else
		{
			request.getSession().removeAttribute("listado");
			request.getSession().removeAttribute("dia");
			request.getSession().removeAttribute("alquilerCancha");
			return new ModelAndView(VISTA_BUSCAR_CANCHA);
		}
		
	}

	private String getHoraFin(String horaInicio){
		String hora = (Integer.parseInt("1" + horaInicio.substring(0,2)) - 99 ) + "";
		hora = hora.length()==1?"0"+hora:hora;
		hora = hora + ":00:00";
		return hora;
	}
	
	private boolean esNocturno(String horaInicio){
		return (Integer.parseInt("1" + horaInicio.substring(0,2)) - 100 ) >=18;
	}
	
	
	
	/**
	 * @param request
	 * @return
	 */
	private boolean esAccionBuscar(HttpServletRequest request)
	{
		return ACCION_BUSCAR.equals(request.getParameter(PARAMETRO_ACCION));
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
	 * @param service
	 */
	public void setService(Service service)
	{
		this.service = service;
	}
	
}