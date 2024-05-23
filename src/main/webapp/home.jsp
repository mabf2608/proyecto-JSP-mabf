<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@page import="connectionpool.ConnectionPool"%>
<%@page import="users.Paciente"%>
<%@page import="users.PacienteService"%>
<%@page import="views.homeView"%>
<%@page import="java.util.ArrayList"%>
<%@page import="users.User"%>

<%

    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0
    response.setDateHeader("Expires", 0); // Proxies

%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Portal del Paciente</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="icon" type="image/png" href="./assets/img/favicon.png">
</head>
<style>
    body {
        background-image: url("./assets/img/50406.jpg");
        text-align: justify;
        margin: 0; padding: 0;
    }

    table {
            background-color: rgba(255, 255, 255, 0.85); 
            box-shadow: 0px 0px 30px rgba(0, 0, 0, 0.85);
            border-color: #28a745;
        }

    .card {
            background-color: #1f6357; 
            box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.85);
            border-color: #1f6357;
            color:#ffffff;
        }

</style>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    User user = (User)session.getAttribute("user");
    ArrayList<Paciente> pacientes = null;
    if(user == null) {
        response.sendRedirect("login.jsp");
        return; // Detener la ejecución del resto del código
    } else {
        //Usuario de la base de datos
        String dbuser = "root";
        //Contraseña de la base de datos
        String dbpassword = "";
        //Pool de conexiones a la base de datos
        ConnectionPool pool = new ConnectionPool("jdbc:mysql://localhost:3306/portal_clinica", dbuser, dbpassword);
        PacienteService pacienteSv = new PacienteService(pool.getConnection());
        pacientes = pacienteSv.requestAll("apellido");
    }
    if (pacientes == null) {
        response.sendRedirect("index.jsp");
        return; // Detener la ejecución del resto del código
    }
    homeView view = new homeView(user, pacientes);
    out.print(view.toString());
%>

    <script>
        window.addEventListener("pageshow", function (event) {
            if (event.persisted) {
                window.location.reload();
            }
        });
    </script>
</body>
</html>
