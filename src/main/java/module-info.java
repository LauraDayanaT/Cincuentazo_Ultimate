module com.cincuentazo._0zo {
    requires javafx.controls;
    requires javafx.fxml;

    // Vista
    opens com.cincuentazo._0zo.vista to javafx.fxml;
    exports com.cincuentazo._0zo.vista;

    // Controlador
    opens com.cincuentazo._0zo.controlador to javafx.fxml;
    exports com.cincuentazo._0zo.controlador;

    // Modelo
    opens com.cincuentazo._0zo.modelo to javafx.fxml;
    exports com.cincuentazo._0zo.modelo;
}
