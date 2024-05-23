package views;

public class registerView {
    public registerView(){}

    @Override
    public String toString() {
        return 
        "<div class=\"container\">" +
        "    <div class=\"row justify-content-center align-items-center vh-100\">" +
        "        <div class=\"col-6\">" +
        "            <div class=\"card\">" +
        "                <div class=\"card-header text-center\" style=\"background-color: #28a745; color: #ffffff;\">" +
        "                    <h2>Registro</h2>" +
        "                </div>" +
        "                <div class=\"card-body\">" +
        "                    <form action=\"doregistration.jsp\" method=\"post\">" +
        "                        <div class=\"form-group\">" +
        "                            <label for=\"username\">Usuario</label>" +
        "                            <input type=\"text\" class=\"form-control\" id=\"username\" name=\"username\" required>" +
        "                        </div>" +
        "                        <div class=\"form-group\">" +
        "                            <label for=\"password\">Contraseña</label>" +
        "                            <input type=\"password\" class=\"form-control\" id=\"password\" name=\"password\" required>" +
        "                        </div>" +
        "                        <div class=\"form-group\">" +
        "                            <label for=\"correo\">Correo</label>" +
        "                            <input type=\"email\" class=\"form-control\" id=\"correo\" name=\"correo\" required>" +
        "                        </div>" +
        "                        <div class=\"form-group\">" +
        "                            <label for=\"nombre\">Nombre</label>" +
        "                            <input type=\"text\" class=\"form-control\" id=\"nombre\" name=\"nombre\" required>" +
        "                        </div>" +
        "                        <div class=\"form-group\">" +
        "                            <label for=\"apellido\">Apellido</label>" +
        "                            <input type=\"text\" class=\"form-control\" id=\"apellido\" name=\"apellido\" required>" +
        "                        </div>" +
        "                        <button type=\"submit\" class=\"btn btn-primary btn-block\" style=\"background-color: #28a745; border-color: #28a745;\">Registrar</button>" +
        "                    </form>" +
        "                </div>" +
        "                <div class=\"card-footer text-center\" style=\"background-color: rgba(255, 255, 255, 0.8);\">" +
        "                    <a href=\"index.jsp\" style=\"color: #28a745;\">¿Ya tienes una cuenta? Inicia sesión aquí</a>" +
        "                </div>" +
        "            </div>" +
        "        </div>" +
        "    </div>" +
        "</div>" +
        "<script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>" +
        "<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js\"></script>" +
        "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>" +
        
                "<script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>" +
                "<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js\"></script>" +
                "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>";
    }
}
