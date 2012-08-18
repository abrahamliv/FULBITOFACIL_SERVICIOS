<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<form name="BuscarCanchaForm" action="<%=request.getContextPath()%>/buscarCancha.do" method="post">
    <input type="hidden" name="accion" value="buscar" />
    <table>
        <tr>
            <td><strong><B>BUSCAR CANCHA</B></strong></td>
            <td><br/><br/><br/></td>
        </tr>



        <tr>
            <td>Fecha:</td>
            <td><input type="text" name="dia" size="60" maxlength="60" value="${dia}"><br/><br/></td>
        </tr>

        <tr>
            <td>Hora:</td>
            <td><input type="text" name="hora" size="60" maxlength="60" value="${hora}"><br/><br/></td>
        </tr>

        <tr>
            <td>Distrito:</td>
            <td>
                <SELECT name="distrito">
                    <OPTION VALUE="">Seleccione...</OPTION>			
                    <OPTION VALUE="1">Lima</OPTION>		
                    <OPTION VALUE="2">Santiago de Surco</OPTION>		
                    <OPTION VALUE="3">San Borja</OPTION>		
                    <OPTION VALUE="4">La Victoria</OPTION>		
                    <OPTION VALUE="5">San Isidro</OPTION>	
                </SELECT>
                <br/><br/></td>
        </tr>
        
        <tr>
            <td><br/><br/><strong><input type="submit" value="Buscar"></strong></td>
            <td><br/><br/><strong><input type="submit" value="Cancelar"></strong></td>
        </tr>

        <tr>
            <td>Resultados de Busqueda</td>
            <td>
                <table>
                    <tr>
                        <td>Dia</td>
                        <td>Hora</td>
                        <td>Cancha</td>
                        <td>Alquilar</td>

                    </tr>
                    <c:forEach var="hc" items="${listado}"  >
                        <tr>
                            <td>${dia}</td>
                            <td>${hc.hora}</td>
                            <td>${hc.cancha.nombre}</td>
                            <td>${hc.alquilado?"SI":"NO"}</td>
                            <td>
                            <c:choose>
                            <c:when test="${hc.alquilado}">
                            	Alquilado
                            </c:when>
                            <c:otherwise>
                            	<a href="<%=request.getContextPath()%>/buscarCancha.do?accion=alquilar&horarioId=${hc.id}">Alquilar</a>
                            </c:otherwise>
                            </c:choose>
                            
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
        </tr>

        
    </table>
</form>