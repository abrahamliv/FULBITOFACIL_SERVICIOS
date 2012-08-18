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
import org.springframework.web.client.RestTemplate;

import upc.iluminados.modelo.rest.AlquilerCancha;
import upc.iluminados.modelo.rest.AlquilerCanchaList;


public class AlquilerCanchaController {
	
protected static Logger logger = Logger.getLogger("controller");
	
	private RestTemplate restTemplate = new RestTemplate();
	
	
	
	
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public String getAll(Model model) {
		logger.debug("recuperar todas las personas de mi agenda ");
		
		// Prepare acceptable media type
		List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
		acceptableMediaTypes.add(MediaType.APPLICATION_XML);
		
		// Prepare header
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(acceptableMediaTypes);
		HttpEntity<AlquilerCancha> entity = new HttpEntity<AlquilerCancha>(headers);

		// Send the request as GET
		try {
			ResponseEntity<AlquilerCanchaList> result = 
					restTemplate.exchange("http://localhost:8085/FulbitoFacilServicios_v5/agenda/consultahis2",
							HttpMethod.GET, entity, AlquilerCanchaList.class);
			// Add to model
			model.addAttribute("persons", result.getBody().getData());
			
		} catch (Exception e) {
			logger.error(e);
		}
		
		// This will resolve to /WEB-INF/jsp/personspage.jsp
		return "personspage";
	}

}
