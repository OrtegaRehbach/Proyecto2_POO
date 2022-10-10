import java.util.ArrayList;
//hola
public class Usuario {
    private String name;
    private String password;
    private ArrayList<Contacto> contactosEmergencia;

    public Usuario(String name, String password) {
        this.name = name;
        this.password = password;
        this.contactosEmergencia = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }
}
