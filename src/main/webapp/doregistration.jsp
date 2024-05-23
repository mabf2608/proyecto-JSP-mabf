<%-- index.jsp (proyecto Incrementa5) --%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@page import="connectionpool.ConnectionPool"%>
<%@page import="users.AuthService"%>
<%@page import="users.User"%>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String nombre = request.getParameter("nombre");
    String apellido = request.getParameter("apellido");
    String correo = request.getParameter("correo");
    //Usuario de la base de datos
    String dbuser = "root";
    //Contraseña de la base de datos
    String dbpassword = "";
    //Pool de conexiones a la base de datos
    ConnectionPool pool = new ConnectionPool("jdbc:mysql://localhost:3306/portal_clinica", dbuser, dbpassword);
    AuthService auth = new AuthService(pool.getConnection());
    User user = auth.register(nombre, apellido, correo, password, username);
    response.sendRedirect("login.jsp");
%>