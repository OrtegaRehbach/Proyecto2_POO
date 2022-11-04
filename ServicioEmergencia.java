public class ServicioEmergencia {
    private String nombre;
    private Contacto contacto;
    private String descripcion;
    
    
    public ServicioEmergencia(String nombre, Contacto contacto, String descripcion) {
        this.nombre = nombre;
        this.contacto = contacto;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Contacto getContacto() {
        return contacto;
    }


    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
