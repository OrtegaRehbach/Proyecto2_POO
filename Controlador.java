import java.io.File;
import java.util.ArrayList;

public class Controlador {
    Usuario usuarioActual;
    ArrayList<Usuario> usuariosRegistrados;
    InfoPrimerosAuxilios[] infoPrimerosAuxilios;
    ServicioEmergencia[] serviciosEmergencia;
    int passwordLenght = 6;

    public Controlador() {
        this.usuarioActual = null;
        this.usuariosRegistrados = new ArrayList<>();
        this.infoPrimerosAuxilios = new InfoPrimerosAuxilios[5];
        this.serviciosEmergencia = new ServicioEmergencia[5];
        this.infoPrimerosAuxilios[0] = new InfoPrimerosAuxilios("Categoria", "Aca va la info de un servicio de primeros auxilios");
    }
    
    public boolean validarDatosUsuario(String name, String password) {
        if (this.usuariosRegistrados.size() != 0) {
            if (validarNombreUsuario(name)) {
                return true;
            } else {
                return false;
            }
        }
        if (validarPasswordUsuario(password)) {
            return true;
        }
        return false;
    }

    public boolean validarNombreUsuario(String name) {
        if (getNombresUsuarioRegistrados() != null) {
            if (getNombresUsuarioRegistrados().contains(name)) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    public boolean validarPasswordUsuario(String password) {
        return (password.length() >= passwordLenght) && (!password.contains(" "));
    }

    public boolean agregarUsuario(Usuario usuario) {
        return this.usuariosRegistrados.add(usuario);
    }
    
    public boolean agregarUsuario(String name, String password) {
        return agregarUsuario(new Usuario(name, password));
    }

    public boolean agregarUsuario(ArrayList<Usuario> usuarios) {
        return this.usuariosRegistrados.addAll(usuarios);
    }

    public void IngresarContactoEmergencia(String nombre,long numero,Usuario usuario ){
        Contacto contacto= new Contacto(nombre,numero);
        usuario.getContactosEmergencia().add(contacto);
    }

    public InfoPrimerosAuxilios CrearInfoPrimerosAuxilios(String categoria){
        InfoPrimerosAuxilios ObjetoInfo = new InfoPrimerosAuxilios();
        ObjetoInfo.Category(categoria);
        return(ObjetoInfo);
    }

    public ArrayList<Usuario> getUsuariosRegistrados() {
        return usuariosRegistrados;
    }

    public Usuario getUsuarioActual() {
        return this.usuarioActual;
    }

    public String getNameUsuarioActual() {
        return (this.usuarioActual != null) ? this.usuarioActual.getName() : null;
    }

    public InfoPrimerosAuxilios[] getInfoPrimerosAuxilios() {
        return infoPrimerosAuxilios;
    }

    public ServicioEmergencia[] getServiciosEmergencia() {
        return serviciosEmergencia;
    }

    public int getPasswordLenght() {
        return passwordLenght;
    }

    public ArrayList<String> getNombresUsuarioRegistrados() {
        if (!usuariosRegistrados.isEmpty()) {
            ArrayList<String> userNames = new ArrayList<String>();
            for (int i = 0; i < usuariosRegistrados.size(); i++) {
                userNames.add(usuariosRegistrados.get(i).getName());
            }
            return userNames;
        } else {
            return null;
        }
    }

    public boolean esUsuarioRegistrado(String nombre, String password) {
        if (!usuariosRegistrados.isEmpty()) {
            for (Usuario usuario : this.usuariosRegistrados) {
                if (usuario.getName().equals(nombre) && usuario.getPassword().equals(password)) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    public void iniciarSesion(String nombreUsuario) {
        for (int i = 0; i < getNombresUsuarioRegistrados().size(); i++) {
            if (this.usuariosRegistrados.get(i).getName().equals(nombreUsuario)) {
                this.usuarioActual = this.usuariosRegistrados.get(i);
                break;
            }
        }
    }

    public void cerrarSesion() {
        this.usuarioActual = null;
    }

    public boolean haySesionIniciada() {
        return this.usuarioActual != null;
    }

    public void updateUserDataFile(File userDataFile, FileHandler fh) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Usuario usuario : this.usuariosRegistrados) {
            stringBuilder.append(fh.userDataToCSVString(usuario));
            stringBuilder.append("\n");
        }
        fh.writeDataToCSVFile(userDataFile, stringBuilder.toString());
    }
}
