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
        <%
            if (request.getUserPrincipal() == null) {
        %>
        <form method="post" action="j_security_check">
            <table>
                <tr>
                    <td>Usuario: </td>
                    <td><input type="text"  name= "j_username" ></td>
                </tr>
                <tr>
                    <td>Contraseña: </td>
                    <td><input type="password"  name= "j_password" ></td>
                </tr>
                <tr>
                    <td><input name="entrar" type="submit" value="Entrar"/></td>
                    <td><a href="${pageContext.request.contextPath}/register.do">Registrarse</a></td>
                </tr>
            </table>
        </form>
        <%
            } else {
                response.sendRedirect(request.getContextPath() + "/logged/logged_index.jsp");
            }
        %>
    </body>
</html>
