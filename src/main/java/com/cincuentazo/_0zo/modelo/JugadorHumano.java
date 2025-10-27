package com.cincuentazo._0zo.modelo;

public class JugadorHumano extends Jugador {
    public JugadorHumano(String nombre) {
        super(nombre);
    }

    @Override
    public Carta elegirCarta(int sumaMesa) {
        return null; // la elige el jugador por la interfaz
    }
}
