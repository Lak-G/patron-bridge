package notificador;

import canal.Canal;

public class NotificadorUrgente extends Notificador {
    public NotificadorUrgente(Canal canal) {
        super(canal);
    }

    @Override
    public void avisar(String tarea) {
        canal.enviar("¡URGENTE! Vence hoy: " + tarea);
    }
}
