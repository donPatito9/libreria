<%-- 
    Document   : libro_listar
    Created on : 22-08-2022, 3:42:33
    Author     : 696
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Libros</title>
    </head>
    <body>
        <%@include file="opciones.jsp" %>
        <h2>Listar Libros</h2>

        <form action="<c:url value="/ListarLibroServlet" />" method="get" >
            Editorial:<input type="text" name="editorial" value="${editorial}"/>
            <input type="submit" value="Buscar" />
        </form>
        <br />
        <c:out value="${mensaje}" />

        <br />
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Titulo</th>
                <th>Autor</th>
                <th>Editorial</th>
                <th>Precio</th>
                <th>Acción</th>
            </tr>
            <c:forEach var="l" items="${lstLibros}">
                <tr>
                    <td><c:out value="${l.id}" /> </td>
                    <td><c:out value="${l.titulo}" /> </td>
                    <td><c:out value="${l.autor}" /> </td>
                    <td><c:out value="${l.editorial}" /> </td>
                    <td><c:out value="${l.precio}" /> </td>
                    <td><c:out value="${l.fechaRegistro}" /> </td>
                    <td>
                        <c:url var="urlEliminar" value="/ListarLibroServlet">
                            <c:param name="editorial" value="${param.editorial}" />
                        </c:url>
                        <form action="${urlEliminar}" method="post">
                            <input type="hidden" name="id" value="${p.id}" />
                            <input type="submit" value="Eliminar" />
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

