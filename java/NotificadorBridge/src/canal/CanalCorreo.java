package canal;

public class CanalCorreo implements Canal {
    @Override
    public void enviar(String mensaje) {
        System.out.println("[Correo enviado] Asunto: Aviso de tarea | Cuerpo: " + mensaje);
    }
}
