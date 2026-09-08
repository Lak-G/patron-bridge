package main

import (
	"bufio"
	"fmt"
	"os"
)

// ===== IMPLEMENTADOR — el "cómo" se envía =====
type Canal interface {
	Enviar(mensaje string)
}

type CanalConsola struct{}

func (c CanalConsola) Enviar(mensaje string) {
	fmt.Println("[Consola]", mensaje)
}

type CanalCorreo struct{}

func (c CanalCorreo) Enviar(mensaje string) {
	fmt.Println("[Correo enviado] Asunto: Aviso de tarea | Cuerpo:", mensaje)
}

// ===== ABSTRACCIÓN — el "qué" se avisa =====
type Notificador struct {
	canal Canal // el puente
}

func (n Notificador) Avisar(tarea string) {
	n.canal.Enviar("Tienes pendiente: " + tarea)
}

// ===== ABSTRACCIÓN REFINADA =====
type NotificadorUrgente struct {
	Notificador
}

func (n NotificadorUrgente) Avisar(tarea string) {
	n.canal.Enviar("¡URGENTE! Vence hoy: " + tarea)
}

// pedirCanal muestra el submenú de canales y regresa el Canal elegido
func pedirCanal(lector *bufio.Scanner) Canal {
	fmt.Println("+--------+------------------------+")
	fmt.Println("| Opcion | Canal                  |")
	fmt.Println("+--------+------------------------+")
	fmt.Println("| 1.     | Consola                |")
	fmt.Println("| 2.     | Correo                 |")
	fmt.Println("+--------+------------------------+")
	fmt.Print("Elige un canal: ")

	lector.Scan()
	opcion := lector.Text()

	switch opcion {
	case "1":
		return CanalConsola{}
	case "2":
		return CanalCorreo{}
	default:
		fmt.Println("Opción no válida, usando Consola por defecto.")
		return CanalConsola{}
	}
}

func pedirTarea(lector *bufio.Scanner) string {
	fmt.Print("Escribe la tarea: ")
	lector.Scan()
	return lector.Text()
}

func main() {
	lector := bufio.NewScanner(os.Stdin)

	for {
		fmt.Println("\n+---------------------------------+")
		fmt.Println("| Opcion | Tipo de Notificaciones |")
		fmt.Println("+--------+------------------------+")
		fmt.Println("| 1.     | Aviso                  |")
		fmt.Println("| 2.     | Notificacion urgente   |")
		fmt.Println("| 3.     | Salir                  |")
		fmt.Println("+--------+------------------------+")
		fmt.Print("Opción: ")

		lector.Scan()
		opcion := lector.Text()

		switch opcion {
		case "1":
			canal := pedirCanal(lector)
			tarea := pedirTarea(lector)
			normal := Notificador{canal: canal}
			normal.Avisar(tarea)

		case "2":
			canal := pedirCanal(lector)
			tarea := pedirTarea(lector)
			urgente := NotificadorUrgente{Notificador{canal: canal}}
			urgente.Avisar(tarea)

		case "3":
			fmt.Println("Adiós.")
			os.Exit(0)

		default:
			fmt.Println("Esta opción no está disponible")
		}
	}
}
