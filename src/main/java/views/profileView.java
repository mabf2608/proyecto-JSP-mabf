package views;

import users.User;

public class profileView {
    User user = null;

    public profileView(User user){
        this.user=user;
    }

    @Override
    public String toString() {
        return new navView(user)+
        "<div class=\"container\">" +
        "   <div  class=\"row justify-content-center align-items-center vh-100\">" +
        "       <div class=\"col-6\">" +
        "       <div id=\"divid\" class=\"card card-transparent\">" +
        "       <div class=\"card-header text-center\" style=\"background-color: #1f6357; color: #ffffff;\">" +
        "           <h2>Perfil del Usuario</h2>" + 
        "   </div>" +
        "   <div class=\"card-body\">" +
        "                 <form action=\"change-profile.jsp\" method=\"POST\">" + 
        "            <div class=\"form-group\">" + 
        "                <label for=\"nombre\">Nombre</label>" + 
        "                <input type=\"text\" class=\"form-control\" id=\"nombre\" name=\"nombre\" placeholder=\"Ingresa tu nombre\" value=\""+user.getNombre()+"\">" + 
        "            </div>" + 
        "            <div class=\"form-group\">" + 
        "                <label for=\"apellido\">Apellido</label>" + 
        "                <input type=\"text\" class=\"form-control\" id=\"apellido\" name=\"apellido\" placeholder=\"Ingresa tu apellido\" value=\""+user.getApellido()+"\">" + 
        "            </div>" + 
        "            <div class=\"form-group\">" + 
        "                <label for=\"correo\">Correo Electrónico</label>" + 
        "                <input type=\"correo\" class=\"form-control\" id=\"correo\" name=\"correo\" placeholder=\"Ingresa tu correo electrónico\" value=\""+user.getCorreo()+"\">" + 
        "            </div>" + 
        "            <div class=\"form-group\">" + 
        "                <label for=\"username\">Nombre de Usuario</label>" + 
        "                <input type=\"text\" class=\"form-control\" id=\"username\" name=\"username\"placeholder=\"Ingresa tu nombre de usuario\" value=\""+user.getUsername()+"\">" + 
        "            </div>" +
        "            <button type=\"submit\" class=\"btn btn-primary\">Guardar Cambios</button>" + 
        "        </form>" + 
        "   </div>" +
        "</div>" +
        "    <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>" + 
        "    <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js\"></script>" + 
        "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>";
    }
}
