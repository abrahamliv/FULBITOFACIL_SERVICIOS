<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<fieldset>

    <form name="AlqCanchaFulbito" action="<%=request.getContextPath()%>/alquilerCancha.do" method="post" >
		<input type="hidden" name="accion" value="pagar" />
    
        <div id="nav" class="nav"><ul>

                <li>Alquiler Cancha de Fulbito</li>

            </ul></div>

        <table border="0">


            <tr>
                <td>Cancha de Fulbito:</td>
                <td>
                    ${alquilerCancha.horarioCancha.cancha.nombre}
                    <br/><br/></td>
            </tr>



            <tr><td><font class="labels">Fecha:</font></td><td>${alquilerCancha.fecha}</td></tr>

            <tr><td><font class="labels">Hora Inicio:</font></td><td>${alquilerCancha.horaInicio}</td></tr>

            <tr><td><font class="labels">Hora Fin:</font></td><td>${alquilerCancha.horaFin}</td></tr>
            
            <tr>
            	<td><font class="labels">Tipo de Pago:</font></td>
            	<td>
                <SELECT name="tipoPago">
                    <OPTION VALUE="1">Debito</OPTION>		
                    <OPTION VALUE="2">Credito</OPTION>		
                </SELECT>
                </td>
        	</tr>
            
             <tr><td><font class="labels">Numero Tarjeta:</font></td><td><input type="text" name="nroTarjeta" size="40" class="texto"/></td></tr>

			 <tr><td><font class="labels">Monto:</font></td><td><input type="text" name="monto" size="40" value="${alquilerCancha.monto}" class="texto"/></td></tr>
			

            <tr><td><button type="reset">

                        <img src="imagenes/delete.gif" alt="" style="height: 17px; "/>Cancelar</button>

                </td><td>

                    <button type="submit">

                        <img src="imagenes/save.png" alt="" style="height: 17px; "/>Pagar

                    </button>

                </td></tr>

        </table>

    </form>

</fieldset>