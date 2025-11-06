module com.cincuentazo._0zo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    // Launcher
    opens com.cincuentazo._0zo to javafx.graphics, javafx.fxml;
    exports com.cincuentazo._0zo;

    // Vista
    opens com.cincuentazo._0zo.vista to javafx.fxml;

    // Controlador
    opens com.cincuentazo._0zo.controlador to javafx.fxml;
    exports com.cincuentazo._0zo.controlador;

    // Modelo
    opens com.cincuentazo._0zo.modelo to javafx.fxml;
    exports com.cincuentazo._0zo.modelo;
}

