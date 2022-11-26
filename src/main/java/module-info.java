module ec.edu.espol.proyecto.videojuegos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ec.edu.espol.proyecto.videojuegos to javafx.fxml;
    exports ec.edu.espol.proyecto.videojuegos;
}
