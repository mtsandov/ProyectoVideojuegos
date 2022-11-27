package ec.edu.espol.proyecto.videojuegos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class SecondaryController implements Initializable {

    @FXML
    private ImageView ImagenShow;

    @FXML
    private Button Salir;

    @FXML
    private Text albumAbierto;

    @FXML
    private Button botonAtras;

    @FXML
    private Button botonSiguiente;

    @FXML
    private TextField buscar;

    @FXML
    private Button buscarBoton;

    @FXML
    private ComboBox<?> busquedasBox;

    @FXML
    private Button datos;

    @FXML
    private TilePane imagenesPane;

    @FXML
    private ListView<?> listViewAlbum;

    @FXML
    private Pane panedeFoto;

    @FXML
    private BorderPane panel;

    @FXML
    private Button regresar;

    @FXML
    private ScrollPane scrollImagen;

    @FXML
    void anteriorGame(ActionEvent event) {

    }

    @FXML
    void busquedaAlbum(ActionEvent event) {

    }

    @FXML
    void cerrarSesion(ActionEvent event) {

    }

    @FXML
    void regresar(ActionEvent event) {

    }

    @FXML
    void siguienteGame(ActionEvent event) {

    }

    @FXML
    void verDatos(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
