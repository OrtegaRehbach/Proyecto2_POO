import java.util.ArrayList;

public class Controlador {
    ArrayList<Usuario> usuariosRegistrados;
    InfoPrimerosAuxilios[] infoPrimerosAuxilios;
    ServicioEmergencia[] serviciosEmergencia;
    int passwordLenght = 6;

    public boolean validarDatosUsuario(String name, String password) {
        if (this.usuariosRegistrados.size() != 0) {
            if (validarNombreUsuario(name)) {
                agregarUsuario(name, password);
                return true;
            } else {
                return false;
            }
        }
        if (validarPasswordUsuario(password)) {
            agregarUsuario(name, password);
            return true;
        }
        return false;
    }

    public boolean validarNombreUsuario(String name) {
        for (Usuario usuario : this.usuariosRegistrados) {
            if (usuario.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    public boolean validarPasswordUsuario(String password) {
        return (password.length() >= passwordLenght) && (!password.contains(" "));
    }

    public void agregarUsuario(String name, String password) {
        this.usuariosRegistrados.add(new Usuario(name, password));
    }
}
