<%@ page import="mx.edu.utez.pruebagit.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrar usuario</title>
</head>
<body>
<%
    HttpSession sesion = request.getSession();
    User u = (User) sesion.getAttribute("usuario");
    if(u != null) { %>
<form method="post" action="sign_in">
    <label>Ingrese su nombre de usuario: </label>
    <input type="text" name="user_name" value="<%=u.getUser_name()%>">
    <br>
    <label>Ingrese su contraseña: </label>
    <input type="password" name="pass1" value="<%=u.getPass()%>">
    <br>
    <label>Ingrese su contraseña nuevamente: </label>
    <input type="password" name="pass2" value="<%=u.getPass()%>">
    <br>
    <label>Ingrese su correo: </label>
    <input type="email" name="email" value="<%=u.getEmail()%>" >
    <br>
    <input type="hidden" value="<%=u.getId()%>" name="operacion" />
    <input type="submit" value="Aceptar">
</form>
    <% } else { %>
<form method="post" action="sign_in">
    <label>Ingrese su nombre de usuario: </label>
    <input type="text" name="user_name" value="">
    <br>
    <label>Ingrese su contraseña: </label>
    <input type="password" name="pass1" value="">
    <br>
    <label>Ingrese su contraseña nuevamente: </label>
    <input type="password" name="pass2" value="">
    <br>
    <label>Ingrese su correo: </label>
    <input type="email" name="email" value="" >
    <br>
    <input type="hidden" value="" name="operacion" />
    <input type="submit" value="Aceptar">
</form>
<% } %>

</body>
</html>
