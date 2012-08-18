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
import upc.iluminados.ws.modelo.Cancha;
import upc.iluminados.ws.modelo.HorarioCancha;
import upc.iluminados.ws.modelo.Local;
import upc.iluminados.ws.modelo.Usuario;

public class RegistrarCanchaController extends AbstractController 
{
	private static final Logger logger = Logger.getLogger(RegistrarCanchaController.class);
	

	private static final String VISTA_REGISTRAR_CANCHA = "RegistrarCancha";
	
	private static final String PARAMETRO_ACCION = "accion";
	private static final String ACCION_GUARDAR = "guardar";
	
	private Service service;
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		logger.debug("Accion es: " + request.getParameter(PARAMETRO_ACCION));
		
		if(esAccionGuardar(request))
		{
			return registrarCancha(request);
		}
		else
		{
			Usuario usuario = (Usuario) request.getSession().getAttribute(Constante.SESION_USUARIO);
			List<Local> listadoLocal = new ArrayList<Local>();
//			Local local = new Local();
//			local.setId(1);
//			local.setNombre("Miramar");
//			listadoLocal.add(local);
            try {
                //Obtener locales del dueño
            	listadoLocal = service.listar(usuario.getId());
            } catch (BaseExcepcion ex) {
            }
            request.getSession().setAttribute("listadoLocal", listadoLocal);
			request.setAttribute("cancha", new Cancha());
			request.getSession().removeAttribute("model");
			return new ModelAndView(VISTA_REGISTRAR_CANCHA);
		}
		
	}

	
	private ModelAndView registrarCancha(HttpServletRequest request) {
		ModelAndView view = null;
		Cancha cancha = new Cancha();

        //Obtener atributos de la cancha
        String strLocal = request.getParameter("local");
        String nombre = request.getParameter("nombre");
        String tarifaDiurna = request.getParameter("tarifaDiurna");
        String tarifaNocturna = request.getParameter("tarifaNocturna");

        try {
        	Local local = new Local();
        	local.setId(Integer.valueOf(strLocal));
        	cancha.setLocal(local);
        } catch (Exception ex) {
        }

        cancha.setNombre(nombre);

        try {
            cancha.setTarifaDiurna(Double.parseDouble(tarifaDiurna));
        } catch (Exception ex) {
        }
        try {
            cancha.setTarifaNocturna(Double.parseDouble(tarifaNocturna));
        } catch (Exception ex) {
        }

        //Obtener horario
        HorarioCancha hc = null;
        List<HorarioCancha> listado = new ArrayList<HorarioCancha>();
        String[] horario = request.getParameterValues("horario");
        String[] arr = null;
        if (horario != null) {
            for (String dia_hora : horario) {
                arr = dia_hora.split("_");
                hc = new HorarioCancha();
                hc.setDia(arr[0]);
                hc.setHora(arr[1]);
                listado.add(hc);
            }
        }
        try{
	        service.registrarCancha(cancha, listado);
	        request.setAttribute("mensaje", "registro exitoso");
	        view =  new ModelAndView(new RedirectView("home"));
        }catch(BaseExcepcion ex){
        	request.setAttribute("cancha", cancha);
        	request.setAttribute("horario", horario);
        	request.setAttribute("error", ex.getMessage());
        	view = new ModelAndView(VISTA_REGISTRAR_CANCHA);
        }
        return view;
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