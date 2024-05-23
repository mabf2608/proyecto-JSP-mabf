package views;

import users.User;

public class navView {
    User user=null;

    public navView(User user){
        this.user=user;
    }

    @Override
    public String toString() {
        return
        "    <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">"+ 
        "        <a class=\"navbar-brand\" href=\"#\">Portal de la Clínica - MABF</a>"+ 
        "        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNav\" aria-controls=\"#navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">"+ 
        "            <span class=\"navbar-toggler-icon\"></span>"+ 
        "        </button>"+ 
        "        <div class=\"collapse navbar-collapse\" id=\"navbarNav\">"+ 
        "            <ul class=\"navbar-nav\">"+ 
        "                <li class=\"nav-item\">"+ 
        "                    <a class=\"nav-link\" href=\"home.jsp\">Inicio <span class=\"sr-only\">(current)</span></a>"+ 
        "                </li>"+ 
        "                <li class=\"nav-item\">"+ 
        "                    <a class=\"nav-link\" href=\"profile.jsp\">Perfil</a>"+ 
        "                </li>"+ 
        "                <li class=\"nav-item\">"+ 
        "                    <a class=\"nav-link\" href=\"logout.jsp\">Cerrar Sesión</a>"+ 
        "                </li>"+ 
        "            </ul>"+ 
        "        </div>"+ 
        "    </nav>";
    }
}
