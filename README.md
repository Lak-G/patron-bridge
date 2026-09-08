# Patrón Bridge — demo en Go y Java

Repo para una presentación de clase sobre el patrón de diseño Bridge. Son dos
implementaciones del mismo ejemplo (un sistema simple de notificaciones), una
en Java y otra en Go, para mostrar que el patrón no depende de que el
lenguaje tenga herencia clásica.

## El ejemplo

La idea es separar **qué se avisa** de **cómo se envía**:

- `Notificador` / `NotificadorUrgente` deciden el tipo de mensaje.
- `CanalConsola` / `CanalCorreo` deciden por dónde se envía.

Ninguna de las dos partes conoce a la otra directamente — `Notificador` solo
sabe que existe algo llamado `Canal` con un método `enviar()`. Esa conexión
es el "puente" del patrón.

## Carpetas

```
java/   - versión en Java, con interfaces y herencia explícita
go/     - la misma lógica en Go, usando interfaces implícitas y structs
```

## Cómo correrlas

**Java**

```
cd java
javac *.java
java Main
```

**Go**

```
cd go
go run main.go
```

Ambas muestran un menú: primero eliges si el aviso es normal o urgente, luego
por qué canal se manda. La combinación se arma en tiempo de ejecución sin que
las clases de un lado sepan nada de las del otro.

## Por qué dos lenguajes

Java tiene interfaces y herencia explícitas (`implements`, `extends`), que es
como se enseña el patrón normalmente. Go no tiene clases ni herencia, así que
la versión en Go usa composición de structs e interfaces que se cumplen
implícitamente — mismo patrón, sintaxis distinta. Está aquí para mostrar que
Bridge es una idea de diseño, no algo atado a la programación orientada a
objetos.
