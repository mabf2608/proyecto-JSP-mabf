package users;

public class Paciente {
    private long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String fechaNac;
    private String nSeg;

    public Paciente(long id, String nombre, String apellido, String dni, String fechaNac, String nSeg){
        this.id=id;
        this.nombre=nombre;
        this.apellido=apellido;
        this.dni=dni;
        this.fechaNac=fechaNac;
        this.nSeg=nSeg;
    }

    public Paciente( String nombre, String apellido, String dni, String fechaNac, String nSeg){
        this.nombre=nombre;
        this.apellido=apellido;
        this.dni=dni;
        this.fechaNac=fechaNac;
        this.nSeg=nSeg;
    }

    public long getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public String getDni(){
        return dni;
    }

    public String getFechaNac(){
        return fechaNac;
    }

    public String getNSeg(){
        return nSeg;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }   
    public void setDni(String dni) {
        this.dni = dni;
    }
    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setnSeg(String nSeg) {
        this.nSeg = nSeg;
    }
    @Override
    public String toString() {
        return String.format("%s %s %s (%s %s)", getNombre(), getApellido(), getDni(), getFechaNac(), getNSeg());
    }
}
