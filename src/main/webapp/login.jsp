<%-- index.jsp (proyecto Incrementa5) --%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@page import="connectionpool.ConnectionPool"%>
<%@page import="users.AuthService"%>
<%@page import="users.User"%>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="assets/css/style.css">
    <!-- Enlace a Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="icon" type="image/png" href="./assets/img/favicon.png">
</head>
<style>
        .card-transparent {
            background-color: rgba(255, 255, 255, 0.8); /* Fondo blanco con 80% de opacidad */
            border-color: #28a745;
        }
        .card-footer-transparent {
            background-color: rgba(255, 255, 255, 0.8); /* Fondo blanco con 80% de opacidad */
        }
</style>
<body>
    <%
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //Usuario de la base de datos
        String dbuser = "root";
        //Contraseña de la base de datos
        String dbpassword = "";
        //Pool de conexiones a la base de datos
        ConnectionPool pool = new ConnectionPool("jdbc:mysql://localhost:3306/portal_clinica", dbuser, dbpassword);
        AuthService auth = new AuthService(pool.getConnection());
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = auth.login(username, password);
        if(user!=null){
            session.setAttribute("user", user);
            response.sendRedirect("home.jsp");
        }
        else
            response.sendRedirect("index.jsp?error=Usuario o contraseña no válido");
    %>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>