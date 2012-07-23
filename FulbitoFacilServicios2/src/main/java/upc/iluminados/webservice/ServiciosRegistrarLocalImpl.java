package upc.iluminados.webservice;
import javax.jws.WebService;
import upc.iluminados.modelo.Local;
/**
*
* @author Fabio Alfaro
*/
@WebService(endpointInterface = "upc.iluminados.webservice.ServiciosRegistrarLocal")
public class ServiciosRegistrarLocalImpl implements ServiciosRegistrarLocal {

	@Override
	public void registrarLocal(Local vo) {
		

	}
}
