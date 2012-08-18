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
import upc.iluminados.ws.excepcion.BaseExcepcion;
import upc.iluminados.ws.modelo.Usuario;

public class RegistrarDuenioController extends AbstractController 
{
	private static final Logger logger = Logger.getLogger(RegistrarDuenioController.class);
	

	private static final String VISTA_REGISTRAR_DUENIO = "RegistrarDuenio";
	
	private static final String PARAMETRO_ACCION = "accion";
	private static final String ACCION_GUARDAR = "guardar";
	private static final String ACCION_INICIAR = "iniciar";
	
	private Service service;
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		logger.debug("Accion es: " + request.getParameter(PARAMETRO_ACCION));
		
		if(esAccionGuardar(request))
		{
			Usuario usuario = null;
			try{
				usuario = registrarDuenio(request);
				return new ModelAndView(new RedirectView("index.jsp"));
			}catch(BaseExcepcion ex){
				setAttributeToModel(request, "usuario", usuario);
				setAttributeToModel(request, "error", ex.getMessage());
				return new ModelAndView(VISTA_REGISTRAR_DUENIO, getModel(request));
			}
			
		}
		else 
		{
			request.getSession().removeAttribute("model");
			setAttributeToModel(request, "usuario", new Usuario());
		}
		
		return new ModelAndView(VISTA_REGISTRAR_DUENIO);
	}

	
	
	private Usuario registrarDuenio(HttpServletRequest request) throws BaseExcepcion {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("nombre");
        String paterno = request.getParameter("paterno");
        String materno = request.getParameter("materno");
        String sexo = request.getParameter("sexo");
        String dni = request.getParameter("dni");
        String direccion = request.getParameter("direccion");
        String distrito = request.getParameter("distrito");
        String email = request.getParameter("email");
        String clave1 = request.getParameter("clave1");
        String fnac = request.getParameter("fnac");
        String celular = request.getParameter("celular");
        
        Usuario vo = new Usuario();
        vo.setNombre(nombre);
        vo.setApellidoPaterno(paterno);
        vo.setApellidoMaterno(materno);
        vo.setSexo(sexo.charAt(0));
        vo.setDni(dni);
        vo.setDireccion(direccion);
        vo.setDistritoId(Integer.valueOf(distrito));
        vo.setCorreo(email);
        vo.setClave(clave1);
        vo.setFechaNacimiento(fnac);
        vo.setCelular(celular);
        
        service.registrarDuenio(vo);
        
        return vo;
        
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
	private boolean esAccionGuardar(HttpServletRequest request)
	{
		return ACCION_GUARDAR.equals(request.getParameter(PARAMETRO_ACCION));
	}

	/**
	 * @param request
	 * @return
	 */
	private boolean esAccionIniciar(HttpServletRequest request)
	{
		return ACCION_INICIAR.equals(request.getParameter(PARAMETRO_ACCION));
	}
	
	/**
	 * @param service
	 */
	public void setService(Service service)
	{
		this.service = service;
	}
	
}