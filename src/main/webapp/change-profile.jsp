<%-- index.jsp (proyecto Incrementa5) --%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@page import="connectionpool.ConnectionPool"%>
<%@page import="users.*"%>
<%@page import="views.*"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="icon" type="image/png" href="./assets/img/favicon.png">
    <!-- Enlace a Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <%
    String username = request.getParameter("username");
    String nombre = request.getParameter("nombre");
    String correo = request.getParameter("correo");
    String apellido = request.getParameter("apellido");
    //Usuario de la base de datos
    String dbuser = "root";
    //Contraseña de la base de datos
    String dbpassword = "";
    //Pool de conexiones a la base de datos
    ConnectionPool pool = new ConnectionPool("jdbc:mysql://localhost:3306/portal_clinica", dbuser, dbpassword);
    User user = (User)session.getAttribute("user");
    AuthService auth = new AuthService(pool.getConnection());
    User usuario = auth.update(user.getId(), nombre, apellido, correo, username);
    response.sendRedirect("logout.jsp");
    %>

    <!-- Bootstrap JavaScript y dependencias -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>