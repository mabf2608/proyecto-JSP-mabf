package views;

import users.User;
import java.util.List;
import users.Paciente;

public class homeView {
    User user = null;
    List<Paciente> pacientes;

    public homeView(User user, List<Paciente> pacientes) {
        this.user = user;
        this.pacientes = pacientes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(new navView(user));
        sb.append("<div class=\"container mt-4\">");
        sb.append("   <div class=\"card\">");
        sb.append("      <h2 style=\"text-align: center;\">Listado de Pacientes</h2>");
        sb.append("    </div><br>");
        sb.append("   <table class=\"table table-bordered\" style=\"margin:auto\">");
        sb.append("      <thead class=\"thead-light\">");
        sb.append("       <tr style=\"text-align:center\">");
        sb.append("           <th scope=\"col\">Nombre</th>");
        sb.append("           <th scope=\"col\">Apellido/s</th>");
        sb.append("           <th scope=\"col\">DNI</th>");
        sb.append("           <th scope=\"col\">Fecha de Nacimiento</th>");
        sb.append("           <th scope=\"col\">Número del seguro</th>");
        sb.append("           <th scope=\"col\">Acciones</th>");
        sb.append("       </tr>");
        sb.append("      </thead>");
        sb.append("      <tbody style=\"text-align:center\">");

        for (Paciente paciente : pacientes) {
            sb.append("       <tr>");
            sb.append("           <td>").append(paciente.getNombre()).append("</td>");
            sb.append("           <td>").append(paciente.getApellido()).append("</td>");
            sb.append("           <td>").append(paciente.getDni()).append("</td>");
            sb.append("           <td>").append(paciente.getFechaNac()).append("</td>");
            sb.append("           <td>").append(paciente.getNSeg()).append("</td>");
            sb.append("           <td>");
            sb.append("               <button class=\"btn btn-warning\" data-toggle=\"modal\" data-target=\"#editPatientModal\" ")
              .append("                       data-id=\"").append(paciente.getId()).append("\" ")
              .append("                       data-nombre=\"").append(paciente.getNombre()).append("\" ")
              .append("                       data-apellido=\"").append(paciente.getApellido()).append("\" ")
              .append("                       data-dni=\"").append(paciente.getDni()).append("\" ")
              .append("                       data-fecha-nac=\"").append(paciente.getFechaNac()).append("\" ")
              .append("                       data-nseg=\"").append(paciente.getNSeg()).append("\">Modificar</button>");
            sb.append("               <a href=\"remove-patients.jsp?id=").append(paciente.getId()).append("\" class=\"btn btn-danger\" onclick=\"return confirmarEliminacion();\">Eliminar</a>");
            sb.append("           </td>");
            sb.append("       </tr>");
        }

        sb.append("      </tbody>");
        sb.append("   </table><br>");
        sb.append("   <button class=\"btn btn-primary mb-3\" data-toggle=\"modal\" data-target=\"#addPatientModal\">Añadir Paciente</button>");
        sb.append("</div>");
        
        sb.append("<div class=\"modal fade\" id=\"addPatientModal\" tabindex=\"-1\" aria-labelledby=\"addPatientModalLabel\" aria-hidden=\"true\">");
        sb.append("   <div class=\"modal-dialog\">");
        sb.append("       <div class=\"modal-content\">");
        sb.append("           <div class=\"modal-header\">");
        sb.append("               <h5 class=\"modal-title\" id=\"addPatientModalLabel\">Añadir Paciente</h5>");
        sb.append("               <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">");
        sb.append("                   <span aria-hidden=\"true\">&times;</span>");
        sb.append("               </button>");
        sb.append("           </div>");
        sb.append("           <div class=\"modal-body\">");
        sb.append("               <form method=\"POST\" action=\"add-patients.jsp\">");
        sb.append("                   <div class=\"form-group\">");
        sb.append("                       <label for=\"nombre\">Nombre</label>");
        sb.append("                       <input type=\"text\" class=\"form-control\" id=\"nombre\" name=\"nombre\">");
        sb.append("                   </div>");
        sb.append("                   <div class=\"form-group\">");
        sb.append("                       <label for=\"apellido\">Apellido</label>");
        sb.append("                       <input type=\"text\" class=\"form-control\" id=\"apellido\" name=\"apellido\">");
        sb.append("                   </div>");
        sb.append("                   <div class=\"form-group\">");
        sb.append("                       <label for=\"dni\">DNI</label>");
        sb.append("                       <input type=\"text\" class=\"form-control\" id=\"dni\" name=\"dni\">");
        sb.append("                   </div>");
        sb.append("                   <div class=\"form-group\">");
        sb.append("                       <label for=\"fecha_nac\">Fecha de Nacimiento</label>");
        sb.append("                       <input type=\"date\" class=\"form-control\" id=\"fecha_nac\" name=\"fechaNac\">");
        sb.append("                   </div>");
        sb.append("                   <div class=\"form-group\">");
        sb.append("                       <label for=\"ns\">Número del Seguro</label>");
        sb.append("                       <input type=\"text\" class=\"form-control\" id=\"ns\" name=\"nSeg\">");
        sb.append("                   </div>");
        sb.append("                   <button type=\"submit\" class=\"btn btn-primary\">Guardar</button>");
        sb.append("               </form>");
        sb.append("           </div>");
        sb.append("       </div>");
        sb.append("   </div>");
        sb.append("</div>");
        
        sb.append("<div class=\"modal fade\" id=\"editPatientModal\" tabindex=\"-1\" aria-labelledby=\"editPatientModalLabel\" aria-hidden=\"true\">");
        sb.append("   <div class=\"modal-dialog\">");
        sb.append("       <div class=\"modal-content\">");
        sb.append("           <div class=\"modal-header\">");
        sb.append("               <h5 class=\"modal-title\" id=\"editPatientModalLabel\">Modificar Paciente</h5>");
        sb.append("               <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">");
        sb.append("                   <span aria-hidden=\"true\">&times;</span>");
        sb.append("               </button>");
        sb.append("           </div>");
        sb.append("           <div class=\"modal-body\">");
        sb.append("               <form method=\"POST\" action=\"update-patients.jsp\">");
        sb.append("                   <input type=\"hidden\" id=\"edit_id\" name=\"id\">");
        sb.append("                   <div class=\"form-group\">");
        sb.append("                       <label for=\"edit_nombre\">Nombre</label>");
        sb.append("                       <input type=\"text\" class=\"form-control\" id=\"edit_nombre\" name=\"nombre\">");
        sb.append("                   </div>");
        sb.append("                   <div class=\"form-group\">");
        sb.append("                       <label for=\"edit_apellido\">Apellido</label>");
        sb.append("                       <input type=\"text\" class=\"form-control\" id=\"edit_apellido\" name=\"apellido\">");
        sb.append("                   </div>");
        sb.append("                   <div class=\"form-group\">");
        sb.append("                       <label for=\"edit_dni\">DNI</label>");
        sb.append("                       <input type=\"text\" class=\"form-control\" id=\"edit_dni\" name=\"dni\">");
        sb.append("                   </div>");
        sb.append("                   <div class=\"form-group\">");
        sb.append("                       <label for=\"edit_fecha_nac\">Fecha de Nacimiento</label>");
        sb.append("                       <input type=\"date\" class=\"form-control\" id=\"edit_fecha_nac\" name=\"fechaNac\">");
        sb.append("                   </div>");
        sb.append("                   <div class=\"form-group\">");
        sb.append("                       <label for=\"edit_nss\">Número de Seguridad Social</label>");
        sb.append("                       <input type=\"text\" class=\"form-control\" id=\"edit_nss\" name=\"nSeg\">");
        sb.append("                   </div>");
        sb.append("                   <button type=\"submit\" class=\"btn btn-primary\">Guardar Cambios</button>");
        sb.append("               </form>");
        sb.append("           </div>");
        sb.append("       </div>");
        sb.append("   </div>");
        sb.append("</div>");
        
        sb.append("<script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>");
        sb.append("<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js\"></script>");
        sb.append("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>");
        sb.append("<script>");
        sb.append("    $('#editPatientModal').on('show.bs.modal', function (event) {");
        sb.append("        var button = $(event.relatedTarget);");
        sb.append("        var id = button.data('id');");
        sb.append("        var nombre = button.data('nombre');");
        sb.append("        var apellido = button.data('apellido');");
        sb.append("        var dni = button.data('dni');");
        sb.append("        var fechaNac = button.data('fecha-nac');");
        sb.append("        var nSeg = button.data('nseg');");
        sb.append("        var modal = $(this);");
        sb.append("        modal.find('#edit_id').val(id);");
        sb.append("        modal.find('#edit_nombre').val(nombre);");
        sb.append("        modal.find('#edit_apellido').val(apellido);");
        sb.append("        modal.find('#edit_dni').val(dni);");
        sb.append("        modal.find('#edit_fecha_nac').val(fechaNac);");
        sb.append("        modal.find('#edit_nss').val(nSeg);");
        sb.append("    });");
        sb.append("</script>");
        sb.append("<script>");
        sb.append("    function confirmarEliminacion() {");
        sb.append("    return confirm('¿Estás seguro de que deseas eliminar este paciente?');");
        sb.append("     }");
        sb.append("</script>");

        return sb.toString();
    }
}
