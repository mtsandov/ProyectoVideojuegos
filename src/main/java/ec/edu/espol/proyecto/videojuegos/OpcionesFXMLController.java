/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyecto.videojuegos;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Melanie
 */
public class OpcionesFXMLController implements Initializable {
    int cambio = 4;
    
    
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
    private AnchorPane Color;
    @FXML
    private Button izq;
    @FXML
    private Button der;

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
        
        fondo();
        //cambiarColor();
    }    
    
    
    
    public void fondo(){
       
        InputStream input2= App.class.getResourceAsStream("Extra/1.jpg");
        ImagenShow.setImage(new Image(input2));
        
    }
     public void cambiarColor()
    {
        Color.setStyle("-fx-background-color: #21005d");
    }
     
     public void cambioImagen(int cambio){
     
            String pasar = String.valueOf(cambio);
            String cadenaNueva = "Extra/"+pasar+".jpg";
            InputStream input2= App.class.getResourceAsStream(cadenaNueva);
            ImagenShow.setImage(new Image(input2));
     }
     
     public void irIzquierda(){
         if(cambio > 1){
             cambio --;
             System.out.println(cambio);
             cambioImagen(cambio);
             
         
         }
         else if(cambio == 1){
             cambio = 4;
            cambioImagen(cambio);
            
             
         }else{
             cambio = 4;
             cambioImagen(cambio);
             
         }
     }
     
     public void irDerecha(){
         if(cambio < 4){
             cambio ++;
             
             cambioImagen(cambio);
             
             
         }
         else if(cambio == 4){
             cambio = 1;
            cambioImagen(cambio);
            
             
         }
         
         else{
             cambio = 1;
             cambioImagen(cambio);
             
         }
     }
     
     
     
     
     
     
     
     
     
     
     
}
