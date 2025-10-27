package com.cincuentazo._0zo.modelo;

import java.util.*;

public class Mazo {
    private final List<Carta> cartas;

    public Mazo() {
        cartas = new ArrayList<>();
        inicializarMazo();
        barajar();
    }

    /** Llena el mazo con cartas de 1 a 10 y figuras */
    private void inicializarMazo() {
        String[] caras = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        for (String cara : caras) {
            for (int i = 0; i < 4; i++) {
                cartas.add(new Carta(cara));
            }
        }
    }

    /** Baraja las cartas aleatoriamente */
    public void barajar() {
        Collections.shuffle(cartas);
    }

    /** Saca una carta del mazo (si hay) */
    public Carta sacarCarta() {
        if (cartas.isEmpty()) return null;
        return cartas.remove(0);
    }

    /** Devuelve una carta al final del mazo */
    public void agregarAlFinal(Carta carta) {
        if (carta != null) cartas.add(carta);
    }
}
