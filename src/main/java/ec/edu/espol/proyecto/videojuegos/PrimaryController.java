package ec.edu.espol.proyecto.videojuegos;

import Model.Cuenta;
import estructuras.ArrayListTDA;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class PrimaryController implements Initializable {
    
    @FXML
    private TextField txtusuariologin;
    @FXML
    private PasswordField txtcontralogin;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    @FXML
    private void CambiarAOpciones(MouseEvent event) {
        ArrayListTDA<Cuenta> usu = Cuenta.leer("cuentas");
        if (Cuenta.verificarCuenta(txtusuariologin.getText(),txtcontralogin.getText(),"cuentas")){
            ArrayListTDA<String> dat = Cuenta.datos(txtusuariologin.getText());
            try {
                FXMLLoader fxmlloader = App.loadFXMLLoader("secondary");
                App.setRoot(fxmlloader);
                App.setHeight(305);
                App.setWidth(615);
               
              
            } catch (IOException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR,"No se pudo cambiar de escena");
                a.show();   
            }   
        }
        else{
            Alert a = new Alert(Alert.AlertType.ERROR,"Los datos introducidos son incorrectos.");
            a.show();
        }
    }
    
    @FXML
    private void CambiarAR(MouseEvent e){
      
         try {
                FXMLLoader fxmlloader = App.loadFXMLLoader("RegistroFXML");
                App.setRoot(fxmlloader);
                App.setHeight(537);
                App.setWidth(496);
               
              
            } catch (IOException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR,"No se pudo cambiar de escena");
                a.show();   
            }   
    }
}




