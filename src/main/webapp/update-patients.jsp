<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@page import="connectionpool.ConnectionPool"%>
<%@page import="users.PacienteService"%>
<%@page import="users.Paciente"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Actualizar Paciente</title>
    <link rel="stylesheet" href="assets/css/style.css">
    <!-- Enlace a Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="icon" type="image/png" href="./assets/img/favicon.png">
</head>
<body>
 <%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    // Usuario de la base de datos
    String dbuser = "root";
    // Contraseña de la base de datos
    String dbpassword = "";
    // Pool de conexiones a la base de datos
    ConnectionPool pool = new ConnectionPool("jdbc:mysql://localhost:3306/portal_clinica", dbuser, dbpassword);
    PacienteService pacientes = new PacienteService(pool.getConnection());

    try {
        long id = Long.parseLong(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("dni");
        String fechaNac = request.getParameter("fechaNac");
        String nSeg = request.getParameter("nSeg");
        
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }

        Paciente p = pacientes.requestById(id);
        p.setNombre(nombre);
        p.setApellido(apellido);
        p.setDni(dni);
        p.setFechaNac(fechaNac);
        p.setnSeg(nSeg);

        int rowsAffected = pacientes.update(p);
        if (rowsAffected == 1) {
            response.sendRedirect("home.jsp");
        } else {
            response.sendRedirect("home.jsp?error=No se ha podido actualizar la información del paciente");
        }
    } catch (Exception e) {
        e.printStackTrace();
        response.sendRedirect("home.jsp?error=" + e.getMessage());
    }
%>


    <!-- Bootstrap JavaScript y dependencias -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
