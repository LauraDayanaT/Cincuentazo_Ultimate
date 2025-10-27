package com.cincuentazo._0zo.modelo;

import java.util.*;

public abstract class Jugador {
    protected String nombre;
    protected List<Carta> mano = new ArrayList<>();
    protected boolean eliminado = false;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }
    public List<Carta> getMano() { return mano; }
    public boolean estaEliminado() { return eliminado; }
    public void setEliminado(boolean e) { eliminado = e; }

    public void agregarCarta(Carta carta) { if (carta != null) mano.add(carta); }
    public void quitarCarta(Carta carta) { mano.remove(carta); }

    public abstract Carta elegirCarta(int sumaMesa);
}
