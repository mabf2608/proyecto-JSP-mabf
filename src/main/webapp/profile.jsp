<%-- index.jsp (proyecto Incrementa5) --%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@page import="users.User"%>
<%@page import="views.profileView"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Perfil del Usuario</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="icon" type="image/png" href="./assets/img/favicon.png">
</head>
<style>
    body {
        background-image: url("./assets/img/50406.jpg");
        text-align: justify;
        color: #000000;
    }
    .card {
            background-color: rgba(255, 255, 255, 0.8); 
            box-shadow: 0px 0px 30px rgba(0, 0, 0, 0.8);
            border-color: #1f6357;
        }
</style>

</style>
<body>
    <%
        User user = (User)session.getAttribute("user");
        if(user==null){
            response.sendRedirect("login.jsp");
        }
        else{
            out.print(new profileView(user));
        }
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
