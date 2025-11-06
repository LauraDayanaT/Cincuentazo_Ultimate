package com.cincuentazo._0zo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class Launcher extends Application {

    @Override
    public void start(Stage escenario) throws Exception {
        //lineas comentadas para ver las interfaces nuevas

        // FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/cincuentazo/_0zo/vista/ViewMain.fxml"));
        // FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/cincuentazo/_0zo/vista/viewStart.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/cincuentazo/_0zo/vista/VistaPrincipal.fxml"));
        Parent raiz = loader.load();

        Scene escena = new Scene(raiz);
        escena.getStylesheets().add(Objects.requireNonNull(
                getClass().getResource("/com/cincuentazo/_0zo/vista/estilos.css")).toExternalForm());
        escenario.setTitle("El Cincuentazo");
        escenario.setScene(escena);
        escenario.getIcons().add(new Image(Objects.requireNonNull(
                getClass().getResourceAsStream("/com/cincuentazo/_0zo/vista/logo.jpg"
                ))));
        escenario.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
