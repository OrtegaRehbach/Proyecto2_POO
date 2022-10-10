import java.util.Scanner;

public class Main {
    private static String DIVIDER = "----------------------------------------------------";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean exit = false;
        
        while (!exit) {
            System.out.println(DIVIDER);
            System.out.print("Ingrese una opcion: ");
            String input = sc.next();
            switch (input) {
                case "1":
                    System.out.println("Se ingreso la opcion " + input);
                    break;
                case "2":
                    System.out.println("Se ingreso la opcion " + input);
                    break;
                case "3":
                    System.out.println("Se ingreso la opcion " + input);
                    break;
                case "4":
                    System.out.println("Se ingreso la opcion " + input);
                    break;
                case "5":
                    System.out.println("Se ingreso la opcion " + input);
                    break;
                case "6":
                    System.out.println("Se ingreso la opcion " + input);
                    break;
                case "Salir":
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