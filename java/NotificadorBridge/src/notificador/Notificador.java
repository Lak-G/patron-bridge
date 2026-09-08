package notificador;

import canal.Canal;

public class Notificador {
    protected Canal canal; // el puente

    public Notificador(Canal canal) {
        this.canal = canal;
    }

    public void avisar(String tarea) {
        canal.enviar("Tienes pendiente: " + tarea);
    }
}
