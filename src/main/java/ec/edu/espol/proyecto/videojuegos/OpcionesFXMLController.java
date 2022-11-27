/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyecto.videojuegos;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Melanie
 */
public class OpcionesFXMLController implements Initializable {
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
    private Button datos;

    @FXML
    private TilePane imagenesPane;

    @FXML
    private Pane panedeFoto;

    @FXML
    private Button regresar;

    @FXML
    private ScrollPane scrollImagen;

    @FXML
    void anteriorGame(MouseEvent event) {

    }

    @FXML
    void cerrarSesion(MouseEvent event) {

    }

    @FXML
    void regresar(MouseEvent event) {
          try {
            App.setRoot("primary",446,398);
        }catch (IOException ex){
            Alert a = new Alert(Alert.AlertType.ERROR,"No se pudo cambiar las ventana");
            a.show();
        }

    }

    @FXML
    void siguienteGame(MouseEvent event) {

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
}
