


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
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
    <body>
        <div align="center">
            <h3>Login</h3>
            <FORM action="Login" method="post">
                <table width="346" border="0" cellpadding="2" cellspacing="2">
                    <tr>
                        <td width="68"><strong>Login:</strong></td>
                        <td width="144"><input type="text" name="login" value =""/></td>
                        <td width="106" rowspan="3"><img src="./img/login_welcome.jpg" width="120" height="100"></td>
                    </tr>
                    <tr>
                        <td><strong>Password:</strong></td>
                        <td><input type="text" name="password" value =""/></td>
                    </tr>
                    <tr align="center">
                        <td height="28" colspan="2"><strong>
                                <input type="submit" value="Aceptar" >
                            </strong></td>
                    </tr>
                    <tr align="right">
                        <td height="28" colspan="2"><strong>
                                <a href="<%=request.getContextPath()%>/registrarDuenio.do?accion=iniciar"/>Registrar Duenio</a>
                            </strong>
                        </td>
                    </tr>
                    <tr align="right">
                        <td height="28" colspan="2"><strong>
                                Registrar Cliente
                            </strong>
                        </td>
                    </tr>
                </table>
                <p>&nbsp;</p>
            </FORM>
            <br>

        </div>
    </body>
</html>