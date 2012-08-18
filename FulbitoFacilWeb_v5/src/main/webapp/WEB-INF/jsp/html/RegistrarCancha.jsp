<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:scriptlet>
    String[] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
    String[] indiceDias = {"1", "2", "3", "4", "5", "6", "0"};
    String[] horas = {"08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"};
    request.setAttribute("dias", dias);
    request.setAttribute("indiceDias", indiceDias);
    request.setAttribute("horas", horas);
</jsp:scriptlet>

<jsp:declaration>
    boolean existeDiaHorario(String[] horario, String diaHora) {
        if (horario != null && horario.length != 0) {
            for (String dh : horario) {
                if (dh.equals(diaHora)) {
                    return true;
                }
            }
        }
        return false;
    }
</jsp:declaration>


<form name="RegCancha" action="<%=request.getContextPath()%>/registrarCancha.do" method="post">
    <input type="hidden" name="accion" value="guardar"/>
    <table>
        <tr>
            <td><strong><B>REGISTRAR CANCHA</B></strong></td>
            <td><br/><br/><br/></td>
        </tr>

        <tr>
            <td>Local:</td>
            <td>
                <SELECT name="local">
                    <option VALUE="0">Seleccione...</option>			
                    <c:forEach var="local" items="${listadoLocal}"  >
                        <option VALUE="${local.id}" ${local.id==cancha.local.id?"selected":""} >${local.nombre}</option>	
                    </c:forEach>
                </SELECT>
                <br/><br/>
            </td>
        </tr>

        <tr>
            <td>Nombre:</td>
            <td><input type="text" name="nombre" size="60" maxlength="60" value="${cancha.nombre}"><br/><br/></td>
        </tr>

        <tr>
            <td>Tarifa diurna:</td>
            <td><input type="text" name="tarifaDiurna" size="60" maxlength="60" value="${cancha.tarifaDiurna}"><br/><br/></td>
        </tr>

        <tr>
            <td>Tarifa nocturna:</td>
            <td><input type="text" name="tarifaNocturna" size="60" maxlength="60" value="${cancha.tarifaNocturna}"><br/><br/></td>
        </tr>

        <tr>
            <td>Horario:</td>
            <td>
                <table>
                    <tr>
                        <td>&nbsp;</td>
                        <c:forEach var="dia" items="${dias}"  >
                            <td>${dia}</td>
                        </c:forEach>
                    </tr>
                    <c:forEach var="hora" items="${horas}"  >
                        <tr>
                            <td>${hora}</td>
                            <c:forEach var="indice" items="${indiceDias}">
                                <td>
                                    <input type="checkbox" name="horario" value="${indice}_${hora}" <jsp:expression>existeDiaHorario((String[])request.getAttribute("horario"),pageContext.getAttribute("indice") + "_"+ pageContext.getAttribute("hora"))?"checked":""</jsp:expression> />
                                </td>
                            </c:forEach>
                        </tr>
                    </c:forEach>
                </table>
            </td>
        </tr>

        <tr>
            <td colspan="2">${mensaje}${error}</td>
        </tr>


        <tr>
            <td><br/><br/><strong><input type="submit" value="Guardar" ${(mensaje!=null && error==null)?"disabled":""}></strong></td>
            <td><br/><br/><strong><input type="button" value="Salir" onclick="top.location.href='<%=request.getContextPath()%>/futbitofacil1.jsp'" ></strong></td>
        </tr>
    </table>
</form>