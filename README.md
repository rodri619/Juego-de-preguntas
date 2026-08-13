# 🍷 Juego de Preguntas

Juego de fiesta en consola escrito en Java, inspirado en la dinámica de "Agua de Calzón" (similar a *Verdad o Reto* / *Truth or Drink*). Un jugador le hace una pregunta a otro sobre gustos, anécdotas o datos personales, y el grupo decide si la respuesta fue correcta.

## 🕹️ Cómo se juega

1. Al iniciar, se ingresa el número de jugadores (entre 2 y 10) y sus nombres.
2. En cada ronda, el juego selecciona aleatoriamente a dos jugadores: uno pregunta y otro responde.
3. Se elige una pregunta aleatoria del banco de preguntas.
4. El resto del grupo decide si la respuesta fue correcta (`1`) o incorrecta (`2`).
5. Si es correcta, quien respondió gana un punto.
6. Se muestra la tabla de puntuaciones tras cada ronda.
7. Gana quien llegue primero a **10 puntos**.

## 🗂️ Estructura del proyecto

| Archivo | Responsabilidad |
|---|---|
| `AguaDeCalzon.java` | Clase principal: controla el flujo del juego (registro de jugadores, rondas, condición de victoria). |
| `Jugador.java` | Representa a cada jugador: nombre y puntuación. |
| `BancoDePreguntas.java` | Almacena y entrega preguntas aleatorias; permite agregar nuevas. |
| `Utilidades.java` | Funciones auxiliares: selección aleatoria de jugadores y validación de respuestas por consola. |

## ▶️ Ejecución

```bash
javac *.java
java AguaDeCalzon
```

## ✏️ Personalizar las preguntas

El banco de preguntas vive en `BancoDePreguntas.java`, dentro del método `CargaPreguntasIniciales()`. Puedes agregar tus propias preguntas así:

```java
preguntas.add("¿Cuál es mi película favorita?");
```

También existe el método `AgregarPregunta(String pregunta)` para añadir preguntas en tiempo de ejecución.

## 🚀 Posibles mejoras futuras

- Cargar las preguntas desde un archivo externo (`.txt` o `.json`) en vez de tenerlas hardcodeadas.
- Agregar categorías de preguntas seleccionables al inicio.
- Interfaz gráfica en vez de consola.
