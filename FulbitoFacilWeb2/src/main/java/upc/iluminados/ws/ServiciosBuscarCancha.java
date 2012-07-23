/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upc.iluminados.ws;

import java.util.List;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import upc.iluminados.ws.excepcion.BaseExcepcion;
import upc.iluminados.ws.modelo.HorarioCancha;

/**
 *
 * @author Carlos
 */
@WebService(targetNamespace="http://webservice.iluminados.upc/")
public interface ServiciosBuscarCancha {

    @WebResult(name = "horarios")
    List<HorarioCancha> listar(@WebParam(name = "idCancha") Integer idCancha,
            @WebParam(name = "distrito") Integer distrito,
            @WebParam(name = "dia") String dia,
            @WebParam(name = "hora") String hora) throws BaseExcepcion;
}
