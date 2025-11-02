package com.cincuentazo._0zo.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {

    @Override
    public void start(Stage escenario) throws Exception {
        //lineas comentadas para ver las interfaces nuevas
       // FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/cincuentazo/_0zo/vista/ViewMain.fxml"));
       // FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/cincuentazo/_0zo/vista/viewStart.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/cincuentazo/_0zo/vista/VistaPrincipal.fxml"));
        Parent raiz = loader.load();

        Scene escena = new Scene(raiz);
        escena.getStylesheets().add(getClass().getResource("/com/cincuentazo/_0zo/vista/estilos.css").toExternalForm());

        escenario.setTitle("🎴 El Cincuentazo 🎴");
        escenario.setScene(escena);
        escenario.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
