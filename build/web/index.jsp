<%-- 
    Document   : index
    Created on : 22-08-2022, 3:41:30
    Author     : 696
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>La Libreria de Papel</title>
    </head>
    <body>
         
        <c:import url="opciones.jsp" />
        <c:url var="urlForm" value="/agregarLibroServlet"/>
        <form action="${urlForm}" method="post">
            
            Id: <input type="text" name="id"/></br></br>
            
            Titulo: <input type="text" name="titulo"/></br></br>
            
            Autor: <input type="text" name="autor"/></br></br>
            
           
            Editorial: <input type="text" name="editorial"/></br></br>
            
            Precio: <input type="text" name="precio"/></br></br>
            
            
            
            <input type="submit" value="Grabar"/>
            <input type="reset" value="Limpiar"/>
        </form>
        <c:if test="${not empty respuesta}">
            <h2> <c:out value="${respuesta}" /></h2>
        </c:if></br> 

        <c:if test="${not empty error}">
            <ul>
                <c:forEach var="e" items="${error}">
                    <li><c:out value="${e}"/></li>  
                </c:forEach>
            </ul>
        </c:if>    
    </body>
</html>

