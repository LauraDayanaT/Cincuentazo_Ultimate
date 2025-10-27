package com.cincuentazo._0zo.controlador;

import com.cincuentazo._0zo.modelo.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

/**
 * Controlador que maneja la interacción entre la vista y el modelo del juego.
 */
public class ControladorJuego {

    @FXML
    private Label etiquetaSuma;

    @FXML
    private Label etiquetaCartaMesa;

    @FXML
    private Button botonIniciar;

    @FXML
    private HBox contenedorCartas;

    private ModeloJuego juego;
    private JugadorHumano jugadorHumano;
    private JugadorIA jugadorIA;

    @FXML
    public void iniciarJuego() {
        juego = new ModeloJuego();
        jugadorHumano = new JugadorHumano("Jugador");
        jugadorIA = new JugadorIA("IA");

        juego.agregarJugador(jugadorHumano);
        juego.agregarJugador(jugadorIA);
        juego.repartirCartas();

        actualizarInterfaz();
    }

    private void actualizarInterfaz() {
        etiquetaCartaMesa.setText("Carta en mesa: " + juego.obtenerCartaSuperior());
        etiquetaSuma.setText("Suma actual: " + juego.obtenerSumaMesa());

        contenedorCartas.getChildren().clear();
        for (Carta carta : jugadorHumano.getMano()) {
            Button botonCarta = new Button(carta.getCara());
            botonCarta.setOnAction(e -> jugarCarta(carta));
            contenedorCartas.getChildren().add(botonCarta);
        }
    }

    private void jugarCarta(Carta cartaSeleccionada) {
        boolean jugadaValida = juego.jugarCarta(jugadorHumano, cartaSeleccionada);
        if (!jugadaValida) {
            mostrarMensaje("No puedes jugar esa carta. La suma pasaría de 50.");
            return;
        }

        Carta cartaIA = jugadorIA.elegirCarta(juego.obtenerSumaMesa());
        if (cartaIA != null) {
            juego.jugarCarta(jugadorIA, cartaIA);
            mostrarMensaje("La IA jugó: " + cartaIA.getCara());
        } else {
            juego.eliminarJugador(jugadorIA);
            mostrarMensaje("La IA fue eliminada (no puede jugar).");
        }

        actualizarInterfaz();
    }

    private void mostrarMensaje(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Cincuentazo");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
