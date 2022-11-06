import java.util.ArrayList;

public class Controlador {
    ArrayList<Usuario> usuariosRegistrados;
    InfoPrimerosAuxilios[] infoPrimerosAuxilios;
    ServicioEmergencia[] serviciosEmergencia;
    int passwordLenght = 6;

    public Controlador() {
        this.usuariosRegistrados = new ArrayList<>();
        this.infoPrimerosAuxilios = new InfoPrimerosAuxilios[5];
        this.serviciosEmergencia = new ServicioEmergencia[5];
    }
    
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

    public boolean agregarUsuario(String name, String password) {
        return this.usuariosRegistrados.add(new Usuario(name, password));
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

    public InfoPrimerosAuxilios[] getInfoPrimerosAuxilios() {
        return infoPrimerosAuxilios;
    }

    public ServicioEmergencia[] getServiciosEmergencia() {
        return serviciosEmergencia;
    }

    public int getPasswordLenght() {
        return passwordLenght;
    }
}
