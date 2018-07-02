<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<jsp:useBean id="userFormBean" class="form.UserFormBean" scope="page">
</jsp:useBean>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form action="validateLogin.do" method="post">
            <table border="0">
                <tbody>
                    <tr>
                        <td>
                            <p style="color: red; font: bold;">${mensaje}</p>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Usuario:</td>
                        <td>
                            <html:text name="userFormBean" property="userName" />
                        </td>
                    </tr>
                    <tr>
                        <td>Contraseña:</td>
                        <td>
                            <html:password name="userFormBean" property="password" />
                        </td>
                    </tr>
                    <tr>
                        <td><html:submit value="Entrar" /></td>
                        <td><a href="register.do">Registrarse</a></td>
                    </tr>
                </tbody>
            </table>            
        </form>
    </body>
</html>
