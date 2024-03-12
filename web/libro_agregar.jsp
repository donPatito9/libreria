<%-- 
    Document   : libro_agregar
    Created on : 22-08-2022, 3:43:08
    Author     : 696
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Libro</title>
    </head>
    <body>
        <%@include file="opciones.jsp" %>
        <h2>Agregar Libro</h2>
         <table border="1">
        <form action="<c:url value="/AgregarLibroServlet" />" method="post">
            <tr><td> ID:</td>
            <td> <input type="text"
                   name="id" 
                   value="<c:out value="${libro.id}" />"
                   autofocus="true"
                   />
                <c:out value="${mapMensajes['id']}" /></td>
            <br />
            </tr>
            <tr><td> titulo:</td>
                <td><input type="text"
                   name="titulo" 
                   value="<c:out value="${libro.titulo}" />"
                   />
                   <c:out value="${mapMensajes['titulo']}" /></td>
            <br />
        </tr>
        <tr><td> Autor:</td>
            <td><input type="text"
                   name="autor" 
                   value="<c:out value="${libro.autor}" />"
                   />
                <c:out value="${mapMensajes['autor']}" /></td>
            <br />
        </tr>
        <tr><td>Editorial:</td>
            <td><input type="text"
                   name="editorial"
                   value="<c:out value="${libro.editorial}" />"
                   />
                <c:out value="${mapMensajes['editorial']}" /></td>
            <br />
        </tr>
        <tr><td> Precio:</td>
            <td><input type="text"
                   name="precio"
                   value="<c:out value="${libro.precio}" />"
                   />
                <c:out value="${mapMensajes['precio']}" /></td>
            <br />
            <br />
            <tr>
                <td><input type="submit" value="Grabar" /></td>
            </tr>
            <br />

        </form>
        <br/>

        <c:out value="${mensaje}" />
    </body>
</html>
