public class Contacto {
    private String nombre;
    private long numero;


    public Contacto(String nombre, long numero) {
        this.nombre = nombre;
        this.numero = numero;
    }


    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getNumero() {
        return this.numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }


}
