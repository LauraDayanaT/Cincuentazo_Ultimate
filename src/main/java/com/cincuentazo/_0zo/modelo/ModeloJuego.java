package com.cincuentazo._0zo.modelo;

import java.util.*;

/**
 * Clase que contiene la lógica principal del juego El Cincuentazo.
 * Se encarga de manejar el mazo, los jugadores y las cartas en la mesa.
 */
public class ModeloJuego {
    private Mazo mazo;
    private List<Carta> mesa;
    private List<Jugador> jugadores;

    public ModeloJuego() {
        mazo = new Mazo();
        mesa = new ArrayList<>();
        jugadores = new ArrayList<>();
    }

    /** Agrega un jugador a la lista del juego */
    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    /** Devuelve la lista actual de jugadores */
    public List<Jugador> obtenerJugadores() {
        return jugadores;
    }

    /** Reparte 4 cartas a cada jugador y una carta a la mesa */
    public void repartirCartas() {
        for (int i = 0; i < 4; i++) {
            for (Jugador j : jugadores) {
                j.agregarCarta(mazo.sacarCarta());
            }
        }
        mesa.add(mazo.sacarCarta());
    }

    /** Calcula la suma actual de las cartas sobre la mesa */
    public int obtenerSumaMesa() {
        int suma = 0;
        for (Carta carta : mesa) {
            int[] valores = carta.obtenerValores();
            suma += valores.length == 2 ? (suma + valores[1] <= 50 ? valores[1] : valores[0]) : valores[0];
        }
        return suma;
    }

    /** Devuelve la carta superior de la mesa */
    public Carta obtenerCartaSuperior() {
        if (mesa.isEmpty()) return null;
        return mesa.get(mesa.size() - 1);
    }

    /** Permite que un jugador juegue una carta si no pasa de 50 */
    public boolean jugarCarta(Jugador jugador, Carta carta) {
        if (carta == null) return false;

        int sumaActual = obtenerSumaMesa();
        int[] valores = carta.obtenerValores();
        boolean valida = false;

        for (int v : valores) {
            if (sumaActual + v <= 50) valida = true;
        }

        if (!valida) return false;

        jugador.quitarCarta(carta);
        mesa.add(carta);
        jugador.agregarCarta(mazo.sacarCarta());
        return true;
    }

    /** Marca un jugador como eliminado y devuelve su carta al mazo */
    public void eliminarJugador(Jugador jugador) {
        jugador.setEliminado(true);
        if (!jugador.getMano().isEmpty()) {
            mazo.agregarAlFinal(jugador.getMano().remove(0));
        }
    }
}
