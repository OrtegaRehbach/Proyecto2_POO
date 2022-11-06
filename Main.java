import java.util.Scanner;

public class Main {
    private static String DIVIDER = "----------------------------------------------------";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Controlador controlador = new Controlador();

        boolean exit = false;
        
        while (!exit) {
            System.out.println(DIVIDER);
            System.out.println("Ingrese una opcion: ");
            System.out.println("1. Crear de Perfil");
            System.out.println("2. **SOS**"); //para el mensaje de texto de auxilio con ubicación
            System.out.println("3. Actualizar datos de contacto de Emergencia para SOS");
            System.out.println("4. Mostrar servicios de emergencia");
            System.out.println("5. Información Primeros Auxilios");

            System.out.println("7. Salir del Programa");


            String input = sc.next();
            switch (input) {
                case "1":
                    System.out.println("Se ingreso la opcion " + input);
                    System.out.print("Ingrese nombre de usuario: ");
                    String nombre = sc.next();
                    System.out.print("Ingrese contrasena: ");
                    String password = sc.next();
                    System.out.println(controlador.agregarUsuario(nombre, password));
                    for (Usuario usuario : controlador.getUsuariosRegistrados()) {
                        System.out.println(usuario.toString());
                    }
                    break;
                case "2":
                    System.out.println("Se ingreso la opcion " + input);
                    break;
                case "3":
                    System.out.println("Se ingreso la opcion " + input);
                    
                    System.out.print("Ingresar nombre de contacto: ");
                    nombre = sc.next();
                     System.out.print("Ingrese numero de contacto: ");
                    long numero = sc.nextLong();
                    controlador.IngresarContactoEmergencia(nombre, numero, controlador.getUsuariosRegistrados().get(0));
                    for (Contacto contacto : controlador.getUsuariosRegistrados().get(0).getContactosEmergencia()) {
                        System.out.println(contacto.toString());
                    }
                    break;
                case "4":
                    System.out.println("Se ingreso la opcion " + input);
                    System.out.println("Llamar a la Policia Nacional Civil (1): ");
                    System.out.println("Llamar a Bomberos Municipales (2)");
                    System.out.println("Llamae Bomberos Voluntarios (3)");
                    System.out.println("Llamar a Ambulancia de IGSS (4)");
                    System.out.println("Llamar a atencion de violencia domestica (5)");
                    int opcion= sc.nextInt();
                    switch(opcion){
                        case 1:
                        System.out.println("Llamando a PNC...");
                        break;

                        case 2:
                        System.out.println("Llamando a Bomberos Municipales...");
                        break;

                        case 3:
                        System.out.println("Llamando a Bomberos Voluntarios....");
                        break;

                        case 4:
                        System.out.println("Llamando a Ambulancia de IGSS...");
                        break;

                        case 5:
                        System.out.println("Llamar a atencion de violencia domestica...");
            
                    }
                    


                    break;
                case "5":
                    System.out.println("Se ingreso la opcion " + input);
                    System.out.println("1) Asfixia \n2)Desmayo \n3)Fracturas\n 4)Quemadura");
                    opcion=sc.nextInt();
                    switch(opcion){
                        case 1:
                        InfoPrimerosAuxilios ObjetoInfo =controlador.CrearInfoPrimerosAuxilios("Asfixia");
                        ObjetoInfo.ReturnInfo("Asfixia", ObjetoInfo);
                        System.out.println(ObjetoInfo.getInfo());
                        break;

                        case 2:
                        InfoPrimerosAuxilios ObjetoInfo1 =controlador.CrearInfoPrimerosAuxilios("Desmayo");
                        ObjetoInfo1.ReturnInfo("Desmayo", ObjetoInfo1);
                        System.out.println(ObjetoInfo1.getInfo());
                        break;

                        case 3:
                        InfoPrimerosAuxilios ObjetoInfo2= controlador.CrearInfoPrimerosAuxilios("Fracturas");
                        ObjetoInfo2.ReturnInfo("Fracturas", ObjetoInfo2);
                        System.out.println(ObjetoInfo2.getInfo());
                        break;
    
                        case 4:
                        InfoPrimerosAuxilios ObjetoInfo3= controlador.CrearInfoPrimerosAuxilios("Quemadura");
                        ObjetoInfo3.ReturnInfo("Quemadura", ObjetoInfo3);
                        System.out.println(ObjetoInfo3.getInfo());
                        break;

                        default:
                        System.out.println("Ingrese una opción valida");
                    }

                    break;
                case "6":
                    System.out.println("Se ingreso la opcion " + input);
                    break;
                case "7":
                    System.out.println("Se ingreso la opcion " + input);
                    exit = true;
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

}