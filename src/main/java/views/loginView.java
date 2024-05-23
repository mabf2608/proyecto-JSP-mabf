package views;

public class loginView {
    public loginView(){}

    @Override
    public String toString() {
            return 
            "<div class=\"container\">" +
            "   <div  class=\"row justify-content-center align-items-center vh-100\">" +
            "       <div class=\"col-4\">" +
            "       <div id=\"divid\" class=\"card card-transparent\">" +
            "       <div class=\"card-header text-center\" style=\"background-color: #28a745; color: #ffffff;\">" +
            "           <h2>Portal Clínica</h2>" +
            "   </div>" +
            "   <div class=\"card-body\">" +
            "       <form action=\"login.jsp\" method=\"post\">" +
            "           <div class=\"form-group\">" +
            "               <label for=\"username\">Usuario</label>" +
            "               <input type=\"text\" class=\"form-control\" id=\"username\" name=\"username\" required>" +
            "           </div>" +
            "           <div class=\"form-group\">" +
            "               <label for=\"password\">Contraseña</label>" +
            "               <input type=\"password\" class=\"form-control\" id=\"password\" name=\"password\" required>" +
            "           </div>" +
            "           <button type=\"submit\" class=\"btn btn-primary btn-block\" style=\"background-color: #28a745; border-color: #28a745;\">Iniciar Sesión</button>" +
            "       </form>" +
            "   </div>" +
            "   <div class=\"card-footer text-center card-footer-transparent\">" +
            "       <a href=\"register.jsp\" style=\"color: #28a745;\">¿No tienes una cuenta? Regístrate aquí</a>" +
            "   </div>" +
            "</div>" +
            "<script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>" +
            "<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js\"></script>" +
            "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>";
    }
}
