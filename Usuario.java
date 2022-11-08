import java.util.ArrayList;
public class Usuario {
    private String name;
    private String password;
    private ArrayList<Contacto> contactosEmergencia;

    public Usuario(String name, String password) {
        this.name = name;
        this.password = password;
        this.contactosEmergencia = new ArrayList<>();
    }

    public Usuario(String name, String password, Contacto... contactos) {
        this.name = name;
        this.password = password;
        this.contactosEmergencia = new ArrayList<Contacto>();
        for (Contacto contacto : contactos) {
            this.contactosEmergencia.add(contacto);
        }
    }

    public Usuario() {
        this.name = "User";
        this.password = "password";
        this.contactosEmergencia = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Contacto> getContactosEmergencia() {
        return this.contactosEmergencia;
    }

    public void setContactosEmergencia(ArrayList<Contacto> contactosEmergencia) {
        this.contactosEmergencia = contactosEmergencia;
    }

    public boolean agregarContactoEmergencia(Contacto contacto) {
        return this.contactosEmergencia.add(contacto);
    }

    public boolean agregarContactoEmergencia(String nombre, long numero) {
        return this.agregarContactoEmergencia(new Contacto(nombre, numero));
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", password='" + getPassword() + "'" +
            ", contactosEmergencia='" + getContactosEmergencia() + "'" +
            "}";
    }

}
