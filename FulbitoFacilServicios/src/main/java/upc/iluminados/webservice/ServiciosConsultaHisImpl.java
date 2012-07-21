package upc.iluminados.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import upc.iluminados.modelo.AlquilerCancha;
import upc.iluminados.modelo.Usuario;



@WebService(endpointInterface = "upc.iluminados.webservice.ServiciosConsultaHis")
public class ServiciosConsultaHisImpl implements ServiciosConsultaHis {


	@Override
	public Usuario obtenerCliente(String id) {
		// TODO Auto-generated method stub
		
	Usuario usu=new Usuario();
		
		usu.setApellidoPaterno("Luque");
		usu.setApellidoMaterno("Luque");
		usu.setNombre("Abraham");
		

		return usu;
	}





	@Override
	public List<AlquilerCancha> listarConHis(String nombre, String fechadesde,
			String fechahasta) {
		AlquilerCancha alquiler01=new AlquilerCancha();
		
		/*cli01=buscarCliente(cli01) */
		
		Usuario cli01=new Usuario();
		cli01.setApellidoPaterno("Luque");
		cli01.setApellidoMaterno("Luque");
		cli01.setNombre("Abraham");
		
		List<AlquilerCancha> lista=new ArrayList<AlquilerCancha>();
		
		alquiler01.setCliente(cli01);
		alquiler01.setFecha("2012-07-03");
		alquiler01.setHoraInicio("16-00-00");
		alquiler01.setHoraFin("18-00-00");
		
		
		lista.add(alquiler01);
		
		
		return lista;
	}

}
