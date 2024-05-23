package users;

public class User {
    private long id;
    private String nombre;
    private String apellido;
    private String username;
    private String correo;
    
    public User(long id, String nombre, String apellido, String correo, String username){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.username = username;
    }

    public long getId() {
        return id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%s %s)",getNombre(), getApellido(), getCorreo(), getUsername());
    }
    
}
