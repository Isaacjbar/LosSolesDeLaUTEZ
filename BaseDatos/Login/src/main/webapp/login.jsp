<%--
  Created by IntelliJ IDEA.
  User: Isaac
  Date: 19/06/2024
  Time: 05:35 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Inicio de Sesión</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Inicio de Sesión</h2>
    <form action="LoginServlet" method="post">
        <div class="form-group">
            <label for="username">Nombre de Usuario o Correo Electrónico</label>
            <input type="text" class="form-control" id="username" name="username" required>
        </div>
        <div class="form-group">
            <label for="password">Contraseña</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>
        <button type="submit" class="btn btn-primary">Iniciar Sesión</button>
    </form>
    <%
        if (request.getAttribute("errorMessage") != null) {
            System.out.println("<div class='alert alert-danger'>" + request.getAttribute("errorMessage") + "</div>");
        }
    %>
</div>
</body>
</html>

