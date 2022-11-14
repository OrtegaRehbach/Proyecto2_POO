import java.io.File;
import java.util.Scanner;

public class Main {
    private static String DIVIDER = "----------------------------------------------------";
    private static char NL = '\n';
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Controlador controlador = new Controlador();

        boolean exit = false;

        FileHandler fh = new FileHandler();
        File userDataFile = fh.createCSVFile("data/user_data.csv");
        
        // Cargar datos del archivo user_data.csv
        controlador.agregarUsuario(fh.getUserListFromCSVFile(userDataFile));

        // Se pide inicio de sesion o creacion de usuario
        autenticarUsuario(sc, controlador, userDataFile, fh);
        exit = !controlador.haySesionIniciada();
        while (!exit) {
            System.out.println(DIVIDER);
            System.out.println("Aplicacion servicios de emergencia");
            System.out.println("Conectado como: \"" + controlador.getNameUsuarioActual() + "\"");
            System.out.println(DIVIDER);
            System.out.println("1. [DEBUG] Ver contactos");
            System.out.println("2. **SOS**"); //para el mensaje de texto de auxilio con ubicación
            System.out.println("3. Actualizar datos de contacto de Emergencia para SOS");
            System.out.println("4. Mostrar servicios de emergencia");
            System.out.println("5. Informacion Primeros Auxilios");
            System.out.println("6. [DEBUG] Ver todos los usuarios registrados");
            System.out.println("7. Salir del Programa");
            System.out.println(DIVIDER);
            System.out.print("Ingrese una opcion: ");
            String input = sc.next();
            System.out.println(DIVIDER);
            switch (input) {
                case "1":
                    System.out.println("CONTACTOS:");
                    for (Contacto contacto : controlador.getUsuarioActual().getContactosEmergencia()) {
                        System.out.println(contacto.toString());
                    }
                    break;

                case "2":
                    System.out.println("¡SOS necesito ayuda lo mas pronto posible!");
                    System.out.println("Se ha enviado un mensaje de auxilio y su ubicacion a su lista de contactos de emergencia.");
                    break;

                case "3":
                    System.out.print("Ingresar nombre de contacto: ");
                    String nombre = sc.next();
                    System.out.print("Ingrese numero de contacto: ");
                    long numero = sc.nextLong();
                    controlador.IngresarContactoEmergencia(nombre, numero, controlador.getUsuarioActual());
                    controlador.updateUserDataFile(userDataFile, fh);
                    break;

                case "4":
                    System.out.println("1. Llamar a la Policia Nacional Civil");
                    System.out.println("2. Llamar a Bomberos Municipales");
                    System.out.println("3. Llamar Bomberos Voluntarios");
                    System.out.println("4. Llamar a Ambulancia de IGSS");
                    System.out.println("5. Llamar a atencion de violencia domestica");
                    System.out.println(DIVIDER);
                    System.out.print("Ingrese una opcion: ");
                    String opcion = sc.next();
                    System.out.println(DIVIDER);
                    switch(opcion){
                        case "1":
                            System.out.println("Llamando a PNC...");
                            break;

                        case "2":
                            System.out.println("Llamando a Bomberos Municipales...");
                            break;

                        case "3":
                            System.out.println("Llamando a Bomberos Voluntarios....");
                            break;

                        case "4":
                            System.out.println("Llamando a Ambulancia de IGSS...");
                            break;

                        case "5":
                            System.out.println("Llamando a atencion de violencia domestica...");
                            break;

                        default:
                            System.out.println("Ingrese una opcion valida.");
                    }
                    break;

                case "5":
                    System.out.println(
                        "1. Asfixia\n" + 
                        "2. Desmayo\n" + 
                        "3. Fracturas\n" + 
                        "4. Quemadura"
                    );
                    System.out.println(DIVIDER);
                    System.out.print("Ingrese una opcion: ");
                    opcion = sc.next();
                    System.out.println(DIVIDER);
                    switch(opcion){
                        case "1":
                        InfoPrimerosAuxilios ObjetoInfo =controlador.CrearInfoPrimerosAuxilios("Asfixia");
                        ObjetoInfo.ReturnInfo("Asfixia", ObjetoInfo);
                        System.out.println(ObjetoInfo.getInfo());
                        break;

                        case "2":
                        InfoPrimerosAuxilios ObjetoInfo1 =controlador.CrearInfoPrimerosAuxilios("Desmayo");
                        ObjetoInfo1.ReturnInfo("Desmayo", ObjetoInfo1);
                        System.out.println(ObjetoInfo1.getInfo());
                        break;

                        case "3":
                        InfoPrimerosAuxilios ObjetoInfo2= controlador.CrearInfoPrimerosAuxilios("Fracturas");
                        ObjetoInfo2.ReturnInfo("Fracturas", ObjetoInfo2);
                        System.out.println(ObjetoInfo2.getInfo());
                        break;
    
                        case "4":
                        InfoPrimerosAuxilios ObjetoInfo3= controlador.CrearInfoPrimerosAuxilios("Quemadura");
                        ObjetoInfo3.ReturnInfo("Quemadura", ObjetoInfo3);
                        System.out.println(ObjetoInfo3.getInfo());
                        break;

                        default:
                        System.out.println("Ingrese una opción valida");
                    }

                    break;

                case "6":
                    for (Usuario usuario : controlador.getUsuariosRegistrados()) {
                        System.out.println(usuario.toString());
                    }
                    break;

                case "7":
                    exit = true;
                    controlador.cerrarSesion();
                    controlador.updateUserDataFile(userDataFile, fh);
                    System.out.println(DIVIDER);
                    System.out.println("Gracias por usar el programa");
                    System.out.println(DIVIDER);
                    break;

                default:
                    System.out.println("Ingrese una opcion valida.");
                    break;
            }   
        }
        sc.close();
    }

    // Funcion para autenticar usuarios
    private static void autenticarUsuario(Scanner sc, Controlador controlador, File userDataFile, FileHandler fh) {
        boolean exit = false;
        while (!exit) {
            System.out.println(
                DIVIDER + NL + 
                "Login" + NL +
                DIVIDER + NL +
                "1. Iniciar sesion" + NL + 
                "2. Crear usuario" + NL + 
                "3. Salir" + NL + 
                DIVIDER
            );
            System.out.print("Ingrese una opcion: ");
            String input = sc.next();
            switch (input) {
                case "1":
                    System.out.print("Ingrese nombre de usuario: ");
                    String nombre = sc.next();
                    System.out.print("Ingrese contrasena: ");
                    String password = sc.next();
                    if (controlador.esUsuarioRegistrado(nombre, password)) {
                        controlador.iniciarSesion(nombre);
                        System.out.println("Se inicio sesion como \"" + nombre + "\"");
                        exit = true;
                    } else {
                        System.out.println("El nombre de usuario o contrasena ingresados no son validos.");
                    }
                    break;
                case "2":
                    System.out.print("Ingrese nombre de usuario: ");
                    nombre = sc.next();
                    System.out.print("Ingrese contrasena: ");
                    password = sc.next();

                    if (controlador.validarDatosUsuario(nombre, password)) {
                        controlador.agregarUsuario(nombre, password);
                        fh.appendDataToCSVFile(userDataFile, new Usuario(nombre, password));
                        controlador.iniciarSesion(nombre);
                        System.out.println("Se agrego el usuario \"" + nombre + "\" existosamente.");
                        exit = true;
                    } else {
                        System.out.println("El nombre de usuario o contrasena no son validos.");
                    }
                    break;
                case "3":
                    exit = true;
                    controlador.cerrarSesion();
                    System.out.println(DIVIDER);
                    System.out.println("Gracias por usar el programa");
                    System.out.println(DIVIDER);
                    break;
            
                default:
                    System.out.println("Ingrese una opcion valida.");
                    break;
            }
        }
        
    }

}