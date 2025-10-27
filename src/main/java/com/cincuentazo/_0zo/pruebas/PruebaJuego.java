package com.cincuentazo._0zo.pruebas;

import com.cincuentazo._0zo.modelo.*;

/**
 * Clase de prueba para verificar que la lógica del modelo del juego funcione correctamente.
 * Aquí no se usa interfaz gráfica, solo la parte lógica.
 */
public class PruebaJuego {
    public static void main(String[] args) {
        // Crear el juego y los jugadores
        ModeloJuego juego = new ModeloJuego();
        JugadorHumano jugadorHumano = new JugadorHumano("Laura");
        JugadorIA jugadorIA1 = new JugadorIA("IA_1");
        JugadorIA jugadorIA2 = new JugadorIA("IA_2");

        // Agregar los jugadores al modelo
        juego.agregarJugador(jugadorHumano);
        juego.agregarJugador(jugadorIA1);
        juego.agregarJugador(jugadorIA2);

        // Repartir cartas
        juego.repartirCartas();

        System.out.println("=== PRUEBA DEL CINCuentazo ===");
        System.out.println("Se repartieron las cartas iniciales ✅");

        // Mostrar manos iniciales
        for (Jugador jugador : juego.obtenerJugadores()) {
            System.out.println(jugador.getNombre() + " tiene las cartas: " + jugador.getMano());
        }

        // Mostrar carta inicial en la mesa
        System.out.println("Carta en la mesa: " + juego.obtenerCartaSuperior());
        System.out.println("Suma actual: " + juego.obtenerSumaMesa());

        // Simular que el jugador humano juega su primera carta
        if (!jugadorHumano.getMano().isEmpty()) {
            Carta cartaSeleccionada = jugadorHumano.getMano().get(0);
            boolean resultado = juego.jugarCarta(jugadorHumano, cartaSeleccionada);
            if (resultado) {
                System.out.println("El jugador " + jugadorHumano.getNombre() + " jugó la carta " + cartaSeleccionada);
            } else {
                System.out.println("El jugador no pudo jugar la carta " + cartaSeleccionada);
            }
        }

        // Mostrar estado final
        System.out.println("Carta superior ahora: " + juego.obtenerCartaSuperior());
        System.out.println("Suma total actual: " + juego.obtenerSumaMesa());
    }
}
