    
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Fulbito Facil</title>
    <style type="text/css">
        <!--
        body {
            margin-left: 0px;
            margin-top: 0px;
            margin-right: 0px;
            margin-bottom: 0px;
            background-color: #F5F7E8;
        }
        -->
    </style>
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
    
    function soloFecha(evt){
        //asignamos el valor de la tecla a keynum
        if(window.event){// IE
            keynum = evt.keyCode;
        }else{
            keynum = evt.which;
        }
        //comprobamos si se encuentra en el rango
        if ((keynum>47 && keynum<58) || (keynum = 45)){
            return true;
        }else{
            return false;
        }
    }

</script>



<form name="RegDueno" action="<%=request.getContextPath()%>/registrarDuenio.do" method="post">
<input type="hidden" name="accion" value="guardar"/>
    <div id="nav" class="nav"><ul>
            <li>REGISTRAR DUEÑO</li>
        </ul></div>
    <table border="0">
        <tr><td><font class="labels">Nombres</font></td><td><input type="text" name="nombre" size="40" class="texto"/>(*)</td></tr>
        <tr><td><font class="labels">Apellido Paterno</font></td><td><input type="text" name="paterno" size="40" class="texto"/>(*)</td></tr>
        <tr><td><font class="labels">Apellido Materno</font></td><td><input type="text" name="materno" size="40" class="texto"/>(*)</td></tr>
        <tr><td><font class="labels">E-mail</font></td><td><input type="text" name="email" size="20" class="texto"/>(*)</td></tr>
        <tr><td><font class="labels">Sexo</font></td>
            <td>
                <SELECT name="sexo" value="1" size="1" MAXLENGTH="1">
                    <OPTION VALUE="0">Seleccione...</OPTION>			
                    <OPTION VALUE="1">Masculino</OPTION>		
                    <OPTION VALUE="2">Femenino</OPTION>			
                </SELECT></td>
        </tr>

        <tr><td><font class="labels">Dni</font></td><td><input type="text" name="dni" onkeypress="return soloNumeros(event)" size="8" MAXLENGTH="8"/>(*)</td></tr>
        <tr><td><font class="labels">Direccion</font></td><td><input type="text" name="direccion" size="40" class="texto"/></td></tr>

        <tr><td><font class="labels">Distrito</font></td>
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
                </SELECT></td>
        </tr>
        <tr><td><font class="labels">Fecha Nacimiento</font></td><td><input type="text" name="fnac" size="10" MAXLENGTH="10" onkeypress="return soloFecha(event)"/>(aaaa-mm-dd)</td></tr>
        <tr><td><font class="labels">Celular</font></td><td><input type="text" name="celular" size="10" MAXLENGTH="10" onkeypress="return soloNumeros(event)"/></td></tr>
        <tr><td><font class="labels">Clave</font></td><td><input type="password" name="clave1" value="" size="10" MAXLENGTH="10"/></td></tr>
        <tr><td><font class="labels">Confirmar Clave</font></td><td><input type="password" name="clave2" size="10" MAXLENGTH="10"/></td></tr>     

        <tr><td><button type="reset">
                    <img src="imagenes/delete.gif" alt="" style="height: 17px; "/>Cancelar</button>
            </td><td>
                <button type="submit">
                    <img src="imagenes/save.png" alt="" style="height: 17px; "/>Registrarme
                </button>
            </td>
        </tr>
        <tr><td colspan="">${error}
            </td>
        </tr>
    </table>
</form>