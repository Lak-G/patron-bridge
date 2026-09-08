import canal.Canal;
import canal.CanalConsola;
import canal.CanalCorreo;
import java.util.Scanner;
import notificador.Notificador;
import notificador.NotificadorUrgente;

public class Main {

    static Canal pedirCanal(Scanner lector) {
        System.out.println("+--------+------------------------+");
        System.out.println("| Opcion | Canal                  |");
        System.out.println("+--------+------------------------+");
        System.out.println("| 1.     | Consola                |");
        System.out.println("| 2.     | Correo                 |");
        System.out.println("+--------+------------------------+");
        System.out.print("Elige un canal: ");
        String opcion = lector.nextLine();
        switch (opcion) {
            case "1" -> {
                return new CanalConsola();
            }
            case "2" -> {
                return new CanalCorreo();
            }
            default -> {
                System.out.println("Opción no válida, usando Consola por defecto.");
                return new CanalConsola();
            }
        }
    }

    static String pedirTarea(Scanner lector) {
        System.out.print("Escribe la tarea: ");
        return lector.nextLine();
    }

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        //menu inicial
        while (true) {
            System.out.println("\n+---------------------------------+");
            System.out.println("| Opcion | Tipo de Notificaciones |");
            System.out.println("+--------+------------------------+");
            System.out.println("| 1.     | Aviso                  |");
            System.out.println("| 2.     | Notificacion urgente   |");
            System.out.println("| 3.     | Salir                  |");
            System.out.println("+--------+------------------------+");
            System.out.print("Opción: ");
            String opcion = lector.nextLine();

            
            switch (opcion) {
                case "1" ->  {
                    Canal canal = pedirCanal(lector);
                    String tarea = pedirTarea(lector);
                    Notificador normal = new Notificador(canal);
                    normal.avisar(tarea);
                }
                case "2" ->  {
                    Canal canal = pedirCanal(lector);
                    String tarea = pedirTarea(lector);
                    NotificadorUrgente urgente = new NotificadorUrgente(canal);
                    urgente.avisar(tarea);
                }
                case "3" -> {
                    System.out.println("Adiós.");
                    System.exit(0);
                }
                default -> System.out.println("Esta opción no está disponible");
            }
        }
    }
}
