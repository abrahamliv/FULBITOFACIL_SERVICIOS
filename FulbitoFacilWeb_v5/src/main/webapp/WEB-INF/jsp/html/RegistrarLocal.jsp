<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <script type="text/javascript">
 
    function soloNumeros(evt){
        //asignamos el valor de la tecla a keynum
        if(window.event){// IE
        keynum = evt.keyCode;
        }else{
        keynum = evt.which;
        }
        //comprobamos si se encuentra en el rango
        if(keynum>47 && keynum<58){
        return true;
        }else{
        return false;
        }
    }

    </script>

    <body>
        <form name="Local" action="<%=request.getContextPath()%>/registrarLocal.do" method="post" >
                <input type="hidden" name="accion" value="guardar"/>
            <table>
                <tr>
                    <td><strong><B>REGISTRAR LOCAL</B></strong></td>
                    <td><br/><br/><br/></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" size="30" maxlength="30"><br/><br/></td>
                </tr>
                <tr>
                    <td>Direccion:</td>
                    <td><input type="text" name="direccion" size="60" maxlength="60"><br/><br/></td>
                </tr>
                <tr>
                    <td>Distrito:</td>
                    <td>
                        <SELECT name="distrito">
                            <OPTION VALUE="0">Seleccione...</OPTION>			
                            <OPTION VALUE="1">Lima</OPTION>		
                            <OPTION VALUE="2">Santiago de Surco</OPTION>		
                            <OPTION VALUE="3">San Borja</OPTION>		
                            <OPTION VALUE="4">La Victoria</OPTION>		
                            <OPTION VALUE="5">San Isidro</OPTION>
                            <OPTION VALUE="6">Callao</OPTION>		
                            <OPTION VALUE="7">SJM</OPTION>		
                            <OPTION VALUE="8">San Miguel</OPTION>		
                            <OPTION VALUE="9">Miraflores</OPTION>		
                            <OPTION VALUE="10">La Molina</OPTION>
                        </SELECT>
                        <br/><br/></td>
                </tr>
                <tr>
                    <td>Direccion Google Maps:</td>
                    <td><input type="text" name="dire_google" size="40" maxlength="40"><br/><br/></td>
                </tr>
                <tr>
                    <td>Telefono Fijo:</td>
                    <td><input type="text" name="telefono" size="10" maxlength="10" onkeypress="return soloNumeros(event)"><br/><br/></td>
       
                </tr>
                <tr>
                    <td><br/><br/><strong><input type="submit" value="Registrar"></strong></td>
                    <td><br/><br/><strong><input type="submit" value="Cancelar"></strong></td>
                </tr>
            </table>
        </form>
    </body>
</html>