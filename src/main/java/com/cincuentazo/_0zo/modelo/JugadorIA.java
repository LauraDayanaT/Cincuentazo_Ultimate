package com.cincuentazo._0zo.modelo;

public class JugadorIA extends Jugador {
    public JugadorIA(String nombre) {
        super(nombre);
    }

    @Override
    public Carta elegirCarta(int sumaMesa) {
        for (Carta carta : mano) {
            int[] valores = carta.obtenerValores();
            for (int v : valores) {
                if (sumaMesa + v <= 50) return carta;
            }
        }
        return null;
    }
}
