package upc.iluminados.controller.rest;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import upc.iluminados.modelo.rest.Usuario;

public class UsuarioController {
	
	
	protected static Logger logger = Logger.getLogger("controller");
	
	private RestTemplate restTemplate = new RestTemplate();
	
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String getUsuario(@RequestParam("login") String id, @RequestParam("password") String password,  Model model) {
		logger.debug("Retrieve person with id: " + id);
		
		// Prepare acceptable media type
		List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
		acceptableMediaTypes.add(MediaType.APPLICATION_XML);
		
		// Prepare header
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(acceptableMediaTypes);
		HttpEntity<Usuario> entity = new HttpEntity<Usuario>(headers);

		// Send the request as GET
		try {
			ResponseEntity<Usuario> result = restTemplate.exchange("http://localhost:8085/FulbitoFacilServicios_v5/agenda/usuario/{login,password	}", HttpMethod.GET, entity, Usuario.class, id);
			// Add to model
			model.addAttribute("person", result.getBody());
			
		} catch (Exception e) {
			logger.error(e);
		}
		
		// This will resolve to /WEB-INF/jsp/getpage.jsp
		return "home";
	}
	

}
