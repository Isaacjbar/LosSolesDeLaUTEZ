<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Escenas</title>
    <style>
        body {
            display: flex;
        }
        .form-container {
            flex: 1;
            padding: 20px;
            border-right: 1px solid #ddd;
        }
        .table-container {
            flex: 1;
            padding: 20px;
        }
    </style>
</head>
<body>
<div class="form-container">
    <form action="escena" method="post">
        <label for="escenaId">ID de Escena:</label>
        <input type="text" id="escenaId" name="escenaId">
        <button type="submit">Agregar</button>
    </form>
</div>
<div class="table-container">
    <table border="1">
        <thead>
        <tr>
            <th>Escenas</th>
        </tr>
        </thead>
        <tbody>
        <% for (String escena : (ArrayList<String>) request.getAttribute("escenas")) { %>
        <tr>
            <td><%= escena %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
</body>
</html>
