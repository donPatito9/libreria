<%-- 
    Document   : opciones
    Created on : 22-08-2022, 3:41:59
    Author     : 696
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>La Libreria de Papel</h1>
<p>
    Opciones: 
    <a href="<c:url value="/AgregarLibroServlet" />">Agregar Libro</a>
    |
    <a href="<c:url value="/ListarLibroServlet" />">Listar Libros</a>
</p>
<hr />
