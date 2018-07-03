<%
    response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0
    response.setDateHeader("Expires", 0); //prevents caching at the proxy server
    response.setHeader("Cache-Control", "no-store");
%>

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
        <html:form action="saveUser.do" method="post">
            <table>
                <tbody>
                    <tr>
                        <td>Usuario:</td>
                        <td>
                            <html:text name="userFormBean" property="userName" />
                        </td>
                    </tr>
                    <tr>
                        <td>Contraseña:</td>
                        <td><html:password name="userFormBean" property="password" /></td>
                    </tr>
                    <tr>
                        <td>Confirmar Contraseña:</td>
                        <td><html:password name="userFormBean" property="confirmPassword" /></td>
                    </tr>
                    <tr>
                        <td>Roll:</td>
                        <td>
                            <html:select name="userFormBean" property="roll">
                                <html:option value="0">Seleccione el roll</html:option>
                                <html:option value="1">ADMIN</html:option>
                                <html:option value="2">USER</html:option>
                            </html:select>
                        </td>
                    </tr>
                    <tr>
                        <td><html:submit value="Guardar" /></td>
                        <td><html:reset value="Borrar" /></td>
                    </tr>
                </tbody>
            </table>


        </html:form>
    </body>
</html>
