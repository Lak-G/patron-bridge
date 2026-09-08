package canal;

public class CanalConsola implements Canal {
    @Override
    public void enviar(String mensaje) {
        System.out.println("[Consola] " + mensaje);
    }
}
