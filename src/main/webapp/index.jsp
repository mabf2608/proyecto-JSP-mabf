<%-- index.jsp (proyecto Incrementa5) --%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@page import="users.User"%>
<%@page import="views.loginView"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio de sesión</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/styles.css" rel="stylesheet">
    <link rel="icon" type="image/png" href="./assets/img/favicon.png">
</head>
<style>
    body {
        background-image: url("./assets/img/sas-empleo.jpg");
        background-repeat: no-repeat;
        background-size: cover;
        margin: 0; padding: 0;
        color: #000000;
    }
    .card-transparent {
            background-color: rgba(255, 255, 255, 0.5);
            box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.5);
            border-color: #28a745;
        }
    .card-footer-transparent {
        background-color: rgba(255, 255, 255, 0.5);
    }
</style>
<body>
    <% 
    out.print(new loginView());
    %>
</body>
</html>