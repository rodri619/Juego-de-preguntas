import java.util.ArrayList;
import java.util.Scanner;

public class AguaDeCalzon {
    private ArrayList<Jugador> jugadores;
    private BancoDePreguntas bancoDePreguntas;
    private Scanner scanner;

    public AguaDeCalzon() {
        this.jugadores = new ArrayList<>();
        this.bancoDePreguntas = new BancoDePreguntas();
        this.scanner = new Scanner(System.in);
    }

    public void iniciarJuego() {
        System.out.print("═════════════════════════════════════════════════════════ ");
        System.out.println("¡Bienvenidos a Agua de Calzón! 🍷🔥");
        System.out.print("═════════════════════════════════════════════════════════ ");
        System.out.print("Ingresa la cantidad de jugadores (2-10): ");
        
        int cantidadJugadores;
        while (true) {
            cantidadJugadores = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            if (cantidadJugadores >= 2 && cantidadJugadores <= 10) break;
            System.out.print("Número inválido. Ingresa un número entre 2 y 10: ");
        }

        for (int i = 1; i <= cantidadJugadores; i++) {
            System.out.print("Nombre del jugador " + i + ": ");
            String nombre = scanner.nextLine();
            jugadores.add(new Jugador(nombre));
        }

        jugarRondas();
    }

    private void jugarRondas() {
        boolean juegoActivo = true;

        while (juegoActivo) {
            System.out.println("\n--- Va de nuez ---");
            Jugador[] seleccionados = Utilidades.seleccionarJugadores(jugadores);
            Jugador quienPregunta = seleccionados[0];
            Jugador quienResponde = seleccionados[1];

            System.out.println(quienPregunta.getNombre() + " hará una pregunta a " + quienResponde.getNombre());
            String pregunta = bancoDePreguntas.obtenerPreguntaAleatoria();
            System.out.println("📢 Pregunta: " + pregunta);

            // Validar respuesta correcta o incorrecta
            boolean respuestaCorrecta = Utilidades.validarRespuesta(scanner);
            if (respuestaCorrecta) {
                quienResponde.aumentarPuntos();
                System.out.println("✅ Eres la verga. ¡Ganas un punto!");
            } else {
                System.out.println("❌ MAL, eres tont@. ¡Tómate un shot por wey!");
            }

            mostrarPuntuaciones();

            // Verificar si hay un ganador
            for (Jugador j : jugadores) {
                if (j.getPuntos() >= 10) {
                    System.out.println("\n🎉 ¡" + j.getNombre() + " es la riata y ha ganado con 10 puntos! 🎉");
                    juegoActivo = false;
                    break;
                }
            }
        }
    }

    private void mostrarPuntuaciones() {
        System.out.println("\n📊 Tabla de puntuaciones:");
        for (Jugador j : jugadores) {
            System.out.println(j.getNombre() + ": " + j.getPuntos() + " puntos");
        }
    }

    public static void main(String[] args) {
        AguaDeCalzon juego = new AguaDeCalzon();
        juego.iniciarJuego();
    }
}
