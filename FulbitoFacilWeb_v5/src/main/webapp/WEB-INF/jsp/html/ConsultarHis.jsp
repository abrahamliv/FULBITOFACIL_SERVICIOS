<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="upc.iluminados.ws.modelo.Usuario"%>
<%@page import="java.util.List"%>
<html>
<head>
<title>Sistema de Alquiler de Canchas</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link href="img/stylesheet.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
body {
	background-color: #000000;
}
.Estilo2 {
	font-size: 18px;
	color: #FFFFFF;
}
.Estilo3 {
	font-size: 16px;
	font-family: Arial, Helvetica, sans-serif;
	font-weight: bold;
	color: #B8B8B8;
}
.Estilo4 {
	font-size: 36px;
	color: #FFFFFF;
	font-weight: bold;
	font-family: Arial, Helvetica, sans-serif;
}
.Estilo7 {color: #B8B8B8}
.Estilo13 {color: #000000; font-weight: bold; font-family: Arial, Helvetica, sans-serif; font-size: 18px; }
.Estilo17 {color: #000000}
.Estilo18 {color: #000000; font-weight: bold; font-family: Arial, Helvetica, sans-serif; font-size: 12px; }
.Estilo27 {font-family: Arial, Helvetica, sans-serif, font-size: 11px;}
.Estilo44 {font-family: Arial, Helvetica, sans-serif; font-weight: bold; }
.Estilo54 {font-family: Arial, Helvetica, sans-serif; font-size: 11px; font-weight: bold; }
.Estilo56 {font-weight: bold; font-size: 11px; color: #FFFFFF; }
.Estilo22 {font-family: Arial, Helvetica, sans-serif; font-size: 11px; }
--> 
</style> 

<script type="text/javascript">

	function buscar()
	{
		
		if(document.formularioCliente.codigoCliente.value.length==0 ||document.formularioCliente.fechaDesde.value.length==0
				||document.formularioCliente.fechaHasta.value.length==0){
			alert("Ingrese Todos los datos ");
			
		}else{
		
		document.formularioCliente.accion.value = 'buscar';
		document.formularioCliente.submit();
		}
		
		
	}
	
	function siguiente()
	{
		document.formularioCliente.accion.value = 'siguiente';
		document.formularioCliente.submit();			
	}

</script>


</head>
<body>
<form name="formularioCliente" method="get" action="<%=request.getContextPath()%>/consultarHis.do">
<input type="hidden" name="accion" value=""/>
 
<table width="100%" bgcolor="#000000">
<tr>
<td height="587" valign="top">
<table cellpadding="0" cellspacing="0" border="0" class="main" align="center" width="70%">
		
	<tr>
	  <td width="20%" height="144" valign="top" bgcolor="#FFFFCC" class="footer"></td>
	  <td width="80%" valign="top" bgcolor="#FFFFCC" class="footer"><table width="100%" border="0" bgcolor="#FFFFCC">
        <tr>
          <td width="2%"><table width="100%" border="0">
            <tr>
              <th width="2%" scope="row"><span class="Estilo27"></span></th>
              <td colspan="5"><span class="Estilo44">CONSULTA DE HISTORIAL DE ALQUILERES DE CANCHA </span></td>
            </tr>
            <tr>
              <th scope="row"><span class="Estilo27"></span></th>
              <td width="16%"><span class="Estilo27"></span></td>
              <td width="26%"><span class="Estilo27"></span></td>
              <td width="14%"><span class="Estilo27"></span></td>
              <td width="22%">&nbsp;</td>
              <td width="20%"><span class="Estilo27"></span></td>
            </tr>
            <tr>
              <th scope="row"><span class="Estilo27"></span></th>
              
              <td><span class="Estilo54">Ingrese CLiente(codigo): </span></td>
              <td><input id="codigoCliente" name="codigoCliente" type="text" ></td>
              
              <tr>
                    <td>Fecha Desde</td>
                    <td><input type="text" name="fechaDesde" value="" size="20" /></td>
                    
                    
                </tr>
         <tr>
         
         <td>Fecha Hasta</td>
                    <td><input type="text" name="fechaHasta" value="" size="20" /></td>
         
              
              
              <td><span class="Estilo27">
                <input name="btnBuscar" type="submit" id="btnBuscar" onclick="javascript:buscar();" value="Buscar">
              </span></td>
            </tr>
            <tr>
              <th scope="row"><span class="Estilo27"></span></th>
              <td><span class="Estilo27"></span></td>
              <td><span class="Estilo27"></span></td>
              <td><span class="Estilo27"></span></td>
              <td>&nbsp;</td>
              <td><span class="Estilo27"></span></td>
            </tr>
            <tr>
              <th scope="row"><span class="Estilo27"></span></th>
              <td colspan="5" rowspan="5"><table width="100%" border="1">
                  <tr>
                    <td width="4%" bgcolor="#CC0000" class="Estilo27" scope="row"><span class="Estilo56">N°</span></td>
                    <td width="18%" bgcolor="#CC0000" class="Estilo27"><span class="Estilo56">Nombre </span></td>
                    <td width="30%" bgcolor="#CC0000" class="Estilo27"><span class="Estilo56">Apellidos </span></td>
                    <td width="14%" bgcolor="#CC0000" class="Estilo27"><span class="Estilo56">Fecha</span></td>
                    <td width="13%" bgcolor="#CC0000" class="Estilo27"><span class="Estilo56">Hora Inicio</span></td>
                    <td width="10%" bgcolor="#CC0000" class="Estilo27"><span class="Estilo56">Hora Fin</span></td>
                    
                  </tr>
                  <c:forEach items="${model.ac}" var="cliente">
	                  <tr>
	                    <td class="Estilo22" scope="row">${cliente.cliente.id}</td>
	                    <td class="Estilo22">${cliente.cliente.nombre}</td>
	                    <td class="Estilo22">${cliente.cliente.apellidoPaterno}</td>
	                    <td class="Estilo22">${cliente.fecha}</td>
	                    <td class="Estilo22">${cliente.horaInicio}</td>
	                    <td class="Estilo22">${cliente.horaFin}</td>
	                  </tr>                  	
                  </c:forEach>
              </table></td>
            </tr>
            <tr>
              <th scope="row"><span class="Estilo27"></span></th>
            </tr>
            <tr>
              <th scope="row"><span class="Estilo27"></span></th>
            </tr>
            <tr>
              <th scope="row"><span class="Estilo27"></span></th>
            </tr>
            <tr>
              <th scope="row"><span class="Estilo27"></span></th>
            </tr>
            <tr>
              <th scope="row"><span class="Estilo27"></span></th>
              <td><span class="Estilo27"></span></td>
              <td><span class="Estilo27"></span></td>
              <td><span class="Estilo27"></span></td>
              <td>&nbsp;</td>
              <td><span class="Estilo27"></span></td>
            </tr>
            
            
          </table></td>
        </tr>
      </table></td>
	</tr>
</table>
</td>
</tr>
</table>
</form>
</body>
</html>